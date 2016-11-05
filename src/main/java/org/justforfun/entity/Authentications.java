package org.justforfun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


// default package
// Generated Oct 16, 2016 10:50:15 PM by Hibernate Tools 4.0.1.Final

/**
 * Authentications generated by hbm2java
 */
@Table(name = "authentications")
@Entity(name="Authentications")
public class Authentications implements java.io.Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="user_id",insertable=false,nullable=false,updatable=false)
	private Integer userId;
	

	@ManyToOne(targetEntity=Users.class,fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private Users users;
	
	@Column(name="password")
	private String password;

	public Authentications() {
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
