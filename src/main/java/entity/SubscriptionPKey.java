package entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SubscriptionPKey implements Serializable {

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;

    public SubscriptionPKey(int student_id, int course_id) {
        this.studentId = student_id;
        this.courseId = course_id;
    }

    public int hashCode() {
        return courseId + studentId;
    }

    public boolean equals(Object object) {
        if (object instanceof SubscriptionPKey) {
            SubscriptionPKey otherId = (SubscriptionPKey) object;
            return (otherId.studentId == this.studentId)
                    && (otherId.courseId == this.courseId);
        }
        return false;
    }
}
