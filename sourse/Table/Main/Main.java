package Main;

import View.ViewDangNhap;

public class Main {

	public static void main(String[] args) {
		System.out.println("ok..");
//		ViewMain index = new ViewMain(true);
		
//		ModelHoaDon.xuatHD(26);
		
		ViewDangNhap dia = new ViewDangNhap(); 
		dia.setResizable(false);
		dia.setLocationRelativeTo(null);
		dia.setVisible(true);
		
	}
}
