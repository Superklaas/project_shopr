package be.vdab.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class ItemOrder { //TRAINER: Order is een reserved keyword in sql

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @OneToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "item_order_id")
    private List<ItemOrderUnit> itemOrderUnits;

    @ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private WebUser webUser;

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<ItemOrderUnit> getItemOrderUnits() {
        return itemOrderUnits;
    }

    public void setItemOrderUnits(List<ItemOrderUnit> itemOrderUnits) {
        this.itemOrderUnits = itemOrderUnits;
    }

    public WebUser getWebUser() {
        return webUser;
    }

    public void setWebUser(WebUser webUser) {
        this.webUser = webUser;
    }

}
