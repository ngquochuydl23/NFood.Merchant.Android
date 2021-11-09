package com.nsolution.nfoodmerchant.Ui.Promotions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter.PromotionAdapter
import com.nsolution.nfoodmerchant.Models.ItemPromotionDto

import com.nsolution.nfoodmerchant.R
import kotlinx.android.synthetic.main.fragment_history_promotion.*

class HistoryPromotionFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_history_promotion, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initialView()
    getCurrentPromotion()
  }

  private fun initialView(){
    listPromotion.layoutManager = LinearLayoutManager(context)
  }

  private fun getCurrentPromotion(){
    val itemPromotions = ItemPromotionDto().apply {
      promoId = 1
      promoTitle = "Get 30% off for the New Year !"
      promoSubtitle = "30% off Nasi Goreng, Nasi Lemak, Nasi"
      promoDate = "20 Jan 2021 - 31 Jan 2020"
      promoStatus = "Ended"
    }

    listPromotion.adapter = PromotionAdapter(arrayListOf(itemPromotions,itemPromotions,itemPromotions,itemPromotions))
  }
}
