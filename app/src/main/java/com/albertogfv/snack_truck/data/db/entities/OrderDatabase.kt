package com.albertogfv.snack_truck.data.db.entities


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.albertogfv.snack_truck.data.db.OrderDao
import com.albertogfv.snack_truck.ui.orderList.OrderActivity

@Database(
    entities = [OrderItem::class],
    version = 1
)

abstract class OrderDatabase : RoomDatabase() {

    abstract fun getOrderDao(): OrderDao

    companion object {
        @Volatile
        private var instance: OrderDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: OrderActivity) = instance
            ?: synchronized(LOCK) {
                instance
                    ?: createDatabase(
                        context
                    )
                        .also { instance = it }
            }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                OrderDatabase::class.java, "OrderDb.db"
            ).build()
    }
}
