package com.tlenparty.translator.data.remote

import com.tlenparty.translator.model.data.DataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("words/search")
    suspend fun search(@Query("search") word:String): List<DataModel>
}