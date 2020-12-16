package be.vdab.domain.item;

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

    public Item(Long id, String title, double price, String supplierId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.supplierId = supplierId;
    }

    public Item() {
    }
}
