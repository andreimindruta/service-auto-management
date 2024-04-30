package com.servicecompany.serviceautomanagement.Repository;

import com.servicecompany.serviceautomanagement.Entities.Masina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasinaRepository extends JpaRepository<Masina, Long> {
}
