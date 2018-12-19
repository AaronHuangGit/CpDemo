package com.android.demos.module.appbarstyle

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aaron.demo.common.base.fragment.BaseFragment
import com.aaron.demo.common.base.widget.recycleview.RecyclerItemDecoration
import com.aaron.demo.common.base.widget.recycleview.SimpleItemTouchHelperCallback
import com.android.demos.R
import com.android.demos.module.appbarstyle.adpater.AppBarStyleRecyclerAdapter

/**
 * Created on 16/5/3.
 *
 * @author aaron.huang
 * @version 1.0.0
 */
class AppBarStyleFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val recyclerView = inflater.inflate(R.layout.fragment_app_bar_style, null, false) as RecyclerView
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(RecyclerItemDecoration(activity, LinearLayoutManager.VERTICAL, R.drawable.main_recycler_divider))
        val appBarStyleRecyclerAdapter = AppBarStyleRecyclerAdapter(activity!!)

        appBarStyleRecyclerAdapter.setData(resources.getStringArray(R.array.app_bar_style_item).toMutableList())
        recyclerView.adapter = appBarStyleRecyclerAdapter
        val itemTouchHelper = ItemTouchHelper(SimpleItemTouchHelperCallback(appBarStyleRecyclerAdapter))
        itemTouchHelper.attachToRecyclerView(recyclerView)
        return recyclerView
    }
}
