package com.ca.recoqueryservice.functions;


import com.ca.recocore.dto.AllSongRegisteredEvent;
import com.ca.recocore.mapper.AlbumMapper;
import com.ca.recocore.mapper.ArtistMapper;
import com.ca.recocore.mapper.GenreMapper;
import com.ca.recocore.mapper.SongMapper;
import com.ca.recocore.models.Album;
import com.ca.recocore.models.Artist;
import com.ca.recocore.models.Genre;
import com.ca.recocore.models.Song;
import com.ca.recoqueryservice.repositories.AlbumRepository;
import com.ca.recoqueryservice.repositories.ArtistRepository;
import com.ca.recoqueryservice.repositories.GenreRepository;
import com.ca.recoqueryservice.repositories.SongRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;


@Component
public class MusicServiceConsumer {

    private final SongRepository songRepository;
    private final GenreRepository genreRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;


    public MusicServiceConsumer(SongRepository songRepository, GenreRepository genreRepository, ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.genreRepository = genreRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }


    @Bean
    public Consumer<AllSongRegisteredEvent> onReceive() {
        return (event) -> {

            Song song = SongMapper.INSTANCE.songDTOToSong(event.getSong());
            Album album = AlbumMapper.INSTANCE.albumDTOToAlbum(event.getAlbum());
            Genre genre = GenreMapper.INSTANCE.genreDTOToGenre(event.getGenre());
            Artist artist = ArtistMapper.INSTANCE.artistDTOToArtist(event.getArtist());

            songRepository.save(song).subscribe(x-> {
                genre.addRelation(song);
                genreRepository.save(genre).subscribe();
            });
            albumRepository.save(album).subscribe();
            artistRepository.save(artist).subscribe();

        };
    }
}