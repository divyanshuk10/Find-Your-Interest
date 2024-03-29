package com.divyanshu.findyourinterest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.divyanshu.findyourinterest.databinding.FavouriteItemViewBinding
import com.divyanshu.findyourinterest.fragments.FavouriteFragment
import com.divyanshu.findyourinterest.fragments.FavouriteFragmentDirections
import com.divyanshu.findyourinterest.model.Interest
import com.divyanshu.findyourinterest.utils.Constant

class FavouriteInterestsAdapter(private val fragment: FavouriteFragment) :
    RecyclerView.Adapter<FavouriteInterestsAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: FavouriteItemViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Interest>() {
        override fun areItemsTheSame(oldItem: Interest, newItem: Interest): Boolean {
            return oldItem.key == newItem.key
        }

        override fun areContentsTheSame(oldItem: Interest, newItem: Interest): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            FavouriteItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = differ.currentList[position]
        holder.binding.apply {
            txtInterest.text = buildString {
                append("Activity :")
                append(currentItem.activity)
            }
            txtInterestParticipants.text = buildString {
                append("Participants :")
                append(currentItem.participants)
            }
            txtInterestType.text = buildString {
                append("Type :")
                append(currentItem.type)
            }
            txtInterestLink.text = buildString {
                append("Interest :")
                append(currentItem.link)
            }
            txtInterestAccessibility.text = buildString {
                append("Accessibility :")
                append(currentItem.accessibility.toString())
            }
            imgItemBody.load(Constant.hobbiesList[(0..9).random()])
        }
        holder.itemView.setOnClickListener {
            if (currentItem.link.isNotEmpty() && currentItem.link.isNotBlank()) {
                val direction =
                    FavouriteFragmentDirections.actionFavouriteFragmentToInterestDetailsFragment(
                        currentItem
                    )
                it.findNavController().navigate(direction)
            }
        }

        holder.binding.imgBtnDelete.setOnClickListener {
            fragment.deleteInterest(currentItem)
        }
    }
}