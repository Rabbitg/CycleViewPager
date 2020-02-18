package com.example.cycleviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    internal var movieList:MutableList<Movie> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        val adapter = MyAdapter(this@MainActivity,movieList)
        viewpager.adapter = adapter
    }

    private fun initData() {
        movieList.add(Movie("C A R", getString(R.string.long_text),R.drawable.one))
        movieList.add(Movie("C A R", getString(R.string.long_text2),R.drawable.two))
        movieList.add(Movie("C A R", getString(R.string.long_text3),R.drawable.three))
    }
}
