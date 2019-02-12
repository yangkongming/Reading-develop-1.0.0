package com.hankkin.reading

import android.app.Application
import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.hankkin.library.http.HttpConfig
import com.hankkin.library.utils.AppUtils
import com.hankkin.library.utils.SPUtils
import com.hankkin.library.widget.toasty.Toasty
import com.hankkin.reading.common.Constant
import com.hankkin.reading.greendao.DaoMaster
import com.hankkin.reading.greendao.DaoSession
import com.hankkin.reading.greendao.GreenOpenHelper
import com.hankkin.reading.utils.ThemeHelper
import com.squareup.leakcanary.LeakCanary
import com.tencent.bugly.Bugly
import com.youdao.sdk.app.YouDaoApplication

/**
 * Created by wenxin on 2018/11/8.
 */
class EApplication : Application() {


    private lateinit var daoSession: DaoSession

    companion object {
        private var instance: EApplication? = null

        fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        com.hankkin.library.utils.FileUtils.initSd(AppUtils.getAppName(this)!!)
        SPUtils.init(this, Constant.COMMON.SP_NAME)
        initCommon()
        initHttp()
        initLeakCanary()
        initDao()
        YouDaoApplication.init(this, "46dbe20b62a7eae3")
        Bugly.init(this, "61fd6ca178", false)
    }

    /**
     * 初始化http
     */
    private fun initHttp() {
        HttpConfig.setCookie(PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(this)))
    }

    private fun initCommon() {
        BGASwipeBackHelper.init(this, null)
        Toasty.Config.getInstance()
                .setInfoColor(resources.getColor(ThemeHelper.getCurrentColor(this)))
                .apply(this)
    }

    private fun initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
    }

    private fun initDao() {
        val devOpenHelper = GreenOpenHelper(this, Constant.COMMON.DB_NAME, null)
        val daoMaster = DaoMaster(devOpenHelper.writableDb)
        daoSession = daoMaster.newSession()
    }

    fun getDaoSession(): DaoSession {
        return daoSession
    }
}