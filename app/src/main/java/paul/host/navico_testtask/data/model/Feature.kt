package paul.host.navico_testtask.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Feature(
    @SerializedName("id")
    @Expose
    var id: String,
    @SerializedName("type")
    @Expose
    var type: String,
    @SerializedName("place_type")
    @Expose
    var placeType: List<String>,
    @SerializedName("relevance")
    @Expose
    var relevance: Double,
    @SerializedName("properties")
    @Expose
    var properties: Properties,
    @SerializedName("text")
    @Expose
    var text: String,
    @SerializedName("place_name")
    @Expose
    var placeName: String,
    @SerializedName("center")
    @Expose
    var center: List<Double>,
    @SerializedName("geometry")
    @Expose
    var geometry: Geometry,
    @SerializedName("context")
    @Expose
    var context: List<Context>
)
