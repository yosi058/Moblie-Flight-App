package com.example.remote_control_flightgear.view.ViewModel

import com.example.remote_control_flightgear.view.Model.Model

class ViewModel() {
    val model = Model()

    fun connectServer(ip: String, port: Int) {
        model.connectFlightGear(ip, port)
    }

    fun setThrottle(value: Float) {
        val command = "set /controls/engines/current-engine/throttle ${value / 100} \r\n"
        model.sendData(command)
    }

    fun setRudder(value: Float) {
        val new_val = value - 50
        val command = "set /controls/flight/rudder/ ${new_val / 50} \r\n"
        model.sendData(command)
    }
    fun setAileron(aileron:Float){
        val command = "set /controls/flight/aileron/ $aileron \r\n"
        model.sendData(command)
    }
    fun setElevator(elevator:Float){
        val command = "set /controls/flight/elevator/ $elevator \r\n"
        model.sendData(command)

    }
    fun disconnectServer(){
        model.disconnectFlightGear()
    }

}