package com.route.islami_app_c38.UI.Home.tabs.Sepha

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.viewbinding.ViewBinding
import com.route.islami_app_c38.UI.Constant
import com.route.islami_app_c38.databinding.ActivityContentBinding
import com.route.islami_app_c38.databinding.ActivityFragmentHadethBinding
import com.route.islami_app_c38.databinding.ActivityFragmentSephaBinding
import java.util.zip.Inflater

class Sepha : Fragment() {
    lateinit var imag_sebha: ImageView
    lateinit var tv_counter: TextView
    lateinit var tv_content: TextView

    var counter = 0

    lateinit var viewBinding: ActivityFragmentSephaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = ActivityFragmentSephaBinding.inflate(inflater, container, false)
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imag_sebha = viewBinding.boody
        tv_content = viewBinding.sephaContent
        tv_counter = viewBinding.sephaCount

        tv_content.text = Constant.SOBHANALLAH
        tv_counter.text = "$counter"
        imag_sebha.setOnClickListener {
            onClickSebha()
        }


    }
    fun onClickSebha(){
        imag_sebha.rotation = imag_sebha.rotation + 5

        counter++

        tv_counter.text = "$counter"

        if (tv_content.text == Constant.LA_ALAH_EL_ALLAH) {
            tv_content.text == Constant.LA_ALAH_EL_ALLAH
            counter = 0

            tv_counter.text = "$counter"
        }
        if (counter == 33) {
            if (tv_content.text == Constant.SOBHANALLAH) {
                tv_content.text == Constant.SOBHANALLAH
                counter = 0
                tv_counter.text = "$counter"
            } else if (tv_content.text == Constant.ALHAMDALLAH) {
                tv_content.text == Constant.ALLAH_AKBAR
                counter = 0
                tv_counter.text = "$counter"
            } else if (tv_content.text == Constant.ALLAH_AKBAR) {
                tv_content.text == Constant.LA_ALAH_EL_ALLAH
                counter = 0
                tv_counter.text = "$counter"
            }
        }
    }
}


