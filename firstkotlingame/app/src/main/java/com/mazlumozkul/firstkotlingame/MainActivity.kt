package com.mazlumozkul.firstkotlingame

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mazlumozkul.firstkotlingame.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var score=0
    var imageArray=ArrayList<Button>()
    var runnable= Runnable {}
    var handler=Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        imageArray.add(binding.button)
        imageArray.add(binding.button2)
        imageArray.add(binding.button3)
        imageArray.add(binding.button4)
        imageArray.add(binding.button5)
        imageArray.add(binding.button6)
        imageArray.add(binding.button7)
        imageArray.add(binding.button8)
        imageArray.add(binding.button9)

        startCountDown()
        hideImages()
    }

    fun hideImages(){

        runnable = object : Runnable{
            override fun run() {
                for(image in imageArray){
                    image.visibility=View.INVISIBLE
                }
                val random= Random()
                val randomIndex=random.nextInt(9)
                imageArray[randomIndex].visibility=View.VISIBLE

                handler.postDelayed(runnable,500)
            }
        }

           handler.post(runnable)
        }






    fun startCountDown() {
        object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.textView.text = "Time: ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {

                binding.textView.text = "Time:0"
                handler.removeCallbacks(runnable)

                for(image in imageArray){

                    image.visibility=View.INVISIBLE
                }
                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Warning")
                alert.setMessage("are you restart?")
                alert.setPositiveButton("Yes", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface, which: Int) {
                        hideImages()
                        startCountDown()
                    }
                })
                alert.setNegativeButton("No", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface, which: Int) {

                    }
                })

                alert.show()
            }


        }.start()

    }

    fun increaseScore(view: View){
        score=score+1
        binding.textView2.text="Score: ${score}"
    }
}