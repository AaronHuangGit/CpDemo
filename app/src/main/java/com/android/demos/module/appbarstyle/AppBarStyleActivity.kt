package com.android.demos.module.appbarstyle

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.ActionBar
import android.view.Gravity
import com.aaron.demo.common.base.activity.BaseActivity
import com.aaron.demo.common.base.widget.pager.TabFragmentPagerAdapter
import com.android.demos.R
import com.yueren.util.DisplayUtils
import kotlinx.android.synthetic.main.activity_custom_view.*
import java.util.*


/**
 * Created on 16/4/21.
 *
 * @author aaron.huang
 * @version 1.0.0
 */
class AppBarStyleActivity : BaseActivity() {
    private val DP = 10
    private val ALPHA = 0.8f
    private var mSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)
        initToolbar()
        val tabFragmentPagerAdapter = TabFragmentPagerAdapter(this, supportFragmentManager, buildFragmentBinders())
        appStyleViewPager.adapter = tabFragmentPagerAdapter
        appStyleTabLayout.setupWithViewPager(appStyleViewPager)
    }

    private fun initToolbar() {
        setSupportActionBar(appStyleToolBar)
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.title = "AppBarStyle"
        val customView = layoutInflater.inflate(R.layout.layout_toolbar_custom_view, null)
        customView.setOnClickListener {
            mSnackbar = Snackbar.make(it, "Custom mView click", Snackbar.LENGTH_LONG)
                    .setAction("OK") { mSnackbar!!.dismiss() }
            val snackBarLayout = mSnackbar!!.view as Snackbar.SnackbarLayout
            snackBarLayout.alpha = ALPHA
            mSnackbar!!.show()
        }

        val customLayoutParams = ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT)
        customLayoutParams.gravity = Gravity.RIGHT
        customLayoutParams.rightMargin = DisplayUtils.dp2px(this, DP.toFloat())
        actionBar.setCustomView(customView,
                customLayoutParams)
        actionBar.setDisplayShowCustomEnabled(true)

    }

    private fun buildFragmentBinders(): List<TabFragmentPagerAdapter.FragmentBinder> {
        val fragmentBinders = ArrayList<TabFragmentPagerAdapter.FragmentBinder>()
        val fragmentBinder01 = TabFragmentPagerAdapter.FragmentBinder(0, "Tab01", 0, AppBarStyleFragment())
        val fragmentBinder02 = TabFragmentPagerAdapter.FragmentBinder(1, "Tab02", 0, AppBarStyleFragment())
        fragmentBinders.add(fragmentBinder01)
        fragmentBinders.add(fragmentBinder02)
        return fragmentBinders
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
