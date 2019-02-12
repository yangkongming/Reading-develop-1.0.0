package com.hankkin.reading.domain

/**
 * Created by wenxin on 2018/11/6.
 */
data class NewsListBean(val id: Int,
                        val author: String,
                        val pubDate: String,
                        val title: String,
                        val authorid: Long,
                        val commentCount: Int,
                        val type: Int)