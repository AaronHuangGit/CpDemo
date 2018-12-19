package com.android.demos.data.remote.http

import com.aaron.demo.common.BuildConfig


/**
 * 说明:
 * Author shaozucheng
 * Time:16/6/7 上午10:13
 */
object UrlList {

    private val HOST_VERSION = "/v1"

    private val versionHostUrl: String
        get() = hostUrl + HOST_VERSION

    private val hostUrl: String
        get() = BuildConfig.HTTP_HOST

    /**
     * 基础配置
     */
    val BASE_CONFIG = hostUrl + "/config/config"
    /**
     * 同步时间戳
     */
    val SYNC_SERVER_TIMESTAMP = hostUrl + "/time/timestamp"
    /**
     * 获取首页课程列表
     */
    val GET_COURSE_CATEGORY_LIST = versionHostUrl + "/course/course"
    /**
     * 获取课表
     */
    val COURSE_COURSE_SCHEDULE = versionHostUrl + "/course/course-schedule"
    /**
     * 课程详情
     */
    val COURSE_DETAILS = versionHostUrl + "/course/course-detail"
    /**
     * 检测更新
     */
    val APP_UPDATE = hostUrl + "/config/config"
    /**
     * 获取用户信息
     */
    val GET_USER_INFO = versionHostUrl + "/user/info"


}
