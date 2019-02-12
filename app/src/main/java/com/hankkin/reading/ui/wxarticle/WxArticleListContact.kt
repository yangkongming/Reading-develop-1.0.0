package com.hankkin.reading.ui.wxarticle

import com.hankkin.library.mvp.contract.IBaseViewContract
import com.hankkin.library.mvp.contract.IPresenterContract
import com.hankkin.reading.domain.WxArticleListBean

/**
 * Created by wenxin on 2018/12/8.
 */
interface WxArticleListContact {

    interface IView : IBaseViewContract {
        fun setWxArticles(data: WxArticleListBean)
    }

    interface IPresenter : IPresenterContract {
        fun getWxArticleList(id: Int, page: Int)
    }
}