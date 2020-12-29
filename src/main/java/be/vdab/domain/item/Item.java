package be.vdab.domain.item;

import be.vdab.domain.ItemOrder;
import be.vdab.domain.Review;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "item_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String title;

    @NotNull
    @Digits(integer = 5, fraction = 2)
    private double price;

    @NotNull
    @Size(max = 100)
    private String supplierId;

    private Integer inventory;

    @Column(name = "item_type", insertable = false, updatable = false)
    private String itemType;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private ItemOrder itemOrder;

    @OneToOne(mappedBy = "item",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
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

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String articleType) {
        this.itemType = articleType;
    }

    public ItemOrder getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(ItemOrder itemOrder) {
        this.itemOrder = itemOrder;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;

    }
}
