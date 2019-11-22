package ru.jdroid.exlistview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // find the ListView by id
        val listView: ListView = findViewById(R.id.lv_list1)

        // create data set for our list (take data from internet or e.t.c...)
        val images: Array<Int> = arrayOf(
            R.drawable.img1, R.drawable.img2, R.drawable.img3,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background
        )
        val titles: Array<String> = arrayOf(
            "Title1", "2 title", " other ...",
            " other ...",
            " other ...",
            " other ...",
            " other ...",
            " other ...",
            " other ...",
            " other ...",
            " other ...",
            " other ..."
        )
        val descriptions: Array<String> = arrayOf(
            "d1", "dddwdwdwdadasdasdasdadsawdawd2", "ddd3",
            " other ...",
            " other ...",
            " other ...",
            " other ...",
            " other ...",
            " other ...",
            " other ...",
            " other ...",
            " other ..."
        )

        // create object of data Adapter class ...
        val myListAdapter = MyListAdapter(this, titles, descriptions, images)

        // set adapter for listView
        listView.adapter = myListAdapter

    }

    class MyListAdapter(
        _context: Context,
        private val _titles: Array<String>,
        private val _descriptions: Array<String>,
        private val _images: Array<Int>
    ) : ArrayAdapter<String>(
        _context,
        R.layout.row_element, R.id.tv_title, _titles
    ) {

        @SuppressLint("ViewHolder")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            // Inflate our row_element.xml -> to object
            val row = LayoutInflater.from(context).inflate(R.layout.row_element, parent, false)

            // get views from row_el
            val title: TextView = row.findViewById(R.id.tv_title)
            val description: TextView = row.findViewById(R.id.tv_description)
            val icon: ImageView = row.findViewById(R.id.iv_icon)

            // change view properties and to sets any listeners...
            title.text = _titles[position]
            description.text = _descriptions[position]
            icon.setImageResource(_images[position])

            // listener on icon -> set by click a random color for title
            icon.setOnClickListener {
                val rnd = Random()
                val color: Int =
                    Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
                title.setTextColor(color)
            }

            return row
        }
    }

}
