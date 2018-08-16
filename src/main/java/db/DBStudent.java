package db;

import model.Course;
import model.Lesson;
import model.Student;

import java.util.List;

public class DBStudent {

    public static void addStudentToLesson(Student student, Lesson lesson){
        lesson.addStudent(student);
        DBHelper.update(student);
    }

}