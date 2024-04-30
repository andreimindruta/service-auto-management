package com.servicecompany.serviceautomanagement.Repository;

import com.servicecompany.serviceautomanagement.Entities.Programare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramareRepository extends JpaRepository<Programare, Long> {

}
