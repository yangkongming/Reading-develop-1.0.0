package com.hankkin.reading.ui.home.hot.hotlist

import com.hankkin.reading.domain.ArticleBean
import com.hankkin.reading.domain.BannerBean
import com.hankkin.library.mvp.contract.IBaseViewContract
import com.hankkin.library.mvp.contract.IPresenterContract

/**
 * Created by wenxin on 2018/1/8.
 */
interface HotListContact {
    interface IView : IBaseViewContract {
        fun setBanner(banner: MutableList<BannerBean>)
        fun setFail()
        fun setData(data: ArticleBean)
    }

    interface IPresenter : IPresenterContract {
        fun queryKey(page: Int, key: String)
        fun getBannerHttp()
    }
}