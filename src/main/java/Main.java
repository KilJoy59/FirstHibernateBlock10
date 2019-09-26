import Entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import javax.persistence.Query;
import java.util.List;


/**
 * Project FirstHibernate
 * Created by End on сент., 2019
 */

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        //получение сущности Student
        Student student = session.get(Student.class,1);

        //получение сущности Course
        Course course = session.get(Course.class,10);
        List<Student> studentList = course.getStudents();
        studentList.forEach(System.out::println);

        //получение сущности Teacher
        Teacher teacher = session.get(Teacher.class, 2);
        List<Course> courseList = teacher.getCourses();
        courseList.forEach(System.out::println);

        //получение сущности Subscription
        CompositeKey compositeKey = new CompositeKey(student ,course);
        Subscription subscription = session.get(Subscription.class, compositeKey );
        System.out.println(subscription.getSubscriptionDate());
        System.out.println(subscription.getKey().getCourse());
        System.out.println(subscription.getKey().getStudent());

        //Создаем запрос который выберет все строки из сущности Student и создаем список
        String studentQuery = "FROM Student";
        Query query = session.createQuery(studentQuery);
        List<Student> students = query.getResultList();

        //Создаем запрос который выберет все строки из сущности Course и создаем список
        String courseQuery = "FROM Course";
        Query query2 = session.createQuery(courseQuery);
        List<Course> courses = query2.getResultList();

        //Создаем запрос который выберет все строки из сущности Purchaselist и создаем список
        String purchaselistQuery = "FROM Purchaselist";
        Query query3 = session.createQuery(purchaselistQuery);
        List<Purchaselist> purchases = query3.getResultList();

        //метод который добавляет id курса и id студента в purchaselist
        setIdInPurchaselist(students,courses,purchases);

        //Вывод на консоль
         for (Purchaselist purchaselist : purchases) {
             System.out.println(purchaselist.getStudentName() + " - " + purchaselist.getStudentId()
                     + " " + purchaselist.getCourseName() + " - " + purchaselist.getCourseID() );
         }

        transaction.commit();
        session.close();
        HibernateUtil.shutdown();
    }

    private static void setIdInPurchaselist(List<Student> students, List<Course> courses, List<Purchaselist> purchases) {
        for (Purchaselist purchaselist : purchases) {
            for (Student student : students) {
                if (purchaselist.getStudentName().equals(student.getName())) {
                    purchaselist.setStudentId(student.getId());
                }
                for (Course course : courses) {
                    if (purchaselist.getCourseName().equals(course.getName())) {
                        purchaselist.setCourseID(course.getId());
                    } } } }
    }

}
