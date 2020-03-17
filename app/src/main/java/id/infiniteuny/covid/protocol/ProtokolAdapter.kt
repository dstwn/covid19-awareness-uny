package id.infiniteuny.covid.protocol

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.infiniteuny.covid.R
import kotlinx.android.synthetic.main.item_protocol.view.*

class ProtokolAdapter(val data: List<DataItem>, private var context : Context) : RecyclerView.Adapter<ProtokolAdapter.ProHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_protocol,parent,false)
        return ProHolder(v)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ProHolder, position: Int) =
        holder.bind(data?.get(position), context)
    class ProHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(get: DataItem?, context: Context){
            itemView.title.text =  get?.title
            itemView.desc.text = get?.description
            itemView.filePdf.text = get?.fileUrl
            Glide.with(itemView).load(get?.imageUrl).into(itemView.imageView2)
            itemView.setOnClickListener{
                context.startActivity(Intent(context, ProtocolView::class.java).apply {
                    putExtra("PROT", get)
                })
            }
        }
    }
}