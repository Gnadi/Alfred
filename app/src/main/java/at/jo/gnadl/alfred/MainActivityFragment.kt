package at.jo.gnadl.alfred

import android.app.Activity
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView



/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment() {


    private var title: String? = null
    private var page: Int = 0

    // newInstance constructor for creating fragment with arguments
    // Wrap new instance function inside companion object
    companion object {
        // newInstance constructor for creating fragment with arguments
        fun newInstance(page: Int, title: String): MainActivityFragment {
            val fragmentFirst = MainActivityFragment()
            val args = Bundle()
            args.putInt("someInt", page)
            args.putString("someTitle", title)
            fragmentFirst.setArguments(args)
            return fragmentFirst
        }
    }

    // Store instance variables based on arguments passed
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(null != this.arguments) {
            page = this.arguments.getInt("someInt", 1)
            title = this.arguments.getString("someTitle")
        }
    }

    // Inflate the view for the fragment based on layout XML
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_main, container, false)
        return view
    }
}
