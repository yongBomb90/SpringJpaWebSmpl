package com.bomb.springjpasmpl.zone;


import com.bomb.springjpasmpl.domain.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepository extends JpaRepository<Zone, Long> {
}
