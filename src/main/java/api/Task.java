package api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String title;
	private Long category_id;
	private Boolean isComplete;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		 this.id = id;
   }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
	    this.title = title;
	}
	
	public Long getCategory_id() {
		return category_id;
	}
	
	public void setCategory_id(Long category_id) {
		 this.category_id = category_id;
   }
	
	public Boolean getIsComplete() {
		return isComplete;
	}
	
	public void setIsComplete(Boolean isComplete) {
		 this.isComplete = isComplete;
   }
     
}