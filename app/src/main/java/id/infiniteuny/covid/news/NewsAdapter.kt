package id.infiniteuny.covid.news

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.infiniteuny.covid.R
import id.infiniteuny.covid.protocol.ProtocolView
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(val data: List<ResponseNews>, private var context: Context) : RecyclerView.Adapter<NewsAdapter.NewsHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsHolder(v)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: NewsAdapter.NewsHolder, position: Int) {
        holder.bind(data?.get(position), context)
    }
    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(get: ResponseNews?, context: Context){
            itemView.newsTitle.text = get?.title
            itemView.newsData.text = get?.news
            Glide.with(itemView).load(get?.imageUrl).into(itemView.newsImage)
            itemView.setOnClickListener {
                context.startActivity(Intent(context, DetailNews::class.java).apply {
                    putExtra("NEWS", get)
                })
            }
        }
    }
}