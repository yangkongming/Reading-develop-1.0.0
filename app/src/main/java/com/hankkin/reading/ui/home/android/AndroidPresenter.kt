package com.hankkin.reading.ui.home.android

import com.hankkin.reading.http.HttpClientUtils
import com.hankkin.library.mvp.presenter.RxLifePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by wenxin on 2018/1/8.
 */
class AndroidPresenter : RxLifePresenter<AndroidContact.IView>(), AndroidContact.IPresenter {
    /**
     * 取消收藏
     * 传递文章id
     */
    override fun cancelCollectHttp(id: Int) {
        HttpClientUtils.Builder.getCommonHttp()
                .cancelCollectArticle(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeNx({
                    getMvpView().cancelCollectResult(id)
                }, {
                    getMvpView().setFail()
                }).bindRxLifeEx(RxLife.ON_DESTROY)
    }

    /**
     * 收藏
     * 传递文章id
     */
    override fun collectHttp(id: Int) {
        HttpClientUtils.Builder.getCommonHttp()
                .collectArticle(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeNx({
                    getMvpView().collectResult(id)
                }, {
                    getMvpView().setFail()
                }).bindRxLifeEx(RxLife.ON_DESTROY)
    }


    /**
     * 获取文章
     * 传递page page在onLoadMore中自增
     */
    override fun getArticle(page: Int) {
        HttpClientUtils.Builder.getCommonHttp()
                .getArticle(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeNx({
                    getMvpView().setArticle(it.data)
                }, {
                    getMvpView().setFail()
                }).bindRxLifeEx(RxLife.ON_DESTROY)
    }


}