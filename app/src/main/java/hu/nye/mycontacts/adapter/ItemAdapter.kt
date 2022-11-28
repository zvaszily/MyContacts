package hu.nye.mycontacts.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import hu.nye.mycontacts.MainActivity
import hu.nye.mycontacts.R
import hu.nye.mycontacts.detail.ContactDetailActivity
import hu.nye.mycontacts.entity.User

const val SELECTED_USER = "selected user"

class ItemAdapter (
    private val context: Context,
    private val dataset: List<User>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder (private val view: View): RecyclerView.ViewHolder(view) {
        val nameId: TextView =  view.findViewById(R.id.contact_name)
        val emailId: TextView =  view.findViewById(R.id.contact_email)
        val addressId: TextView =  view.findViewById(R.id.contact_address)
        val imageId: ImageView = view.findViewById(R.id.contact_image)

        val clickTrap: FrameLayout = view.findViewById(R.id.contact_click_trap)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contact, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.nameId.text = item.nameId
        holder.emailId.text = item.emailId
        holder.addressId.text = item.addressId
        //holder.imageId.setImageResource((item.imageUrlId))
        holder.imageId.run {
            Glide.with(context).load(item.imageUrlId).apply(RequestOptions.circleCropTransform().override(250)).into(this)
        }

        holder.clickTrap.setOnClickListener{
            val intent = Intent(context as MainActivity, ContactDetailActivity::class.java)
            intent.putExtra(SELECTED_USER, item)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}