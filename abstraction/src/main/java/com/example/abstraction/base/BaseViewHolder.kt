package com.example.abstraction.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Yehezkiel on 2020-01-23
 */
abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(element: T)
}