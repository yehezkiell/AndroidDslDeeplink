package com.example.team.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.abstraction.base.BaseViewHolder
import com.example.abstraction.data.TeamApiResponse
import com.example.team.R
import kotlinx.android.synthetic.main.team_view_holder.view.*

/**
 * Created by Yehezkiel on 2020-01-23
 */
class TeamAdapter(val listener: TeamInterface) :
    ListAdapter<TeamApiResponse.TeamData, BaseViewHolder<*>>(TeamDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.team_view_holder, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val item = getItem(position)
        (holder as TeamViewHolder).bind(item)
    }

    inner class TeamViewHolder(private val view: View) :
        BaseViewHolder<TeamApiResponse.TeamData>(view) {

        override fun bind(element: TeamApiResponse.TeamData) {
            view.setOnClickListener {
                listener.onItemTeamClicked(element.id)
            }

            view.teamTitle.text = element.fullName
            view.teamConference.text = element.conference
        }
    }

    class TeamDiffUtil : DiffUtil.ItemCallback<TeamApiResponse.TeamData>() {
        override fun areItemsTheSame(
            oldItem: TeamApiResponse.TeamData,
            newItem: TeamApiResponse.TeamData
        ): Boolean {
            Log.e("difutilnya","masuk")
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: TeamApiResponse.TeamData,
            newItem: TeamApiResponse.TeamData
        ): Boolean {
            Log.e("difutilnya","masuk")
            return oldItem == newItem
        }
    }

    interface TeamInterface {
        fun onItemTeamClicked(position: Int)
    }
}
