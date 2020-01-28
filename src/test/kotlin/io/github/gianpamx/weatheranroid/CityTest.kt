package io.github.gianpamx.weatheranroid

import io.github.gianpamx.weatherandroid.City
import io.github.gianpamx.weatherandroid.groupByCountry
import org.junit.Test

class CityTest {
    @Test
    fun print() {
        val cities = listOf(
            City("Guadalajara", "Mexico"),
            City("Mexico City", "Mexico"),
            City("Monterrey", "Mexico"),
            City("Canberra", "Australia"),
            City("Melbourne", "Australia"),
            City("Perth", "Australia"),
            City("Sydney", "Australia"),
            City("Dublin", "Ireland"),
            City("Galway", "Ireland"),
            City("Kilkenny", "Ireland"),
            City("Manila", "Philippines"),
            City("Cebu City", "Philippines"),
            City("London", "United Kingdom"),
            City("Conwy", "United Kingdom"),
            City("Brighton", "United Kingdom"),
            City("Bath", "United Kingdom"),
            City("York", "United Kingdom"),
            City("Edinburgh", "United Kingdom"),
            City("San Francisco", "United States"),
            City("New York", "United States"),
            City("Boston", "United States"),
            City("Los Angeles", "United States"),
            City("Montevideo", "Uruguay"),
            City("Punta del Este", "Uruguay"),
            City("Colonia del Sacramento", "Uruguay")
        )

        print(cities.groupByCountry())
    }
}
