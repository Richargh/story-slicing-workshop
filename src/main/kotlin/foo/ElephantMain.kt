package foo


class ElephantMain {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            mainTotalPrice(*args)
        }

        fun mainTotalPrice(vararg args: String): Double {
            if(args.size < 2){
                println("Must provide at least 2 parameters: COUNTRY ITEMCOUNT:ITEMNUMBER")
                return 0.0
            }

            val countryCode = args[0]
            val items = args.toList().subList(1, args.size).map {
                val amount = it.split(":")
                Item(amount[0].toInt(), amount[1].toDouble())
            }

            return calculate(items, vat(countryCode))
        }




    }
}