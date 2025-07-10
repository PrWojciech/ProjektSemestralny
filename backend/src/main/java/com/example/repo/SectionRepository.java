package com.example.repo;

import com.example.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Integer> {
    public Section getSectionById(Integer id);
}
