package be.vdab.domain;

import be.vdab.domain.item.Item;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class ItemOrder { //TRAINER: Order is een reserved keyword in sql

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @OneToMany(mappedBy = "itemOrder",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Item> items;

    @OneToOne(mappedBy = "itemOrder",
            cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private WebUser webUser;

    public ItemOrder() { }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public WebUser getUser() {
        return webUser;
    }

    public void setUser(WebUser webUser) {
        this.webUser = webUser;
    }

    public Long getId() {
        return id;
    }

}
