package com.alim.coroutinewithretrofit.network

import com.alim.coroutinewithretrofit.model.PostResponseDto
import retrofit2.http.GET

const val API_GATEWAY_BASE_URL = "https://jsonplaceholder.typicode.com"
interface ApiGateway {

    @GET("/posts")
    suspend fun getPosts() : List<PostResponseDto>
}