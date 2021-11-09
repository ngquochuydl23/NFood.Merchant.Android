package com.nsolution.nfoodmerchant.Network

import com.nsolution.nfoodmerchant.Models.SignUpInputDto
import com.nsolution.nfoodmerchant.Models.ResultAction
import com.nsolution.nfoodmerchant.Models.ResultTokenDto
import com.nsolution.nfoodmerchant.Models.SignInInputDto
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface IAccount {
  @POST("Account/SignIn")
  fun signInAction(
    @Body signInInput: SignInInputDto?
  ): Observable<ResultAction<ResultTokenDto>>

  @POST("Account/SignUp")
  fun signUpAction(
    @Body signUpInput: SignUpInputDto?
  ): Observable<ResultAction<ResultTokenDto>>
}