//package be.vdab.domain;
//
//import javax.persistence.*;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;
//import java.util.List;
//import java.util.Objects;
//
//@Entity
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Size(min = 18, max=90)
//    private int age;
//
//    @Pattern(regexp = "^(([a-zA-Z]){1})(([a-zA-Z])|([-])){0,15}(([a-zA-Z]){1})$",
//            message = "your first name cannot contain a number or a special character")
//    private String name;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "order_id")
//    private Order order;
//
//    @OneToMany(mappedBy = "user",
//    cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
//    fetch = FetchType.LAZY)
//    private List<Review> reviews;
//
//    public User() {}
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
//
//    public List<Review> getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(List<Review> reviews) {
//        this.reviews = reviews;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return age == user.age &&
//                Objects.equals(id, user.id) &&
//                Objects.equals(name, user.name) &&
//                Objects.equals(order, user.order) &&
//                Objects.equals(reviews, user.reviews);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, age, name, order, reviews);
//    }
//}
