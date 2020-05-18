package Model;

import Connection.ConnectionUser;
import Table.User;

public class ModelUser {
	ConnectionUser conUser = null;
	
	public ModelUser() {
		conUser = new ConnectionUser();
	}
	
	public User login(String taiKhoan, String matKhau) {
        return conUser.login(taiKhoan, matKhau);
	}
}
