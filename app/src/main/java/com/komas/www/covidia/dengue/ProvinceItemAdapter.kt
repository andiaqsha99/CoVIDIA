package com.komas.www.covidia.dengue

import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.komas.www.covidia.R
import com.komas.www.covidia.data.response.dbd.DbdResponse
import com.komas.www.covidia.data.response.dbd.ProvinceModel
import kotlinx.android.synthetic.main.item_province.view.*

class ProvinceItemAdapter: RecyclerView.Adapter<ProvinceItemAdapter.ItemViewHolder>() {
    private val listItem = ArrayList<ProvinceModel>()

    fun setData(data: DbdResponse) {
        listItem.clear()
        listItem.add(ProvinceModel(data.source, data.numberOfCase, data.numberDeath))
        listItem.addAll(data.spread)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProvinceItemAdapter.ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_province, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: ProvinceItemAdapter.ItemViewHolder, position: Int) {
        if (position == 0) {
            holder.bindFirst(listItem[position])
        } else {
            holder.bindItem(listItem[position])
        }
    }

    inner class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItem(province: ProvinceModel){
            with(itemView) {
                txt_case.text = "Kasus: " + province.kasus
                txt_death.text = "Meninggal: " + province.meninggal
                tv_province_name.text = province.nama
            }
        }
        fun bindFirst(province: ProvinceModel) {
            with(itemView) {
                tv_province_name.text = "Kasus: " + province.kasus
                txt_case.text = "Meninggal: " + province.meninggal
                txt_death.text = "Sumber: " + province.nama
                Linkify.addLinks(txt_death, Linkify.WEB_URLS)
                txt_death.linksClickable = true

            }
        }
    }
}