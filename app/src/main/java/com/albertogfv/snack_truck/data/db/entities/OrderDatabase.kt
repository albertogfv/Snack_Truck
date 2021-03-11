package com.albertogfv.snack_truck.data.db.entities


import androidx.room.Database
import androidx.room.RoomDatabase
import com.albertogfv.snack_truck.data.db.OrderDao

@Database(
    entities = [OrderItem::class],
    version = 1
)
abstract class OrderDatabase : RoomDatabase() {

    abstract fun getOrderDao(): OrderDao

}
