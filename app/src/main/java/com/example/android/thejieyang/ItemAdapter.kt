package com.example.android.thejieyang

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ItemAdapter(activity: Activity,val resourceId:Int,data:List<Item>):ArrayAdapter<Item>(activity,resourceId,data) {


    inner class ViewHolder(val itemImage:ImageView,val itemName:TextView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view:View
        val viewHolder:ViewHolder
        if(convertView==null){
            view = LayoutInflater.from(context).inflate(resourceId,parent,false)
            val itemImage:ImageView = view.findViewById(R.id.itemImage)
            val itemName:TextView = view.findViewById(R.id.itemName)
            viewHolder = ViewHolder(itemImage,itemName)
            view.tag = viewHolder
        }else{
            view=convertView
            viewHolder = view.tag as ViewHolder
        }
//        var itemImage:ImageView = view.findViewById(R.id.itemImage)
//        var itemName:TextView = view.findViewById(R.id.itemName)
        var item = getItem(position)//获取当前的item
        if(item!=null){
            viewHolder.itemImage.setImageResource(item.imageId)
            viewHolder.itemName.text = item.name
        }
        return view
    }
}