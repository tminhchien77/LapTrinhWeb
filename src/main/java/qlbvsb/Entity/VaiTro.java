package qlbvsb.Entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="VaiTro")
public class VaiTro {

	@Id
	@GeneratedValue
	private int maVaiTro;
	private String vaiTro;
	@OneToMany(mappedBy = "vaiTro",fetch = FetchType.EAGER)
	private Collection<BanHuanLuyen> banHuanLuyen;
	
	@OneToMany(mappedBy = "vaiTro",fetch = FetchType.EAGER)
	private Collection<CauThu> cauThu;

	public VaiTro(int maVaiTro, String vaiTro, Collection<BanHuanLuyen> banHuanLuyen, Collection<CauThu> cauThu) {
		super();
		this.maVaiTro = maVaiTro;
		this.vaiTro = vaiTro;
		this.banHuanLuyen = banHuanLuyen;
		this.cauThu = cauThu;
	}

	public VaiTro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMaVaiTro() {
		return maVaiTro;
	}

	public void setMaVaiTro(int maVaiTro) {
		this.maVaiTro = maVaiTro;
	}

	public String getVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}

	public Collection<BanHuanLuyen> getBanHuanLuyen() {
		return banHuanLuyen;
	}

	public void setBanHuanLuyen(Collection<BanHuanLuyen> banHuanLuyen) {
		this.banHuanLuyen = banHuanLuyen;
	}

	public Collection<CauThu> getCauThu() {
		return cauThu;
	}

	public void setCauThu(Collection<CauThu> cauThu) {
		this.cauThu = cauThu;
	}
	
	
}
