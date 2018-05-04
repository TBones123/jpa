package entity;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "asda")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "idx")
    private int id;

    private String name;
    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.ALL},
            mappedBy = "user"
    )
    private List<Car> carList = new ArrayList<Car>();

@ManyToMany(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
)
    private  List<Book> books = new ArrayList<Book>();
    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
