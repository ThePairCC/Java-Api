package api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongsController {
	
	@RequestMapping(value = "/songs", method=RequestMethod.GET)
    public ArrayList<Song> renderSongs() {
        return new ArrayList<Song>();
    }
	
	@RequestMapping(value = "/songs/1", method=RequestMethod.GET)
    public Song renderSong() {
        return new Song();
    }
	
	@RequestMapping(value = "/songs", method=RequestMethod.POST)
    public String createSong(@RequestBody String jsonString) {
        return jsonString;
    }
}
