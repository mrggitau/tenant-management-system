package com.example.tenantmanagementsystem_lab5.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tenantmanagementsystem_lab5.R
import com.example.tenantmanagementsystem_lab5.data.repository.TenantRepository
import com.example.tenantmanagementsystem_lab5.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tenantCountTextView.text = getString(R.string.tenant_count, TenantRepository.tenants.size)
        binding.totalRentTextView.text = getString(R.string.total_rent, TenantRepository.totalRent())

        binding.addTenantButton.setOnClickListener {
            findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToAddTenantFragment())
        }
        binding.viewTenantsButton.setOnClickListener {
            findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToViewTenantsFragment())
        }
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}
