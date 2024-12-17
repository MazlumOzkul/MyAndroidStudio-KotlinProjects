package com.mazlumozkul.landmarkbookkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mazlumozkul.landmarkbookkotlin.databinding.ActivityDetailsBinding
import com.mazlumozkul.landmarkbookkotlin.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        //casting
        val selectedLandmark = intent.getSerializableExtra("landmark") as Landmark
        binding.nameText.text=selectedLandmark.name
        binding.CountryText.text= selectedLandmark.country
        binding.imageView.setImageResource(selectedLandmark.image)




    }
}