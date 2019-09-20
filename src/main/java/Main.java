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

        Student student = session.get(Student.class,1);

        Course course = session.get(Course.class,10);
        List<Student> studentList = course.getStudents();
        studentList.forEach(System.out::println);

        Teacher teacher = session.get(Teacher.class, 2);
        List<Course> courseList = teacher.getCourses();
        courseList.forEach(System.out::println);

        SubscriptionKey subscriptionKey = new SubscriptionKey(student ,course);
        Subscription subscription = session.get(Subscription.class, subscriptionKey );
        System.out.println(subscription.getSubscriptionDate());
        System.out.println(subscription.getKey().getCourse());
        System.out.println(subscription.getKey().getStudent());


        transaction.commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
