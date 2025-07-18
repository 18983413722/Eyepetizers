package com.example.home.adapter



import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.home.Apiservice.Recommend
import com.example.home.R

class homerecommendadapter : PagingDataAdapter<Recommend, RecyclerView.ViewHolder>(NewsDiffCallback) {

    companion object {
        private const val TYPE_TEXT = 0
        private const val TYPE_SMALL = 1
        private const val TYPE_FOLLOW = 2
    }

    object NewsDiffCallback : DiffUtil.ItemCallback<Recommend>() {
        override fun areItemsTheSame(oldItem: Recommend, newItem: Recommend): Boolean {
            return true
        }
        override fun areContentsTheSame(oldItem: Recommend, newItem: Recommend): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is rtextViewHolder -> {
                holder.textview.text = getItem(position)?.data?.header?.title ?: "暂无标题"
            }

            is r2imageViewHolder -> {
                val id  = getItem(position)?.data?.content?.data?.cover?.feed
                Log.d("urii", "onBindViewHolder: $id")
                Glide.with(holder.videocoverImageView)
                    .load(getItem(position)?.data?.content?.data?.cover?.feed)
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.videocoverImageView)
                holder.videotitleTextView.text = getItem(position)?.data?.content?.data?.title
                val duration = getItem(position)?.data?.content?.data?.duration
                if(duration!=null){
                    holder.videoduration.text = duration.secondsToTimeString()
                }
                val log = getItem(position)?.data?.content?.data?.tags
                if (log != null) {
                    holder.videotags.text = "#"+log[0].name
                } else {
                    holder.videotags.text = "#该视频没有标签"
                }
            }

            is r1imageViewHolder -> {
                Glide.with(holder.videocoverImageView)
                    .load(getItem(position)?.data?.content?.data?.cover?.feed)
                    .into(holder.videocoverImageView)
                holder.videotitleTextView.text = getItem(position)?.data?.content?.data?.title
                Glide.with(holder.authorcoverImageView)
                    .load(getItem(position)?.data?.content?.data?.author?.icon)
                    .into(holder.authorcoverImageView)
                val duration = getItem(position)?.data?.content?.data?.duration
                val id  = getItem(position)?.data?.content?.data?.cover?.feed
                Log.d("idididid", "follow: $id")
                if(duration!=null){
                    holder.videoduration.text = duration.secondsToTimeString()
                }
                val log = getItem(position)?.data?.content?.data?.tags
                if (log != null) {
                    holder.videotags.text = "#"+log[0].name
                } else {
                    holder.videotags.text = "#该视频没有标签"
                }
                holder.videoresoureceTextView.text = getItem(position)?.data?.content?.data?.category
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            TYPE_TEXT ->{
                val view = View.inflate(parent.context,R.layout.homelogtextitem,null)
                return rtextViewHolder(view)
            }

            TYPE_SMALL ->{
                            val view = View.inflate(parent.context,R.layout.homeremmendbanneritem,null)
                            return r2imageViewHolder(view)
                        }

            TYPE_FOLLOW ->{
                val view = View.inflate(parent.context,R.layout.homerecommendfollowitem,null)
                return r1imageViewHolder(view)
            }

        }
        throw IllegalArgumentException("未知的类型")
    }

    inner class rtextViewHolder(view: View):RecyclerView.ViewHolder(view){
        val textview = view.findViewById<TextView>(R.id.textView)
    }

    inner class r1imageViewHolder(view:View):RecyclerView.ViewHolder(view){
        val videocoverImageView =view.findViewById<ImageView>(R.id.videocover)
        val authorcoverImageView =view.findViewById<ImageView>(R.id.authorcover)
        val videotitleTextView =view.findViewById<TextView>(R.id.video_title)
        val videoresoureceTextView =view.findViewById<TextView>(R.id.video_resourece)
        val videoduration = view.findViewById<TextView>(R.id.video_duration)
        val videotags = view.findViewById<TextView>(R.id.video_tag)
    }
    inner class r2imageViewHolder(view:View):RecyclerView.ViewHolder(view){
        val videocoverImageView =view.findViewById<ImageView>(R.id.iv_cover)
        val videotitleTextView =view.findViewById<TextView>(R.id.tv_title)
        val videoduration = view.findViewById<TextView>(R.id.tv_duration)
        val videotags = view.findViewById<TextView>(R.id.tv_tag)
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)!!
        if(item.type == "textCard") {
            return TYPE_TEXT
        } else {
            if(item.type == "followCard") {
                return TYPE_FOLLOW
            } else {
                return TYPE_SMALL
            }
        }
    }

    fun Int.secondsToTimeString(): String {
        val minutes = this / 60
        val seconds = this % 60
        return String.format("%02d:%02d", minutes, seconds)
    }
}
/*
* val videocoverImageView =view.findViewById<ImageView>(R.id.iv_cover)
        val videotitleTextView =view.findViewById<TextView>(R.id.tv_title)
        val videoduration = view.findViewById<TextView>(R.id.tv_duration)
        val videotags = view.findViewById<TextView>(R.id.tv_tag)
        *
        * Glide.with(holder.videocoverImageView)
                    .load(getItem(position)?.data?.content?.data?.cover?.feed)
                    .into(holder.videocoverImageView)
                holder.videotitleTextView.text = getItem(position)?.data?.content?.data?.title
                val duration = getItem(position)?.data?.content?.data?.duration
                if(duration!=null){
                    holder.videoduration.text = duration.secondsToTimeString()
                }
                val log = getItem(position)?.data?.content?.data?.tags
                if (log != null) {
                        holder.videotags.text = "#"+log[0].name
                    } else {
                        holder.videotags.text = "#该视频没有标签"
                    }
* */