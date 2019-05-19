package com.tw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    ArrayList<Student> students;
    Menu(){
        students=new ArrayList<>();
    }
    public void printMainMenu(){
        System.out.println("1. 添加学生\n2. 生成成绩单\n3. 退出\n请输入你的选择（1-3）：");
        Scanner sc = new Scanner((System.in));
        int function = sc.nextInt();
        switch (function){
            case 1:
                addStudent();
                break;
            case 2:
                printScore();
                break;
            case 3:
                return;
                default:

        }
        printMainMenu();
    }

    public void addStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
        String str=sc.next();
        List<String> infoList = Arrays.asList(str.split(","));
        //String name=buffer.
        //System.out.println("请输入学号");
        //String number=sc.next();
        if(infoList.isEmpty()||infoList.size()<3){
            System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）1：");
            addStudent();
            return;
        }
        for(int i=0;i<infoList.size();i++){
            if(infoList.get(i).isEmpty()){
                System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）2：");
                addStudent();
                return;
            }
        }
        String name=infoList.get(0);
        String number=infoList.get(1);
        for(int i=0;i<students.size();i++){
            if(students.get(i).getStudentNumber().equals(number)){
                System.out.println("学号已存在，请查证后添加");
                return;
            }
        }

        Student theNewStudent=new Student(name,number);
        this.students.add(theNewStudent);
        for(int i=2;i<infoList.size();i++){
            String buffer2=infoList.get(i);
            List<String> theList = Arrays.asList(buffer2.split(":"));
            if(theList.size()<2||theList.get(0).isEmpty()||theList.get(1).isEmpty()){
                System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）3：");
                addStudent();
                return;
            }
            theNewStudent.addScore(theList.get(0),Integer.valueOf(theList.get(1)));
            //theList.get(0)
        }



//        System.out.println("请输入科目名称/按回车确认");
//        String subject=sc.next();
//        System.out.println("请输入分数/按回车确认/");
//        int score=sc.nextInt();
//
//        while(sc.hasNext()){
//            System.out.println("请输入科目名称/按回车确认/按esc退出");
//            //sc.next();
//            subject=sc.next();
//            System.out.println("请输入分数/按回车确认/按esc退出");
//            score=sc.nextInt();
//            theNewStudent.addScore(subject,score);
//        }
        System.out.println("添加成功");
    }

    public void printScore(){
        ArrayList<String> printOrder=new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
        String str=sc.next();
        List<String> infoList = Arrays.asList(str.split(","));
            for(int j=0;j<infoList.size();j++){
                for(int i=0;i<students.size();i++){
                    if(students.get(i).getStudentNumber().equals(infoList.get(j))){
                    System.out.println("成绩单");
                    System.out.print("姓名  ");
                    System.out.println(students.get(i).getName());
                    System.out.print("学号  ");
                    System.out.println(students.get(i).getStudentNumber());
                        for (String key : students.get(i).scoreList.keySet()) {
                            System.out.println("科目  " + key+" ");
                            System.out.println("分数  " + students.get(i).scoreList.get(key)+" ");
                        }
                    break;
                    }else{

                        System.out.println(students.get(0).getStudentNumber());
                        System.out.println(infoList.get(j)+" 学生不存在");
                    }
            }
        }
    }



}
