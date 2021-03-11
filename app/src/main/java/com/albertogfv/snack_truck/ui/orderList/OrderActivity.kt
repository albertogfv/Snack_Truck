package com.albertogfv.snack_truck.ui.orderList

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.albertogfv.snack_truck.R
import com.albertogfv.snack_truck.data.db.OrderDao
import com.albertogfv.snack_truck.data.db.entities.OrderItem
import com.albertogfv.snack_truck.other.OrderItemAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_order.*
import javax.inject.Inject

@AndroidEntryPoint
class OrderActivity : AppCompatActivity() {

    @Inject
    lateinit var orderDao: OrderDao
    private val viewModel: OrderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        Log.d("orderdao", "ORDERDAO: ${orderDao.hashCode()}")

        val adapter = OrderItemAdapter(listOf(), viewModel)

        rvOrderItems.layoutManager = LinearLayoutManager(this)
        rvOrderItems.adapter = adapter

        viewModel.getAllOrderItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })
        val sendDialog = AlertDialog.Builder(this)
            .setTitle("Send Order")
            .setMessage("Is this your final order?")
            .setPositiveButton("Send") {
                    _, _ ->
                Toast.makeText(this, "order sent", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Send") {
                    _, _ ->
                Toast.makeText(this, "order cancel", Toast.LENGTH_SHORT).show()
            }.create()
        fab.setOnClickListener {
            sendDialog.show()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
      when (item.itemId){
            R.id.nav_newSnack -> AddOrderItemDialog(this,
                    object : AddDialogListener {
                    override fun onAddButtonClicked(item: OrderItem) {
                        viewModel.insert(item)
                    }
                }).show()

        }

        return super.onOptionsItemSelected(item)

    }


}