package com.jaycola99.book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class BookShelfActivity : BaseActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var rvBookShelf: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //保持屏幕常亮
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }

    override fun initView(savedInstanceState: Bundle?) {
        toolbar = findViewById(R.id.toolbar_book_shelf)
        rvBookShelf = findViewById(R.id.rv_book_shelf)

        //配置toolbar
        toolbar.title = "书架"
        //设置toolbar
        setSupportActionBar(toolbar)
    }

    override fun initListener() {

    }

    override fun initData() {

    }

    override fun getLayoutID() = R.layout.activity_book_shelf
}