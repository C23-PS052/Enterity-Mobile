package com.bangkit.enterity.ui.main.fragment.analytics

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bangkit.enterity.R
import com.bangkit.enterity.databinding.FragmentAnalyticsBinding

class AnalyticsFragment : Fragment() {

    private lateinit var binding : FragmentAnalyticsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnalyticsBinding.inflate(layoutInflater)

        binding.apply {

            layoutCardProyeksi.barChart.animation.duration = animationDuration
            layoutCardProyeksi.barChart.animate(barSet)

//            barChartHorizontal.animation.duration = animationDuration
//            barChartHorizontal.animate(horizontalBarSet)

            layoutCardPendapatan.barChartPendapatan.animation.duration = animationDuration
            layoutCardPendapatan.barChartPendapatan.animate(barSetPendapatan)

            layoutCardChannel.chartChannel.donutColors = intArrayOf(
                Color.parseColor("#03AC0E"),
                Color.parseColor("#EE4D2D"),
            )
            layoutCardChannel.chartChannel.animation.duration = animationDuration
            layoutCardChannel.chartChannel.animate(donutSet)


        }

        return binding.root
    }

    companion object{
        private val barSet = listOf(
            "1" to 4F,
            "2" to 7F,
            "3" to 2F,
            "4" to 2.3F,
            "5" to 5F
        )

        private val barSetPendapatan = listOf(
            "1" to 4F,
            "2" to 7F,
            "3" to 2F,
            "4" to 2.3F,
            "5" to 5F
        )

        private val donutSet = listOf(
            60f,
            40f

        )



        private const val animationDuration = 1000L
    }


}