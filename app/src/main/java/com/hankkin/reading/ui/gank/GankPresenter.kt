package com.hankkin.reading.ui.gank

import com.hankkin.library.mvp.presenter.RxLifePresenter
import com.hankkin.reading.http.HttpClientUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by wenxin on 2018/1/8.
 */
class GankPresenter : RxLifePresenter<GankContract.IView>(), GankContract.IPresenter {

    override fun getGanks(cate: String, page: Int) {
        HttpClientUtils.Builder.getGankHttp().getGank(cate, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    getMvpView().setGanks(it)
                }
                .bindRxLifeEx(RxLife.ON_DESTROY)

    }
}