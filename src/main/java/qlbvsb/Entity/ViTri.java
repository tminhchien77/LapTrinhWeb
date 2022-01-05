package qlbvsb.Entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ViTri")
public class ViTri {
	@Id
	@GeneratedValue
	private int maViTri;
	private String viTri;
	@OneToMany(mappedBy = "viTri",fetch = FetchType.EAGER)
	private Collection<CauThu> cauThu;
	public ViTri() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ViTri(int maViTri, String viTri, Collection<CauThu> cauThu) {
		super();
		this.maViTri = maViTri;
		this.viTri = viTri;
		this.cauThu = cauThu;
	}
	public int getMaViTri() {
		return maViTri;
	}
	public void setMaViTri(int maViTri) {
		this.maViTri = maViTri;
	}
	public String getViTri() {
		return viTri;
	}
	public void setViTri(String viTri) {
		this.viTri = viTri;
	}
	public Collection<CauThu> getCauThu() {
		return cauThu;
	}
	public void setCauThu(Collection<CauThu> cauThu) {
		this.cauThu = cauThu;
	}
	
	
}
