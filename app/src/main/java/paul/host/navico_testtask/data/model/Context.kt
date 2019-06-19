package paul.host.navico_testtask.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Context(
    @SerializedName("id")
    @Expose
    var id: String,
    @SerializedName("wikidata")
    @Expose
    var wikidata: String,
    @SerializedName("text")
    @Expose
    var text: String,
    @SerializedName("short_code")
    @Expose
    var shortCode: String
)
