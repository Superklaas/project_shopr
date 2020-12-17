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

    //heeft nog validatie nodig
    private LocalDate date;

    @OneToMany(mappedBy = "orderedItem",
            cascade = { CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private List<Item> itemList;

    @OneToOne(mappedBy = "itemOrder",
            cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private WebUser webUser;

    public ItemOrder() { }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemOrder itemOrder = (ItemOrder) o;
        return Objects.equals(id, itemOrder.id) &&
                Objects.equals(date, itemOrder.date) &&
                Objects.equals(itemList, itemOrder.itemList) &&
                Objects.equals(webUser, itemOrder.webUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, itemList, webUser);
    }

    public void setId(Long id) {
        this.id = id;
    }
}
