package com.mymusic.SongService.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mymusic.SongService.dto.Request.SongRequest;
import com.mymusic.SongService.dto.Response.Response;
import com.mymusic.SongService.dto.Response.MessageResponse;
import com.mymusic.SongService.dto.Response.ListOfSongsResponse;
import com.mymusic.SongService.dto.Response.SongResponse;
import com.mymusic.SongService.model.Song;
import com.mymusic.SongService.services.SongServices;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/song")
public class SongController {

  private SongServices songServices;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public Response getAllSongs() {
    try {
      return ListOfSongsResponse.builder()
        .listOfSongs(songServices.getAllSongs())
        .build();
    } catch (Exception e) {
      return MessageResponse.builder()
      .status("error")
      .message(e.getMessage())
      .build();
    }
  }

  @GetMapping("/{songId}")
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public Response getAllSongs(@PathVariable Long songId) {
    try {
      Song songData = songServices.getSongById(songId);

      return SongResponse.builder()
      .song(songData)
      .build();
    } catch (Exception e) {
      return MessageResponse.builder()
      .message(e.getMessage())
      .build();
    }
  }
  
  @PostMapping("/")
  @ResponseStatus(HttpStatus.CREATED)
  public Response createSong(@RequestBody SongRequest song) {
    try {
      songServices.createSong(song);

      return MessageResponse.builder()
      .status("success")
      .message("new Song created")
      .build();
    } catch (Exception e) {
      return MessageResponse.builder()
      .status("error")
      .message(e.getMessage())
      .build();
    }
  }

  @PutMapping("/{songId}")
  @ResponseStatus(HttpStatus.OK)
  public Response modifySong(@PathVariable Long songId, @RequestBody SongRequest songData) {
    try {
      songServices.updateSong(songId, songData);
      
      return MessageResponse.builder()
      .status("success")
      .message("Song with id:" + songId + " has been modified")
      .build();
    } catch (Exception e) {
      return MessageResponse.builder()
      .status("error")
      .message(e.getMessage())
      .build();
    }
  }

  @DeleteMapping("/{songId}")
  @ResponseStatus(HttpStatus.OK)
  public Response deleteSong(@PathVariable Long songId) {
    try {
      songServices.removeSong(songId);
      
      return MessageResponse.builder()
      .status("success")
      .message("Song with id:" + songId + " has been deleted")
      .build();
    } catch (Exception e) {
      return MessageResponse.builder()
      .status("error")
      .message(e.getMessage())
      .build();
    }
  }
}