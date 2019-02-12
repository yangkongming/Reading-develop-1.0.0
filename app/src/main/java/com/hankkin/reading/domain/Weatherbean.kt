package com.hankkin.reading.domain

/**
 * Created by wenxin on 2018/11/16.
 */
data class Weatherbean(val results: MutableList<Resultes>)

data class Resultes(val location: Location, val now: Now, val last_update: String)

data class Location(val id: String, val name: String, val country: String, val path: String, val timezone: String, val timezone_offset: String)

data class Now(val text: String, val code: String, val temperature: String)