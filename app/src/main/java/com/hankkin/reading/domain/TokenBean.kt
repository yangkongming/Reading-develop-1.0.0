package com.hankkin.reading.domain

/**
 * Created by wenxin on 2018/11/8.
 */
data class TokenBean(val access_token: String,
                     val refresh_token: String,
                     val token_type: String,
                     val expires_in: Long,
                     val uid: Int)