package com.example.remote_control_flightgear.view.Model

import android.annotation.SuppressLint
import java.io.PrintWriter

import java.net.Socket
import java.util.concurrent.Executors


class Model() {

    private lateinit var socket: Socket
    private lateinit var printwritre: PrintWriter
    private val executor = Executors.newSingleThreadExecutor()

    @SuppressLint("SetTextI18n")
    fun connectFlightGear(ip: String, port: Int) {
        val connect = Runnable {
            try {
                this.socket = Socket(ip, port)
                this.printwritre = PrintWriter(socket.getOutputStream(), true)
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }
        executor.execute(connect)
    }

    fun sendData(command: String) {
        val send = Runnable {
            try {
                println(command)
                this.printwritre.print(command)
                this.printwritre.flush()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        executor.execute(send)
    }

    fun disconnectFlightGear() {
        this.printwritre.close()
        this.socket.close()
        //executor.shutdown()

    }
}