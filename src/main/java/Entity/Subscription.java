package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Project FirstHibernate
 * Created by End on сент., 2019
 */
@Entity
@Table(name = "Subscriptions")
public class Subscription implements Serializable {

    @EmbeddedId
    private SubscriptionKey key;

    public Subscription() {
    }

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public SubscriptionKey getKey() {
        return key;
    }

    public void setKey(SubscriptionKey key) {
        this.key = key;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
