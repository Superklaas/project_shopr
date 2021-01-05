package be.vdab.domain;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
public class WebUser { //TRAINER TODO: user is ook een reserved keyword in MySql

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    //TRAINER TODO: als je regex gebruikt moet het matchen. Dus alles waar een numer of special character in zit match niet en geeft de error message weer
    //TRAINER TODO: zie test
    @Pattern(regexp = "[a-z\\sA-Z]*",
            message = "your first name cannot contain a number or a special character")
    private String name;

    @NotNull
    @Range(min=18,max=90)
    private int age;

    @OneToMany(mappedBy = "webUser",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<ItemOrder> itemOrders;

    @OneToMany(mappedBy = "webUser",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Review> reviews;

    public WebUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public WebUser() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<ItemOrder> getItemOrders() {
        return itemOrders;
    }

    public void setItemOrders(List<ItemOrder> itemOrders) {
        this.itemOrders = itemOrders;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}

