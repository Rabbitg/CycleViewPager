package com.example.cycleviewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyAdapter(internal var context: Context,
                internal  var movieList:List<Movie>) : PagerAdapter(){
    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 == p1
    }

    override fun getCount(): Int {
        return movieList.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // Inflate layout
        val view = LayoutInflater.from(context).inflate(R.layout.card_item,container,false)
        // View
        val movie_image = view.findViewById<View>(R.id.movie_image) as ImageView
        val movie_title = view.findViewById<View>(R.id.movie_title) as TextView
        val movie_description = view.findViewById<View>(R.id.movie_description) as TextView
        val btn_fav = view.findViewById<View>(R.id.btn_fav) as FloatingActionButton

        //Set data
        movie_image.setImageResource(movieList[position].image)
        movie_title.text = movieList[position].name
        movie_description.text = movieList[position].description

        //Event
        view.setOnClickListener {
            //Here you can add startActivity for navigate new activity
            // In this example I just use Toast
            Toast.makeText(context,""+movieList[position].name,Toast.LENGTH_SHORT).show()
        }
        btn_fav.setOnClickListener {
            Toast.makeText(context,"Button Clicked, Add to Fav",Toast.LENGTH_SHORT).show()
        }
        container.addView(view)
        return view
    }
}