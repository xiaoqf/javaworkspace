package learn.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="book")
@Data
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String bookName;
	
	private String auther;
}
