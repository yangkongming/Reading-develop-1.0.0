package com.hankkin.reading.ui.home.project.projectlist

import com.hankkin.reading.domain.ArticleBean
import com.hankkin.library.mvp.contract.IBaseViewContract
import com.hankkin.library.mvp.contract.IPresenterContract

/**
 * Created by wenxin on 2018/12/8.
 */
interface ProjectListContact {
    interface IView : IBaseViewContract {
        fun setCateList(data: ArticleBean)
        fun setFail()
    }

    interface IPresenter : IPresenterContract {
        fun getCateList(page: Int, cid: Int)
    }
}