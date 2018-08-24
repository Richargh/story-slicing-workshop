package de.richargh.carpaccio

internal fun calculate(items: List<Item>, countryCode: String): Double {
    val sum = items.fold(0.0) {
        total: Double, item -> total + item.totalPrice()
    }
    return applyDiscount(sum * vat(countryCode))
}

private fun vat(countryCode: String): Double{
    return when(countryCode){
        "LU" -> 1.17
        "DE" -> 1.19
        "GB" -> 1.2
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