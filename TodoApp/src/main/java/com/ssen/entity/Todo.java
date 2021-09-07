package com.ssen.entity;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message="Task must be set")
	@Size(min=10, message="Task should not be less than 10 characters")
	private String task;
	
	@NotNull(message="Due date must be set")
	@FutureOrPresent(message="Due date must be in future or present")
	@JsonbDateFormat(value="yyyy-MM-dd")
	private LocalDate dateDue;
	
	
	private boolean isCompleted;
	private LocalDate dateCompleted;
	private LocalDate dateCreated;
	
	@PrePersist
	private void init() {
		setDateCreated(LocalDate.now());
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public LocalDate getDateDue() {
		return dateDue;
	}
	public void setDateDue(LocalDate dateDue) {
		this.dateDue = dateDue;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public LocalDate getDateCompleted() {
		return dateCompleted;
	}
	public void setDateCompleted(LocalDate dateCompleted) {
		this.dateCompleted = dateCompleted;
	}
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
