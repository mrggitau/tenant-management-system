package com.example.tenantmanagementsystem_lab5.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tenantmanagementsystem_lab5.data.model.Tenant

@Database(entities = [Tenant::class], version = 1)
abstract class TenantDatabase : RoomDatabase() {
    abstract fun tenantDao(): TenantDao

    companion object {
        @Volatile
        private var INSTANCE: TenantDatabase? = null

        fun getDatabase(context: Context): TenantDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    TenantDatabase::class.java,
                    "tenant_database"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
