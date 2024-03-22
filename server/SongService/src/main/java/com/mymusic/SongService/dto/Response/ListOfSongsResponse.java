package com.mymusic.SongService.dto.Response;

import java.util.List;

import com.mymusic.SongService.model.Song;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class ListOfSongsResponse extends Response {
  public final String status = "success";
  public List<Song> listOfSongs;
}