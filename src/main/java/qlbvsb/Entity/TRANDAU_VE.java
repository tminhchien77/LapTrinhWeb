package qlbvsb.Entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="TRANDAU_VE")
public class TRANDAU_VE {
	@Id
	@GeneratedValue
	private int MaVe_Tran;
	@OneToMany(mappedBy = "tranDau_Ve")
	Set<HoaDon> hoaDon;
	
	
	@ManyToOne
    @JoinColumn(name = "maTran")
    TRANDAU tranDau;

    @ManyToOne
    @JoinColumn(name = "maGiaApDung")
    GiaApDung giaApDung;
    
    private int soLuongVeBan;
    @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date ngayPhatHanh;
	public TRANDAU_VE() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TRANDAU_VE(int maVe_Tran, Set<HoaDon> hoaDon, TRANDAU tranDau, GiaApDung giaApDung, int soLuongVeBan,
			Date ngayPhatHanh) {
		super();
		MaVe_Tran = maVe_Tran;
		this.hoaDon = hoaDon;
		this.tranDau = tranDau;
		this.giaApDung = giaApDung;
		this.soLuongVeBan = soLuongVeBan;
		this.ngayPhatHanh = ngayPhatHanh;
	}
	public int getMaVe_Tran() {
		return MaVe_Tran;
	}
	public void setMaVe_Tran(int maVe_Tran) {
		MaVe_Tran = maVe_Tran;
	}
	public Set<HoaDon> getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(Set<HoaDon> hoaDon) {
		this.hoaDon = hoaDon;
	}
	public TRANDAU getTranDau() {
		return tranDau;
	}
	public void setTranDau(TRANDAU tranDau) {
		this.tranDau = tranDau;
	}
	public GiaApDung getGiaApDung() {
		return giaApDung;
	}
	public void setGiaApDung(GiaApDung giaApDung) {
		this.giaApDung = giaApDung;
	}
	public int getSoLuongVeBan() {
		return soLuongVeBan;
	}
	public void setSoLuongVeBan(int soLuongVeBan) {
		this.soLuongVeBan = soLuongVeBan;
	}
	public Date getNgayPhatHanh() {
		return ngayPhatHanh;
	}
	public void setNgayPhatHanh(Date ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}
}
