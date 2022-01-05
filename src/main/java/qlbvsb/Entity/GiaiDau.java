package qlbvsb.Entity;

import java.util.Base64;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="GiaiDau")
public class GiaiDau {
	@Id
	@GeneratedValue
	private int maGiai;
	@OneToMany(mappedBy = "giaiDau")
	Set<ThamGiaGiai> thamGiaGiai;
	private String tenGiai;
	private byte[] logo;
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
	public GiaiDau() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GiaiDau(int maGiai, Set<ThamGiaGiai> thamGiaGiai, String tenGiai, byte[] logo, String base64Image) {
		super();
		this.maGiai = maGiai;
		this.thamGiaGiai = thamGiaGiai;
		this.tenGiai = tenGiai;
		this.logo = logo;
		this.base64Image = base64Image;
	}
	public int getMaGiai() {
		return maGiai;
	}
	public void setMaGiai(int maGiai) {
		this.maGiai = maGiai;
	}
	public Set<ThamGiaGiai> getThamGiaGiai() {
		return thamGiaGiai;
	}
	public void setThamGiaGiai(Set<ThamGiaGiai> thamGiaGiai) {
		this.thamGiaGiai = thamGiaGiai;
	}
	public String getTenGiai() {
		return tenGiai;
	}
	public void setTenGiai(String tenGiai) {
		this.tenGiai = tenGiai;
	}
	public byte[] getLogo() {
		return logo;
	}
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	
}
