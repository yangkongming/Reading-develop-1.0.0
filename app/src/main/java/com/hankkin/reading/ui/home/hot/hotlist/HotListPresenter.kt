package com.hankkin.reading.ui.home.hot.hotlist

import com.hankkin.reading.http.HttpClientUtils
import com.hankkin.library.mvp.presenter.RxLifePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by wenxin on 2018/1/8.
 */
class HotListPresenter : RxLifePresenter<HotListContact.IView>(), HotListContact.IPresenter {
    /**
     * 搜索
     */
    override fun queryKey(page: Int, key: String) {
        HttpClientUtils.Builder.getCommonHttp()
                .query(page, key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeNx({
                    getMvpView().setData(it.data)
                }, {
                    getMvpView().setFail()
                }).bindRxLifeEx(RxLife.ON_DESTROY)
    }

    /**
     *获取banner
     */
    override fun getBannerHttp() {
        HttpClientUtils.Builder.getCommonHttp()
                .getHomeBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeNx({
                    getMvpView().setBanner(it.data)
                }, {
                    getMvpView().setFail()
                }).bindRxLifeEx(RxLife.ON_DESTROY)
    }


}