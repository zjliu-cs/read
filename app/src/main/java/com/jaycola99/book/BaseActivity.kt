package com.jaycola99.book

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutID())
        initView(savedInstanceState)
        initData()
        initListener()
    }

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun initListener()

    abstract fun initData()

    abstract fun getLayoutID(): Int

}