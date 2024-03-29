package paul.host.navico_testtask.ui.base


import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import paul.host.navico_testtask.ui.NavigationListener

abstract class BaseActivity : AppCompatActivity(), NavigationListener {

    protected val isBackStackEmpty: Boolean = supportFragmentManager.backStackEntryCount == 0

    abstract val container: Int

    fun startFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(fragment.javaClass.canonicalName)
            .replace(container, fragment)
            .commit()
    }

    override fun goBack() {
        this.onBackPressed()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            finish()
        } else {
            supportFragmentManager.popBackStack()
        }
    }
}
