package userReg;

import entities.Gender;
import entities.Hobbies;
import entities.User;
import entities.UserAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegView  {

    public JFrame frame;

    UserProfile up;
    boolean regFlag=true;
    String errMsg;

    public UserProfile getUp() {
        return up;
    }

    public void setUp(UserProfile up) {
        this.up = up;
    }

    public boolean isRegFlag() {
        return regFlag;
    }

    public void setRegFlag(boolean regFlag) {
        this.regFlag = regFlag;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public static String padLeft(String origin, int length, char ch) {
        while (origin.length() < length) {
            origin = ch + origin;
        }
        return origin;
    }
    public UserRegView(UserProfile up,boolean regFlag,String errMsg){
        this.up=up;
        this.regFlag=regFlag;
        this.errMsg=errMsg;

        this.frame = new JFrame("User Registed view ");
        this.frame.setBounds(500,100,400,550);
        frame.setLayout(null);
        if (this.regFlag) {

            JLabel eMailStr = new JLabel(padLeft("Email:", 15, ' '));
            eMailStr.setBounds(20, 25, 80, 25);
            frame.add(eMailStr);

            JLabel nameStr = new JLabel(padLeft("name:", 15, ' '));
            nameStr.setBounds(20, 50, 100, 25);
            frame.add(nameStr);

            JLabel genderStr = new JLabel(padLeft("Gender:", 15, ' '));
            genderStr.setBounds(20, 75, 100, 25);
            frame.add(genderStr);

            JLabel ageStr = new JLabel(padLeft("age:", 15, ' '));
            ageStr.setBounds(20, 100, 100, 30);
            frame.add(ageStr);

            JLabel heightStr = new JLabel(padLeft("height:", 15, ' '));
            heightStr.setBounds(20, 125, 100, 30);
            frame.add(heightStr);

            JLabel programOfStudyStr = new JLabel(padLeft("programOfStudy:", 15, ' '));
            programOfStudyStr.setBounds(20, 150, 100, 30);
            frame.add(programOfStudyStr);

            JLabel hobbyStr = new JLabel(padLeft("hobby:", 15, ' '));
            hobbyStr.setBounds(20, 175, 100, 30);
            frame.add(hobbyStr);

            JLabel interestedInStr = new JLabel(padLeft("interestedIn:", 15, ' '));
            interestedInStr.setBounds(20, 200, 100, 30);
            frame.add(interestedInStr);

            JLabel selfIntroStr = new JLabel(padLeft("selfIntro:", 15, ' '));
            selfIntroStr.setBounds(20, 225, 100, 30);
            frame.add(selfIntroStr);

            //----------------------------------
            JLabel eMail = new JLabel(up.getEmail());
            eMail.setBounds(140, 25, 180, 25);
            frame.add(eMail);

            JLabel name = new JLabel(up.getName());
            name.setBounds(140, 50, 180, 25);
            frame.add(name);

            JLabel genderText = new JLabel(up.getGender().toString());
            genderText.setBounds(140, 75, 180, 25);
            frame.add(genderText);

            JLabel age = new JLabel(String.valueOf(up.getAge()));
            age.setBounds(140, 100, 180, 25);
            frame.add(age);

            JLabel height = new JLabel(String.valueOf(up.getHeight()));
            height.setBounds(140, 125, 180, 25);
            frame.add(height);

            JLabel programOfStudy = new JLabel(up.getProgramOfStudy());
            programOfStudy.setBounds(140, 150, 180, 25);
            frame.add(programOfStudy);

            JLabel hobby = new JLabel(String.valueOf(up.getHobby()));
            hobby.setBounds(140, 175, 180, 25);
            frame.add(hobby);

            JLabel interestedIn = new JLabel(up.getInterestedIn().toString());
            interestedIn.setBounds(140, 200, 180, 25);
            frame.add(interestedIn);

            JLabel selfIntro = new JLabel(up.getSelfIntro());
            selfIntro.setBounds(140, 225, 180, 50);
            frame.add(selfIntro);
        }
        else{
            JLabel errmsg = new JLabel(this.errMsg);
            errmsg.setBounds(140, 30, 180, 125);
            frame.add(errmsg);

            JButton buttonregister = new JButton("registe");
            buttonregister.setBounds(20, 50, 100, 25);
            frame.add(buttonregister);
            buttonregister.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    UserRegUI ur=new UserRegUI();
                }
            });
        }

       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
//        UserRegView ur=new UserRegView();
    }
}
