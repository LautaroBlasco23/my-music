package com.mymusic.SongService.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class MessageResponse extends Response {
  public String status;
  public String message;
}
