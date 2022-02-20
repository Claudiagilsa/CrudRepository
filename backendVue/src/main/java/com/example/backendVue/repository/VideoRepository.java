package com.example.backendVue.repository;

import com.example.backendVue.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByPublished(boolean published);
    List<Video> findByTitleContaining(String title);
}
