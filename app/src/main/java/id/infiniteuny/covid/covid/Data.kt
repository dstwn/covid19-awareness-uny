package id.infiniteuny.covid.covid

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import id.infiniteuny.covid.covid.Covid19StatsItem

@Generated("com.robohorse.robopojogenerator")
data class Data(

	@field:SerializedName("covid19Stats")
	val covid19Stats: List<Covid19StatsItem?>? = null,

	@field:SerializedName("lastChecked")
	val lastChecked: String? = null
)