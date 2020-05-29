package com.example.team.repository

import com.example.abstraction.data.TeamApiResponse
import com.example.abstraction.network.NbaApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by Yehezkiel on 2020-01-23
 */

class TeamRepository @Inject constructor(private val api: NbaApi) {

    fun getAllTeams(page: Int): Flow<TeamApiResponse?> {
        return flow {
            emit(
                api.getAllTeam(
                    mapOf(
                        "page" to page.toString(),
                        "per_page" to "10"
                    )
                )
            )
        }
            .flowOn(Dispatchers.IO)
            .map {
                if (!it.isSuccessful) throw RuntimeException(it.message())
                it.body()
            }
    }
}