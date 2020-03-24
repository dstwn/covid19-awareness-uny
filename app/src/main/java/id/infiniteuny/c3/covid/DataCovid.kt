package id.infiniteuny.c3.covid

data class DataCovid(
    val cases: Int,
    val todayCases: Int,
    val deaths: Int,
    val todayDeaths: Int,
    val recovered: Int
)