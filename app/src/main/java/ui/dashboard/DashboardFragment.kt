package com.example.tenantmanagementsystem_lab5.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.tenantmanagementsystem_lab5.databinding.FragmentDashboardBinding
import com.example.tenantmanagementsystem_lab5.ui.viewmodel.TenantViewModel

class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TenantViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.tenantCountText.observe(viewLifecycleOwner) { text ->
            binding.tenantCountTextView.text = text
        }
        viewModel.totalRentText.observe(viewLifecycleOwner) { text ->
            binding.totalRentTextView.text = text
        }

        binding.addTenantButton.setOnClickListener {
            findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToAddTenantFragment())
        }
        binding.viewTenantsButton.setOnClickListener {
            findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToViewTenantsFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}