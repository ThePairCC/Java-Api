package api;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/categories/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Category> getCategory(@PathVariable final Long id) {
       return categoryRepository.findById(id);
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
	
	@RequestMapping(value = "/categories/{id}", method=RequestMethod.DELETE)
	public @ResponseBody String deleteCategory(@PathVariable final Long id) {
		categoryRepository.deleteById(id);
		return "Successuflly deleted id: " + id;
    }
}
	

