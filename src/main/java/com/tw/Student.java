package com.tw;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private String studentNumber;
    Map<String,Integer>scoreList;
    Student(String name,String studentNumber){
        this.name=name;
        this.studentNumber=studentNumber;
        scoreList=new HashMap<>();
        //TODO input verification
    }
    void addScore(String subject,int score){
        scoreList.put(subject,score);
    }
    private void changeName(String newName){
        //TODO verification on newName
        name=newName;
    }
    String getStudentNumber(){
        return studentNumber;
    }
    private void changeStudentNumber(){
        //TODO finish changeStudentNumber
    }

    String getName(){
        return name;
    }



}
