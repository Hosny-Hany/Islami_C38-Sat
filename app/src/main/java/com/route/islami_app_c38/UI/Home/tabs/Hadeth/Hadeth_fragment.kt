package com.route.islami_app_c38.UI.Home.tabs.Hadeth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Contacts
import android.provider.SyncStateContract.Constants
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import com.route.islami_app_c38.UI.Constant
import com.route.islami_app_c38.UI.Hadeth_details.Hadeth_details
import com.route.islami_app_c38.UI.Home.Model.Hadeth
import com.route.islami_app_c38.databinding.ActivityFragmentHadethBinding

class Hadeth_fragment : Fragment() {

    lateinit var viewBinding: ActivityFragmentHadethBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = ActivityFragmentHadethBinding.inflate(inflater,container,false)
        return viewBinding.root
    }
    @Override
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        latiniatview()
    }
    lateinit var adapter:Hadeth_recyclerview
    private fun latiniatview() {
        adapter = Hadeth_recyclerview(null)
        adapter.onItemClickListner = Hadeth_recyclerview.onItemClickListners{
            position, hadeth ->
            ShowHadethDetails(hadeth)
        }
        viewBinding.HadethRecycleview.adapter = adapter
    }

    private fun ShowHadethDetails(hadeth: Hadeth) {
        val intent = Intent(activity,Hadeth_details::class.java)
        intent.putExtra(Constant.EXTRA_HADETH,hadeth)
        startActivity(intent)

    }


    override fun onStart() {
        super.onStart()
        LoadHadethFile()
        bindHadethList()

    }

    private fun bindHadethList() {
        adapter.bindHadethItem(hadethlist)
    }

    val hadethlist = mutableListOf<Hadeth>()

    private fun LoadHadethFile() {
        val filecontant = requireActivity().assets.open("Hadeth.txt").bufferedReader().use { it.readText()}
        val SingleHadethList = filecontant.trim().split('#')
        SingleHadethList.forEach{elemnt->

            var lines = elemnt.trim().split("\n")
            val title = lines[0]
            val content =lines.joinToString("\n")
            val hadeth = Hadeth(title, content)
            hadethlist.add(hadeth)
        }


    }

}