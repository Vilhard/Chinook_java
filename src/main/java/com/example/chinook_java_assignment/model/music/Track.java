package com.example.chinook_java_assignment.model.music;

public class Track {
    public int TrackId;
    public String Name;
    public String Composer;
    public int AlbumId;
    public int GenreId;

    public Track(int trackId, String name, String composer, int albumId, int genreId) {
        TrackId = trackId;
        Name = name;
        Composer = composer;
        AlbumId = albumId;
        GenreId = genreId;
    }
}
