package com.albertogfv.snack_truck.ui.orderList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.albertogfv.snack_truck.data.repositories.OrderRepository


class OrderViewModelFactory(
    private val repository: OrderRepository
): ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return OrderViewModel(repository) as T
    }
}