package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSecondBinding
import com.example.myapplication.model.Music


class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSecondBinding.inflate(inflater, container, false)

        var item:Music = bundleOf().getSerializable("music") as Music

        binding.img.setImageResource(item.img)
        binding.name.text = item.name
        binding.author.text = item.author

        return binding.root

    }


}