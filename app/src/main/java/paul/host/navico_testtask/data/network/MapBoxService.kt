package paul.host.navico_testtask.data.network

import io.reactivex.Single
import paul.host.navico_testtask.data.model.MapBoxResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MapBoxService {
    @GET("/geocoding/v5/mapbox.places/{query}.json")
    fun location(
        @Path("query") query: String,
        @Query("access_token") token: String = "pk.eyJ1IjoicGF1bGhvc3QiLCJhIjoiY2p4MXVmMzFtMDB1MjQ5bXk2aTMwc3IzdSJ9.cRwlR9dTkl6vFyWpvaK0pA"
    ): Single<MapBoxResponse>
}