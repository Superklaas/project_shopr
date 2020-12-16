//package be.vdab.domain;
//
//import be.vdab.domain.item.Item;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.util.Objects;
//
//@Entity
//public class Review {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Size(min = 0,max=10)
//    @NotNull
//    private int score;
//
//    @NotBlank
//    @Size(min = 1, max = 255)
//    private String description;
//
//    @ManyToOne(cascade = {CascadeType.DETACH,
//            CascadeType.MERGE,
//            CascadeType.PERSIST,
//            CascadeType.REFRESH})
//    @JoinColumn(name="user_id")
//    private User user;
//
//    @OneToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//    @JoinColumn(name="item_id")
//    private Item item;
//
//    public Review() { }
//
//    public int getScore() {
//        return score;
//    }
//
//    public void setScore(int score) {
//        this.score = score;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Item getItem() {
//        return item;
//    }
//
//    public void setItem(Item item) {
//        this.item = item;
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
//        Review review = (Review) o;
//        return score == review.score &&
//                Objects.equals(id, review.id) &&
//                Objects.equals(description, review.description) &&
//                Objects.equals(user, review.user) &&
//                Objects.equals(item, review.item);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, score, description, user, item);
//    }
//}
