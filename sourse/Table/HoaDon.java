package Table;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class HoaDon {
	private int mahd;
	private List<CTHD> cthd = new ArrayList<>();
	private Date ngayhd;
	private int makh = (Integer) null;
	private int manv = (Integer) null;
	private double tongTien;
	
	public int getMahd() {
		return mahd;
	}
	public void setMahd(int mahd) {
		this.mahd = mahd;
	}
	public List<CTHD> getCthd() {
		return cthd;
	}
	public void setCthd(List<CTHD> cthd) {
		this.cthd = cthd;
	}
	public Date getNgayhd() {
		return ngayhd;
	}
	public void setNgayhd(Date ngayhd) {
		this.ngayhd = ngayhd;
	}
	public int getMakh() {
		return makh;
	}
	public void setMakh(int makh) {
		this.makh = makh;
	}
	public int getManv() {
		return manv;
	}
	public void setManv(int manv) {
		this.manv = manv;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	
}
