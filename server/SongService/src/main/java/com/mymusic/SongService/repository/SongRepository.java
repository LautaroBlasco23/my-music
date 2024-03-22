package com.mymusic.SongService.repository;

import org.springframework.data.repository.CrudRepository;
import com.mymusic.SongService.model.Song;

public interface SongRepository extends CrudRepository<Song, Long> {}