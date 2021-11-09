package com.nsolution.nfoodmerchant.Ui.Report

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter.MostFavouriteFoodAdapter
import com.nsolution.nfoodmerchant.Adapter.RecyclerView.Adapter.TrendingFoodAdapter
import com.nsolution.nfoodmerchant.Models.ItemMostFavouriteFoodDto
import com.nsolution.nfoodmerchant.Models.ItemTrendingFoodDto
import com.nsolution.nfoodmerchant.R
import kotlinx.android.synthetic.main.fragment_report_food.*

class ReportFoodFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_report_food, container, false)
  }


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    listTrending.layoutManager = LinearLayoutManager(context)
    listFavourite.layoutManager = LinearLayoutManager(context)

    getListTrendingFood()
    getMostFavouriteFood()
  }

  private fun getListTrendingFood(){
    val itemTrending = ItemTrendingFoodDto().apply {
      id = 1
      foodId = 1
      foodName = "Sữa tươi trân châu đường đen"
      foodImage = "https://pozaatea.vn/wp-content/uploads/2018/04/hockaiido.png"
      foodPrice = 34000.0
      numberOrder = 50
      categoryName = "Trà sữa "
    }
    listTrending.adapter = TrendingFoodAdapter(arrayListOf(itemTrending,itemTrending,itemTrending))

  }

  private fun getMostFavouriteFood(){
    val itemFavourite = ItemMostFavouriteFoodDto().apply {
      id = 1
      foodId = 1
      foodName = "Sữa tươi trân châu đường đen"
      foodImage = "https://pozaatea.vn/wp-content/uploads/2018/04/hockaiido.png"
      foodRated = 4.5
      numberOrder = 50
      categoryName = "Trà sữa "
    }
    listFavourite.adapter = MostFavouriteFoodAdapter(arrayListOf(itemFavourite,itemFavourite,itemFavourite))
  }
}
