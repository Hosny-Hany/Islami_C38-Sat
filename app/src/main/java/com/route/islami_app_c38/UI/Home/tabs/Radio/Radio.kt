package com.route.islami_app_c38.UI.Home.tabs.Radio

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import com.route.islami_app_c38.databinding.ActivityContentBinding
import com.route.islami_app_c38.databinding.ActivityFragmentHadethBinding
import com.route.islami_app_c38.databinding.ActivityFragmentRadioBinding
import java.util.zip.Inflater

class Radio : Fragment() {

    lateinit var viewBinding: ActivityFragmentRadioBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = ActivityFragmentRadioBinding.inflate(inflater,container,false)
        return viewBinding.root

    }
}