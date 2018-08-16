package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lesson")
public class Lesson {
    private int id;
    private String title;
    private int clasroomNumber;
    private Course course;
    private List<Student> students;

    public Lesson() {
    }

    public Lesson(String title, int clasroomNumber, Course course) {
        this.title = title;
        this.clasroomNumber = clasroomNumber;
        this.course = course;
        this.students = new ArrayList<Student>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "classroom_number")
    public int getClasroomNumber() {
        return clasroomNumber;
    }

    public void setClasroomNumber(int clasroomNumber) {
        this.clasroomNumber = clasroomNumber;
    }

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    @JoinTable(name = "student_lessons",
            joinColumns = {@JoinColumn(name = "lesson_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "student_id", nullable = false, updatable = false)}
    )
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);

    }
}
