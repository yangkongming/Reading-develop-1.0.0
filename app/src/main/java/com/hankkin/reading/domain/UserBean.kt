package com.hankkin.reading.domain

/**
 * Created by wenxin on 2018/11/22.
 */
data class UserBean(val id: Int, val email: String, val password: String, val icon: String,
                    val username: String, val type: Int,
                    val collectIds: MutableList<String>)

