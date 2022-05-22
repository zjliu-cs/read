package com.jaycola99.book

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : BaseActivity() {

    private lateinit var fcv: FragmentContainerView
    private lateinit var bnv: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        initView(savedInstanceState)
//        initData()
//        initListener()
    }

    override fun initView(savedInstanceState: Bundle?) {
        fcv = findViewById(R.id.nav_main)
        bnv = findViewById(R.id.bnv_main)
        bnv.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_LABELED
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_main) as NavHostFragment
        val navController = navHostFragment.navController
        bnv.setupWithNavController(navController)


    }

    override fun initListener() {
    }

    override fun initData() {
    }

    override fun getLayoutID() = R.layout.activity_main
}