package paul.host.navico_testtask.ui

import android.os.Bundle
import paul.host.navico_testtask.R
import paul.host.navico_testtask.ui.base.BaseActivity
import paul.host.navico_testtask.ui.fragment.ListFragment
import paul.host.navico_testtask.ui.fragment.MapFragment

class MainActivity : BaseActivity() {

    override val container: Int
        get() = R.id.container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (isBackStackEmpty) startFragment(ListFragment.getInstance())
    }

    override fun goMap(login: String) {
        startFragment(MapFragment.newInstance(login))
    }
}
