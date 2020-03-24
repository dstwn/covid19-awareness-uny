package id.infiniteuny.c3.protocol

import android.os.Parcel
import android.os.Parcelable
import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class DataItem(
    @field:SerializedName("image_url")
    val imageUrl: String? = null,

    @field:SerializedName("file_url")
    val fileUrl: String? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("updated_by")
    val updatedBy: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("created_by")
    val createdBy: String? = null
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(imageUrl)
        writeString(fileUrl)
        writeString(updatedAt)
        writeString(updatedBy)
        writeString(description)
        writeString(createdAt)
        writeString(id)
        writeString(title)
        writeString(createdBy)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<DataItem> = object : Parcelable.Creator<DataItem> {
            override fun createFromParcel(source: Parcel): DataItem = DataItem(source)
            override fun newArray(size: Int): Array<DataItem?> = arrayOfNulls(size)
        }
    }
}