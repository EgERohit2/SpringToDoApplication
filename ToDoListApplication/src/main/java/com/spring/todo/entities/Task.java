package com.spring.todo.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "task_tab")
public class Task {

	
	
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Task(int id, String desc, Date startDate, Date endDate, TaskStatus status, List<Role> role) {
		super();
		this.id = id;
		this.desc = desc;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "description")
	private String desc;
	@Column(nullable = false)
	private Date startDate;
	@Column(nullable = false)
	private Date endDate;
	@CreationTimestamp
	private Date createdAt;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TaskStatus status;
	@ManyToMany(mappedBy = "task")
	private List<Role> role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	public List<Role> getRole() {
		return role;
	}
	public void setRole(List<Role> role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", desc=" + desc + ", startDate=" + startDate + ", endDate=" + endDate + ", status="
				+ status + ", role=" + role + "]";
	}
	
	
	
	
}
