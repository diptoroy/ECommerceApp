package com.ddev.ecommerceapp.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddev.ecommerceapp.R
import com.ddev.ecommerceapp.adapter.FlowerAdapter
import com.ddev.ecommerceapp.model.FlowerData
import com.ddev.ecommerceapp.model.SliderData
import com.ddev.ecommerceapp.onclickListener.OnClickListener
import kotlinx.android.synthetic.main.fragment_flowers.*
import kotlinx.android.synthetic.main.fragment_vapes.*
import java.util.*


class FlowersFragment : Fragment(), OnClickListener {

    private val flowerAdapter by lazy { FlowerAdapter(this) }
    private val flowerList = ArrayList<FlowerData>()
    private val sliderList = ArrayList<SliderData>()
    private val sliderList2 = ArrayList<SliderData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_flowers, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        setUpRecyclerView()

    }



    private fun setUpRecyclerView() {
        flower_recyclerview.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false

        )
        flower_recyclerview.setHasFixedSize(true)

        sliderList.add(SliderData(R.drawable.picd))
        sliderList.add(SliderData(R.drawable.picd))
        sliderList.add(SliderData(R.drawable.picd))

        sliderList2.add(SliderData(R.drawable.picb))
        sliderList2.add(SliderData(R.drawable.picc))
        sliderList2.add(SliderData(R.drawable.pica))

        flowerList.add(FlowerData(1, sliderList, "PURE SUN FARMS", "Indica Rips", 20))
        flowerList.add(FlowerData(2, sliderList2, "PURE SUN FARMS", "Indica Diba", 10))
        flowerList.add(FlowerData(3, sliderList, "PURE SUN FARMS", "Indica Blends", 30))
        flowerList.add(FlowerData(4, sliderList2, "PURE SUN FARMS", "Indica Rips", 70))
        flowerList.add(FlowerData(5, sliderList, "PURE SUN FARMS", "Indica Rips", 45))
        flowerList.add(FlowerData(6, sliderList2, "PURE SUN FARMS", "Indica Rips", 5))



        flower_recyclerview.adapter = flowerAdapter
        flowerAdapter.setData(flowerList)

    }

    override fun onClick(item: FlowerData, position: Int) {
        val intent = Intent(activity, FlowerDetailsActivity::class.java)
        intent.putExtra("id", item.id)
        intent.putExtra("name", item.itemName)
        intent.putExtra("store", item.itemStore)
        intent.putExtra("price", item.itemPrice)
        intent.putExtra("list", ArrayList(item.itemImage))
        startActivity(intent)
    }

}