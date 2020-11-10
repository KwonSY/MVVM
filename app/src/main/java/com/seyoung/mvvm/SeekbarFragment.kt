package com.seyoung.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.seyoung.mvvm.databinding.FragmentSeekbarBinding

class SeekbarFragment : Fragment() {

    lateinit var binding: FragmentSeekbarBinding

    fun SeekbarFragment() {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_seekbar, container, false)
//        val binding = DataBindingUtil.inflate(inflater, R.layout.fragment_seekbar, container, false)
        //or
//        val binding = FragmentSeekbarBinding.inflate(inflater, container, false)
        val view = binding.root
        
        return view
        
        // binding 안 할 때
//        return inflater.inflate(R.layout.fragment_seekbar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: ShareViewModel = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)

        binding!!.seekbar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                viewModel.progress.value = progress
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }
            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })

        viewModel.progress.observe(requireActivity(), Observer {
            progress -> binding.seekbar.setProgress(progress)
        })
    }
}