package be.vdab.repository;

import be.vdab.domain.Review;
import be.vdab.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
