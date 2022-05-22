package com.jaycola99.book

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.jaycola99.book.model.BookInfo

class BookShelfAdapter(private val bookInfo: Array<BookInfo>) :
    RecyclerView.Adapter<BookShelfAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivBook: ImageView = itemView.findViewById(R.id.iv_book_shelf)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_book_shelf, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ivBook.setImageBitmap(bookInfo[position].image)
    }

    override fun getItemCount() = bookInfo.size
}