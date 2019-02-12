package com.hankkin.reading.ui.home.search

import com.hankkin.reading.domain.HotBean
import com.hankkin.reading.dao.BaseDaoContract

/**
 * Created by wenxin on 2018/1/25.
 */
interface SearchDaoContract : BaseDaoContract {

    fun insertHot(hotBean: HotBean)

    fun query(): MutableList<HotBean>

    fun delete(id: Long)

}