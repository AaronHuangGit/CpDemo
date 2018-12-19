package com.android.demos

import android.content.Context
import android.support.multidex.MultiDex
import com.aaron.demo.common.app.BaseApplication


/**
 * Created on 2018/4/3.
 * @author HuangRan
 * @version
 */

class DemoApplication : BaseApplication() {
    private val TAG = javaClass.simpleName

    override fun onCreate() {
        super.onCreate()
//        initProcess()
//        ApplicationHelper.printInfo()
    }

    private fun initProcess() {
//        Preference.init(this)
//        AppConfig.init(AppConfig.AppConfigData(BuildConfig.APP_FLAG,
//                BuildConfig.VERSION_CODE, BuildConfig.VERSION_NAME, BuildConfig.TEST_MODE, BuildConfig.HTTP_HOST))
//        NetworkUtils.init(this)
//        ApplicationHelper.initImageLoader(this)
//        DiskStorageManager.init(AppConfig.appFlag)
//        DisplayUtils.init(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}