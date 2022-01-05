package qlbvsb.Entity;


import java.util.Collection;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ThamGiaGiai")
public class ThamGiaGiai {
	@Id
	private int maDoiDauGiai;
	@OneToMany(mappedBy="thamGiaGiai")
    private Set<TRANDAU> tranDau;
    @ManyToOne
    @JoinColumn(name = "maDoi")
    DoiBong doiBong;

    @ManyToOne
    @JoinColumn(name = "maGiai")
    GiaiDau giaiDau;
	
	public ThamGiaGiai() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ThamGiaGiai(int maDoiDauGiai, Set<TRANDAU> tranDau, DoiBong doiBong, GiaiDau giaiDau) {
		super();
		this.maDoiDauGiai = maDoiDauGiai;
		this.tranDau = tranDau;
		this.doiBong = doiBong;
		this.giaiDau = giaiDau;
	}

	public int getMaDoiDauGiai() {
		return maDoiDauGiai;
	}

	public void setMaDoiDauGiai(int maDoiDauGiai) {
		this.maDoiDauGiai = maDoiDauGiai;
	}

	public Set<TRANDAU> getTranDau() {
		return tranDau;
	}

	public void setTranDau(Set<TRANDAU> tranDau) {
		this.tranDau = tranDau;
	}

	public DoiBong getDoiBong() {
		return doiBong;
	}

	public void setDoiBong(DoiBong doiBong) {
		this.doiBong = doiBong;
	}

	public GiaiDau getGiaiDau() {
		return giaiDau;
	}

	public void setGiaiDau(GiaiDau giaiDau) {
		this.giaiDau = giaiDau;
	}

}
