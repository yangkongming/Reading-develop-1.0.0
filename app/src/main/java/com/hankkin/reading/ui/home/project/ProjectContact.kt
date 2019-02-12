package com.hankkin.reading.ui.home.project

import com.hankkin.reading.domain.CateBean
import com.hankkin.library.mvp.contract.IBaseViewContract
import com.hankkin.library.mvp.contract.IPresenterContract

/**
 * Created by wenxin on 2018/12/8.
 */
interface ProjectContact {
    interface IView : IBaseViewContract {
        fun setCates(data: MutableList<CateBean>)
    }

    interface IPresenter : IPresenterContract {
        fun getCatesHttp()
    }
}