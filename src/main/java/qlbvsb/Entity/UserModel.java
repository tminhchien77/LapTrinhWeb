package qlbvsb.Entity;
import org.hibernate.validator.constraints.NotEmpty;
public class UserModel {

	@NotEmpty(message = "Vui lòng nhập")
	private String id;

	@NotEmpty(message = "Vui lòng nhập")
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserModel() {
		super();
	}

	public UserModel(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
}
