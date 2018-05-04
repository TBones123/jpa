import entity.Book;
import entity.Car;
import entity.User;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xxx");
        EntityManager entityManager = factory.createEntityManager();


        entityManager.getTransaction().begin();

//        entityManager.persist(new User("Vasya"));
//        entityManager.persist(new User("Petya"));

        User user = entityManager.find(User.class, 1);
        System.out.println(user);

//        TypedQuery<User> usersQ = entityManager.createQuery("select u from User u where u.id >=:zxc", User.class);
//
//        usersQ.setParameter("zxc", 2);
//
//        List<User> resultList = usersQ.getResultList();
//        System.out.println(resultList);



        Car car = new Car("subaru", new User("serj"));
        entityManager.persist(car);



        User user1 = new User("anton");
        entityManager.persist(user1);
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("mb", user1));
        cars.add(new Car("bmv", user1));
        user1.setCarList(cars);


        User user2 = new User("alex");
        entityManager.persist(user2);
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("bible"));
        books.add(new Book("main kampf"));
        user2.setBooks(books);













        entityManager.getTransaction().commit();




        entityManager.close();
        factory.close();
    }
}
