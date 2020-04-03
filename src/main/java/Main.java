import entity.Course;
import entity.Student;
import entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Course course = session.get(Course.class, 2);

        System.out.println("Длительность курса \"" + course.getName() + "\" составляет " + course.getDuration() + " часов. Он относится к типу: " + course.getType());
        System.out.println("На курсе учится " + course.getStudentsCount() + " студентов");

        Course courseTwo = session.get(Course.class, 4);

        System.out.println("Стоимость курса \"" + courseTwo.getName() + "\": " + course.getPrice() + '\u20BD');
        System.out.println("Описание курса \"" + courseTwo.getName() + "\" гласит: " + courseTwo.getDescription());

        System.out.println("Курс \"" + course.getName() + "\" ведёт преподаватель: " + course.getTeacher().getName());

        System.out.println("Количество учеников курса \"" + courseTwo.getName() + "\": " + courseTwo.getStudents().size());

        course.getStudents().forEach(s -> System.out.println(s.getName()));

        Student student = session.get(Student.class, 1);
        System.out.println("Первый студент: " + student);

        Teacher teacher = session.get(Teacher.class, 1);
        System.out.println("Первый преподаватель: " + teacher);


        transaction.commit();
        sessionFactory.close();
    }
}
