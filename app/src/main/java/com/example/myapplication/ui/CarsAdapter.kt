package com.example.myapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemCarBinding
import com.example.myapplication.model.CarModel
import com.example.myapplication.utils.Utils.circularDrawable


class CarsAdapter(private val list: MutableList<CarModel>) :
    RecyclerView.Adapter<CarsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCarBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(private val binding: ItemCarBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(carModel: CarModel) {
            binding.apply {

                Glide.with(binding.root.context)
                    .load(carModel.imageUrl)
                    .placeholder(circularDrawable(binding.root.context))
                    .into(binding.ivImage)

                tvBrand.text = carModel.brand
                tvIsUsed.text = carModel.isUsed.toString()
                tvConstructionYear.text = carModel.constructionYear

            }
        }

    }
}