package user_register_system;

import controller_presenter.BigController;
import controller_presenter.BigPresenter;
import entities.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UserRegUI extends JPanel{
    protected BigController controllers;
    protected BigPresenter presenters;

    /**
     * 此函数实现如果字段名称长度不够前面补空格。
     * */
    public static String padLeft(String origin, int length, char ch) {
        while (origin.length() < length) {
            origin = ch + origin;
        }
        return origin;
    }
    public UserRegUI(BigController controllers, BigPresenter presenters) {
        this.controllers = controllers;
        this.presenters = presenters;

        // set the panel size
        this.setSize(500, 600);

        // Set email
        this.setLayout(null);
        JLabel eMailStr = new JLabel(padLeft("EMAIL:",15,' '));
        eMailStr.setBounds(20, 25, 80, 25);
        this.add(eMailStr);
        // Set password
        JLabel passwordStr = new JLabel(padLeft("PASSWORD:",15,' '));
        passwordStr.setBounds(20, 50, 100, 25);
        this.add(passwordStr);

        // Set Name
        JLabel nameStr = new JLabel(padLeft("NAME:",15,' '));
        nameStr.setBounds(20, 75, 100, 25);
        this.add(nameStr);

        // Set Gender
        JLabel genderStr = new JLabel(padLeft("GENDER:",15,' '));
        genderStr.setBounds(20, 100, 100, 25);
        this.add(genderStr);

        // Set age
        JLabel ageStr = new JLabel(padLeft("AGE:",15,' '));
        ageStr.setBounds(20, 125, 100, 30);
        this.add(ageStr);

        // Set height
        JLabel heightStr = new JLabel(padLeft("HEIGHT:",15,' '));
        heightStr.setBounds(20, 150, 100, 30);
        this.add(heightStr);

        // Set program
        JLabel programOfStudyStr = new JLabel(padLeft("PROGRAM:",15,' '));
        programOfStudyStr.setBounds(20, 175, 100, 30);
        this.add(programOfStudyStr);

        // Set hobby
        JLabel hobbyStr = new JLabel(padLeft("HOBBY:",15,' '));
        hobbyStr.setBounds(20, 200, 100, 30);
        this.add(hobbyStr);

        // Set interests
        JLabel interestedInStr = new JLabel(padLeft("INTERESTS:",15,' '));
        interestedInStr.setBounds(20, 225, 100, 30);
        this.add(interestedInStr);

        // Set introduction
        JLabel selfIntroStr = new JLabel(padLeft("INTRO:",15,' '));
        selfIntroStr.setBounds(20, 250, 100, 30);
        this.add(selfIntroStr);

        //----------------------------------
        // Add email
        JTextField eMail = new JTextField();
        eMail.setBounds(140, 25, 180, 25);
        this.add(eMail);

        // Add password
        JTextField password = new JPasswordField();
        password.setBounds(140, 50, 180, 25);
        this.add(password);

        // Add name
        JTextField name = new JTextField();
        name.setBounds(140, 75, 180, 25);
        this.add(name);

        // Add gender (Male)
        JTextField genderText= new JTextField();
        genderText.setText(Gender.MALE.toString());
        JRadioButton mrb=new JRadioButton(Gender.MALE.toString(),true);
        mrb.setBounds(140,100,90,30);
        this.add(mrb);
        mrb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                genderText.setText(mrb.getText());
            }
        });
        // Add gender (Female)
        JRadioButton frb=new JRadioButton(Gender.FEMALE.toString(),false);
        frb.setBounds(210,100,90,30);
        this.add(frb);
        frb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genderText.setText(frb.getText());
            }
        });
        ButtonGroup genderBg=new ButtonGroup();
        genderBg.add(mrb);
        genderBg.add(frb);

        // Add age
        JTextField age = new JTextField();
        age.setBounds(140, 130, 180, 25);
        this.add(age);

        // Add height
        JTextField height = new JTextField();
        height.setBounds(140, 155, 180, 25);
        this.add(height);

        // Add program
        JTextField programOfStudy = new JTextField();
        programOfStudy.setBounds(140, 180, 180, 25);
        this.add(programOfStudy);

        // Add hobbies
        JComboBox hobby=new JComboBox();
        //Add sub-button (select)
        hobby.addItem("--select--");
        for (Hobbies hb : Hobbies.values()){
            hobby.addItem(hb);

        }
        hobby.setBounds(140, 205, 180, 25);
        this.add(hobby);

        // Add interests
        JTextField interestedIn = new JTextField();
        interestedIn.setText(Gender.MALE.toString());
        JRadioButton mrb1=new JRadioButton(Gender.MALE.toString(),true);
        mrb1.setBounds(140,230,90,30);
        this.add(mrb1);
        mrb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interestedIn.setText(mrb1.getText());
            }
        });
        JRadioButton frb1=new JRadioButton(Gender.FEMALE.toString(),false);
        frb1.setBounds(210,230,90,30);
        this.add(frb1);
        frb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interestedIn.setText(frb1.getText());
            }
        });
        ButtonGroup genderBg1=new ButtonGroup();
        genderBg1.add(mrb1);
        genderBg1.add(frb1);

        JTextArea selfIntro = new JTextArea(12,34);
        selfIntro.setBounds(140, 260, 180, 125);
        this.add(selfIntro);

        // Set submit button
        JButton buttonregister = new JButton("submit");
        buttonregister.setBounds(160, 450, 100, 25);
        this.add(buttonregister);
        // Set register button and process further action including passing data to UserRegUIController.
        buttonregister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取窗口元素输入的值
                String name_v=name.getText();
                String eMail_v = eMail.getText();
                String password_v = password.getText();
                //System.out.println(genderText.getText());
                Gender gender= Gender.valueOf(genderText.getText());
                int age_v=Integer.valueOf(("".equals(age.getText())?"0":age.getText()));
                float height_v=Float.valueOf("".equals(height.getText())?"0":height.getText());
                String programOfStudy_v=programOfStudy.getText();
                Hobbies hobby_v=Hobbies.valueOf(hobby.getSelectedItem().toString());
                String selfIntro_v=selfIntro.getText();
                Gender interestedIn_v=Gender.valueOf(interestedIn.getText());

                UserRegUIResponseModel userRegUIResponseModel=  controllers.getUserRegUIController().userProfileCreate(
                        eMail_v,password_v,name_v, gender, age_v, height_v, programOfStudy_v,
                        hobby_v, selfIntro_v, interestedIn_v);
                UserRegUIOutputBoundary presenter = presenters.getUserRegUIPresenter();
                UserRegUIResponseModel  prepareView=presenter.prepareView(userRegUIResponseModel);
                // Check error code.
                if ("ERR001".equals(prepareView.getRegMessage())){
                    JOptionPane.showMessageDialog(null,"Invalid Email!");
                }else if("ERR002".equals(prepareView.getRegMessage())){
                    JOptionPane.showMessageDialog(null,
                            "The provided email already registered!");
                }else{
                    // UI page for future connection
                    JOptionPane.showMessageDialog(null,
                            "Thank you! You're successfully registered! Please sign in your account.");
                }
            }
        });
    }
}
