package org.andcreator.iconpack.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import org.andcreator.iconpack.bean.LauncherItem
import org.andcreator.iconpack.R
import org.andcreator.iconpack.holder.LauncherHolder
import org.andcreator.iconpack.view.FastScrollRecyclerView
import java.util.*
import kotlin.collections.ArrayList

class LauncherAdapter(private val context: Context,
                      private val launchers: ArrayList<LauncherItem>,
                      private val listener: LauncherHolder.OnLauncherClickListener): RecyclerView.Adapter<LauncherHolder>(), FastScrollRecyclerView.SectionedAdapter {

    override fun getSectionName(position: Int): String {
        return launchers[position].name.substring(0, 1).toUpperCase(Locale.ENGLISH)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): LauncherHolder {
        val inflater = LayoutInflater.from(p0.context)
        return LauncherHolder(inflater.inflate(R.layout.item_launcher, p0, false),listener)
    }

    override fun getItemCount(): Int {
        return launchers.size
    }

    override fun onBindViewHolder(p0: LauncherHolder, p1: Int) {
        p0.setItem(context, launchers[p0.adapterPosition])
    }
}