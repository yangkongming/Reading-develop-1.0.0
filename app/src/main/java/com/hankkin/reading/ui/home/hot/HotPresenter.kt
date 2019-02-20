package com.hankkin.reading.ui.home.hot

import com.hankkin.reading.http.HttpClientUtils
import com.hankkin.library.mvp.presenter.RxLifePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by wenxin on 2018/12/8.
 */
class HotPresenter : RxLifePresenter<HotContact.IView>(), HotContact.IPresenter {
    /**
     *首页 热门搜索文章
     */
    override fun getHot() {
        HttpClientUtils.Builder.getCommonHttp()
                .getHot()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeNx({
                    getMvpView().setHot(it.data)
                }).bindRxLifeEx(RxLife.ON_DESTROY)
    }

}