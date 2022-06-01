package com.lien.store.repository;

import com.lien.store.model.Segurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SegurityRepository extends JpaRepository<Segurity, Long> {}
