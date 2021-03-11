package com.albertogfv.snack_truck.ui.orderList

import com.albertogfv.snack_truck.data.db.entities.OrderItem

interface AddDialogListener {
    fun onAddButtonClicked(item: OrderItem)
}