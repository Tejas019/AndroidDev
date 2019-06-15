package com.tejas.architecturesamples.ui.demo

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.View
import com.tejas.architecturesamples.R

class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
        Log.d("mostunique", "onCreate")
//        supportFragmentManager.beginTransaction().add()
    }


//    override fun onStart() {
//        super.onStart()
//        Log.d("mostunique", "onStart")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d("mostunique", "onResume")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d("mostunique", "onPause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d("mostunique", "onStop")
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.d("mostunique", "onRestart")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d("mostunique", "onDestroy")
//    }
//
//    override fun onSaveInstanceState(outState: Bundle?) {
//        super.onSaveInstanceState(outState)
////        outState?.putString("data", "data")
//        Log.d("mostunique", "onSaveInstanceState")
//    }
//
//    override fun onConfigurationChanged(newConfig: Configuration?) {
//        super.onConfigurationChanged(newConfig)
//        Log.d("mostunique", "onConfigurationChanged")
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
//        super.onRestoreInstanceState(savedInstanceState)
//        Log.d("mostunique", "onRestoreInstanceState")
//    }
//
//    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
//        super.onCreateContextMenu(menu, v, menuInfo)
//        Log.d("mostunique", "onCreateContextMenu")
//
//    }
//
//    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
//        return super.onPrepareOptionsMenu(menu)
//        Log.d("mostunique", "onPrepareOptionsMenu")
//    }
}


//Change to be added in commit second in branch one @ 00:49