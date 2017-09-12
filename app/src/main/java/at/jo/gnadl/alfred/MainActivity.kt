package at.jo.gnadl.alfred

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
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
import android.os.CountDownTimer
import android.util.Log
import android.util.TypedValue
import android.widget.TextView
import android.widget.LinearLayout
import android.support.v4.app.FragmentStatePagerAdapter






class MainActivity : AppCompatActivity() {
    var adapterViewPager: FragmentPagerAdapter? = null
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        var all = findViewById<TextView>(R.id.mands) as TextView
        object : CountDownTimer(65000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                var minutes = (millisUntilFinished / 60000).toString()
                var seconds = ((millisUntilFinished % 60000) / 1000).toString()
                all.text= if (seconds.toInt() == 60) minutes + 1 + ":00" else minutes + ":" + (if (seconds.toInt() < 10) "0" else "") + seconds;
                Log.d("min",(millisUntilFinished / 1000).toString())
            }

            override fun onFinish() {
                //mTextField.setText("done!")
            }
        }.start()
        val vpPager = findViewById<VerticalViewPager>(R.id.pager) as VerticalViewPager
        adapterViewPager = MyPagerAdapter(supportFragmentManager)
        vpPager.adapter = adapterViewPager


        val inLay = findViewById<View>(R.id.innerLay) as LinearLayout

        for (x in 0..9) {
            inLay.addView(getView(x))
        }


        /*val timer = TextView(this)
        timer.text = "hallo"
        timer.id = 5
        timer.setTextAppearance(R.style.fontForNotificationLandingPage);
        timer.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)



        val timer1 = TextView(this)
        timer1.text = "ttisdf"
        timer1.id = 6
        timer1.setTextAppearance(R.style.fontForNotificationLandingPage);
        timer1.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)


        val timer2 = TextView(this)
        timer2.text = "sdfj"
        timer2.id = 7
        timer2.setTextAppearance(R.style.fontForNotificationLandingPage);
        timer2.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        (lin as LinearLayout).addView(timer)
        (lin).addView(timer1)
        (lin).addView(timer2)*/



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
            }
        })

    }

    fun getView(x: Int): View {
        val rootView = layoutInflater.inflate(R.layout.featured_item, null)
        return rootView
    }
    fun convertSpToPixels(sp: Float, context: Context): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics())
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
                -> return MainActivityFragment.newInstance(0)
                1 // Fragment # 0 - This will show FirstFragment different title
                -> return SecondFragment.newInstance(1)
                else -> return null
            }
        }

        companion object {
            private val NUM_ITEMS = 2
        }

    }

}

private class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return MainActivityFragment()
    }
}
