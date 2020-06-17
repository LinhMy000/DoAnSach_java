package View;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class ViewTrangChu extends JPanel {

	public ViewTrangChu() {
		setBackground(new Color(0, 0, 0));
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("C://Users//LENOVO//eclipse-workspace//DoAnSach//source//Image//ImageSachDen.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			add(picLabel);
		} 
		catch (IOException e) {
			System.out.println("Loi hinh anh trang chu!");
			e.printStackTrace();
		}
		
	}

}
