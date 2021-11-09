package com.nsolution.nfoodmerchant.Ui.AuthScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nsolution.nfoodmerchant.R
import kotlinx.android.synthetic.main.fragment_sign_up.*
import org.angmarch.views.NiceSpinner
import org.angmarch.views.OnSpinnerItemSelectedListener

class SignUpFragment : Fragment() {

  override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_sign_up, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initialView()
  }

  private fun initialView(){
    selectDistrict.setOnSpinnerItemSelectedListener(object : OnSpinnerItemSelectedListener{
      override fun onItemSelected(parent: NiceSpinner?, view: View?, position: Int, id: Long) {

      }
    })

    selecCity.setOnSpinnerItemSelectedListener(object : OnSpinnerItemSelectedListener{
      override fun onItemSelected(parent: NiceSpinner?, view: View?, position: Int, id: Long) {

      }
    })

    selectCuisine.setOnSpinnerItemSelectedListener(object : OnSpinnerItemSelectedListener{
      override fun onItemSelected(parent: NiceSpinner?, view: View?, position: Int, id: Long) {

      }
    })

    selectCompanyType.setOnSpinnerItemSelectedListener(object : OnSpinnerItemSelectedListener{
      override fun onItemSelected(parent: NiceSpinner?, view: View?, position: Int, id: Long) {

      }
    })

    submitButton.setOnClickListener {
      findNavController().navigate(R.id.action_signUpFragment_to_verificationRegister)
    }
  }
}
