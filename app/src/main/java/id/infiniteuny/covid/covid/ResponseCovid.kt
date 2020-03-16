package id.infiniteuny.covid.covid

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import id.infiniteuny.covid.covid.Data

@Generated("com.robohorse.robopojogenerator")
data class ResponseCovid(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
)