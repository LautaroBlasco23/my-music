package com.mymusic.SongService.dto.Response;

import com.mymusic.SongService.model.Song;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class SongResponse extends Response {
  public final String status = "success";
  public Song song;
}