package com.hankkin.reading.ui.todo

import com.hankkin.library.mvp.contract.IBaseViewContract
import com.hankkin.library.mvp.contract.IPresenterContract

/**
 * @author wenxin
 * @date 2018/12/28
 */
interface AddToDoContract {
    interface IView : IBaseViewContract {
        fun addTodoSuccess()
        fun updateToDoSuccess()
        fun setFail()
    }

    interface IPresenter : IPresenterContract {
        fun addTodo(map: HashMap<String, Any>)
        fun updateTodo(id: Int, map: HashMap<String, Any>)
    }
}