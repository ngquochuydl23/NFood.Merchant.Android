package com.nsolution.nfoodmerchant.Adapter.RecyclerView.Holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.nsolution.nfoodmerchant.R
import com.willy.ratingbar.ScaleRatingBar

class MostFavouriteFoodHolder(itemView: View) : BaseHolder(itemView) {
  val categoryName = itemView.findViewById<TextView>(R.id.categoryName)
  val foodName = itemView.findViewById<TextView>(R.id.foodName)
  val foodImage = itemView.findViewById<ImageView>(R.id.foodImage)
  val numberOrder = itemView.findViewById<TextView>(R.id.numberOrder)
  val foodRated = itemView.findViewById<ScaleRatingBar>(R.id.foodRated)
}