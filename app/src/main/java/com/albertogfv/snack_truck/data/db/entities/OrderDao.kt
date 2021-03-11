package com.albertogfv.snack_truck.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.albertogfv.snack_truck.data.db.entities.OrderItem

@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: OrderItem)

    @Delete
    suspend fun delete(item: OrderItem)

    @Query("Select * FROM order_items")
    fun getAllOrderItems(): LiveData<List<OrderItem>>

    @Query("Select * FROM order_items WHERE isVeggie = 'true' ")
    fun getAllVegOrderItems(): LiveData<List<OrderItem>>

    @Query("Select * FROM order_items WHERE isVeggie = 'false' ")
    fun getAllNonVegOrderItems(): LiveData<List<OrderItem>>

    @Query("Select * FROM order_items WHERE amount > 0 ")
    fun getAllSendOrderItems(): LiveData<List<OrderItem>>



}