package com.albertogfv.snack_truck.ui.orderList

import androidx.lifecycle.ViewModel
import com.albertogfv.snack_truck.data.db.entities.OrderItem
import com.albertogfv.snack_truck.data.repositories.OrderRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class OrderViewModel (
    private val repository: OrderRepository
): ViewModel() {

    fun upsert(item: OrderItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: OrderItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllOrderItems()  = repository.getAllOrderItems()

    fun getVegOrderItems() = repository.getVegOrderItems()

    fun getNoVegOrderItems() = repository.getNoVegOrderItems()

    fun getSendOrderItems() = repository.getSendOrderItems()
}