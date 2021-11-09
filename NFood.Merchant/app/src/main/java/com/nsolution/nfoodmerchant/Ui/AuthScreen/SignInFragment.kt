package com.nsolution.nfoodmerchant.Ui.AuthScreen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nsolution.nfoodmerchant.Models.SignInInputDto
import com.nsolution.nfoodmerchant.Network.IAccount
import com.nsolution.nfoodmerchant.Network.IHttpClient.Companion.retrofit
import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.SharedReferences.SaveTokenSharedPreferences
import com.nsolution.nfoodmerchant.Ui.CustomView.CustomDialog.LoadingDialog
import com.nsolution.nfoodmerchant.Ui.Order.Order
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_sign_in.*

class SignInFragment : Fragment()  {

  lateinit var service: IAccount
  lateinit var loadingDialog: LoadingDialog

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_sign_in, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    service = retrofit.create(IAccount::class.java)
    loadingDialog = LoadingDialog(context)

    signInButton.setOnClickListener {
      val email = enterEmail.text.toString()
      val password = enterPassword.text.toString()

      //loadingDialog.showDialog()
      //signInAction(email, password)

      navigateToHomescreen()
    }
  }

  private fun signInAction(email : String, Password : String){
    service.signInAction(SignInInputDto(email, Password))
      .observeOn(AndroidSchedulers.mainThread())
      .subscribeOn(Schedulers.io())
      .subscribe({
        val token = it.result?.token

        println(token)
        loadingDialog.dismiss()
        SaveTokenSharedPreferences(context).setData(token)
        navigateToHomescreen()
      }, {
        loadingDialog.dismiss()
        it.printStackTrace()
      })
  }

  private fun navigateToHomescreen() {
    val intent = Intent(context, Order::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(intent)
    requireActivity().finish()
  }
}
