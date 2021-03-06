package com.hankkin.reading.ui.person

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.afollestad.materialdialogs.MaterialDialog
import com.hankkin.library.utils.*
import com.hankkin.reading.R
import com.hankkin.reading.base.BaseActivity
import com.hankkin.reading.common.Constant
import com.hankkin.reading.event.EventMap
import com.hankkin.reading.utils.DBUtils
import com.hankkin.reading.utils.LoadingUtils
import com.hankkin.reading.utils.ThemeHelper
import com.hankkin.reading.utils.ViewHelper
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : BaseActivity() {


    private var mCurrentTheme: Int = 0

    override fun isHasBus(): Boolean {
        return true
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_setting
    }

    override fun initViews(savedInstanceState: Bundle?) {

        setMiuiStatusBar()

        mCurrentTheme = ThemeHelper.getTheme(this)
        tv_setting_theme_value.text = ThemeHelper.getName(this, mCurrentTheme)
        rl_setting_theme.setOnClickListener { startActivity(Intent(this, ThemeActivity::class.java)) }

        //数据备份
        switch_lock_backup.setOnCheckedChangeListener { buttonView, isChecked ->
            SPUtils.put(Constant.SP_KEY.LOCK_BACKUP_OPEN, if (isChecked) 1 else 0)
            ll_setting_backup.visibility = if (isChecked) View.VISIBLE else View.GONE
        }
        //数据备份
        rl_setting_data_backup.setOnClickListener {
            if (DBUtils.isNeedBackup(this)) {
                LoadingUtils.showLoading(this)
                val disposable = Observable.create<Boolean> {
                    try {
                        DBUtils.saveDBData(this)
                        it.onNext(true)
                        it.onComplete()
                    } catch (e: Exception) {
                        it.onError(e)
                    }
                }
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            LoadingUtils.hideLoading()
                            ToastUtils.showSuccess(this, resources.getString(R.string.setting_lock_backup_success))
                        }, {
                            LoadingUtils.hideLoading()
                            ToastUtils.showError(this, resources.getString(R.string.setting_lock_backup_fail))
                        })
                disposables.add(disposable)
            } else {
                ToastUtils.showInfo(this, resources.getString(R.string.setting_lock_backup_new))
            }

        }

        //数据还原
        rl_setting_data_restore.setOnClickListener {
            LoadingUtils.showLoading(this)
            val disposable = Observable.create<Boolean> {
                try {
                    DBUtils.loadDBData(this)
                    it.onNext(true)
                    it.onComplete()
                } catch (e: Exception) {
                    it.onError(e)
                }
            }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        LoadingUtils.hideLoading()
                        ToastUtils.showInfo(this, resources.getString(R.string.setting_lock_data_restore_success))
                    }, {
                        LoadingUtils.hideLoading()
                        ToastUtils.showError(this, resources.getString(R.string.setting_lock_data_restore_fail))
                    })
            disposables.add(disposable)

        }

        //数据清空
        rl_setting_data_clear.setOnClickListener {
            ViewHelper.showConfirmDialog(this, resources.getString(R.string.setting_db_delete_hint),
                    MaterialDialog.SingleButtonCallback { dialog, which ->
                        DBUtils.deleteData(this)
                        ToastUtils.showSuccess(this, resources.getString(R.string.setting_db_delete_success))
                    })
        }

        rl_setting_clear_cache.setOnClickListener {
            ViewHelper.showConfirmDialog(this,
                    resources.getString(R.string.setting_clear_cache_hint),
                    MaterialDialog.SingleButtonCallback { dialog, which ->
                        CacheUtils.clearGlideImg(this)
                        ToastUtils.showInfo(this, resources.getString(R.string.setting_clear_cache_success))
                        tv_setting_cache_size.text = "0KB"
                    })
        }

        tv_setting_version.text = "V " + AppUtils.getVersionName(this)
    }

    override fun initData() {
        tv_setting_cache_size.text = CacheUtils.getCachesSize(this, Constant.COMMON.DB_NAME)
    }

    override fun onEvent(event: EventMap.BaseEvent) {
        if (event is EventMap.ChangeThemeEvent) {
            mCurrentTheme = ThemeHelper.getTheme(this)
            tv_setting_theme_value.text = ThemeHelper.getName(this, mCurrentTheme)
        }
    }

}
