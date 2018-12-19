package com.classba.nnyc.storage

import android.content.Context
import android.content.SharedPreferences
import com.aaron.demo.common.app.AppConfig

/**
 * Created on 15/7/23.
 *
 * @author ran.huang
 * @version 1.0.0
 */
object Preference {

    /**
     * 初始化SharedPreferences
     */
    private var instance: SharedPreferences? = null
    private val TAG = "AbsPreference"
    private val FIRSTINTOAPP = "isFistIntoApp"
    private val TOKEN = "token"
    private val USERMOBILE = "userMobile"
    private val REGISTRATION_ID = "registrationId"
    private val USERAVATAR = "userAvatar"
    private val USERNAME = "userName"
    private val USERAREA = "userArea"
    private val LOGINTYPE = "loginType"
    private val SIMLE_ZIP_URL = "simpleuniturl"
    private val HOST_URL = "hostUrl"

    fun init(context: Context?) {
        if (instance == null) {
            instance = context!!.getSharedPreferences(AppConfig.appFlag, Context.MODE_PRIVATE)
        }
    }

    /**
     * 清空SharedPreferences
     */
    fun clear() {
        instance!!.edit().clear().apply()
    }

    /**
     * 根据Key移除SharedPreferences
     *
     * @param key key
     */
    fun remove(key: String) {
        instance!!.edit().remove(key).apply()
    }

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param key    Key
     * @param object 需要存的引用对象
     * @return 数据是否成功存储
     */
    fun setObject(key: String, `object`: Any?): Boolean {
        if (`object` == null) {
            return false
        }
        val type = `object`.javaClass.simpleName
        val editor = instance!!.edit()
        when (type) {
            "String" -> editor.putString(key, `object` as String?)
            "Integer" -> editor.putInt(key, (`object` as Int?)!!)
            "Boolean" -> editor.putBoolean(key, (`object` as Boolean?)!!)
            "Float" -> editor.putFloat(key, (`object` as Float?)!!)
            "Long" -> editor.putLong(key, (`object` as Long?)!!)
        }
        return editor.commit() //为保证后面取值的正确性,这里使用同步存储(线程阻塞)commit方法
        //为保证后面取值的正确性,这里使用同步存储(线程阻塞)commit方法
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     * @param key           Key
     * @param defaultObject 默认值
     * @return 取值
     */
    fun getObject(key: String, defaultObject: Any): Any? {
        val type = defaultObject.javaClass.simpleName
        return when (type) {
            "String" -> instance!!.getString(key, defaultObject as String)
            "Integer" -> instance!!.getInt(key, defaultObject as Int)
            "Boolean" -> instance!!.getBoolean(key, defaultObject as Boolean)
            "Float" -> instance!!.getFloat(key, defaultObject as Float)
            "Long" -> instance!!.getLong(key, defaultObject as Long)
            else -> null
        }

    }

}
