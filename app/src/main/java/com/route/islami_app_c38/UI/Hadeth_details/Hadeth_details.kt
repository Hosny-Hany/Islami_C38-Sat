package com.route.islami_app_c38.UI.Hadeth_details

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.SyncStateContract.Constants
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.route.islami_app_c38.UI.Constant
import com.route.islami_app_c38.UI.Home.Model.Hadeth
import com.route.islami_app_c38.databinding.ActivityHadethDetailsBinding

class Hadeth_details :AppCompatActivity() {
    lateinit var ViewBinding: ActivityHadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewBinding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(ViewBinding.root)
        initViews()
        Linitiatparams()
        bindhadeth()
    }

    private fun initViews() {
        setSupportActionBar(ViewBinding.bottomNav)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun bindhadeth() {
        ViewBinding.title.text = hadeth?.title
        ViewBinding.content1.hadethText.text = hadeth?.content
    }

     var hadeth: Hadeth ?=null

    private fun Linitiatparams() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeth = intent.getParcelableExtra(Constant.EXTRA_HADETH, Hadeth::class.java)
        } else {
            hadeth = intent.getSerializableExtra(Constant.EXTRA_HADETH) as Hadeth?
        }
    }
}