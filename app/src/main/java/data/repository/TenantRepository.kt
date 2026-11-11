package com.example.tenantmanagementsystem_lab5.data.repository

import com.example.tenantmanagementsystem_lab5.data.model.Tenant
object TenantRepository {
    val tenants = mutableListOf<Tenant>()

    fun addTenant(tenant: Tenant) {
        tenants.add(tenant)
    }

    fun totalRent(): Double {
        return tenants.sumOf { it.rent.toDoubleOrNull() ?: 0.0 }
    }
}