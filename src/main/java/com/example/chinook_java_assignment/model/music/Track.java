package com.example.chinook_java_assignment.model.music;

public class Track {
    public int TrackId;
    public String Name;
    public String Composer;
    public int AlbumId;
    public int GenreId;
    public String AlbumName;
    public String GenreName;

    public Track(int trackId, String name, String composer, int albumId, int genreId) {
        TrackId = trackId;
        Name = name;
        Composer = composer;
        AlbumId = albumId;
        GenreId = genreId;
        AlbumName = null;
        GenreName = null;
    }

    public Track(int trackId, String name, String composer, int albumId, int genreId,  String albumName, String genreName) {
        TrackId = trackId;
        Name = name;
        Composer = composer;
        AlbumId = albumId;
        AlbumName = albumName;
        GenreName = genreName;
        GenreId = genreId;
    }
}
