package com.tejas.architecturesamples.ui

import android.app.AlertDialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.tejas.architecturesamples.R
import com.tejas.architecturesamples.di.MyApp
import com.tejas.helpers.utils.DaggerViewModelFactory
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

        mainActivityViewModel.getData().observe(this, Observer { response ->
            response?.let {
                when (it.status) {
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
                        showMessage(it.message!!)
                    }
                    Status.UNSUCCESSFUL -> {
                        progress_loader.setLoading(false)
                        showMessage(it.message!!)
                    }
                }
            }
        })
    }


    private fun showMessage(message: String) {
        val alertDialog = AlertDialog.Builder(this@MainActivity)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton(getString(R.string.ok), null)
        alertDialog.show()
    }
}
