package com.android.demos.module.appbarstyle.adpater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.aaron.demo.common.base.widget.recycleview.BaseRecycleViewAdapter
import com.aaron.demo.common.base.widget.recycleview.BaseRecycleViewHolder
import com.aaron.demo.common.base.widget.recycleview.ItemTouchHelperAdapter

import com.android.demos.R
import com.yueren.util.StringUtils
import kotlinx.android.synthetic.main.main_recycler_item.view.*

/**
 * Created on 16/5/4.
 *
 * @author aaron.huang
 * @version 1.0.0
 */
class AppBarStyleRecyclerAdapter(context: Context) :
        BaseRecycleViewAdapter<AppBarStyleRecyclerAdapter.AppBarStyleRecyclerViewHolder, String>(context), ItemTouchHelperAdapter {

    override fun createViewHolder(parent: ViewGroup): AppBarStyleRecyclerViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_recycler_item, parent, false)
        return AppBarStyleRecyclerViewHolder(view)
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    override fun onItemDismiss(position: Int) {
        notifyItemRemoved(position)
    }

    override fun onItemMoveFinish() {

    }

    /**
     * AppBarStyleRecyclerViewHolder
     */
    inner class AppBarStyleRecyclerViewHolder(itemView: View) : BaseRecycleViewHolder<String>(itemView) {
        private val mTitleTextView: TextView = itemView.mainTitleTextView
        override fun bindViews(`object`: String) {
            if (StringUtils.isEmpty(`object`)) {
                return
            }
            mTitleTextView.text = `object`
        }

    }
}
