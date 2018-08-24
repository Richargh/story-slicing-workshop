package de.richargh.carpaccio


class CarpaccioMain {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println("The total sum is: ${mainTotalPrice(*args)}")
        }

        internal fun mainTotalPrice(vararg args: String): Double {
            if(args.size < 2){
                println("Must provide at least 2 parameters: COUNTRY ITEMCOUNT:ITEMNUMBER")
                return 0.0
            }

            val countryCode = args[0]
            val items = args.toList().subList(1, args.size)
                    .map { it.split(":") }
                    .map { Item(it[0].toInt(), it[1].toDouble()) }

            return calculate(items, countryCode)
        }




    }
}