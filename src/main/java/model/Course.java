package model;

import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    private int id;
    private String title;
    private Level level;
    List<Lesson> lessons;
    List<Student> students;

    public Course(){}

    public Course(String title, Level level){
        this.title = title;
        this.level = level;
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

    @Enumerated(value = EnumType.STRING)
    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @OneToMany(mappedBy="course", fetch = FetchType.LAZY)
    public List<Lesson> getLesson() {
        return lessons;
    }

    public void setLesson(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @OneToMany(mappedBy="course", fetch = FetchType.LAZY)
    public List<Student> getStudent() {
        return students;
    }

    public void setStudent(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }
}
