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
@Table(name="TRANDAU")
public class TRANDAU {
	@Id
	@GeneratedValue
	private int maTran;
	@OneToMany(mappedBy = "tranDau")
	Set<TRANDAU_VE> tranDau_Ve;
	@ManyToOne
    @JoinColumn(name="maDoiDauGiai", nullable=false)
    private ThamGiaGiai thamGiaGiai;
	@Column(name="Nha_Khach")
	private int nhaKhach;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date ngayThiDau;
	@Column(name="BT_DoiNha")
	private Integer btDoiNha;
	@Column(name="BT_DoiKhach")
	private Integer btDoiKhach;
	private String thoiGianBD;
	public TRANDAU() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TRANDAU(int maTran, Set<TRANDAU_VE> tranDau_Ve, ThamGiaGiai thamGiaGiai, int nhaKhach, Date ngayThiDau,
			Integer btDoiNha, Integer btDoiKhach, String thoiGianBD) {
		super();
		this.maTran = maTran;
		this.tranDau_Ve = tranDau_Ve;
		this.thamGiaGiai = thamGiaGiai;
		this.nhaKhach = nhaKhach;
		this.ngayThiDau = ngayThiDau;
		this.btDoiNha = btDoiNha;
		this.btDoiKhach = btDoiKhach;
		this.thoiGianBD = thoiGianBD;
	}
	public int getMaTran() {
		return maTran;
	}
	public void setMaTran(int maTran) {
		this.maTran = maTran;
	}
	public Set<TRANDAU_VE> getTranDau_Ve() {
		return tranDau_Ve;
	}
	public void setTranDau_Ve(Set<TRANDAU_VE> tranDau_Ve) {
		this.tranDau_Ve = tranDau_Ve;
	}
	public ThamGiaGiai getThamGiaGiai() {
		return thamGiaGiai;
	}
	public void setThamGiaGiai(ThamGiaGiai thamGiaGiai) {
		this.thamGiaGiai = thamGiaGiai;
	}
	public int getNhaKhach() {
		return nhaKhach;
	}
	public void setNhaKhach(int nhaKhach) {
		this.nhaKhach = nhaKhach;
	}
	public Date getNgayThiDau() {
		return ngayThiDau;
	}
	public void setNgayThiDau(Date ngayThiDau) {
		this.ngayThiDau = ngayThiDau;
	}
	public Integer getBtDoiNha() {
		return btDoiNha;
	}
	public void setBtDoiNha(Integer btDoiNha) {
		this.btDoiNha = btDoiNha;
	}
	public Integer getBtDoiKhach() {
		return btDoiKhach;
	}
	public void setBtDoiKhach(Integer btDoiKhach) {
		this.btDoiKhach = btDoiKhach;
	}
	public String getThoiGianBD() {
		return thoiGianBD;
	}
	public void setThoiGianBD(String thoiGianBD) {
		this.thoiGianBD = thoiGianBD;
	}
}
