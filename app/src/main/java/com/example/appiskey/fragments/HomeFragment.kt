package com.example.appiskey.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appiskey.R
import com.example.appiskey.adapters.ImagesDetailAdapter
import com.example.appiskey.databinding.FragmentHomeBinding
import com.example.appiskey.models.GetImagesDetail
import com.example.appiskey.network.ApiClient
import com.example.appiskey.network.ApiInterface
import com.example.appiskey.viewmodels.HomeViewModel
import com.example.appiskey.viewmodels.HomeViewModelFactory

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val client = ApiClient.getInstance().create(ApiInterface::class.java)
        val application = requireNotNull(this.activity).application

        val viewModelFactory = HomeViewModelFactory(client)
        homeViewModel = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
        getData()
        setObserver()
        return binding.root
    }

    private fun setAdapter(imagesList: List<GetImagesDetail.Hit?>?) {
        binding.rvImagesDetail.layoutManager = LinearLayoutManager(context)
        binding.rvImagesDetail.adapter = ImagesDetailAdapter(requireContext(), imagesList, ::onImageClick)
        binding.progressBar.visibility = View.GONE
    }

    private fun setObserver() {
        homeViewModel.list.observe(viewLifecycleOwner) {
            setAdapter(it.hits)
        }
    }

    private fun getData() {
        binding.progressBar.visibility = View.VISIBLE
        homeViewModel.getImages()
    }

    private fun onImageClick(url: String) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToImageDetailFragment(url))
    }

}