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

    //use dagger to get acces to dependencies
    @Inject
    lateinit var orderDao: OrderDao
    private val viewModel: OrderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        Log.d("orderdao", "ORDERDAO: ${orderDao.hashCode()}")

        val adapter = OrderItemAdapter(listOf(), viewModel)

        //populate recycler view to the adapter
        rvOrderItems.layoutManager = LinearLayoutManager(this)
        rvOrderItems.adapter = adapter

        //populate recycler view
        viewModel.getAllOrderItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        //stub messages for slecting veg or no veg items
/*
        viewModel.getNoVegOrderItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        viewModel.getVegOrderItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })
*/

        //an attempt data from viewmodel to send to the dialog box
        val names = viewModel.getNameOrderItems()
        Log.d("list", "${names.value.toString()}")

        //create dialog bog for the send order message
        val sendDialog = AlertDialog.Builder(this)
            .setTitle("Send Order")
            .setMessage("listItems")
            .setPositiveButton("Send") {
                    _, _ ->
                Toast.makeText(this, "order sent", Toast.LENGTH_SHORT).show()

            }
            .setNegativeButton("Cancel") {
                    _, _ ->
                Toast.makeText(this, "order cancel", Toast.LENGTH_SHORT).show()
            }.create()

        //send order botton
        fab.setOnClickListener {

            sendDialog.show()

            //possible location to reset the amounts to zero after order submitted
            /*
            viewModel.setToZero.observe(this, Observer {
                adapter.items = it
                adapter.notifyDataSetChanged()
            })
            */
        }
    }


    //code for adding the taskbar menu button
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
      when (item.itemId){
          //open the dialog box to add items to the menu
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