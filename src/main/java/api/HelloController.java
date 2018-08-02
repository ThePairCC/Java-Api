package api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String renderRoot() {
        return "Hello World asdfasdf!";
    }
    
    @RequestMapping(value = "/say", method=RequestMethod.GET)
    public String renderSay(@RequestParam(value="what", defaultValue="Something") String what) {
        return "Say " + what;
    }
}
