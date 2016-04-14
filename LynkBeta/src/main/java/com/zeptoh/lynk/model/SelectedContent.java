package com.zeptoh.lynk.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="UserFactualContent")
public class SelectedContent {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@Column(name = "E_MAIL")
	private String userId;
	
	@Column(name = "URL")
	private String url;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "TOKEN")
	private String token;
	
	@Column(name = "FLAG")
	private String flag;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "DATA")
	private String data;
	
	@Column(name = "DUMMY1")
	private String dummy1;
	
	@Column(name = "DUMMY2")
	private String dummy2;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private UserRegistration user;
	
	
	

	public SelectedContent(String userId, String url, String name,
			String token, String flag, String description, String data,
			String dummy1, String dummy2) {
		this.userId = userId;
		this.url = url;
		this.name = name;
		this.token = token;
		this.flag = flag;
		this.description = description;
		this.data = data;
		this.dummy1 = dummy1;
		this.dummy2 = dummy2;
	}

	public SelectedContent() {
		// TODO Auto-generated constructor stub
	}

	public UserRegistration getUser() {
		return user;
	}

	public void setUser(UserRegistration user) {
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDummy1() {
		return dummy1;
	}

	public void setDummy1(String dummy1) {
		this.dummy1 = dummy1;
	}

	public String getDummy2() {
		return dummy2;
	}

	public void setDummy2(String dummy2) {
		this.dummy2 = dummy2;
	}

	
	

}
