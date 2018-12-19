package com.android.demos.module.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View
import com.aaron.demo.common.base.activity.BaseActivity
import com.aaron.demo.common.base.widget.recycleview.OnRecycleViewItemClickListener
import com.aaron.demo.common.base.widget.recycleview.RecyclerItemDecoration
import com.aaron.demo.common.base.widget.recycleview.SimpleItemTouchHelperCallback
import com.aaron.demo.common.manager.ARouterManager
import com.alibaba.android.arouter.launcher.ARouter
import com.android.demos.R
import com.android.demos.module.appbarstyle.AppBarStyleActivity
import com.android.demos.module.kotlin.AnkoTestActivity
import com.android.demos.module.kotlin.KotlinTestActivity
import com.android.demos.module.main.adapter.MainRecyclerAdapter
import com.android.demos.module.map.MapActivity
import com.android.demos.module.progressimageview.ProgressImageViewActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created on 15/12/7.
 *
 * @author aaron.huang
 * @version 1.0.0
 */
class MainActivity : BaseActivity() {
    private var mRecyclerItemList: MutableList<String>? = null
    private val POSITION_APPBAR = 0
    private val POSITION_FRESCO = POSITION_APPBAR + 1
    private val POSITION_KOTLIN = POSITION_FRESCO + 1
    private val POSITION_KOTLIN_ANKO = POSITION_KOTLIN + 1
    private val POSITION_MAP = POSITION_KOTLIN_ANKO + 1
    private val POSITION_PROGRESS_IMAGE = POSITION_MAP + 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.title_activity_main)
        mRecyclerItemList = resources.getStringArray(R.array.main_item_title).toMutableList()
        initViews()
    }

    private fun initViews() {
        val layoutManager = LinearLayoutManager(this)
        mainRecyclerView.addItemDecoration(RecyclerItemDecoration(this, LinearLayoutManager.VERTICAL,
                R.drawable.main_recycler_divider))
        mainRecyclerView.layoutManager = layoutManager
        val mainRecyclerAdapter = MainRecyclerAdapter(this)
        mainRecyclerAdapter.setData(mRecyclerItemList)
        mainRecyclerView.adapter = mainRecyclerAdapter
        mainRecyclerAdapter.setOnRecycleViewItemClickListener(object : OnRecycleViewItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                val cls = when (position) {
                    POSITION_APPBAR -> AppBarStyleActivity::class.java
                    POSITION_FRESCO -> {
                        ARouter.getInstance().build(ARouterManager.ROUTER_PATH_FRESCO).navigation()
                        return
                    }
                    POSITION_KOTLIN -> KotlinTestActivity::class.java
                    POSITION_KOTLIN_ANKO -> AnkoTestActivity::class.java
                    POSITION_MAP -> MapActivity::class.java
                    POSITION_PROGRESS_IMAGE -> ProgressImageViewActivity::class.java
                    else -> {
                        null
                    }
                }
                cls?.let {
                    startActivity(Intent(this@MainActivity, it))
                }
            }

            override fun onItemLongClick(view: View, position: Int): Boolean {
                return true
            }
        })
        val itemTouchHelper = ItemTouchHelper(SimpleItemTouchHelperCallback(mainRecyclerAdapter))
        itemTouchHelper.attachToRecyclerView(mainRecyclerView)
    }

}
