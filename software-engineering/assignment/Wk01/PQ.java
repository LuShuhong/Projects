package Wk01;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ArrayList;

class Student{
    private String name;
    private int id;
    private double gpa;

    public Student(String name, int id, double gpa){
        this.name = name;
        this.id = id;
        this.gpa=gpa;
    }
    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public double getGpa(){
        return gpa;
    }

    public String toString() {
        return "Name: " + name + " ID: " + id + " GPA: " + gpa;
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return student1.getName().compareTo(student2.getName());
    }
}

class GPAComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return Double.compare(student2.getGpa(), student1.getGpa());
    }
}


class StudentRepo{
    private ArrayList<Student> students;
    public StudentRepo(ArrayList<Student> students){
        this.students = students;
    }

    public PriorityQueue<Student> getStudentNamePriorityQueue(){
        var priorityQueue = new PriorityQueue<Student>(Comparator.comparing((student -> student.getName())));
        for(Student student : students){
            priorityQueue.add(student);
        }
        return priorityQueue;
    }

    public PriorityQueue<Student> getStudentGPAPriorityQueue(){
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(new GPAComparator());
        for(Student student: students){
            priorityQueue.add(student);
        }
        return priorityQueue;
    }
}

public class PQ{
    public static void main(String[] args){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice",1,4.0));
        students.add(new Student("Bob",2,2.0));
        students.add(new Student("Tom",3,3.0));
        students.add(new Student("Charlotte",1,3.5));
        students.add(new Student("Barbie",2,3.0));
        students.add(new Student("Tim",3,1.0));


        StudentRepo studentRepo = new StudentRepo(students);
        /*loop to get things out */
        System.out.println(studentRepo.getStudentNamePriorityQueue());
        System.out.println(studentRepo.getStudentGPAPriorityQueue());

    }
}




