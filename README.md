# BMI_Calc_App
## Android BMI Calculator App (Individual Class Project)
```
This is my second android App. It was an individual class project for Advanced Sofware Analysis & Design at ASU.
```
[DEMO VIDEO (Skip to 3:56 for demo)](https://youtu.be/bYLuDipfkb4)
## INCLUDED FILES:
### PART 1: (BMI Calculation SOC Application) (RESTful)
```
BMICalc.svc.cs	
IBMICalc.cs	
Web.config	
```

### PART 2: (Mobile BMI Calculator App)
```	
BMI_App.png		(Mobile App Picture)	
MainActivity.java	(View of MVC)
BMIController.java	(Controller of MVC)
BMIModel.java		(Model of MVC)
JSON_File.java		(Helper JSON Class)
```
### SUMMARY OF REQUIREMENTS
#### PART 1:
```
Create 2x BMI Calculation SOC Application (REST and SOAP) with the following functions:
	- myBMI (Calculates BMI from user's height & weight)
	- myHealth (calculate BMI from user's height & weight and provide "risk" assessment)
	- "risk" assessment provides different responses based on calculated BMI
```
#### PART 2:
```
Develop BMI Calculator Mobile App using MVC (Model-View-Controller) Architecture
	- App uses REST Web APIs to call functions/operations created in Part 1.
	- App shall have the following features
		- 2x Input boxes (height & weight input)
		- 1x Text box to display user BMI & message
		- 1x "Call BMI API" Button
		- 1x "Educate Me" Button
```
```
Once the "Call BMI API" button is selected the app will do the following:
	- Perform API call to WCF REST Web Service set up in Part 1.
	- Recieve JSON file, parse, and update text box to display BMI and message from "risk" assessment
```
```
Once the "Educate Me" button is selected the app will load a web page from a given array of health links.
```
```
Submit DEMO Video (Require to show video of yourself logging in and demostrating)
```
