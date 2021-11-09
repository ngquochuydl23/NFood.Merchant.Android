package com.nsolution.nfoodmerchant.Ui.MenuManagement.SetupMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter.OverviewCategoryAdapter
import com.nsolution.nfoodmerchant.Network.IHttpClient
import com.nsolution.nfoodmerchant.Network.IMenu

import com.nsolution.nfoodmerchant.R
import com.nsolution.nfoodmerchant.Ui.Base.BaseFragment
import com.nsolution.nfoodmerchant.Ui.CustomView.BottomSheetView.AddFoodOrCategotyBottomSheet
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_setup_all_food.*

class SetupAllFoodFragment : BaseFragment() {

  lateinit var bottomSheetFragment: AddFoodOrCategotyBottomSheet
  lateinit var service: IMenu

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_setup_all_food, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    service = IHttpClient.retrofit.create(IMenu::class.java)
    bottomSheetFragment = AddFoodOrCategotyBottomSheet()

    initialView()
    getCategories()
  }

  private fun initialView(){
    progressBar.visibility = View.VISIBLE
    addItemOrCategory.setOnClickListener {
      bottomSheetFragment.show(childFragmentManager, bottomSheetFragment.tag)
    }
    categories.layoutManager = LinearLayoutManager(context)
  }

  private fun getCategories(){
    service.getAll(tokenAuthenticate)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribeOn(Schedulers.io())
      .subscribe({
        categories.adapter = OverviewCategoryAdapter(it.result, true)
        progressBar.visibility = View.GONE
      }, {
        progressBar.visibility = View.GONE
        it.printStackTrace()
      })
  }
}
