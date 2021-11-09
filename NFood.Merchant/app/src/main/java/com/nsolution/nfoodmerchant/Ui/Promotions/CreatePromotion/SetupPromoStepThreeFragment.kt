package com.nsolution.nfoodmerchant.Ui.Promotions.CreatePromotion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.nsolution.nfoodmerchant.R

class SetupPromoStepThreeFragment : Fragment() {


  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_setup_promo_step_three, container, false)
  }

}
