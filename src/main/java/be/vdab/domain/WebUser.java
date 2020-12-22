package be.vdab.domain;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
public class WebUser { //TRAINER: user is ook een reserved keyword in MySql
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 18, max=90)
    private int age;

    @Pattern(regexp = "^(([a-zA-Z]){1})(([a-zA-Z])|([-])){0,15}(([a-zA-Z]){1})$",
            message = "your first name cannot contain a number or a special character")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itemorder_id")
    private ItemOrder itemOrder;

    @OneToMany(mappedBy = "webUser",
    cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
    fetch = FetchType.LAZY)
    private List<Review> reviews;

    public WebUser() {}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public ItemOrder getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(ItemOrder itemOrder) {
        this.itemOrder = itemOrder;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebUser webUser = (WebUser) o;
        return age == webUser.age &&
                Objects.equals(id, webUser.id) &&
                Objects.equals(name, webUser.name) &&
                Objects.equals(itemOrder, webUser.itemOrder) &&
                Objects.equals(reviews, webUser.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name, itemOrder, reviews);
    }
}

