package paul.host.navico_testtask.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Properties(
    @SerializedName("landmark")
    @Expose
    var landmark: Boolean,
    @SerializedName("address")
    @Expose
    var address: String,
    @SerializedName("category")
    @Expose
    var category: String
)
