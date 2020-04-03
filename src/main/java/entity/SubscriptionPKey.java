package entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SubscriptionPKey implements Serializable {

/*    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;*/

    private int student_id;
    private int course_id;


    public int hashCode() {
        return course_id + student_id;
    }

    public boolean equals(Object object) {
        if (object instanceof SubscriptionPKey) {
            SubscriptionPKey otherId = (SubscriptionPKey) object;
            return (otherId.student_id == this.student_id)
                    && (otherId.course_id == this.course_id);
        }
        return false;
    }
}
