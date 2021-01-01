package be.vdab.repository;

import be.vdab.domain.ItemOrder;
import be.vdab.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<ItemOrder,Long> {
}
