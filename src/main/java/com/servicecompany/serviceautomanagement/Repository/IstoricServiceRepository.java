package com.servicecompany.serviceautomanagement.Repository;

import com.servicecompany.serviceautomanagement.Entities.IstoricService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IstoricServiceRepository extends JpaRepository<IstoricService, Long> {
}
