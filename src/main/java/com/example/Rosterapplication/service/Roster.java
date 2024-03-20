package com.example.Rosterapplication.service;

import java.util.ArrayList;
import java.util.List;

import com.example.Rosterapplication.model.Student;

import org.springframework.stereotype.Service;
@Service
public class Roster {
    static List<Student> entries = new ArrayList<>();
    public Roster() {
        entries.add(new Student(20, "Drake", 1111, 2026, "CS"));
        entries.add(new Student(22, "Keenan", 1112, 2023, "Architecture"));
        entries.add(new Student(25, "Roman", 1113, 2021, "Engineering"));
        entries.add(new Student(22, "Mark", 1114, 2024, "CS"));
        entries.add(new Student(20, "Tony", 1115, 2027, "Architecture"));
        entries.add(new Student(22, "Stark", 1116, 2024, "Art"));
        entries.add(new Student(21, "Bobby", 1117, 2026, "Econ"));
        entries.add(new Student(21, "Luke", 1118, 2026, "Poly-sci"));
        entries.add(new Student(20, "Nolan", 1119, 2026, "Econ"));
        entries.add(new Student(20, "Alec", 1121, 2026, "Econ"));
        entries.add(new Student(20, "Keegan", 1122, 2026, "Psych"));
        entries.add(new Student(20, "Mike", 1123, 2026, "Econ"));

    }

    //getting all the students in current directory (Get Command for Restful)
    public List<Student> getAllStudents() {return entries;}
    //getting individual Student by ID
    //deleting mapping here as an expirement
    public Student getStudentById(long id)
    {
        for(int i = 0; i<entries.size(); i++)
        {
            if(entries.get(i).getId() == id)
            {
                return entries.get(i);
            }
        }
        return null;
    }
    //gets individual student by name (Get command for Restful but using name instead of id)
    //also here
    public Student getStudentByName(String name)
    {
        for(int i = 0; i<entries.size(); i++)
        {
            if(entries.get(i).getName().equals(name))
            {
                return entries.get(i);
            }
        }
        return null;
    }
    //Post a new student (post command of restful)
    public Student addStudent(Student newStudent)
    {
        entries.add(newStudent);
        return newStudent;
    }

    //put update by student id (put command for restful)
    public Student updateStudent(long id, Student updatedStudent)
    {
        for(Student student : entries)
        {
            if(student.getId()==id)
            {
                student.setName(updatedStudent.getName());
                student.setAge(updatedStudent.getAge());
                student.setMajor(updatedStudent.getMajor());
                student.setGradYear(updatedStudent.getGradYear());
                return student;
            }
        }
        return null;
    }

    //Delete student by ID (Delete command for restful)
    public Student deleteStudent(long id){
        Student removedStudent = null;
        for(int i = 0; i<entries.size(); i++)
        {
            if(entries.get(i).getId() == id)
            {
                removedStudent = entries.get(i);
                entries.remove(removedStudent);
            }
        }
        return removedStudent;
    }

    public Student save(Student student) {
        long id = student.getId();
        // update Tutorial
        if (student.getId() != 0) {
            long _id = student.getId();

            for (int idx = 0; idx < entries.size(); idx++)
                if (_id == entries.get(idx).getId()) {
                    entries.set(idx, student);
                    break;
                }

            return student;
        }

        // create new Tutorial
        student.setId(++id);
        entries.add(student);
        return student;
    }

}
