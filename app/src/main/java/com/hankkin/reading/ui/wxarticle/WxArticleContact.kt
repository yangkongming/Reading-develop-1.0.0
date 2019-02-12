package com.hankkin.reading.ui.wxarticle

import com.hankkin.library.mvp.contract.IBaseViewContract
import com.hankkin.library.mvp.contract.IPresenterContract
import com.hankkin.reading.domain.WxArticleBean

/**
 * Created by wenxin on 2018/12/8.
 */
interface WxArticleContact {
    interface IView : IBaseViewContract {
        fun setTabs(data: MutableList<WxArticleBean>)
    }

    interface IPresenter : IPresenterContract {
        fun getWxTabs()
    }
}