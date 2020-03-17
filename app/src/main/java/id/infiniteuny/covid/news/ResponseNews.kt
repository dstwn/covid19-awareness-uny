package id.infiniteuny.covid.news

import android.os.Parcel
import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ResponseNews(

	@field:SerializedName("news")
	val news: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null
) : Parcelable {
	constructor(source: Parcel) : this(
		source.readString(),
		source.readString(),
		source.readString(),
		source.readString(),
		source.readValue(Int::class.java.classLoader) as Int?,
		source.readString()
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
		writeString(news)
		writeString(updatedAt)
		writeString(imageUrl)
		writeString(createdAt)
		writeValue(id)
		writeString(title)
	}

	companion object {
		@JvmField
		val CREATOR: Parcelable.Creator<ResponseNews> = object : Parcelable.Creator<ResponseNews> {
			override fun createFromParcel(source: Parcel): ResponseNews = ResponseNews(source)
			override fun newArray(size: Int): Array<ResponseNews?> = arrayOfNulls(size)
		}
	}
}