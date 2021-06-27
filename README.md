# Moblie-Flight-App
Link to github-https://github.com/yosi058/Moblie-Flight-App.git

Link for the presentation of Mobile App-https://www.youtube.com/watch?v=tJavODlgAmw.  


A Moblie app which connects to FlightGear simulator and can contorl the flight route by the velocity and the steering wheel.

General Description:  
This program controls an aircraft within the "[FlightGear]" (https://www.flightgear.org/) flight simulator. The program connects to the flight 
simulator as a client.
The client will send to the simulator the data that he gets from the user - a data that will tell the simulator where it should go instructions.

### Collaborators
This program was developed by two student, Ori Choen and Yosef Berebi, CS students from Bar-Ilan university, Israel.

### Code Design:
Moblie-Flight-App has been programmed by the MVVM design, as we used Kotlin data binding mechanism,and xaml.


![WhatsApp Image 2021-06-25 at 13 03 32](https://user-images.githubusercontent.com/71962627/123433935-a2708c00-d5d4-11eb-8223-33be2f0a36ed.jpeg)


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
We bulided some Views and then put them in the Main Activity.  
The main-activity knowing the viewmodel class and the joystick - there are not Knowing him.  
meening - the joystick is not dependenton the main-activity and we may want to take him to another project and we will can do that.   
like we see at the UML -  the joystick has a function called "update" and every class or project that want to use it - only need to implement the update function.  
This is the strategy pattern that each one can use the joystick and implement the function like he want.  
The rest is usual - the view and the viewmodel has a databinging between them,and each time something change at the view the viewmodel will immediate know about it.  

<img width="734" alt="צילום מסך 2021-06-25 164302" src="https://user-images.githubusercontent.com/71962627/123433793-7f45dc80-d5d4-11eb-8064-4a107278b673.png">



