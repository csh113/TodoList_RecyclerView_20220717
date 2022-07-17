package com.cshka.todolist_recyclerview_20220717

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.cshka.todolist_20220717.adapters.MainViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mPagerAdapter: MainViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPagerAdapter = MainViewPagerAdapter(this)
        mainViewPager.adapter = mPagerAdapter

//        Bottom Navigation 클릭 이벤트 처리
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> mainViewPager.currentItem = 0
                R.id.paper -> mainViewPager.currentItem = 1
                R.id.profile -> mainViewPager.currentItem = 2
            }
            return@setOnItemSelectedListener true
        }

//        뷰 페이저 연결을 해야 옆 슬라이드 먹힘 (공고, 내정보)
//        일단 화면 비었으니 Bottom Navigation 슬라이드 하면 checked된 것으로 색을 보라색으로 해서 표시해준다.
        mainViewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    bottomNav.menu.getItem(position).isChecked = true
                }
            }
        )
    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPagerAdapter = MainViewPagerAdapter(supportFragmentManager)
        mainViewPager.adapter = mPagerAdapter

        mainViewPager.offscreenPageLimit = 3

        mainTabLayout.setupWithViewPager(mainViewPager)
    }*/

}