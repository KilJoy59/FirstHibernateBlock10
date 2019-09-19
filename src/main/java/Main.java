import Entity.Course;
import Entity.Teacher;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * Project FirstHibernate
 * Created by End on сент., 2019
 */
public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Course course = session.get(Course.class,1);
        System.out.println( "id курса - " + course.getId());
        System.out.println("курс - " + course.getName());
        System.out.println("описание -  " + course.getDescription());
        System.out.println("продолжительность - " + course.getDuration());
        System.out.println("id учителя - " + course.getTeacherId());
        System.out.println("типа курса - " + course.getType());
        System.out.println("кол-во учеников - " + course.getStudentsCount());
        System.out.println("цена - " + course.getPrice());
        System.out.println("цена за час - " + course.getPricePerHour() + "\n");

        Teacher teacher = session.get(Teacher.class, 2);
        System.out.println("id учителя - " + teacher.getId());
        System.out.println("Имя учителя -" + teacher.getName());
        System.out.println("Возраст учителя - " + teacher.getAge());
        System.out.println("Зарплата - " + teacher.getSalary() + "\n");

        session.close();
        HibernateUtil.shutdown();
    }
}
