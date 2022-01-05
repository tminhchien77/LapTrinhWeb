package qlbvsb.Model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import qlbvsb.Entity.CauThu;
import qlbvsb.Entity.VaiTro;
import qlbvsb.Entity.ViTri;

public class PlayerInfo {
	private int soAo;
	private String hoTen;
	private String tenAoDau;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaySinh;
	private String noiSinh;
	private Float canNang;
	private int chieuCao;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngayRaMat;
	private String tieuSu;
	// Upload file.
    private CommonsMultipartFile fileData;
	private VaiTro vaiTro;	
	private ViTri viTri;
	
	public PlayerInfo() {
		
	}
	public PlayerInfo(CauThu player) {
		super();
		this.soAo = player.getSoAo();
		this.hoTen = player.getHoTen();
	
		this.tenAoDau = player.getTenAoDau();
		this.ngaySinh = player.getNgaySinh();
		this.noiSinh = player.getNoiSinh();
		this.canNang = player.getCanNang();
		this.chieuCao = player.getChieuCao();
		this.ngayRaMat = player.getNgayRaMat();
		this.tieuSu = player.getTieuSu();
		
		this.vaiTro = player.getVaiTro();
		this.viTri = player.getViTri();
	}
	public PlayerInfo(int soAo, String hoTen, String tenAoDau, Date ngaySinh, String noiSinh, Float canNang,
			int chieuCao, Date ngayRaMat, String tieuSu, VaiTro vaiTro, ViTri viTri) {
		super();
		this.soAo = soAo;
		this.hoTen = hoTen;
	
		this.tenAoDau = tenAoDau;
		this.ngaySinh = ngaySinh;
		this.noiSinh = noiSinh;
		this.canNang = canNang;
		this.chieuCao = chieuCao;
		this.ngayRaMat = ngayRaMat;
		this.tieuSu = tieuSu;
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
	public Date getNgayRaMat() {
		return ngayRaMat;
	}
	public void setNgayRaMat(Date ngayRaMat) {
		this.ngayRaMat = ngayRaMat;
	}
	public String getTieuSu() {
		return tieuSu;
	}
	public void setTieuSu(String tieuSu) {
		this.tieuSu = tieuSu;
	}
	public CommonsMultipartFile getFileData() {
		return fileData;
	}
	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
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
