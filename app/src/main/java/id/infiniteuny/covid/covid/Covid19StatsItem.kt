package id.infiniteuny.covid.covid

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class Covid19StatsItem(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("recovered")
	val recovered: Int? = null,

	@field:SerializedName("province")
	val province: String? = null,

	@field:SerializedName("lastUpdate")
	val lastUpdate: String? = null,

	@field:SerializedName("confirmed")
	val confirmed: Int? = null,

	@field:SerializedName("deaths")
	val deaths: Int? = null
)