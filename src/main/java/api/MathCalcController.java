package api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MathCalcController {
	
	@RequestMapping(value = "/math", method=RequestMethod.GET)
		public String renderRoot() {
	    	return "5x5=25";
	    }
	 
    @RequestMapping(value = "/math/add", method=RequestMethod.GET)
    	public String mathAdd(@RequestParam(value="what", defaultValue= "0" ) Integer what) {
        	return "Math add 5 + " + what + " = " + what * 5;
    	}
	
	@RequestMapping(value = "/math", method=RequestMethod.POST)
    public String createArtist(@RequestBody String jsonString) {
		
		System.out.println("Calculating: " + jsonString);
//    	MathCalc a;
    	
//    	try {
//            a = new ObjectMapper().readValue(jsonString, MathCalc.class);
//            return a.getId().toString();
//        } catch (JsonParseException e) {
//            e.printStackTrace();
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        
        return "Hello";
    }
}
