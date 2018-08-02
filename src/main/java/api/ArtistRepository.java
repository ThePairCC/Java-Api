package api;

import org.springframework.data.repository.CrudRepository;

import api.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long> {}
