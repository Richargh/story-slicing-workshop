package foo

fun calculate(items: List<Item>, vat: Double): Double {
    val result = items.fold(0.0) {
        total: Double, item -> total + item.totalPrice()
    } * vat
    return applyDiscount(result)
}

fun vat(countryCode: String): Double{
    return when(countryCode){
        "UK" -> 1.2
        "DE" -> 1.19
        else -> 1.0
    }
}

fun applyDiscount(totalPrice: Double): Double{
    val discount = when{
        totalPrice >= 50_000 -> 0.85
        totalPrice >= 10_000 -> 0.90
        totalPrice >= 7_000 -> 0.93
        totalPrice >= 5_000 -> 0.95
        totalPrice >= 1_000 -> 0.97
        else -> 1.0
    }
    return totalPrice * discount
}