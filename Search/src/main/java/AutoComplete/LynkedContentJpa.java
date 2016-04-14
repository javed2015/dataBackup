package AutoComplete;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="Testing_Jpa")
public class LynkedContentJpa {
	
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

	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
	private UserRegistrationJpa user;
	
	

	


	

	public LynkedContentJpa(String userId, String url, String name,
			String token, String flag, String description, String data,
			String dummy1, String dummy2, UserRegistrationJpa user) {
		super();
		this.userId = userId;
		this.url = url;
		this.name = name;
		this.token = token;
		this.flag = flag;
		this.description = description;
		this.data = data;
		this.dummy1 = dummy1;
		this.dummy2 = dummy2;
		this.user = user;
	}

	public LynkedContentJpa() {
		// TODO Auto-generated constructor stub
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
	
	public UserRegistrationJpa getUser() {
		return user;
	}

	public void setUser(UserRegistrationJpa user) {
		this.user = user;
	}
	
	

}
