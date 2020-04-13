package entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Subscriptions")
//@IdClass(SubscriptionPKey.class)
public class Subscription implements Serializable {
    @EmbeddedId
    SubscriptionPKey personalKey;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    @ManyToOne
    @JoinColumn(name = "student_id", updatable = false, insertable = false, referencedColumnName = "id")
    private Student student;


    @ManyToOne
    @JoinColumn(name = "course_id", updatable = false, insertable = false, referencedColumnName = "id")
    private Course course;
}
