package pl.kazlas.frankfurter.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@XmlRootElement(name = "ratesearch")
@JsonIgnoreProperties({ "id" })
public class RateSearchEntity {

	@Id
	@GeneratedValue
	private Long id;

	@JsonSerialize(using = LocalDateTimeSerializer.class)  
	private LocalDateTime date;
	
	private BigDecimal rate;

	@JsonSerialize(using = LocalDateTimeSerializer.class)  
	private LocalDateTime timestamp;

	public RateSearchEntity() {
	}

	public RateSearchEntity(LocalDateTime date, BigDecimal rate, LocalDateTime timestamp) {
		this.date = date;
		this.rate = rate;
		this.timestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
}
