package com.example.viewpager2demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager2demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(
            LayoutInflater.from(baseContext)
        )
    }

    private val adapter by lazy { MyAdapter() }
    private val fragmentAdapter by lazy { MyFragmentStateAdapter(this) }
    private val customPagerAdapter by lazy { CustomPagerAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
        initData()
    }



    private fun initView() {
        val viewPager = binding.viewPager
        viewPager.adapter = customPagerAdapter
        // 设置页面切换监听
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                // 当页面选中时触发回调
                // 在这里可以根据需要执行相应的操作
                printLog("onPageSelected position is $position")
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                // 当页面滚动时触发回调
                // 在这里可以根据需要执行相应的操作
                printLog("onPageScrolled position is $position , positionOffset is $positionOffset")

            }

            override fun onPageScrollStateChanged(state: Int) {
                // 当页面滚动状态改变时触发回调
                // 在这里可以根据需要执行相应的操作
                printLog("onPageScrollStateChanged state is $state")
            }
        })

        val pageTransformer = CustomPageTransformer()
        viewPager.setPageTransformer(pageTransformer)
        viewPager.offscreenPageLimit = 3
    }

    private fun initData() {
//        adapter.setData(dataList)
        customPagerAdapter.setData(createDataList(10))
    }

    private fun createDataList(size: Int): List<String> {
        val dataList = mutableListOf<String>()
        for (i in 0 until size) {
            dataList.add("Item ${i + 1}")
        }
        return dataList
    }

    private fun printLog(msg: String) {
        Log.d(TAG, msg)
    }
}