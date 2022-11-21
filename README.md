# Project: Dating App 

Our project domain is in dating apps, which we design specifically for UofT students. The purpose of our online dating app is giving UofT students access to more friends than they would meet in offline social circles. 

With the aid of this dating app, single University of Toronto students can connect with others in deeper ways. A confirmed official U of T email address is required for users to create personal profiles. Based on the user's registration data, this app offers match recommendations. Users can also use the app to find people based on search criteria such as age and academic specializations. Email contact information of each user is provided in the app for other users to make connections and grow relationships externally. Additional features include blocking or reporting users with inappropriate behaviors. 

## Features
This project implements the following 7 features. The code of each feature is wrapped within a same package. 
- [1] Login.
- [2] Registration.
- [3] App offers users match recommendations (*package matching_system*).
- [4] A search feature where users can use the app to find people based on search criteria such as academic specializations.
- [5] Allows users to report or block other users. 
- [6] In order for users to make connections, users can request other users' email address via app (*package email_request*). 
- [7] Users can upgrade their account by subscribing to be a paid user. A paid user can request unlimited number of email addresses. 

## Members and Responsilities  
- [ ] Yanling Cai: 
  * Implement entities package including User and UserAccount classes.
  * Implement the email request feature that allows a user to request other users' email address (pacakge email_request). 
  * Implement a data access system that allows the program to save information and load the information later (package data_access_storage).
- [ ] James Wang
- [ ] Qianyu Fan
- [ ] Chao Ma
  * Implement Register System
  * Implement RegisterUI Page
  * Implement Register Features
- [ ] Shuhao Lin
- [ ] Aria Hu
- [ ] Nathan Zhu

 

## How to Run Our Program 

* Github Workflow: Please refer to the workflow that was introduced in the first lab. You should follow this when working on your code. The following document provides additional details too.

* [Project Planning and Development Guide](project_plan_dev.md): This document helps you to understand how to create and maintain a project plan for your class project. **This document helps you to complete the Implementation Plan Milestone.**

## Gradle Project
Import this project into your Intellij editor. It should automatically recognise this as a gradle repository.
The starter code was built using SDK version 11.0.1. Ensure that you are using this version for this project. (You can, of course, change the SDK version as per your requirement if your team has all agreed to use a different version)

You have been provided with two starter files for demonstration: HelloWorld and HelloWorldTest.

You will find HelloWorld in `src/main/java/tutorial` directory. Right click on the HelloWorld file and click on `Run HelloWorld.main()`.
This should run the program and print on your console.

You will find HelloWorldTest in `src/test/java/tutorial` directory. Right click on the HelloWorldTest file and click on `Run HelloWorldTest`.
All tests should pass. Your team can remove this sample of how testing works once you start adding your project code to the repo.

Moving forward, we expect you to maintain this project structure. You *should* use Gradle as the build environment, but it is fine if your team prefers to use something else -- just remove the gradle files and push your preferred project setup. Assuming you stick with Gradle, your source code should go into `src/main/java` (you can keep creating more subdirectories as per your project requirement). Every source class can auto-generate a test file for you. For example, open HelloWorld.java file and click on the `HelloWorld` variable as shown in the image below. You should see an option `Generate` and on clicking this your should see an option `Test`. Clicking on this will generate a JUnit test file for `HelloWorld` class. This was used to generate the `HelloWorldTest`.

![image](https://user-images.githubusercontent.com/5333020/196066655-d3c97bf4-fdbd-46b0-b6ae-aeb8dbcf351d.png)

You can create another simple class and try generating a test for this class.
