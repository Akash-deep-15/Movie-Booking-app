package com.example.BookMyShow.Reopsitory;

import com.example.BookMyShow.Model.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<TheatreEntity, Integer> {
}
