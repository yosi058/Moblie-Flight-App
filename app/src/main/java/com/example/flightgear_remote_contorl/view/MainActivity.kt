package com.example.flightgear_remote_contorl.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
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
        try {
            val ip = findViewById<EditText>(R.id.ip).text.toString()
            val port = findViewById<TextView>(R.id.port).text.toString().toInt()
            vm.connectServer(ip, port)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun disConnectServer() {
        vm.disconnectServer()
    }

}