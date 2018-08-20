import db.DBCourse;
import db.DBHelper;
import db.DBLesson;
import model.*;

import java.util.List;

public class Runner {
    public static void main(String[] args) {

        Course course1 = new Course("Computer Science", Level.BSc);
        DBHelper.save(course1);
        Course course2 = new Course("Coding", Level.HNC);
        DBHelper.save(course2);
        Course course3 = new Course("Software Development", Level.PhD);
        DBHelper.save(course3);


        Lesson lesson1 = new Lesson("Into to Coding", 12, course2);
        DBHelper.save(lesson1);
        Lesson lesson2 = new Lesson("Website building", 7, course1);
        DBHelper.save(lesson2);
        Lesson lesson3 = new Lesson("Ruby", 30, course3);
        DBHelper.save(lesson3);
        Lesson lesson4 = new Lesson("Java", 16, course1);
        DBHelper.save(lesson4);
        Lesson lesson5 = new Lesson("CSS", 21, course3);

        Student student1 = new Student("John", 20, 1263, course3);
        DBHelper.save(student1);
        Student student2 = new Student("Tim", 32, 1782, course1);
        DBHelper.save(student2);
        Student student3 = new Student("Sarah", 26, 1873, course2);
        DBHelper.save(student3);
        Student student4 = new Student("Rebecca",40,2638,course1);
        DBHelper.save(student4);
        Student student5 = new Student("David", 16, 2438,course3);
        DBHelper.save(student5);

        Mentor mentor1 = new Mentor("Colin", student1);
        DBHelper.save(mentor1);
        Mentor mentor2 = new Mentor("Alex", student2);
        DBHelper.save(mentor2);
        Mentor mentor3 = new Mentor("Pawel", student3);
        DBHelper.save(mentor3);
        Mentor mentor4 = new Mentor("Keith", student4);
        DBHelper.save(mentor4);
        Mentor mentor5 = new Mentor("Colin 2.0", student5);
        DBHelper.save(mentor5);


        Student foundStudent = DBHelper.find(Student.class, 1);
        Course foundCourse = DBHelper.find(Course.class, 2);

        List<Student> studentsOnCourse = DBCourse.getStudentsOnCourse(course1);
        List<Lesson> lessonsOfCourse = DBCourse.getLessonsOnCourse(course1);



    }
}
