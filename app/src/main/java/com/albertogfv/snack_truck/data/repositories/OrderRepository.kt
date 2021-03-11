package com.albertogfv.snack_truck.data.repositories



import com.albertogfv.snack_truck.data.db.entities.OrderDatabase
import com.albertogfv.snack_truck.data.db.entities.OrderItem

class OrderRepository(
    private val db: OrderDatabase
) {
    suspend fun upsert(item: OrderItem) = db.getOrderDao().upsert(item)

    suspend fun delete(item: OrderItem) = db.getOrderDao().delete(item)

    fun getAllOrderItems() = db.getOrderDao().getAllOrderItems()

    fun getVegOrderItems() = db.getOrderDao().getAllVegOrderItems()

    fun getNoVegOrderItems() = db.getOrderDao().getAllNonVegOrderItems()

    fun getSendOrderItems()  = db.getOrderDao().getAllSendOrderItems()
}