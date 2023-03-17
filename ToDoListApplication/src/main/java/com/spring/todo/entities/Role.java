package com.spring.todo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="role_tab")
public class Role {
	
	
	
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int id, String rolename, List<User> user, List<Task> task) {
		super();
		this.id = id;
		this.rolename = rolename;
		this.user = user;
		this.task = task;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="rolename")
	private String rolename;
	private Boolean isActive=true;
	@CreatedDate
	private Date createdAt;
	@ManyToMany(mappedBy = "role")
	private List<User> user = new ArrayList<>();
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "Role_Task", joinColumns = @JoinColumn(name = "rid"), inverseJoinColumns = @JoinColumn(name = "pid"))
	private List<Task> task = new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public List<Task> getTask() {
		return task;
	}
	public void setTask(List<Task> task) {
		this.task = task;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + ", user=" + user + ", task=" + task + "]";
	}
	
	
	
	
	
	
	
}
