package com.ddev.ecommerceapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.ddev.ecommerceapp.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(this,nav_drawer,toolbar,
            R.string.open,
            R.string.close
        )
        toggle.drawerArrowDrawable.color = resources.getColor(R.color.black)
        nav_drawer.addDrawerListener(toggle)
        toggle.syncState()

        loadFragment(ExploreFragment())

        navigation_view.setNavigationItemSelectedListener {

            var fragment: Fragment? = null

            when(it.itemId){
                R.id.explore ->{
                    fragment = ExploreFragment()
                    loadFragment(fragment)
                }
                R.id.vapes ->{
                    fragment = VapesFragment()
                    loadFragment(fragment)
                }
                R.id.extracts ->{}
                R.id.edibles ->{}
                R.id.flowers ->{}
                R.id.accessories ->{}
                R.id.logout ->{}
            }

            return@setNavigationItemSelectedListener true

        }

    }

    private fun loadFragment( fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment).commit()
        nav_drawer.closeDrawer(GravityCompat.START)
        fragmentTransaction.addToBackStack(null)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId
        when(id){
            R.id.search -> {
                val intent = Intent(this, SearchActivity::class.java)
                startActivity(intent)
            }
            R.id.cart -> {
                val intent = Intent(this, CartActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}

