package userReg;

import entities.Gender;
import entities.Hobbies;
import entities.User;
import entities.UserAccount;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class UserRegUI extends JFrame {

    public static String padLeft(String origin, int length, char ch) {
        while (origin.length() < length) {
            origin = ch + origin;
        }
        return origin;
    }
    public UserRegUI(){

        JFrame frame = new JFrame("User Registe");
        frame.setBounds(500,100,400,550);
        frame.setLayout(null);

        JLabel eMailStr = new JLabel(padLeft("Email:",15,' '));
        eMailStr.setBounds(20, 25, 80, 25);
        frame.add(eMailStr);

        JLabel passwordStr = new JLabel(padLeft("Password:",15,' '));
        passwordStr.setBounds(20, 50, 100, 25);
        frame.add(passwordStr);

        JLabel nameStr = new JLabel(padLeft("name:",15,' '));
        nameStr.setBounds(20, 75, 100, 25);
        frame.add(nameStr);

        JLabel genderStr = new JLabel(padLeft("Gender:",15,' '));
        genderStr.setBounds(20, 100, 100, 25);
        frame.add(genderStr);

        JLabel ageStr = new JLabel(padLeft("age:",15,' '));
        ageStr.setBounds(20, 125, 100, 30);
        frame.add(ageStr);

        JLabel heightStr = new JLabel(padLeft("height:",15,' '));
        heightStr.setBounds(20, 150, 100, 30);
        frame.add(heightStr);

        JLabel programOfStudyStr = new JLabel(padLeft("programOfStudy:",15,' '));
        programOfStudyStr.setBounds(20, 175, 100, 30);
        frame.add(programOfStudyStr);

        JLabel hobbyStr = new JLabel(padLeft("hobby:",15,' '));
        hobbyStr.setBounds(20, 200, 100, 30);
        frame.add(hobbyStr);

        JLabel interestedInStr = new JLabel(padLeft("interestedIn:",15,' '));
        interestedInStr.setBounds(20, 225, 100, 30);
        frame.add(interestedInStr);

        JLabel selfIntroStr = new JLabel(padLeft("selfIntro:",15,' '));
        selfIntroStr.setBounds(20, 250, 100, 30);
        frame.add(selfIntroStr);

        //----------------------------------
        JTextField eMail = new JTextField();
        eMail.setBounds(140, 25, 180, 25);
        frame.add(eMail);


        JTextField password = new JPasswordField();
        password.setBounds(140, 50, 180, 25);
        frame.add(password);

        JTextField name = new JTextField();
        name.setBounds(140, 75, 180, 25);
        frame.add(name);

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

        JTextField age = new JTextField();
        age.setBounds(140, 130, 180, 25);
        frame.add(age);

        JTextField height = new JTextField();
        height.setBounds(140, 155, 180, 25);
        frame.add(height);

        JTextField programOfStudy = new JTextField();
        programOfStudy.setBounds(140, 180, 180, 25);
        frame.add(programOfStudy);

        JComboBox hobby=new JComboBox();
        //创建子项
        hobby.addItem("--select--");
        for (Hobbies hb : Hobbies.values()){
            hobby.addItem(hb);

        }
        hobby.setBounds(140, 205, 180, 25);
        frame.add(hobby);

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

        JButton buttonregister = new JButton("submit");
        buttonregister.setBounds(160, 450, 100, 25);
        frame.add(buttonregister);
        // buttonregister  addActionListener
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
                UserProfile up= new UserProfile(eMail_v,password_v,name_v,gender,age_v,height_v,programOfStudy_v,hobby_v,selfIntro_v,interestedIn_v);
                UserRegController urc=new UserRegController();
                String msg=urc.userProfileCreate(up);
//                System.out.println(msg);
                if ("Err01".equals(msg)){
//                    JOptionPane.showMessageDialog(frame, "email valid!", "email valid!",JOptionPane.ERROR_MESSAGE);
                    frame.setVisible(false);
                    String errMsg="email invalid";
                    UserRegView uru=new UserRegView(up,false,errMsg);
//                    uru.setRegFlag(false);
//                    uru.setErrMsg("email valid!");
//                    uru.setVisible(true);

                }else if ("Err02".equals(msg)){
//                    JOptionPane.showMessageDialog(frame, "email existed!", "email existed!",JOptionPane.ERROR_MESSAGE);
                    frame.setVisible(false);
                    String errMsg="email existed!";
                    UserRegView uru=new UserRegView(up,false,errMsg);
//                    uru.setRegFlag(false);
//                    uru.setErrMsg("email existed!");
////                    uru.setVisible(true);
                }
                else{
                    frame.setVisible(false);
                    UserRegView uru=new UserRegView(up,true,"");
//                    uru.setUp(up);

                }

            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        UserRegUI ur=new UserRegUI();
    }
}
