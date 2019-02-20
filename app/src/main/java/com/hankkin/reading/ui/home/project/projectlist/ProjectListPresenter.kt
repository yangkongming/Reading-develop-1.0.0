package com.hankkin.reading.ui.home.project.projectlist

import com.hankkin.reading.http.HttpClientUtils
import com.hankkin.library.mvp.presenter.RxLifePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by wenxin on 2018/12/8.
 */
class ProjectListPresenter : RxLifePresenter<ProjectListContact.IView>(), ProjectListContact.IPresenter {

    override fun getCateList(page: Int, cid: Int) {
        /**
         *获取分类的文章
         */
        HttpClientUtils.Builder.getCommonHttp()
                .getArticleCid(page, cid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeNx({
                    getMvpView().setCateList(it.data)
                }, {
                    getMvpView().setFail()
                }).bindRxLifeEx(RxLife.ON_DESTROY)
    }


}