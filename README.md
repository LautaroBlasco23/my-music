# My Music

Basic application developed to get music from different platforms and make your own playlists.

With this application you can make a playlist with music from Spotify, Youtube and Soundcloud.

# App Information

This app allows the users to:

- Register/Login.
- Create Playlist.
- Search for music in different platforms.
- Share playlist with their friends.

## Technical information

Application's architecture is a Microservices Architecture.

Application's FrontEnd developed using React.

Databases used are:

- MongoDB for playlists and Songs.
- Redis for auth data.
- MySQL for user's data.

## Entities & Data Types (in java)

**Auth**

- Email | String
- Password | String

**User**

- Id | UUID
- Email | String
- Username | String
- List_of_playlists | List<UUID>

**Playlist**

- Id | UUID
- User_id | UUID
- Name | String
- List_of_songs | List<UUID>
- Available_to | List<UUID>

**Song**

- Id | UUID
- Name | String
- Platform | String
- data (unknown atm)
