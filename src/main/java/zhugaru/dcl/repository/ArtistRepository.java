package zhugaru.dcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zhugaru.dcl.entity.ArtistEntity;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {
    Optional<ArtistEntity> findByArtistId(Long artistId);
    Optional<ArtistEntity> findByArtistNameIgnoreCase(String artistName);
}
