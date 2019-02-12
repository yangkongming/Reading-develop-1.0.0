package com.hankkin.reading.ui.tools.translate

import com.hankkin.reading.domain.TranslateBean
import com.hankkin.reading.dao.BaseDaoContract

/**
 * @author wenxin
 * @date 2018/12/10
 */
interface TranslateDaoContract : BaseDaoContract {

    fun insertTranslateHistory(translateBean: TranslateBean)
    fun queryTranslateHistoty(): MutableList<TranslateBean>?
    fun deleteTranslateHistory(id: Long)
    fun insertTranslates(data: MutableList<TranslateBean>)
}