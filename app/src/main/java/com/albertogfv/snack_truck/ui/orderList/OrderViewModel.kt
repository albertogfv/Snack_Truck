package com.albertogfv.snack_truck.ui.orderList

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.albertogfv.snack_truck.data.db.entities.OrderItem
import com.albertogfv.snack_truck.data.repositories.OrderRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class OrderViewModel @ViewModelInject constructor(
    val repository: OrderRepository
): ViewModel() {

    fun insert(item: OrderItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.insertOrder(item)
    }

    fun delete(item: OrderItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.deleteOrder(item)
    }

    fun getAllOrderItems()  = repository.getAllOrderItems()

    fun getVegOrderItems() = repository.getVegOrderItems()

    fun getNoVegOrderItems() = repository.getNoVegOrderItems()

    fun getSendOrderItems() = repository.getSendOrderItems()

    fun getNameOrderItems() = repository.getNameOrderItems()

    fun setToZero() = repository.setToZero()
}