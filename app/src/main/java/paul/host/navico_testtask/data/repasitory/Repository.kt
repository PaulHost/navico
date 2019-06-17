package paul.host.navico_testtask.data.repasitory

import io.reactivex.Single
import paul.host.navico_testtask.data.module.Contributor
import paul.host.navico_testtask.data.network.ApiService
import javax.inject.Inject

class Repository @Inject constructor(private val api: ApiService) {
    fun contributors(): Single<List<Contributor>> = api.contributors()

    fun contributorLocation(login: String): Single<String> = api.user(login).map { it.location }
}