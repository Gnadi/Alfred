package at.jo.gnadl.alfred

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SecondFragment : Fragment() {

    private var title: String? = null
    private var page: Int = 1

    // newInstance constructor for creating fragment with arguments
    // Wrap new instance function inside companion object
    companion object {
        // newInstance constructor for creating fragment with arguments
        fun newInstance(page: Int, title: String): SecondFragment {
            val fragmentSecond = SecondFragment()
            val args = Bundle()
            args.putInt("someInt", page)
            args.putString("someTitle", title)
            fragmentSecond.setArguments(args)
            return fragmentSecond
        }
    }

    // Store instance variables based on arguments passed
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    // Inflate the view for the fragment based on layout XML
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_second, container, false)
        val tvLabel = view.findViewById<TextView>(R.id.secondpage) as TextView
        tvLabel.text = page.toString() + " -- " + title
        return view
    }
}
