package qlbvsb.Entity;

import java.util.Base64;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="DoiBong")
public class DoiBong {
	@Id
	@GeneratedValue
	private int maDoi;
	@OneToMany(mappedBy = "doiBong")
    Set<ThamGiaGiai> thamGiaGiai;
	
	private String tenDoi;
	private byte[] logo;
	private String sanNhaCLB;
	@Transient
	private String base64Image;
	@Transient
	public String getBase64Image() {
		base64Image = Base64.getEncoder().encodeToString(this.logo);
	    return base64Image;
    }
	@Transient
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
	public DoiBong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DoiBong(int maDoi, Set<ThamGiaGiai> thamGiaGiai, String tenDoi, byte[] logo, String sanNhaCLB,
			String base64Image) {
		super();
		this.maDoi = maDoi;
		this.thamGiaGiai = thamGiaGiai;
		this.tenDoi = tenDoi;
		this.logo = logo;
		this.sanNhaCLB = sanNhaCLB;
		this.base64Image = base64Image;
	}
	public int getMaDoi() {
		return maDoi;
	}
	public void setMaDoi(int maDoi) {
		this.maDoi = maDoi;
	}
	public Set<ThamGiaGiai> getThamGiaGiai() {
		return thamGiaGiai;
	}
	public void setThamGiaGiai(Set<ThamGiaGiai> thamGiaGiai) {
		this.thamGiaGiai = thamGiaGiai;
	}
	public String getTenDoi() {
		return tenDoi;
	}
	public void setTenDoi(String tenDoi) {
		this.tenDoi = tenDoi;
	}
	public byte[] getLogo() {
		return logo;
	}
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	public String getSanNhaCLB() {
		return sanNhaCLB;
	}
	public void setSanNhaCLB(String sanNhaCLB) {
		this.sanNhaCLB = sanNhaCLB;
	}
}
