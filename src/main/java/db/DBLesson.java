package db;

import model.Lesson;
import model.Student;

public class DBLesson {

    public static void addLessonToStudent(Lesson lesson, Student student){
        student.addLessons(lesson);
        DBHelper.update(lesson);
    }
}
