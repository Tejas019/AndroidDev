package com.tejas.architecturesamples.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.tejas.architecturesamples.R
import com.tejas.helpers.utils.DaggerViewModelFactory
import com.tejas.architecturesamples.di.MyApp
import com.tejas.helpers.utils.Status
import com.tejas.helpers.utils.setLoading
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mContext: Context

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    lateinit var mainActivityViewModel: MainActivityViewModel
    lateinit var mDataListAdapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (applicationContext as MyApp).appComponent.inject(this@MainActivity)
        mainActivityViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)

        rv_data_list.apply {
            this.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            mDataListAdapter = DataAdapter()
            this.adapter = mDataListAdapter
        }

        mainActivityViewModel.getData().observe(this, Observer {response ->
            response?.let {
                when(it.status) {
                    Status.LOADING -> {
                        progress_loader.setLoading(true)
                    }

                    Status.SUCCESS -> {
                        progress_loader.setLoading(false)
                        it.data?.let { list ->
                            mDataListAdapter.setData(it.data!!)
                        }
                    }

                    Status.ERROR -> {
                        progress_loader.setLoading(false)
                    }
                }
            }
        })
    }

}
