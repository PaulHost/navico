package paul.host.navico_testtask.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Geometry(
    @SerializedName("coordinates")
    @Expose
    var coordinates: List<Double>,
    @SerializedName("type")
    @Expose
    var type: String
)
