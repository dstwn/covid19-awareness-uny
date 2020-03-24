package id.infiniteuny.c3.info

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.infiniteuny.c3.R
import kotlinx.android.synthetic.main.item_info.view.*

class InfoAdapter (val data : List<ResponseInfo>, private var context: Context) :RecyclerView.Adapter<InfoAdapter.InfoHolder>(){
    lateinit var imageView : ImageView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoAdapter.InfoHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_info, parent, false)
        return InfoHolder(v)
    }

    override fun onBindViewHolder(holder: InfoAdapter.InfoHolder, position: Int) = holder.bind(data?.get(position),context)
    override fun getItemCount(): Int = data.size
    class InfoHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        fun bind(get: ResponseInfo?, context: Context){
            itemView.infoData.text = get?.info
            Glide.with(itemView).load(get?.imageUrl).into(itemView.infoImage)
            itemView.setOnClickListener{
//                context.startActivity(Intent(context,).apply {
//                    putExtra("INFO", get)
//                })
            }
        }
    }
}