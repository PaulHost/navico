package paul.host.navico_testtask.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import paul.host.navico_testtask.App
import paul.host.navico_testtask.R
import paul.host.navico_testtask.data.repasitory.Repository
import paul.host.navico_testtask.ui.adapter.ContributorAdapter
import paulhost.sf.ui.base.BaseFragment
import javax.inject.Inject

@SuppressLint("StaticFieldLeak")
class ListFragment : BaseFragment() {

    private lateinit var adapter: ContributorAdapter
    private lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        App.component.inject(this)
        super.onCreate(savedInstanceState)
        adapter = ContributorAdapter(listener!!)
    }

    @SuppressLint("CheckResult")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        if (view is RecyclerView) {
            recyclerView = view
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
            repository.contributors()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { list, _ ->
                    run {
                        adapter.setItems(list)

                    }
                }
        }
        return view
    }

    companion object {
        private var instance: ListFragment? = null

        fun getInstance(): ListFragment {
            if (instance == null) {
                instance = ListFragment()
            }
            return instance as ListFragment
        }
    }
}
