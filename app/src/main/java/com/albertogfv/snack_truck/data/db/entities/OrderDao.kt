package com.albertogfv.snack_truck.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.albertogfv.snack_truck.data.db.entities.OrderItem

@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(item: OrderItem)

    @Delete
    suspend fun deleteOrder(item: OrderItem)

    @Query("Select * FROM order_items")
    fun getAllOrderItems(): LiveData<List<OrderItem>>

    @Query("Select * FROM order_items WHERE isVeggie = 'true' ")
    fun getAllVegOrderItems(): LiveData<List<OrderItem>>

    @Query("Select * FROM order_items WHERE isVeggie = 'false' ")
    fun getAllNonVegOrderItems(): LiveData<List<OrderItem>>

    @Query("Select * FROM order_items WHERE amount > 0 ")
    fun getAllSendOrderItems(): LiveData<List<OrderItem>>

    @Query("Select item_name FROM order_items")
    fun getAllNameItems(): LiveData<List<String>>

    @Query("UPDATE order_items SET amount = 0 WHERE amount > 0")
    fun setAmounttoZero()
}