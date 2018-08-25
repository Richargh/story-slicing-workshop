package de.richargh.carpaccio

import de.richargh.carpaccio.CarpaccioMain.Companion.mainTotalPrice
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.within
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class CarpaccioTest {

    @Test
    fun `application returns 0 when no parameter is passed`() {
        assertThat(mainTotalPrice()).isEqualTo(0.0)
    }

    @Test
    fun `application is operational when it returns 0`() {
        assertThat(mainTotalPrice("AW")).isEqualTo(0.0)
    }

    @Test
    @Parameters(
        "AW 0:100.0, 0.0",
        "AW 1:100.0, 100.0",
        "AW 2:100.0, 200.0",
        "AW 1:100.0 1:50.0, 150.0",
        "AW 1:100.0 1:50.0 2:25.0, 200.0"
    )
    fun `should calculate correct price for AWesome country`(args: String, expected: Double) {
        assertThat(mainTotalPrice(*args.split(" ").toTypedArray())).isEqualTo(expected)
    }

    @Test
    @Parameters(
            "LU 0:100.0, 0.0",
            "LU 1:100.0, 117.0",
            "LU 1:100.0 2:100.0, 351.0"
    )
    fun `should calculate correct price for Luxemburg`(args: String, expected: Double) {
        assertThat(mainTotalPrice(*args.split(" ").toTypedArray())).isEqualTo(expected)
    }

    @Test
    @Parameters(
            "DE 0:100.0, 0.0",
            "DE 1:100.0, 119.0",
            "DE 1:100.0 2:100.0, 357.0"
    )
    fun `should calculate correct price for Germany`(args: String, expected: Double) {
        assertThat(mainTotalPrice(*args.split(" ").toTypedArray())).isEqualTo(expected)
    }

    @Test
    @Parameters(
            "GB 0:100.0, 0.0",
            "GB 1:100.0, 120.0",
            "GB 1:100.0 2:100.0, 360.0"
    )
    fun `should calculate correct price for UK`(args: String, expected: Double) {
        assertThat(mainTotalPrice(*args.split(" ").toTypedArray())).isEqualTo(expected)
    }

    @Test
    @Parameters(
            "PL 0:100.0, 0.0",
            "PL 1:100.0, 123.0",
            "PL 1:100.0 4:50.0, 369.0"
    )
    fun `should calculate correct price for Poland`(args: String, expected: Double) {
        assertThat(mainTotalPrice(*args.split(" ").toTypedArray())).isEqualTo(expected)
    }

    @Test
    @Parameters(
            "HU 0:100.0, 0.0",
            "HU 1:100.0, 127.0",
            "HU 1:100.0 4:50.0, 381.0"
    )
    fun `should calculate correct price for Hungary`(args: String, expected: Double) {
        assertThat(mainTotalPrice(*args.split(" ").toTypedArray())).isEqualTo(expected)
    }

    @Test
    @Parameters(
            "AW 0:100.0, 0.0",
            "AW 1:1000.0, 970.0",
            "AW 1:5000.0, 4750.0",
            "AW 1:7000.0, 6510.0",
            "AW 1:10000.0, 9000.0",
            "AW 1:50000.0, 42500.0"
    )
    fun `should discount prices depending on total price`(args: String, expected: Double) {
        assertThat(mainTotalPrice(*args.split(" ").toTypedArray())).isEqualTo(expected)
    }



    @Test
    @Parameters(
            "LU 1:1000.0, 1134.9",
            "DE 1:1000.0, 1154.3",
            "GB 1:1000.0, 1164.0",
            "PL 1:1000.0, 1193.1",
            "HU 1:1000.0, 1231.9"
    )
    fun `should add vat and discount prices`(args: String, expected: Double) {
        assertThat(mainTotalPrice(*args.split(" ").toTypedArray())).isCloseTo(expected, within(0.1))
    }
}