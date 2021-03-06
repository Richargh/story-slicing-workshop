package de.richargh.carpaccio

internal data class Item(val amount: Int, val price: Double){
    fun totalPrice(): Double = amount.toDouble() * price
}