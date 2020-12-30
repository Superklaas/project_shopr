package be.vdab.domain;

import be.vdab.domain.item.Item;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ItemOrderUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private int number;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private Item item;

    public ItemOrderUnit(int number, Item item) {
        this.number = number;
        this.item = item;
    }

    public ItemOrderUnit() {

    }

    public long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
