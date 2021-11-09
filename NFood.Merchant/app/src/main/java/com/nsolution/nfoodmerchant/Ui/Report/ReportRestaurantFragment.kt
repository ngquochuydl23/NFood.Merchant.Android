package com.nsolution.nfoodmerchant.Ui.Report

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.data.*
import com.nsolution.nfoodmerchant.R
import kotlinx.android.synthetic.main.fragment_report_restaurant.*


class ReportRestaurantFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_report_restaurant, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    getOrderChart()
    getSaleChart()
  }

  private fun getOrderChart() {
    val entries = arrayListOf<Entry>()
    entries.add(Entry(1f, 2000f))
    entries.add(Entry(2f, 3000f))
    entries.add(Entry(3f, 4000f))
    entries.add(Entry(4f, 3000f))
    entries.add(Entry(5f, 3000f))
    entries.add(Entry(6f, 1000f))
    entries.add(Entry(7f, 2000F))


    val dataSet = LineDataSet(entries, getString(R.string.order))

    val acceptColor = resources.getColor(R.color.accept_color)

    orderChart.axisLeft.apply {
      setDrawLabels(false)
      setDrawAxisLine(false)
      setDrawGridLines(false)
      setDrawZeroLine(false)
    }
    orderChart.axisRight.apply {
      setDrawLabels(false)
      setDrawAxisLine(false)
      setDrawGridLines(false)
      setDrawZeroLine(false)
    }
    orderChart.xAxis.apply {
      setDrawGridLines(false)
      disableGridDashedLine()
    }

    dataSet.apply {
      color = acceptColor
      setCircleColor(acceptColor)
      lineWidth = 3f
      setDrawFilled(true)
      mode = LineDataSet.Mode.CUBIC_BEZIER
      fillColor = acceptColor
    }


    val lineData = LineData(dataSet)
    orderChart.data = lineData
    orderChart.animateY(1000)
  }

  private fun getSaleChart(){
    val entries = arrayListOf<BarEntry>()
    entries.add(BarEntry(1f, 2000f))
    entries.add(BarEntry(2f, 3000f))
    entries.add(BarEntry(3f, 4000f))
    entries.add(BarEntry(4f, 3000f))
    entries.add(BarEntry(5f, 3000f))
    entries.add(BarEntry(6f, 1000f))
    entries.add(BarEntry(7f, 2000F))

    saleChart.axisLeft.apply {
      setDrawAxisLine(false)
      setDrawGridLines(false)
      setDrawZeroLine(false)
    }
    saleChart.axisRight.apply {
      setDrawLabels(false)
      setDrawAxisLine(false)
      setDrawGridLines(false)
      setDrawZeroLine(false)
    }
    saleChart.xAxis.apply {
      setDrawGridLines(false)
      disableGridDashedLine()
      setDrawAxisLine(false)
      setDrawLabels(false)
    }

    val dataSet = BarDataSet(entries, getString(R.string.total_sales))
    dataSet.apply {
      color = resources.getColor(R.color.accept_color)
    }
    val data = BarData(dataSet)

    saleChart.data = data
    saleChart.animateY(1000)
  }
}
