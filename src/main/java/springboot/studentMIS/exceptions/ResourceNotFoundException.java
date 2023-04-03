package springboot.studentMIS.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID=1L;
	private String name;
	private long id;
	
	public ResourceNotFoundException(String name, long id) {
		super(String.format("%s not found with  Id %d ",name,id));
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public Object getId() {
		return id;
	}
	
}

