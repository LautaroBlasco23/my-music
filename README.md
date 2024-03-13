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

Application's logic is developed using Golang.

Application's FrontEnd developed using React.

Databases used are:

- MongoDB for playlists.
- Redis for auth data.
- MySQL for user's data.

## Entities

**Auth**

- Email
- Password

**User**

- Email
- Username
- List_of_playlists

**Playlist**

- Name
- List_of_songs
- Available_to