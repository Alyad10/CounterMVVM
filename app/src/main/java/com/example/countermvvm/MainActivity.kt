package com.example.countermvvm
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.countermvvm.databinding.ActivityMainBinding
import com.example.countermvvm.viewmodel.CountViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CountViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        initClickers()

    }

    private fun initClickers() {
        with(binding) {
            increment.setOnClickListener {
                viewModel.increment()
                viewModel.showToast()
                viewModel.changeColor()
            }

            dincrement.setOnClickListener {
                viewModel.decrement()
            }
        }
    }


    private fun initViewModel(){
        viewModel.counterData.observe(this){
            binding.textCount.text = it.toString()
        }
        viewModel.toastData.observe(this){
            Toast.makeText(this, "Поздравляем!", Toast.LENGTH_SHORT).show()
        }
        viewModel.colorCount.observe(this){
            binding.textCount.setTextColor(resources.getColor(R.color.teal_200))

        }
    }
}

