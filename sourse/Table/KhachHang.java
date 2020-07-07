package Table;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class KhachHang {
	private int maKH;
    private String hoTen;
    private String sdt;
    private String diaChi;
    private Date ngaySinh;
    private int diem;
    
	public KhachHang() {
		this.maKH = 0;
		this.hoTen = null;
		this.sdt = null;
		this.diaChi = null;
		this.ngaySinh = null;
		this.diem = 0;
	}
	public KhachHang(int maKH, String hoTen, String sdt, String diaChi, Date ngaySinh, int diem) {
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.diem = diem;
	}
        
	public int getMaKH() {
		return maKH;
	}
        public void setMaKH(int maKH){
            this.maKH = maKH;
        }
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public int getDiem() {
		return diem;
	}
	public void setDiem(int diem) {
		this.diem = diem;
	}

    @Override
    public String toString() {
        return  hoTen ;
    }
   
	
}
