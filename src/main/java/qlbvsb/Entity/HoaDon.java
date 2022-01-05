package qlbvsb.Entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="HoaDon")
public class HoaDon {
	@Id
	@GeneratedValue
	private int maHoaDon;
	@OneToMany(mappedBy = "hoaDon")
	Set<Ve> ve;
	@ManyToOne
    @JoinColumn(name = "MaVe_Tran")
    TRANDAU_VE tranDau_Ve;
    private int soLuongMua;
    private String email;
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon(int maHoaDon, Set<Ve> ve, TRANDAU_VE tranDau_Ve, int soLuongMua, String email) {
		super();
		this.maHoaDon = maHoaDon;
		this.ve = ve;
		this.tranDau_Ve = tranDau_Ve;
		this.soLuongMua = soLuongMua;
		this.email = email;
	}
	public int getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public Set<Ve> getVe() {
		return ve;
	}
	public void setVe(Set<Ve> ve) {
		this.ve = ve;
	}
	public TRANDAU_VE getTranDau_Ve() {
		return tranDau_Ve;
	}
	public void setTranDau_Ve(TRANDAU_VE tranDau_Ve) {
		this.tranDau_Ve = tranDau_Ve;
	}
	public int getSoLuongMua() {
		return soLuongMua;
	}
	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
