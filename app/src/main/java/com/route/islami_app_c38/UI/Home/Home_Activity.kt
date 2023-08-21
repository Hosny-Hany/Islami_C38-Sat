package com.route.islami_app_c38.UI.Home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.navigation.NavigationBarView
import com.route.islami_app_c38.R
import com.route.islami_app_c38.UI.Home.tabs.Hadeth.Hadeth_fragment
import com.route.islami_app_c38.UI.Home.tabs.Quran.Quran
import com.route.islami_app_c38.UI.Home.tabs.Radio.Radio
import com.route.islami_app_c38.UI.Home.tabs.Sepha.Sepha
import com.route.islami_app_c38.databinding.ActivityHomeBinding


class Home_Activity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.content
            .bottomNav.setOnItemSelectedListener(
                object: NavigationBarView.OnItemSelectedListener{
                    override fun onNavigationItemSelected(item: MenuItem): Boolean {

                        when(item.itemId){
                            R.id.Q->{
                                supportFragmentManager
                                    .beginTransaction()
                                    .replace(R.id.fragmentContener,Quran())
                                    .commit()
                            }
                            R.id.S->{
                                supportFragmentManager
                                    .beginTransaction()
                                    .replace(R.id.fragmentContener,Sepha())
                                    .commit()
                            }
                            R.id.H->{
                                supportFragmentManager
                                    .beginTransaction()
                                    .replace(R.id.fragmentContener,Radio())
                                    .commit()
                            }
                            R.id.R->{
                                supportFragmentManager
                                    .beginTransaction()
                                    .replace(R.id.fragmentContener,Hadeth_fragment())
                                    .commit()
                            }
                        }
                        return true
                    }


                }
            )
        viewBinding.content.bottomNav.selectedItemId = R.id.Q

    }

}