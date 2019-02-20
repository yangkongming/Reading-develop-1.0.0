package com.hankkin.library.mvp.contract

/**
 * Created by wenxin on 2018/6/12.
 */
interface IRefresh : IBaseViewContract {
    fun refresh()
    fun refreshStop()
}