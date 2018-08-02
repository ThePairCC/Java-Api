package api;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class TaskController {
	@Autowired
    private TaskRepository taskRepository;
	
	@RequestMapping(value = "/tasks", method=RequestMethod.GET)
	public @ResponseBody Iterable<Task> getAllTasks() {
       return taskRepository.findAll();
    }
	
	@RequestMapping(value = "/tasks/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Task> getTask(@PathVariable final Long id) {
       return taskRepository.findById(id);
    }
	
	@RequestMapping(value = "/tasks", method=RequestMethod.POST)
    public String createTask(@RequestBody String jsonString) {
		Task a;
        
        try {
            a = new ObjectMapper().readValue(jsonString, Task.class);
            taskRepository.save(a);
            
            return (a).getId().toString();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error";
    }
	
	@RequestMapping(value = "/tasks/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> updateTask(@PathVariable final Long id, @RequestBody Task task) {
		taskRepository.save(task);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/tasks/{id}", method=RequestMethod.DELETE)
	public @ResponseBody String deleteTask(@PathVariable final Long id) {
		taskRepository.deleteById(id);
		return "Successuflly deleted id: " + id;
    }
}
