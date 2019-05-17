package com.tw;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    ArrayList<Student> students;
    Menu(){
        students=new ArrayList<>();
    }
    public void printMainMenu(){
        System.out.println("Main Menu,pls select");
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
                break;
                default:

        }
        printMainMenu();
    }

    public void addStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter name");
        String name=sc.nextLine();
        System.out.println("enter student number");
        String number=sc.nextLine();
        Student theNewStudent=new Student(name,number);
        this.students.add(theNewStudent);
        System.out.println("Student Added");
    }

    public void printScore(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter student number");
        String studentNumber=sc.nextLine();
        for(int i=0;i<students.size();i++){
            if(students.get(i).getStudentNumber().equals(studentNumber)){
                System.out.println("Student Found "+i);
            }
        }

    }



}
