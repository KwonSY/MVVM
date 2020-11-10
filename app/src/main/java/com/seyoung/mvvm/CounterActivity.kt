package com.seyoung.mvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.seyoung.mvvm.databinding.ActivityCounterBinding

class CounterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCounterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_counter)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_counter)
        binding.lifecycleOwner = this

        var vm = ViewModelProvider(this)[CounterViewModel::class.java]
        binding.setVariable(BR.vm, vm)

        binding.buttonPlus.setOnClickListener {
//            vm.counter += 1
            vm.increase()
//            val counter = vm.cnt.value
//            binding.textResult.text = "Up : $counter"
        }

        binding.buttonMinus.setOnClickListener {
//            vm.counter -= 1
            vm.decrease()
//            val counter = vm.cnt.value
//            binding.textResult.text = "Down : $counter"
        }

        binding.buttonShowSeekbar.setOnClickListener {
            var intent = Intent(this, ShareActivity::class.java)
            startActivity(intent)
        }
    }
}