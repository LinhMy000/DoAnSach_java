package Table;

public class Sach {
	private int maSach;
	private String tenSach;
	private String tacGia;
	private int soLuong;
	private double gia;
	
	public Sach() {
		this.maSach = 0;
		this.tenSach = null;
		this.tacGia = null;
		this.soLuong = 0;
		this.gia = 0;
	}
	public Sach(int maSach, String tenSach, String tacGia, int soLuong, double gia) {
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.soLuong = soLuong;
		this.gia = gia;
	}
	
	public int getMaSach() {
		return maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	
}
