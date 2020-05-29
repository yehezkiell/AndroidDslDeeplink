package com.example.team.ui

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.*
import com.example.abstraction.data.TeamApiResponse
import com.example.team.repository.TeamRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Yehezkiel on 2020-01-23
 */
@RequiresApi(Build.VERSION_CODES.N)
@UseExperimental(ExperimentalCoroutinesApi::class)
class TeamViewModel @Inject constructor(private val teamRepository: TeamRepository) : ViewModel() {

    private val teamPage = MutableLiveData(1)
    private val teamDeleteAction = MutableLiveData(-1)
    val teams: LiveData<TeamApiResponse?> = Transformations.switchMap(teamPage) {
        teamRepository.getAllTeams(teamPage.value ?: 1).catch {
            Log.e("teamnya", it.message)
        }.asLiveData()
    }

    val teamsEdited = MediatorLiveData<ArrayList<TeamApiResponse.TeamData>>()

    init {
        teamsEdited.addSource(teamPage) {
            viewModelScope.launch {
                teamRepository.getAllTeams(it).catch {
                    Log.e("teamnya", it.message)
                }.collect {
                    teamsEdited.postValue(it?.data)
                }
            }
        }

        teamsEdited.addSource(teamDeleteAction) {
            if (it != -1) {
                val teamData = teamsEdited.value

                teamData?.removeIf { data ->
                    data.id == it
                }

                teamsEdited.value = ArrayList(teamData)
            }
        }
    }

    fun setDeleteAction(teamId: Int) {
        teamDeleteAction.value = teamId
    }


}