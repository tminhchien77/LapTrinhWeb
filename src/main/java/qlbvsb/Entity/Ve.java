package qlbvsb.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VE")
public class Ve {
	@Id
	private String IDVe;
	
	@ManyToOne
    @JoinColumn(name = "maHoaDon")
    HoaDon hoaDon;

	public Ve() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ve(String iDVe, HoaDon hoaDon) {
		super();
		IDVe = iDVe;
		this.hoaDon = hoaDon;
	}

	public String getIDVe() {
		return IDVe;
	}

	public void setIDVe(String iDVe) {
		IDVe = iDVe;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

}
