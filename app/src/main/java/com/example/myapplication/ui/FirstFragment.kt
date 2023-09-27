package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        list.add(Music(R.drawable.img, "Stayin Alive", "Bee Gees", R.raw.stayin_alive))
        list.add(Music(R.drawable.img1, "Kel yashaylik", "Tohir Sodiqov", R.raw.music))
        list.add(Music(R.drawable.img2, "Wavin' Flag", "K'NAAN", R.raw.wavin_flag))
        list.add(Music(R.drawable.img3, "On My Way", "Alan Walker", R.raw.on_my_way))
        list.add(Music(R.drawable.img7, "I Got Love", "MiyaGi & Эндшпиль", R.raw.i_got_love))
        list.add(Music(R.drawable.img5, "'Till I Collapse'", "Eminem", R.raw.till_i_collapse))
        list.add(Music(R.drawable.img4, "Lily'", "Alan Walker", R.raw.lily))
        list.add(Music(R.drawable.img6, "Mockingbird'", "Eminemr", R.raw.mockingbird))


        var adapter = MusicAdapter(list, object : MusicAdapter.musicInterface{
            override fun onClick(music: Music) {
                val bundle = Bundle()
                bundle.putSerializable("music", music)
                val fragmentSecond = SecondFragment()
                fragmentSecond.arguments = bundle
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main, fragmentSecond)
                    .commit()
            }

        })
        val manager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.musicRv.adapter = adapter
        binding.musicRv.layoutManager = manager
        return binding.root
    }


}