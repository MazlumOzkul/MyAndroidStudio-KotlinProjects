package com.mazlumozkul.ReadingData

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mazlumozkul.ReadingData.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var SharedPref: SharedPreferences
    var userAgePref: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        SharedPref = this.getSharedPreferences("com.mazlumozkul.veriokuma", Context.MODE_PRIVATE)

        val userAgePref = SharedPref.getInt("age", -1)

        if (userAgePref == -1) {
            binding.textView.text = "Your Age: "
        } else {
            binding.textView.text = "Your age: ${userAgePref}"
        }
    }

    fun save(view: View) {

        val myAge = binding.editTextText.text.toString().toIntOrNull()

        if (myAge != null) {

            binding.textView.text = "your Age: ${myAge}"
            SharedPref.edit().putInt("age", myAge).apply()
        }

    }

    fun delete(view: View) {

        userAgePref = SharedPref.getInt("age", -1)

        if (userAgePref != -1) {
            SharedPref.edit().remove("age").apply()
            binding.textView.text = "Your Age: "
        }


    }

}