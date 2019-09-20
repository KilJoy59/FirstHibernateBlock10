package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Project FirstHibernate
 * Created by End on сент., 2019
 */
@Entity
@Table(name = "purchaselist")
public class PurchaseList {

    @Column(name = "student_id")
    private String studentName;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "price")
    private int price;

    @Column(name = "subscription_date")
    private Date subscriptiondate;

    public PurchaseList() {
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptiondate() {
        return subscriptiondate;
    }

    public void setSubscriptiondate(Date subscriptiondate) {
        this.subscriptiondate = subscriptiondate;
    }
}
