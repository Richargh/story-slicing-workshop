package de.richargh.carpaccio

import de.richargh.carpaccio.CarpaccioMain.Companion.mainTotalPrice
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CarpaccioTest {

    @Test
    fun `application returns 0 when no parameter is passed`() {
        assertThat(mainTotalPrice()).isEqualTo(0.0)
    }

    @Test
    fun `application is operational when it returns 0`() {
        assertThat(mainTotalPrice("AW")).isEqualTo(0.0)
    }

    @ParameterizedTest
    @CsvSource(
        "AW 0:100.0, 0.0",
        "AW 1:100.0, 100.0",
        "AW 2:100.0, 200.0",
        "AW 1:100.0 1:50.0, 150.0",
        "AW 1:100.0 1:50.0 2:25.0, 200.0"
    )
    fun `should calculate correct price for AWesome country`(args: String, expected: Double) {
        assertThat(mainTotalPrice(*args.split(" ").toTypedArray())).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
            "UK 0:100.0, 0.0",
            "UK 1:100.0, 120.0",
            "UK 1:100.0 2:100.0, 360.0"
    )
    fun `should calculate correct price for UK`(args: String, expected: Double) {
        assertThat(mainTotalPrice(*args.split(" ").toTypedArray())).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
            "DE 0:100.0, 0.0",
            "DE 1:100.0, 119.0",
            "DE 1:100.0 2:100.0, 357.0"
    )
    fun `should calculate correct price for Germany`(args: String, expected: Double) {
        assertThat(mainTotalPrice(*args.split(" ").toTypedArray())).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
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
}