package qlbvsb.Entity;

import java.util.Base64;
import java.util.Date;

import javax.persistence.Column;
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
@Table(name="CauThu")
public class CauThu {
	@Id
	@GeneratedValue
	private int soAo;
	private String hoTen;
	private String tenAoDau;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaySinh;
	private String noiSinh;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayRaMat;
	private Float canNang;
	private int chieuCao;
	private String tieuSu;
	private byte[] anh;
	@ManyToOne
	@JoinColumn(name="maVaiTro")
	private VaiTro vaiTro;
	
	@ManyToOne
	@JoinColumn(name="maViTri")
	private ViTri viTri;
	

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

	public CauThu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CauThu(int soAo, String hoTen, String tenAoDau, Date ngaySinh, String noiSinh, Date ngayRaMat, Float canNang,
			int chieuCao, String tieuSu, byte[] anh, VaiTro vaiTro, ViTri viTri) {
		super();
		this.soAo = soAo;
		this.hoTen = hoTen;
		this.tenAoDau = tenAoDau;
		this.ngaySinh = ngaySinh;
		this.noiSinh = noiSinh;
		this.ngayRaMat = ngayRaMat;
		this.canNang = canNang;
		this.chieuCao = chieuCao;
		this.tieuSu = tieuSu;
		this.anh = anh;
		this.vaiTro = vaiTro;
		this.viTri = viTri;
	}

	public int getSoAo() {
		return soAo;
	}

	public void setSoAo(int soAo) {
		this.soAo = soAo;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getTenAoDau() {
		return tenAoDau;
	}

	public void setTenAoDau(String tenAoDau) {
		this.tenAoDau = tenAoDau;
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

	public Date getNgayRaMat() {
		return ngayRaMat;
	}

	public void setNgayRaMat(Date ngayRaMat) {
		this.ngayRaMat = ngayRaMat;
	}

	public Float getCanNang() {
		return canNang;
	}

	public void setCanNang(Float canNang) {
		this.canNang = canNang;
	}

	public int getChieuCao() {
		return chieuCao;
	}

	public void setChieuCao(int chieuCao) {
		this.chieuCao = chieuCao;
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

	public ViTri getViTri() {
		return viTri;
	}

	public void setViTri(ViTri viTri) {
		this.viTri = viTri;
	}

}
