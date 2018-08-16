package db;

import model.Course;
import model.Lesson;
import model.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBCourse {
    private static Transaction transaction;
    private static Session session;


    public static List<Student> getStudentsOnCourse(Course course) {
        List<Student> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Student.class);
            cr.add(Restrictions.eq("course", course));
            result = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        } return result;
    }

    public static List<Lesson> getLessonsOnCourse(Course course) {
        List<Lesson> result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Lesson.class);
            cr.add(Restrictions.eq("course", course));
            result = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        } return result;
    }
}
