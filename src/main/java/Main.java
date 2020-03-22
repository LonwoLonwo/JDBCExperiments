import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

        Course course = session.get(Course.class, 2);

        System.out.println("Длительность курса \"" + course.getName() + "\" составляет " + course.getDuration() + " часов.");
        System.out.println("На курсе учится " + course.getStudentsCount() + " студентов");

        Course courseTwo = session.get(Course.class, 4);

        System.out.println("Стоимость курса \"" + courseTwo.getName() + "\": " + course.getPrice() + '\u20BD');
        System.out.println("Описание курса \"" + courseTwo.getName() + "\" гласит: " + courseTwo.getDescription());

        sessionFactory.close();
    }
}