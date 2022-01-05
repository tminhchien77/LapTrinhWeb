package qlbvsb.Entity;

import java.util.Base64;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BanHuanLuyen")
public class BanHuanLuyen {
	@Id
	@GeneratedValue
	private int maTV;
	private String ho;
	private String ten;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date ngaySinh;
	private String noiSinh;
	private String tieuSu;
	private byte[] anh;
	@ManyToOne
	@JoinColumn(name="maVaiTro")
	private VaiTro vaiTro;
	
	@Transient
	private String base64Image;
	@Transient
	public String getBase64Image() {
		base64Image = Base64.getEncoder().encodeToString(this.anh);
	    return base64Image;
    }
	@Transient
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
	
	public BanHuanLuyen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BanHuanLuyen(int maTV, String ho, String ten, Date ngaySinh, String noiSinh, String tieuSu, byte[] anh,
			VaiTro vaiTro, String base64Image) {
		super();
		this.maTV = maTV;
		this.ho = ho;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.noiSinh = noiSinh;
		this.tieuSu = tieuSu;
		this.anh = anh;
		this.vaiTro = vaiTro;
		this.base64Image = base64Image;
	}
	public int getMaTV() {
		return maTV;
	}
	public void setMaTV(int maTV) {
		this.maTV = maTV;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getNoiSinh() {
		return noiSinh;
	}
	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}
	public String getTieuSu() {
		return tieuSu;
	}
	public void setTieuSu(String tieuSu) {
		this.tieuSu = tieuSu;
	}
	public byte[] getAnh() {
		return anh;
	}
	public void setAnh(byte[] anh) {
		this.anh = anh;
	}
	public VaiTro getVaiTro() {
		return vaiTro;
	}
	public void setVaiTro(VaiTro vaiTro) {
		this.vaiTro = vaiTro;
	}
	
}
