package com.mymusic.SongService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mymusic.SongService.dto.Request.SongRequest;
import com.mymusic.SongService.model.Song;
import com.mymusic.SongService.repository.SongRepository;

import lombok.AllArgsConstructor;

// Services can throw exceptions, because they will be handled in controllers.

@Service
@AllArgsConstructor
public class SongServices {
  
  private SongRepository songRepository;

  public List<Song> getAllSongs() {
    List<Song> listOfSongs = new ArrayList<>();
    songRepository.findAll().forEach(listOfSongs::add);

    return listOfSongs;
  }

  public Song getSongById(Long id) throws Exception {
    if (songRepository.findById(id).isPresent()) {
      Song song = songRepository.findById(id).get();

      System.out.println("song data: " + song);

      return Song.builder()
        .id(song.getId())
        .firstName(song.getFirstName())
        .lastName(song.getLastName())
        .build();
    } else {
      throw new Exception();
    }
  }

  public Long createSong(SongRequest song) {
    Song newSong = songRepository.save(Song
    .builder()
    .firstName(song.getFirstName())
    .lastName(song.getLastName())
    .build()
    );

    return newSong.getId();
  }

  public Long updateSong(Long id, SongRequest newSongData) {
    Song songToUpdate = songRepository.findById(id).get();
    
    songToUpdate.setFirstName(newSongData.getFirstName());
    songToUpdate.setLastName(newSongData.getLastName());

    Song updatedSong = songRepository.save(songToUpdate);

    return updatedSong.getId();
  }

  public Long removeSong(Long id) {
    songRepository.deleteById(id);

    return id;
  }
}