package at.jo.gnadl.alfred

import android.app.Activity
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.view.ViewPager
import android.view.View
import android.support.v4.app.FragmentPagerAdapter
import at.jo.gnadl.alfred.MainActivity.MyPagerAdapter
import android.widget.Toast
import android.support.v4.view.ViewPager.OnPageChangeListener
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    var adapterViewPager: FragmentPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val vpPager = findViewById<VerticalViewPager>(R.id.pager) as VerticalViewPager
        adapterViewPager = MyPagerAdapter(supportFragmentManager)
        vpPager.adapter = adapterViewPager

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }


        vpPager.addOnPageChangeListener(object : OnPageChangeListener {

            // This method will be invoked when a new page becomes selected.
            override fun onPageSelected(position: Int) {
                Toast.makeText(this@MainActivity,
                        "Selected page position: " + position, Toast.LENGTH_SHORT).show()
            }

            // This method will be invoked when the current page is scrolled
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            override fun onPageScrollStateChanged(state: Int) {
                // Code goes here
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    class MyPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

        // Returns total number of pages
        override fun getCount(): Int {
            return NUM_ITEMS
        }


        // Returns the fragment to display for that page
        override fun getItem(position: Int): Fragment? {
            when (position) {
                0 // Fragment # 0 - This will show FirstFragment
                -> return MainActivityFragment.newInstance(0, "Page # 1")
                1 // Fragment # 0 - This will show FirstFragment different title
                -> return SecondFragment.newInstance(1, "Page # 2")
                else -> return null
            }
        }

        // Returns the page title for the top indicator
        override fun getPageTitle(position: Int): CharSequence {
            return "Page " + position
        }

        companion object {
            private val NUM_ITEMS = 2
        }

    }

}
