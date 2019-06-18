package paul.host.navico_testtask.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import paul.host.navico_testtask.R
import paul.host.navico_testtask.data.module.Contributor
import paul.host.navico_testtask.ui.NavigationListener

import java.util.ArrayList

class ContributorAdapter(
    private val listener: NavigationListener,
    private var items: List<Contributor> = ArrayList()
) : RecyclerView.Adapter<ContributorAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (items.isNotEmpty()) {
            val item = items[position]
            holder.setImage(item.avatarUrl)
            holder.textView.text = item.login
            holder.itemView.setOnClickListener {
                listener.goMap(item.login)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(items: List<Contributor>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView: ImageView = view.findViewById(R.id.image)
        var textView: TextView = view.findViewById(R.id.name)

        fun setImage(url: String) {
            Picasso.get()
                   .load(url)
                   .resize(50, 50)
                   .into(imageView)
        }
    }
}
