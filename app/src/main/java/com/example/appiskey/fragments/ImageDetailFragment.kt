package com.example.appiskey.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.appiskey.databinding.FragmentImageDetailBinding

class ImageDetailFragment : Fragment() {
    private lateinit var binding: FragmentImageDetailBinding
    val args: ImageDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentImageDetailBinding.inflate(inflater, container, false)
        Glide.with(requireContext()).load(args.loadingUrl)
            .into(binding.ivImage);
        return binding.root
    }
}