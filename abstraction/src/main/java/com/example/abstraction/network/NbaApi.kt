package com.example.abstraction.network

import com.example.abstraction.data.TeamApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface NbaApi {
    @GET("teams")
    suspend fun getAllTeam(@QueryMap data: Map<String, String>): Response<TeamApiResponse>
}