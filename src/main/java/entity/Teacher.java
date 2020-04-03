package entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = {"name", "salary", "age"})
@ToString(of = {"name", "salary", "age"})
@NoArgsConstructor
@Entity
@Table(name = "Teachers")
public class Teacher
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int salary;

    private int age;

/*    @OneToMany (mappedBy="teacher", fetch=FetchType.LAZY)
    private Set<Course> courses;*/
}
