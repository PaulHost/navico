package paul.host.navico_testtask.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.maps.Style
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import paul.host.navico_testtask.App
import paul.host.navico_testtask.data.repasitory.Repository
import paulhost.sf.ui.base.BaseFragment
import timber.log.Timber
import javax.inject.Inject


@SuppressLint("StaticFieldLeak")
class MapFragment : BaseFragment(), OnMapReadyCallback {
    @Inject
    lateinit var repository: Repository

    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        App.component.inject(this)
        super.onCreate(savedInstanceState)
        Mapbox.getInstance(
            context!!,
            "pk.eyJ1IjoicGF1bGhvc3QiLCJhIjoiY2p4MXVmMzFtMDB1MjQ5bXk2aTMwc3IzdSJ9.cRwlR9dTkl6vFyWpvaK0pA"
        )
    }

    @SuppressLint("CheckResult")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(paul.host.navico_testtask.R.layout.fragment_map, container, false)
        mapView = view.findViewById(paul.host.navico_testtask.R.id.map_view)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
        return view
    }

    override fun onMapReady(mapboxMap: MapboxMap) {
        mapboxMap.setStyle(Style.MAPBOX_STREETS) {
            // Map is set up and the style has loaded. Now you can add data or make other map adjustments
        }
        arguments?.let {
            repository.contributorLocation(it[LOGIN] as String)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { location, error ->
                    run {
                        mapboxMap.animateCamera(
                            CameraUpdateFactory.newCameraPosition(
                                CameraPosition.Builder()
                                    .target(LatLng(location.second, location.first))
                                    .zoom(11.0)
                                    .tilt(20.0)
                                    .build()
                            )
                        )
                        Timber.e(error)
                    }
                }

        }
    }

    companion object {
        const val LOGIN = "login"

        fun newInstance(login: String): MapFragment {
            val instance = MapFragment()
            instance.arguments = Bundle().apply {
                putString(LOGIN, login)
            }
            return instance
        }
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }
}
