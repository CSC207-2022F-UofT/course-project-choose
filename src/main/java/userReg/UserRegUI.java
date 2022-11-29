package userReg;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import entities.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class UserRegUI extends JFrame {


// UserRegUIController userRegUIController;

    public static String padLeft(String origin, int length, char ch) {
        while (origin.length() < length) {
            origin = ch + origin;
        }
        return origin;
    }
    // Set UI Frame.
    public UserRegUI( UserRepoManager users){

        JFrame frame = new JFrame("User Register");
        frame.setBounds(500,100,400,550);
        frame.setLayout(null);

        //Takes Email
        JLabel eMailStr = new JLabel(padLeft("EMAIL:",15,' '));
        eMailStr.setBounds(20, 25, 80, 25);
        frame.add(eMailStr);

        //Takes Password
        JLabel passwordStr = new JLabel(padLeft("PASSWORD:",15,' '));
        passwordStr.setBounds(20, 50, 100, 25);
        frame.add(passwordStr);

        //Takes Name
        JLabel nameStr = new JLabel(padLeft("NAME:",15,' '));
        nameStr.setBounds(20, 75, 100, 25);
        frame.add(nameStr);

        //Takes Gender
        JLabel genderStr = new JLabel(padLeft("GENDER:",15,' '));
        genderStr.setBounds(20, 100, 100, 25);
        frame.add(genderStr);

        //Takes Age
        JLabel ageStr = new JLabel(padLeft("AGE:",15,' '));
        ageStr.setBounds(20, 125, 100, 30);
        frame.add(ageStr);

        //Takes Height
        JLabel heightStr = new JLabel(padLeft("HEIGHT:",15,' '));
        heightStr.setBounds(20, 150, 100, 30);
        frame.add(heightStr);

        //Takes Program
        JLabel programOfStudyStr = new JLabel(padLeft("PROGRAM:",15,' '));
        programOfStudyStr.setBounds(20, 175, 100, 30);
        frame.add(programOfStudyStr);

        //Takes Hobby
        JLabel hobbyStr = new JLabel(padLeft("HOBBY:",15,' '));
        hobbyStr.setBounds(20, 200, 100, 30);
        frame.add(hobbyStr);

        //Takes interests
        JLabel interestedInStr = new JLabel(padLeft("INTERESTS:",15,' '));
        interestedInStr.setBounds(20, 225, 100, 30);
        frame.add(interestedInStr);

        //Takes Self-introduction
        JLabel selfIntroStr = new JLabel(padLeft("S-INTRO:",15,' '));
        selfIntroStr.setBounds(20, 250, 100, 30);
        frame.add(selfIntroStr);

        //Add email in frame
        JTextField eMail = new JTextField();
        eMail.setBounds(140, 25, 180, 25);
        frame.add(eMail);

        //Add password in frame
        JTextField password = new JPasswordField();
        password.setBounds(140, 50, 180, 25);
        frame.add(password);

        //Add name in frame
        JTextField name = new JTextField();
        name.setBounds(140, 75, 180, 25);
        frame.add(name);

        //Add gender in frame
        JTextField genderText= new JTextField();
        genderText.setText(Gender.MALE.toString());
        JRadioButton mrb=new JRadioButton(Gender.MALE.toString(),true);
        mrb.setBounds(140,100,90,30);
        frame.add(mrb);
        mrb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                genderText.setText(mrb.getText().toString());
            }
        });
        JRadioButton frb=new JRadioButton(Gender.FEMALE.toString(),false);
        frb.setBounds(210,100,90,30);
        frame.add(frb);
        frb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genderText.setText(frb.getText().toString());
            }
        });
        ButtonGroup genderBg=new ButtonGroup();
        genderBg.add(mrb);
        genderBg.add(frb);

        //Add age in frame
        JTextField age = new JTextField();
        age.setBounds(140, 130, 180, 25);
        frame.add(age);

        //Add height in frame
        JTextField height = new JTextField();
        height.setBounds(140, 155, 180, 25);
        frame.add(height);

        //Add program in frame
        JTextField programOfStudy = new JTextField();
        programOfStudy.setBounds(140, 180, 180, 25);
        frame.add(programOfStudy);

        //Add hobby in frame
        JComboBox hobby=new JComboBox();
        //Create sub-item.
        hobby.addItem("-----SELECT-----");
        for (Hobbies hb : Hobbies.values()){
            hobby.addItem(hb);

        }
        hobby.setBounds(140, 205, 180, 25);
        frame.add(hobby);

        // Add interests in frame
        JTextField interestedIn = new JTextField();
        interestedIn.setText(Gender.MALE.toString());
        JRadioButton mrb1=new JRadioButton(Gender.MALE.toString(),true);
        mrb1.setBounds(140,230,90,30);
        frame.add(mrb1);
        mrb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interestedIn.setText(mrb1.getText().toString());
            }
        });
        JRadioButton frb1=new JRadioButton(Gender.FEMALE.toString(),false);
        frb1.setBounds(210,230,90,30);
        frame.add(frb1);
        frb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interestedIn.setText(frb1.getText().toString());
            }
        });
        ButtonGroup genderBg1=new ButtonGroup();
        genderBg1.add(mrb1);
        genderBg1.add(frb1);

        JTextArea selfIntro = new JTextArea(12,34);
        selfIntro.setBounds(140, 260, 180, 125);
        frame.add(selfIntro);

        //Set submit button
        JButton buttonregister = new JButton("Submit");
        buttonregister.setBounds(160, 450, 100, 25);
        frame.add(buttonregister);

        // Set register button and process further action including passing data to UserRegUIController.
        buttonregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name_v=name.getText();
                String eMail_v = new String(eMail.getText());
                String password_v = new String(password.getText());
                System.out.println(genderText.getText());
                Gender gender= Gender.valueOf(genderText.getText());
                int age_v=Integer.valueOf(("".equals(age.getText())?"0":age.getText()));
                float height_v=Float.valueOf("".equals(height.getText())?"0":height.getText());
                String programOfStudy_v=programOfStudy.getText();
                Hobbies hobby_v=Hobbies.valueOf(hobby.getSelectedItem().toString());
                String selfIntro_v=selfIntro.getText();
                Gender interestedIn_v=Gender.valueOf(interestedIn.getText());
                // Initialize
                User user=new User(name_v, gender, age_v, height_v, programOfStudy_v,
                        hobby_v, selfIntro_v, interestedIn_v);
                UserAccount ua= new UserAccount(eMail_v,password_v,user);
                UserRegUIOutputBoundary presenter = new UserRegUIPresenter();
                UserRegUIInputBoundary interactor = new UserRegUIInteractor(presenter, users);
                UserRegUIController userRegUIController=new UserRegUIController(interactor);
                UserRegUIResponseModel userRegUIResponseModel=userRegUIController.userProfileCreate(ua);
                UserRegUIResponseModel  prepareView=presenter.prepareView(userRegUIResponseModel);
                if (prepareView.getRegMessage()!=""){
                    JOptionPane.showMessageDialog(frame,userRegUIResponseModel.getRegMessage());
                }


            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        UserRepoManager users;
        try{
            File csvFile = new File("src/main/resources/userReg.csv");
            users = new UserRepo(csvFile);
        }catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }

        UserRegUIOutputBoundary presenter = new UserRegUIPresenter();
        UserRegUIInputBoundary interactor = new UserRegUIInteractor(presenter, users);
        UserRegUIController userRegUIController = new UserRegUIController(interactor);

        UserRegUI ur=new UserRegUI( users);


    }
}
