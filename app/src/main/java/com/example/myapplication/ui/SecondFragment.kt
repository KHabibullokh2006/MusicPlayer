package com.example.myapplication.ui

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.core.os.bundleOf
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSecondBinding
import com.example.myapplication.model.Music


class SecondFragment : Fragment() {

    lateinit var runnable:Runnable
    private var handler = Handler()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSecondBinding.inflate(inflater, container, false)
        val args = this.arguments
        var item:Music = args?.getSerializable("music") as Music


        binding.back.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main,FirstFragment())
                .commit()
        }


        binding.img.setImageResource(item.img)
        binding.name.text = item.name
        binding.author.text = item.author

        val mp = MediaPlayer.create(requireContext(),item.audio)
        mp.start()

        binding.seekbar.progress = 0
        binding.seekbar.max = mp.duration

        binding.play.setOnClickListener {
            if (!mp.isPlaying){
                mp.start()
                binding.play.setImageResource(R.drawable.baseline_pause_24)
            }else{
                mp.pause()
                binding.play.setImageResource(R.drawable.baseline_play_arrow_24)
            }
        }

        binding.seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (mp!= null && fromUser){
//                    mp.seekTo(progress)
                    Log.d("TAG", progress.toString())
                }
            }



            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }
        })

        runnable = Runnable {
            binding.seekbar.progress = mp.currentPosition
            handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable,1000)

        mp.setOnCompletionListener {
            binding.play.setImageResource(R.drawable.baseline_play_arrow_24)
            binding.seekbar.progress = 0
        }

        binding.next.setOnClickListener {

        }

        binding.prev.setOnClickListener {

        }





        return binding.root

    }


}