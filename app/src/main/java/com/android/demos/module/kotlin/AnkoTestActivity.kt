package com.android.demos.module.kotlin

import android.os.Bundle
import com.android.demos.utils.PopupUtils
import com.aaron.demo.common.base.activity.appbar.AppBarActivity
import org.jetbrains.anko.button
import org.jetbrains.anko.editText
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.verticalLayout

class AnkoTestActivity : AppBarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Anko Test"
        verticalLayout {
            val name = editText()
            button("Say Hello") {
                this.transformationMethod = null
                onClick { PopupUtils.showToast("Hello, ${name.text}!") }
            }
        }
    }
}
