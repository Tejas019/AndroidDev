package com.tejas.architecturesamples.ui

import android.support.v7.util.SortedList
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.util.SortedListAdapterCallback
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tejas.architecturesamples.R
import kotlinx.android.synthetic.main.list_item_data.view.*

class DataAdapter: RecyclerView.Adapter<DataAdapter.DataHolder>() {

    lateinit var mSortedList: SortedList<MyData>

    init {
        mSortedList = SortedList(MyData::class.java, object:SortedListAdapterCallback<MyData>(this) {
            override fun areItemsTheSame(p0: MyData?, p1: MyData?): Boolean {
                return p0?.id!! == p1?.id!!
            }

            override fun compare(p0: MyData?, p1: MyData?): Int {
                return p0?.id!!.compareTo(p1?.id!!)
            }

            override fun areContentsTheSame(p0: MyData?, p1: MyData?): Boolean {
                return p0 == p1
            }
        })
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_data, parent, false)
        return DataHolder(itemView = itemView)
    }

    override fun getItemCount(): Int {
        return mSortedList.size()
    }

    override fun onBindViewHolder(dataHolder: DataHolder, position: Int) {
        dataHolder.itemView.tvTitle.text = mSortedList[position].title
    }


    inner class DataHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView)

    fun setData(dataList: List<MyData>) {
        mSortedList.replaceAll(dataList)
    }
}