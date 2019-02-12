package com.hankkin.reading.ui.home.hot

import com.hankkin.reading.domain.HotBean
import com.hankkin.library.mvp.contract.IBaseViewContract
import com.hankkin.library.mvp.contract.IPresenterContract

/**
 * Created by wenxin on 2018/1/8.
 */
interface HotContact {
    interface IView : IBaseViewContract {
        fun setHot(data: MutableList<HotBean>)
    }

    interface IPresenter : IPresenterContract {
        fun getHot()
    }
}