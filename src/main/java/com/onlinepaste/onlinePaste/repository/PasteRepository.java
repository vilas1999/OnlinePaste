package com.onlinepaste.onlinePaste.repository;

import com.onlinepaste.onlinePaste.entity.Paste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasteRepository extends JpaRepository<Paste, Long> {
}
