package paul.host.navico_testtask.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MapBoxResponse (
    @SerializedName("type")
    @Expose
    var type: String,
    @SerializedName("query")
    @Expose
    var query: List<String>,
    @SerializedName("features")
    @Expose
    var features: List<Feature>,
    @SerializedName("attribution")
    @Expose
    var attribution: String
)
