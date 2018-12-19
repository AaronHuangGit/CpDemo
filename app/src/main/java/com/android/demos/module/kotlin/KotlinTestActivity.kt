package com.android.demos.module.kotlin

import android.os.Bundle
import com.android.demos.R
import com.aaron.demo.common.base.activity.appbar.AppBarActivity
import kotlinx.android.synthetic.main.activity_kotlin.*

/**
 * Created on 17/5/19.

 * @author aaron.huang
 * *
 * @version 1.0.0
 */

class KotlinTestActivity : AppBarActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        setTitle(R.string.activity_kotlin)
        mTextView.text = "Hello, AaronHuang!!!!!"
        hideAppBar()
    }
}
