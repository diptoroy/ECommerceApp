package com.ddev.ecommerceapp.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ddev.ecommerceapp.R
import com.ddev.ecommerceapp.adapter.FlowerAdapter
import com.ddev.ecommerceapp.adapter.ItemAdapter
import com.ddev.ecommerceapp.model.FlowerData
import com.ddev.ecommerceapp.model.SliderData
import com.ddev.ecommerceapp.onclickListener.OnClickListener
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_flowers.*
import kotlinx.android.synthetic.main.fragment_vapes.*
import kotlinx.android.synthetic.main.fragment_vapes.view.*
import java.util.ArrayList


class VapesFragment : Fragment(),OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_vapes, container, false)

        var skillAdapter = ItemAdapter(childFragmentManager,lifecycle)
        view.itemViewPager.adapter = skillAdapter
        TabLayoutMediator(view.itemTabLayout,view.itemViewPager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when(position){
                    0 -> {
                        tab.text = "Flowers"
                    }
                    1 -> {
                        tab.text = "Vapes"
                    }
                    2 -> {
                        tab.text = "Extracts"
                    }
                    3 -> {
                        tab.text = "Edibles"
                    }
                    4 -> {
                        tab.text = "Accessories"
                    }
                }
            }).attach()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)


    }
    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        var menuItem: MenuItem = menu.findItem(R.id.search)
        menuItem.isVisible = false
    }

    override fun onClick(item: FlowerData, position: Int) {
        TODO("Not yet implemented")
    }

}