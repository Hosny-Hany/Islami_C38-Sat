package com.route.islami_app_c38.UI.chapterDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.islami_app_c38.UI.Constant
import com.route.islami_app_c38.databinding.ActivityChapterDetailsBinding


class ChapterDetails_Activity : AppCompatActivity(){
    lateinit var ViewBinding : ActivityChapterDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewBinding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView (ViewBinding.root)
        inintparam()
        readFileText()
        iniatView()
    }

    private fun iniatView() {
        setSupportActionBar(ViewBinding.bottomNav)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        ViewBinding.title.text = chapterName
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        // on BackPressed()
        return true
    }

    private fun readFileText(){
        var filecontant = assets.open("$chapterIndex.txt").bufferedReader().use { it.readText()}
        var lines = filecontant.trim().split("\n")
        bindverse(lines)

    }
    lateinit var Adapter : verser_Adapter
    private fun bindverse(verses: List<String>) {
        Adapter = verser_Adapter(verses)
        ViewBinding.content.recycler.adapter = Adapter
    }

    lateinit var chapterName: String
    var chapterIndex : Int = 0
    private fun inintparam() {
        chapterName = intent.getStringExtra(Constant.EXTRA_CHAPTER_NAME)?:""
        chapterIndex = intent.getIntExtra(Constant.EXTRA_CHAPTER_INDEX,0)
    }
}