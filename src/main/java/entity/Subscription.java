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

/*    @Id
    @Column(name = "student_id")
    private int studentId;
    @Id
    @Column(name = "course_id")
    private int courseId;*/

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    @ManyToOne
    //@MapsId("student_id")
    @JoinColumn(name = "student_id", updatable = false, insertable = false, referencedColumnName = "id")
    private Student student;


    @ManyToOne
    //@MapsId("course_id")
    @JoinColumn(name = "course_id", updatable = false, insertable = false, referencedColumnName = "id")
    private Course course;
}
