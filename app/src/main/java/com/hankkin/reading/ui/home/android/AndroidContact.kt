package com.hankkin.reading.ui.home.android

import com.hankkin.reading.domain.ArticleBean
import com.hankkin.library.mvp.contract.IBaseViewContract
import com.hankkin.library.mvp.contract.IPresenterContract

/**
 * Created by wenxin on 2018/1/8.
 */
interface AndroidContact {
    interface IView : IBaseViewContract {
        fun setArticle(articleBean: ArticleBean)
        fun setFail()
        fun collectResult(id: Int)
        fun cancelCollectResult(id: Int)
    }

    interface IPresenter : IPresenterContract {
        fun getArticle(page: Int)
        fun collectHttp(id: Int)
        fun cancelCollectHttp(id: Int)
    }
}
