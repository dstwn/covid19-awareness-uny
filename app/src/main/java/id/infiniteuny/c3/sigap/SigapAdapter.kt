package id.infiniteuny.c3.sigap

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.infiniteuny.c3.R
import kotlinx.android.synthetic.main.item_sigap.view.*

class SigapAdapter(val datas: List<ResponseSigap>, private var context: Context) : RecyclerView.Adapter<SigapAdapter.VH>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SigapAdapter.VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_sigap, parent , false)
        return VH(v)
    }
    override fun getItemCount(): Int = datas.size
    override fun onBindViewHolder(holder: SigapAdapter.VH, position: Int) =
        holder.bind(datas?.get(position),context)
        class VH(itemView: View) : RecyclerView.ViewHolder(itemView){
            fun bind(get: ResponseSigap?, context: Context){
                itemView.txtProv.text = get?.title
                itemView.txtUrl.text = get?.webUrl
                Glide.with(itemView).load(get?.imgUrl).apply(RequestOptions().override(50,50)).into(itemView.imgProv)
                itemView.setOnClickListener {
                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(get?.webUrl)))
                }
            }
        }

}