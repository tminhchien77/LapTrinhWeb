package qlbvsb.Entity;

import java.util.Base64;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="LOAIVE")
public class LoaiVe {
	@Id
	private int maLoai;
	@OneToMany(mappedBy="loaiVe")
    private Set<GiaApDung> giaApDung;
	private String tenLoai;
	private int soLuongToiDa;
	private byte[] viewImage;
	@Transient
	private String base64Image;
	@Transient
	public String getBase64Image() {
		base64Image = Base64.getEncoder().encodeToString(this.viewImage);
	    return base64Image;
    }
	@Transient
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
	public LoaiVe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoaiVe(int maLoai, Set<GiaApDung> giaApDung, String tenLoai, int soLuongToiDa, byte[] viewImage,
			String base64Image) {
		super();
		this.maLoai = maLoai;
		this.giaApDung = giaApDung;
		this.tenLoai = tenLoai;
		this.soLuongToiDa = soLuongToiDa;
		this.viewImage = viewImage;
		this.base64Image = base64Image;
	}
	public int getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}
	public Set<GiaApDung> getGiaApDung() {
		return giaApDung;
	}
	public void setGiaApDung(Set<GiaApDung> giaApDung) {
		this.giaApDung = giaApDung;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public int getSoLuongToiDa() {
		return soLuongToiDa;
	}
	public void setSoLuongToiDa(int soLuongToiDa) {
		this.soLuongToiDa = soLuongToiDa;
	}
	public byte[] getViewImage() {
		return viewImage;
	}
	public void setViewImage(byte[] viewImage) {
		this.viewImage = viewImage;
	}
}
