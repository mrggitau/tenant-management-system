package com.example.tenantmanagementsystem_lab5.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.tenantmanagementsystem_lab5.data.local.TenantDatabase
import com.example.tenantmanagementsystem_lab5.data.model.Tenant
import com.example.tenantmanagementsystem_lab5.data.repository.TenantRepository
import kotlinx.coroutines.launch

class TenantViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = TenantRepository(TenantDatabase.getDatabase(application).tenantDao())

    val tenants: LiveData<List<Tenant>> = repository.tenants

    val tenantCountText: LiveData<String> = tenants.map { list -> "Tenants\n${list.size}" }

    val totalRentText: LiveData<String> = tenants.map { list ->
        val total = list.sumOf { it.rent.toDoubleOrNull() ?: 0.0 }
        "Total rent\nKSh %.0f".format(total)
    }

    val allTenantsText: LiveData<String> = tenants.map { list ->
        if (list.isEmpty()) "No tenants yet. Add one from the Dashboard." else list.joinToString("\n\n") { it.summary() }
    }

    fun addTenant(name: String, phone: String, rent: String): Tenant? {
        val cleanName = name.trim()
        val cleanPhone = phone.trim()
        val cleanRent = rent.trim()

        if (cleanName.isEmpty() || cleanPhone.isEmpty() || cleanRent.isEmpty()) {
            return null
        }

        val tenant = Tenant(cleanName, cleanPhone, cleanRent)

        viewModelScope.launch {
            repository.addTenant(tenant)
        }
        return tenant
    }
}