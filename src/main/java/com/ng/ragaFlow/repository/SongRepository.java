package com.ng.ragaFlow.repository;

import com.ng.ragaFlow.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {

}
