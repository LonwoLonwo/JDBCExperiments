package entity;

import java.io.Serializable;

//@Embeddable
public class SubscriptionPKey implements Serializable {

/*    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;*/

    private int studentId;
    private int courseId;


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
