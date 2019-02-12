package com.hankkin.reading.ui.home.articledetail

import com.hankkin.library.mvp.contract.IPresenterContract
import com.hankkin.library.mvp.contract.IBaseViewContract

/**
 * Created by wenxin on 2018/1/16.
 */
interface ArticleDetailContract {

    interface IView : IBaseViewContract {
        fun collectResult()
    }

    interface IPresenter : IPresenterContract {
        fun collectHttp()
    }
}