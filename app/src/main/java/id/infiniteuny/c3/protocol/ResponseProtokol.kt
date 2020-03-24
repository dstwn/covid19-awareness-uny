package id.infiniteuny.c3.protocol

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ResponseProtokol(

    @SerializedName("data")
	val data: List<DataItem>,

    @field:SerializedName("succes")
	val succes: Boolean? = null
)