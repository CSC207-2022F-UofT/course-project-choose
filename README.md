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
- [ ] Shuhao Lin
  * Implement Login System
  * Implement HomePageUI
- [ ] Aria Hu
  * Implement entities package Searcher class.
  * Implement Searching System feature.
- [ ] Nathan Zhu

 

## How to Run Our Program 

We are still waiting to connect individual features implemented by each team member. Up to Milestone 4, Two feature implementations "match recommendations" and "email request" are reviewed and merged to the main branch. Please run the java class MatchingSystemMain.java under Package matching_system to see a demo for these two features working simultanously. 
<img width="1278" alt="how_to_run_program" src="https://user-images.githubusercontent.com/113075282/203178684-0777ad48-e755-48a5-ac73-4f337deeb96b.png">

- After running MatchingSystemMain.java, the following window will pop up. 
<img width="629" alt="Screen Shot 2022-11-21 at 6 32 39 PM" src="https://user-images.githubusercontent.com/113075282/203179077-a37973cf-56a6-4ac6-bc64-4282f4469c53.png">

- Click on "Request Email". If the user can see the requested email, then a window with the requested email address will pop up. Click "OK" to close the message window. Please notice that this action of requesting email address will update the csv file "matchingSystemTest.csv". The demo user has an email address of a@mail.utoronto.ca. Her number of email requests, the numOfEmailRequest column in "matchingSystemTest.csv", will be incremented by 1 for each email request. 
<img width="636" alt="Screen Shot 2022-11-21 at 6 35 18 PM" src="https://user-images.githubusercontent.com/113075282/203179277-02d24072-5a63-44b2-a3fe-fce978103fe3.png">

The csv files and their data are all temporary. We'll prepare a final csv file when all features are merged into one cohesive dating app. 

## Test Coverage 
Up to Milestone 4, the test classes for Package data_access_storate and email_request are ready. Please see the test coverage below. Please notice that Main.java and MatcherUITemplate.java in Package email_request are created termporarily for checking features and will be removed. 
<img width="1162" alt="Screen Shot 2022-11-21 at 6 48 25 PM" src="https://user-images.githubusercontent.com/113075282/203180810-18feaac0-8aa1-4e23-810e-6ab3f03b2179.png">
<img width="1162" alt="Screen Shot 2022-11-21 at 6 48 25 PM" src="https://user-images.githubusercontent.com/113075282/203180826-3f96ca3a-580c-4387-a47d-e44a279baa1a.png">

## Our Design
We have implemented our feature following clean architecture. So far, we identified one design pattern: strategy design pattern. 
