package entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@EqualsAndHashCode(of = {"name", "duration", "description"})
@ToString(of = {"name", "duration", "description", "studentsCount", "price", "pricePerHour"})
@NoArgsConstructor
@Entity
@Table(name="Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    private String name;

    @Setter
    private int duration;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('DESIGN', 'PROGRAMMING','MARKETING','MANAGEMENT','BUSINESS')")
    private CourseType type;

    @Setter
    private String description;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Teacher teacher;

    @Column(name = "students_count")
    private int studentsCount;

    @Setter
    private int price;

    @Setter
    @Column(name = "price_per_hour")
    private float pricePerHour;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subscriptions",
        joinColumns = {@JoinColumn(name = "course_id")}, //foreign key for entity.Course in Subscriptions table
        inverseJoinColumns = {@JoinColumn(name = "student_id")} //foreign key for other side for entity.Course in Subscriptions table
   )
    private List<Student> students;


/*   @OneToMany(mappedBy = "courses")
    private Set<Subscription> students;*/


}
