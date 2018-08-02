package api;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CategoriesController {
	@Autowired
    private CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/categories", method=RequestMethod.GET)
	public @ResponseBody Iterable<Category> getAllCategories() {
       return categoryRepository.findAll();
    }
	
	@RequestMapping(value = "/categories", method=RequestMethod.POST)
    public String createCategory(@RequestBody String jsonString) {
		Category a;
        
        try {
            a = new ObjectMapper().readValue(jsonString, Category.class);
            categoryRepository.save(a);
            
            return a.getId().toString();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error";
    }
}
	
//	@RequestMapping(value = "/categories/1", method=RequestMethod.GET)
//    public Song renderSong() {
//        return new Song();
//    }
//	
//	@RequestMapping(value = "/songs", method=RequestMethod.POST)
//    public String createSong(@RequestBody String jsonString) {
//        return jsonString;
//    }

