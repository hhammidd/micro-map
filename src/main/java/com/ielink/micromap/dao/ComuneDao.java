package com.ielink.micromap.dao;

import com.ielink.micromap.model.Comune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComuneDao extends JpaRepository<Comune, Long> {
}
