package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.MusicAdapter
import com.example.myapplication.databinding.FragmentFirstBinding
import com.example.myapplication.model.Music


class FirstFragment : Fragment() {

    var list = mutableListOf<Music>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFirstBinding.inflate(inflater, container, false)

        list.add(Music(R.drawable.img, "Stayin Alive", "Bee Gees"))
        list.add(Music(R.drawable.img1, "Kel yashaylik", "Tohir Sodiqov"))


        var adapter = MusicAdapter(list, object : MusicAdapter.musicInterface{
            override fun onClick(music: Music) {
                val bundle = Bundle()
                bundle.putSerializable("music", music)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main, SecondFragment()::class.java,bundle)
                    .commit()

            }

        })
        val manager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.musicRv.adapter = adapter
        binding.musicRv.layoutManager = manager
        return binding.root
    }


}