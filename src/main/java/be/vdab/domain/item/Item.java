package be.vdab.domain.item;

import be.vdab.domain.Order;
import be.vdab.domain.Review;

import javax.persistence.*;

@MappedSuperclass
@Entity
@DiscriminatorColumn(name = "article_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private double price;
    private String supplierId;
    private int inventory;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name="ordered_item_id")
    private Order orderedItem;

    @OneToOne
    private Review review;

    public Item(Long id, String title, double price, String supplierId, int inventory) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.supplierId = supplierId;
        this.inventory = inventory;
    }

    public Item() {
    }
}
