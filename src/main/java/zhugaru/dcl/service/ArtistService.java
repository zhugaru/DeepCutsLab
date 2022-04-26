package zhugaru.dcl.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhugaru.dcl.entity.ArtistEntity;
import zhugaru.dcl.repository.ArtistRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistEntity saveArtist(ArtistEntity artist) {
        if (artistRepository.findByArtistNameIgnoreCase(artist.getArtistName()).isPresent()) {
            artist = artistRepository.findByArtistNameIgnoreCase(artist.getArtistName()).get();
            artist.setArtistName(artist.getArtistName());
        }
        artistRepository.save(artist);

        return artist;
    }

    public ArtistEntity findByArtistName(String artistName) {
        Optional<ArtistEntity> artist = artistRepository.findByArtistNameIgnoreCase(artistName);
        if (artist.isPresent()) {
            return artist.get();
        }
        throw new NoSuchElementException();
    }
}
