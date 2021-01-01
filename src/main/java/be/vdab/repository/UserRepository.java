package be.vdab.repository;

import be.vdab.domain.WebUser;
import be.vdab.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<WebUser,Long> {
}
