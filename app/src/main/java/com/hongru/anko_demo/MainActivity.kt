package com.hongru.anko_demo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hongru.anko_demo.layouts.LayoutMainUI
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        LayoutMainUI().setContentView(this)
    }
}
