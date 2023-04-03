package springboot.studentMIS.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name="Student")
@Data
public class student {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String address;
	public student(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public student() {
		super();
		
	}
	

}
