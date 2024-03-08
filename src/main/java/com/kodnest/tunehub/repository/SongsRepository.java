package com.kodnest.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodnest.tunehub.entity.Songs;

@Repository
public interface SongsRepository extends JpaRepository<Songs, Long> {

}
