import Entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

/**
 * Project FirstHibernate
 * Created by End on сент., 2019
 */
public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Course course = session.get(Course.class,1);
        List<Student> studentList = course.getStudents();
        studentList.forEach(System.out::println);

        Teacher teacher = session.get(Teacher.class, 2);
        List<Course> courseList = teacher.getCourses();
        courseList.forEach(System.out::println);

        SubscriptionKey subscriptionKey = session.get(SubscriptionKey.class,1);
        Subscription subscription = session.get(Subscription.class,subscriptionKey );
        System.out.println(subscription.getKey().getCourse());

        transaction.commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
