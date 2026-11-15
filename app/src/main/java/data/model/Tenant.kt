package com.example.tenantmanagementsystem_lab5.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

// @Entity tells Room to create a table named "tenants"
@Entity(tableName = "tenants")
data class Tenant(
    val name: String,
    val phone: String,
    val rent: String,

    // A unique ID for the database
    @PrimaryKey(autoGenerate = true) val id: Int = 0
) : Serializable {
    fun summary(): String {
        return "Tenant: $name\nPhone: $phone\nRent: KSh $rent"
    }
}