package com.example.reportmusic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.json.JSONArray

class CustomAdapter(context: Context, val dataSource: JSONArray) : BaseAdapter() {

    private val thiscontext: Context = context
    private val inflater: LayoutInflater = thiscontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.length()
    }

    override fun getItem(position: Int): Any {
        return dataSource.getJSONObject(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view: View
        val holder : ViewHolder

        // 1
        if (convertView == null) {

            // 2
            view = inflater.inflate(R.layout.layout_listview, parent, false)

            // 3
            holder = ViewHolder()
            holder.titleTextView = view.findViewById(R.id.tv_name) as TextView
            holder.detailTextView = view.findViewById(R.id.tv_description) as TextView

            // 4
            view.tag = holder
        } else {
            // 5
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        // 6
        val titleTextView = holder.titleTextView
        val detailTextView = holder.detailTextView

        titleTextView.setText( dataSource.getJSONObject(position).getString("title").toString() )
        detailTextView.setText( dataSource.getJSONObject(position).getString("description").toString() )

        return view
    }
    private class ViewHolder {

        lateinit var titleTextView: TextView
        lateinit var detailTextView: TextView

    }


}
