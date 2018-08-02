package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;

    @RequestMapping(value = "/artists", method=RequestMethod.GET)
    public @ResponseBody Iterable<Artist> getAllArtists() {
        return artistRepository.findAll();
    }
}
