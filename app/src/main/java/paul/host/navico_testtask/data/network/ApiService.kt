package paul.host.navico_testtask.data.network

import io.reactivex.Single
import paul.host.navico_testtask.data.model.Contributor
import paul.host.navico_testtask.data.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/repos/{owner}/{repo}/contributors")
    fun contributors(
        @Path("owner") owner: String = "ruby",
        @Path("repo") repo: String = "ruby"
    ): Single<List<Contributor>>

    @GET("/users/{login}")
    fun user(@Path("login") login: String): Single<User>
}
