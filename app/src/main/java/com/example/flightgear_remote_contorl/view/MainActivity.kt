package com.example.flightgear_remote_contorl.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.flightgear_remote_contorl.R
import com.example.remote_control_flightgear.view.ViewModel.ViewModel
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    val vm = ViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val connect_button: Button = findViewById(R.id.connect_btn)
        connect_button.setOnClickListener { connectServer() }
        val dis_connect_button: Button = findViewById(R.id.disconnect_btn)
        dis_connect_button.setOnClickListener { disConnectServer() }
        val throttle: SeekBar = findViewById(R.id.thorttle)
        throttle.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                vm.setThrottle(progress.toFloat())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        val rudder: SeekBar = findViewById(R.id.rudder)
        rudder.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                vm.setRudder(progress.toFloat())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        val joystick: Joystic = findViewById(R.id.joystick)
        joystick.update = { a: Float, b: Float ->
            vm.setAileron(a)
            vm.setElevator(b)
        }
    }

    fun connectServer() {
        val massage = findViewById<View>(R.id.textView) as TextView
        massage.textSize = 15F
        try {
            val ip = findViewById<EditText>(R.id.ip).text.toString()
            val port = findViewById<EditText>(R.id.port).text.toString().toInt()
            vm.connectServer(ip, port)
            massage.setBackgroundColor(Color.WHITE)

            if(vm.getSucceeded()) {
                massage.setTextColor(Color.GREEN)
                massage.text = "Succeeded connect to the server!"
            }else{
                massage.setBackgroundColor(Color.BLACK)
                massage.setTextColor(Color.RED)
                massage.text = "    Failed connect to  the server!"
            }
            change(massage)
        } catch (e: Exception) {
            massage.setBackgroundColor(Color.BLACK)
            massage.setTextColor(Color.RED)
            massage.text = "    Failed connect to  the server!!"
            change(massage)
            e.printStackTrace()
        }
    }

    fun change(msg: TextView) {
        val connect = Thread({
            Thread.sleep(3000)
            msg.setBackgroundColor(Color.TRANSPARENT)
            msg.text = ""
        }
        )
        connect.start()
    }

    fun disConnectServer() {
        val massage = findViewById<View>(R.id.textView) as TextView
        massage.textSize = 15F
        try {
            massage.setBackgroundColor(Color.WHITE)
            massage.setTextColor(Color.GREEN)
            massage.text = "Dis connect to the server succeeded!!"
            vm.disconnectServer()
            change(massage)

        } catch (e: Exception) {
            massage.setBackgroundColor(Color.BLACK)
            massage.setTextColor(Color.RED)
            massage.text = " Failed Dis connect to the server !!"
            e.printStackTrace()

        }
    }

}