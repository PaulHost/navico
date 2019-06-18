package paul.host.navico_testtask.ui

import android.os.Bundle
import paul.host.navico_testtask.R
import paul.host.navico_testtask.ui.base.BaseActivity
import paul.host.navico_testtask.ui.fragment.ListFragment

class MainActivity : BaseActivity() {

    override val container: Int
        get() = R.id.container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startFragment(ListFragment.getInstance())
    }

    override fun goMap(login: String) {
//        TODO: navigation to map
    }
}
