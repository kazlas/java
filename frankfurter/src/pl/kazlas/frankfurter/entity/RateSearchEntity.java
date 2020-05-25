package pl.kazlas.frankfurter.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RateSearchEntity {

	@Id
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
