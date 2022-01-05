package qlbvsb.Entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="GiaApDung")
public class GiaApDung {
	@Id
	private int maGiaApDung;
	@OneToMany(mappedBy = "giaApDung")
	Set<TRANDAU_VE> tranDau_Ve;
	@ManyToOne
    @JoinColumn(name="maLoai", nullable=false)
    private LoaiVe loaiVe;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date ngayApDung;
	private float gia;
	private int soLuongBan;
	
	public GiaApDung() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiaApDung(int maGiaApDung, Set<TRANDAU_VE> tranDau_Ve, LoaiVe loaiVe, Date ngayApDung, float gia,
			int soLuongBan) {
		super();
		this.maGiaApDung = maGiaApDung;
		this.tranDau_Ve = tranDau_Ve;
		this.loaiVe = loaiVe;
		this.ngayApDung = ngayApDung;
		this.gia = gia;
		this.soLuongBan = soLuongBan;
	}

	public int getMaGiaApDung() {
		return maGiaApDung;
	}

	public void setMaGiaApDung(int maGiaApDung) {
		this.maGiaApDung = maGiaApDung;
	}

	public Set<TRANDAU_VE> getTranDau_Ve() {
		return tranDau_Ve;
	}

	public void setTranDau_Ve(Set<TRANDAU_VE> tranDau_Ve) {
		this.tranDau_Ve = tranDau_Ve;
	}

	public LoaiVe getLoaiVe() {
		return loaiVe;
	}

	public void setLoaiVe(LoaiVe loaiVe) {
		this.loaiVe = loaiVe;
	}

	public Date getNgayApDung() {
		return ngayApDung;
	}

	public void setNgayApDung(Date ngayApDung) {
		this.ngayApDung = ngayApDung;
	}

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}

	public int getSoLuongBan() {
		return soLuongBan;
	}

	public void setSoLuongBan(int soLuongBan) {
		this.soLuongBan = soLuongBan;
	}

}
