package com.android.demos.utils

import android.widget.Toast
import com.aaron.demo.common.app.BaseApplication
import com.yueren.util.StringUtils


/**
 * Created on 2014/12/16 11:18.
 *
 * @author ran.huang
 * @version 1.0.0
 */
object PopupUtils {

    /**
     * 显示Toast
     *
     * @param msg 内容
     */
    fun showToast(msg: String) {
        if (!StringUtils.isEmpty(msg)) {
            Toast.makeText(BaseApplication.application!!, msg, Toast.LENGTH_LONG).show()
        }
    }

    /**
     * 显示Toast
     *
     * @param resId 资源ID
     */
    fun showToast(resId: Int) {
        showToast(BaseApplication.application!!.getString(resId))
    }
}
