# Project: Dating App 

Our project domain is in dating apps, which we design specifically for UofT students. The purpose of our online dating app is giving UofT students access to more friends than they would meet in offline social circles. 

With the aid of this dating app, single University of Toronto students can connect with others in deeper ways. A confirmed official U of T email address is required for users to create personal profiles. Based on the user's registration data, this app offers match recommendations. Users can also use the app to find people based on search criteria such as academic specializations. Email contact information of each user is provided in the app for other users to make connections and grow relationships externally. Additional features include blocking or reporting users with inappropriate behaviors. 

## Features
This project implements the following 7 features. The code of each feature is wrapped within a same package. 
- [1] Login.
- [2] Registration.
- [3] App offers users match recommendations (*package matching_system*).
- [4] A search feature where users can use the app to find people based on search criteria such as academic specializations.
- [5] Allows users to report or block other users. 
- [6] In order for users to make connections, users can request other users' email address via app (*package email_request*). 
- [7] Male users can upgrade their account by subscribing to be a paid user. A paid male user can request unlimited number of email addresses. Notice female users can requested unlimited number of email addresses. 

## Members and Responsilities  
- [ ] Yanling Cai: 
  * Implement entities package including User and UserAccount classes.
  * Implement the email request feature that allows a user to request other users' email address (pacakge email_request). 
  * Implement a data access system that allows the program to save information and load the information later (package data_access_storage).
- [ ] James Wang
  * Implement entities package including Matcher.
  * Implement matching_system package to complete the action from requesting match to return match results.
  * Created Tests for Matcher and MatchManager
- [ ] Qianyu Fan
  * Implement upgrading feature to allow male users request unlimited number of emails as they upgrade accounts as paid users (package upgrade).
  * Implement UpgradeUI and link to MatcherUI.
- [ ] Chao Ma
  * Implement Register System: Create user profile and save in date base by using the date from new user.
  * Implement RegisterUI Page: Provide UI page that allow new user inputs their information.
  * Implement Register Features: Check whether users' inputs are valid or not, and return messages or warnings.
- [ ] Shuhao Lin
  * Implement Login System
  * Implement HomePageUI
- [ ] Aria Hu
  * Implement entities package Searcher class.
  * Implement Searching System feature.
- [ ] Nathan Zhu

 

## How to Run Our Program 

We are still waiting to connect individual features implemented by each team member. Up to Milestone 4, two feature implementations "match recommendations" and "email request" are reviewed and merged to the main branch. Please run the java class MatchingSystemMain.java under Package matching_system to see a demo for these two features working simultanously. 

- Start by running Main.java 
- After running Main.java, the following window will pop up. 
 
  <img width="458" alt="Screen Shot 2022-12-04 at 10 31 22 AM" src="https://user-images.githubusercontent.com/113075282/205499642-79a5ffd3-7806-435b-a458-9800c24033c6.png">

- Click on "Request Email". If the user can see the requested email, then a window with the requested email address will pop up. Click "OK" to close the message window. Please notice that this action of requesting email address will update the csv file "matchingSystemTest.csv". The demo user has an email address of a@mail.utoronto.ca. Her number of email requests, the numOfEmailRequest column in "matchingSystemTest.csv", will be incremented by 1 for each email request. 
<img width="636" alt="Screen Shot 2022-11-21 at 6 35 18 PM" src="https://user-images.githubusercontent.com/113075282/203179277-02d24072-5a63-44b2-a3fe-fce978103fe3.png">

The csv files and their data are all temporary. We'll prepare a final csv file when all features are merged into one cohesive dating app. 

## Test Coverage 
Up to Milestone 4, the test classes for Package data_access_storate and email_request are ready. Please see the test coverage below. Please notice that Main.java and MatcherUITemplate.java in Package email_request are created termporarily for checking features and will be removed. 
<img width="1162" alt="Screen Shot 2022-11-21 at 6 48 25 PM" src="https://user-images.githubusercontent.com/113075282/203180810-18feaac0-8aa1-4e23-810e-6ab3f03b2179.png">
<img width="1157" alt="Screen Shot 2022-11-21 at 6 48 14 PM" src="https://user-images.githubusercontent.com/113075282/203188069-02c31f7b-894a-40cf-bb0f-f999a19a2e90.png">


## Our Design
We have implemented our feature following clean architecture. To help visiualize our code structure, please check out an illustration diagram that we prepare with 
[Lucidchart](https://lucid.app/lucidchart/d1b31d27-0a5e-46bb-bf2c-2a41ba4217d7/edit?viewport_loc=-794%2C90%2C1737%2C795%2CA4t_9l4I1bNN&invitationId=inv_75bd61a9-cd75-49e0-b6a2-33b9b6565112). For demonstration purpose, this diagram uses the implementation of feature Email Request as an example. 


Further more, we identified one design pattern: strategy design pattern. This pattern is implemented in our entities package. Our app verifies whether a user email is valid. We define a user email to be valid if the email ends with "@mail.utoronto.ca". However, we may want to change our definition of being a valid email later. Thus, we created an interface called EmailVerifier with a public method called verify that takes a email address String as parameter and returns true if the email address is valid, and false otherwise. The class UofTStudentEmailVerifier implements this interface and verfies whether a email address ends with "@mail.utoronto.ca". In the future, if we would like to verify a email address by other definitions, then we can have other classes to implment the interface EmailVerifier. 

