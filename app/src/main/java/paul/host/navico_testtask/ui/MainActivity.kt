package paul.host.navico_testtask.ui

import android.os.Bundle
import paul.host.navico_testtask.R
import paul.host.navico_testtask.ui.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun getContainer(): Int = R.id.container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
