package de.richargh.carpaccio

internal fun calculate(items: List<Item>, countryCode: String): Double {
    val result = items.fold(0.0) {
        total: Double, item -> total + item.totalPrice()
    } * vat(countryCode)
    return applyDiscount(result)
}

private fun vat(countryCode: String): Double{
    return when(countryCode){
        "UK" -> 1.2
        "DE" -> 1.19
        else -> 1.0
    }
}

private fun applyDiscount(totalPrice: Double): Double{
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