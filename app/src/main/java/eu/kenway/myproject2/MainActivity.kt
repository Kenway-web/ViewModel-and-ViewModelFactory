package eu.kenway.myproject2

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModelProvider
import eu.kenway.myproject2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var  binding: ActivityMainBinding
    private  lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewModelFactory=MainViewModelFactory(125)
        viewModel= ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        binding.resultTextView.text=viewModel.getTotal().toString()

        binding.button.setOnClickListener {
            viewModel.setTotal(binding.inputedittext.text.toString().toInt())
            binding.resultTextView.text=viewModel.getTotal().toString()
        }




    }
}