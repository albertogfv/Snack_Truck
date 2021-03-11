package com.albertogfv.snack_truck.ui.orderList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.albertogfv.snack_truck.R
import com.albertogfv.snack_truck.data.db.OrderDao
import com.albertogfv.snack_truck.data.db.entities.OrderItem
import com.albertogfv.snack_truck.other.OrderItemAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_order.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import javax.inject.Inject

@AndroidEntryPoint
class OrderActivity : AppCompatActivity() {

    @Inject
    lateinit var orderDao: OrderDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        Log.d("orderdao", "ORDERDAO: ${orderDao.hashCode()}")


    /*
        //val viewModel = ViewModelProviders.of(this, factory).get(OrderViewModel::class.java)

        //val adapter = OrderItemAdapter(listOf(), viewModel)

        //rvOrderItems.layoutManager = LinearLayoutManager(this)
        //rvOrderItems.adapter = adapter

        //viewModel.getAllOrderItems().observe(this, Observer {
         //   adapter.items = it
          //  adapter.notifyDataSetChanged()
       // })

        fab.setOnClickListener {
            AddOrderItemDialog(this,
                object : AddDialogListener {
                    override fun onAddButtonClicked(item: OrderItem) {
                      //  viewModel.upsert(item)
                    }
                }).show()
        }
        */

    }
}