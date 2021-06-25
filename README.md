# Moblie-Flight-App
Link to github-https://github.com/yosi058/Moblie-Flight-App.git


A Moblie app which connects to FlightGear simulator and can contorl the flight route by the velocity and the steering wheel.

General Description:  
This program controls an aircraft within the "[FlightGear]" (https://www.flightgear.org/) flight simulator. The program connects to the flight 
simulator as a client.
The client will send to the simulator the data that he gets from the user - a data that will tell the simulator where it should go instructions.

### Collaborators
This program was developed by two student, Ori Choen and Yosef Berebi, CS students from Bar-Ilan university, Israel.

### Code Design:
Moblie-Flight-App has been programmed by the MVVM design, as we used Kotlin data binding mechanism,and xaml.

## Structure project:  

There is a few folders:

1.In the java folder we have all the kotlin files android.

2.In the com.exmple.flightgear_remote_contorl we have 3 packages folder :  
a.View folder - has the MainbActivity file and also the Joystick  

b.ViewModel - has only the view-model file  

c.Model - also like ViewModel has only the model file.  

3.In addtion,we have all the basic android file - like AndroidManifest file and the gradle files.  

# Installation for running the Moblie-App
1.Open the FlightGear app (Downloads it if you d'ont hev - click here https://www.flightgear.org/).

2.Config the setting and write this in the commend line in the setiing:

--telnet=socket,in,10,192.168.56.1,6400,tcp - when the ip is your intern ip computer.  

3.Downloads the project by git clone form https://github.com/yosi058/Moblie-Flight-App.git

4. Start the enigne of the plane - and start flay away!
## Documentation
We can see in the UML below of the App which based on the MVVM architecture.
We bulided some Views and then put them in the Main Window. Every View has View Model of its own, which is as the model for the View.
For the View, it is an abstraction of the Model.It passes commands from the view to the model.

The Views Model Converts model information into view information.
The Model and every View Model Implement INotifyPropertyChanged interface and notify about changes for the observers like a View Model or View.
The views Model get notifications from the model by adding delegates to its PropertyChangedevent.
Eventually we used Data binding within the UI.

If a View want to make change in the model we used with functions.

Also, the Model has a client which resposinble about the connection with the Flight Gear Simulator.
In the left side we can see that the View of the Graph has a member of dinamic dll which responsible on the connect of the dll View to the Main Window.
The dll can be any algorithm whichimplement the interrface by name IntrfaceDll which contain the 3 function Create,Update,Time(its cut in the picture)



