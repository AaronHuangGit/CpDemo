package com.android.demos.module.progressimageview

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.RadioGroup
import android.widget.Toast
import com.aaron.demo.common.base.activity.BaseActivity
import com.android.demos.R
import com.android.demos.widget.ProgressImageView
import kotlinx.android.synthetic.main.activity_progress_image.*

/**
 * Created on 2018/7/13.
 *
 * @author HuangRan
 */

class ProgressImageViewActivity : BaseActivity(), RadioGroup.OnCheckedChangeListener {
    private val SUCCESS = 0
    private var downloadProgress: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_image)
        initView()
    }

    private fun initView() {
        id_group.setOnCheckedChangeListener(this)
    }


    private var mHandler: Handler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when (msg.what) {
                SUCCESS -> Toast.makeText(this@ProgressImageViewActivity, "图片上传完成", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCheckedChanged(group: RadioGroup, checkedId: Int) {
        when (checkedId) {
            R.id.id_left -> (image as ProgressImageView).setType(0)
            R.id.id_top -> (image as ProgressImageView).setType(1)
            R.id.id_right -> (image as ProgressImageView).setType(2)
            R.id.id_bottom -> (image as ProgressImageView).setType(3)
        }
        downloadProgress = 0
        initData()
    }


    //模拟图片上传进度
    private fun initData() {
        Thread(Runnable {
            while (true) {
                if (downloadProgress == 100) {//图片上传完成
                    mHandler.sendEmptyMessage(SUCCESS)
                    return@Runnable
                }
                downloadProgress++
                (image as ProgressImageView).setProgress(downloadProgress)
                try {
                    Thread.sleep(100)  //暂停0.1秒
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            }
        }).start()
    }
}
