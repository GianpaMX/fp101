package io.github.gianpamx.weatherandroid

data class City(val name: String, val country: String)

fun List<City>.groupByCountry() = this.groupBy { it.country }
    .toSortedMap()
    .map {
        listOf(it.key) +
                it.value.map { city -> city.name }
                    .distinct()
                    .sorted()
    }
    .toList()
    .flatten()
