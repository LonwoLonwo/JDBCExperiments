import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int duration;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('DESIGN', 'PROGRAMMING','MARKETING','MANAGEMENT','BUSINESS')")
    private CourseType type;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;

    @Column(name = "students_count")
    private int studentsCount;

    private int price;

    @Column(name = "price_per_hour")
    private float pricePerHour;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subscriptions",
        joinColumns = {@JoinColumn(name = "course_id")}, //foreign key for Course in Subscriptions table
        inverseJoinColumns = {@JoinColumn(name = "student_id")} //foreign key for other side for Course in Subscriptions table
   )
    private List<Student> students;

}
