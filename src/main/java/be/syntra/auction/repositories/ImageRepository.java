package be.syntra.auction.repositories;

import be.syntra.auction.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findByItem_Id(Long id);
}
