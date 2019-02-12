package com.hankkin.reading.domain

/**
 * Created by wenxin on 2018/12/11.
 */
data class UserInfoBean(val uid: Int,
                        val name: String,
                        val gender: Int,
                        val province: String,
                        val city: String,
                        val joinTime: String,
                        val lastLoginTime: String,
                        val portrait: String,
                        val fansCount: Int,
                        val favoriteCount: Int,
                        val followersCount: Int,
                        val platforms: MutableList<String>,
                        val expertise: MutableList<String>)