package com.android.demos.module.main.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.aaron.demo.common.base.widget.recycleview.BaseRecycleViewAdapter
import com.aaron.demo.common.base.widget.recycleview.BaseRecycleViewHolder
import com.aaron.demo.common.base.widget.recycleview.ItemTouchHelperAdapter
import com.aaron.demo.common.base.widget.recycleview.ItemTouchHelperViewHolder
import com.android.demos.R
import kotlinx.android.synthetic.main.main_recycler_item.view.*


/**
 * Created on 16/4/8.
 *
 * @author aaron.huang
 * @version 1.0.0
 */
class MainRecyclerAdapter(context: Context) : BaseRecycleViewAdapter<MainRecyclerAdapter.MainRecyclerViewHolder, String>(context), ItemTouchHelperAdapter {

    private val TAG = "MainRecyclerAdapter"

    override fun createViewHolder(parent: ViewGroup): MainRecyclerViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.main_recycler_item, parent, false)
        return MainRecyclerViewHolder(itemView)
    }

    /**
     * MainRecyclerViewHolder
     */
    inner class MainRecyclerViewHolder(itemView: View) : BaseRecycleViewHolder<String>(itemView), ItemTouchHelperViewHolder {

        private val mTitleTextView: TextView = itemView.mainTitleTextView

        override fun bindViews(title: String) {
            mTitleTextView.text = title
        }

        override fun onItemSelected() {

        }

        override fun onItemClear() {

        }
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    override fun onItemDismiss(position: Int) {
        notifyItemRemoved(position)
    }

    override fun onItemMoveFinish() {
        Log.d(TAG, "onItemMoveFinish----")
    }

}
