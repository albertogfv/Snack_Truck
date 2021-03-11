package com.albertogfv.snack_truck.data.repositories



import com.albertogfv.snack_truck.data.db.OrderDao
import com.albertogfv.snack_truck.data.db.entities.OrderItem
import javax.inject.Inject

class OrderRepository @Inject constructor(
    val orderDao: OrderDao

) {
    suspend fun insertOrder(item: OrderItem) = orderDao.insertOrder(item)

    suspend fun deleteOrder(item: OrderItem) = orderDao.deleteOrder(item)

    fun getAllOrderItems() = orderDao.getAllOrderItems()

    fun getVegOrderItems() = orderDao.getAllVegOrderItems()

    fun getNoVegOrderItems() = orderDao.getAllNonVegOrderItems()

    fun getSendOrderItems()  = orderDao.getAllSendOrderItems()

    fun getNameOrderItems() = orderDao.getAllNameItems()

    fun setToZero() = orderDao.setAmounttoZero()
}