package com.hankkin.reading.ui.home.project

import com.hankkin.reading.http.HttpClientUtils
import com.hankkin.library.mvp.presenter.RxLifePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by wenxin on 2018/11/8.
 */
class ProjectPresenter : RxLifePresenter<ProjectContact.IView>(), ProjectContact.IPresenter {
    override fun getCatesHttp() {
        /**
         * 首页项目分类
         */
        HttpClientUtils.Builder.getCommonHttp()
                .getProject()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeNx({
                    getMvpView().setCates(it.data)
                }).bindRxLifeEx(RxLife.ON_DESTROY)

    }


}