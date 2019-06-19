package paul.host.navico_testtask.data.repasitory

import com.mapbox.mapboxsdk.geometry.LatLng
import io.reactivex.Single
import paul.host.navico_testtask.data.model.Contributor
import paul.host.navico_testtask.data.network.ApiService
import paul.host.navico_testtask.data.network.MapBoxService
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: ApiService,
    private val map: MapBoxService
) {
    fun contributors(): Single<List<Contributor>> = api.contributors()

    fun contributorLocationCity(login: String): Single<String> = api.user(login).map { it.location }

    fun contributorLocation(login: String): Single<Pair<Double, Double>> = contributorLocationCity(login).flatMap {
        map.location(query = it)
    }.map {
        it.features[0].center
    }.map {
        Pair(it[0], it[1])
    }
}
