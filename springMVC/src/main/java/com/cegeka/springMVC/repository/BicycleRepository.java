package com.cegeka.springMVC.repository;

import com.cegeka.springMVC.entity.BicycleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BicycleRepository  extends JpaRepository<BicycleEntity, Long> {

    BicycleEntity findByName(String name);

    @Query("SELECT b FROM BicycleEntity b WHERE LOWER(b.name) = LOWER(:name)")
    BicycleEntity retrieveByName(@Param("name") String name);
}
