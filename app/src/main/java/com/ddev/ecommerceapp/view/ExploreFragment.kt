package com.ddev.ecommerceapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddev.ecommerceapp.adapter.PriceOffAdapter
import com.ddev.ecommerceapp.model.PriceOffData
import com.ddev.ecommerceapp.R
import kotlinx.android.synthetic.main.fragment_explore.*
import java.util.*

class ExploreFragment : Fragment() {

    private val priceOffAdapter by lazy { PriceOffAdapter() }
    private val priceList = ArrayList<PriceOffData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_explore, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        price_off_recyclerview.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.HORIZONTAL,
            false

        )
        price_off_recyclerview.setHasFixedSize(true)

        priceList.add(PriceOffData(R.drawable.price))
        priceList.add(PriceOffData(R.drawable.price))
        priceList.add(PriceOffData(R.drawable.price))


        price_off_recyclerview.adapter = priceOffAdapter
        priceOffAdapter.setData(priceList)

    }

}