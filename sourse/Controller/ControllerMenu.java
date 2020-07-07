package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Model.ModelMenu;
import View.ViewBanHang;
import View.ViewHoaDon;
import View.ViewHoaDon;
import View.ViewKhachHang;
import View.ViewSach;
import View.ViewThongKe;
import View.ViewTrangChu;
import View.ViewTrangChu;
import View.ViewUser;

public class ControllerMenu {
	private JPanel pnView;
	private String kindMenu = "";
	List<ModelMenu> listMenu = null;

	public ControllerMenu(JPanel pnView) {
		this.pnView = pnView;
	}
	
	public void setView(JLabel lbMenu) {
		kindMenu = "Trang chu";
		lbMenu.setOpaque(true);
		lbMenu.setBackground(new Color(61,61,107));
	    
	    JPanel node = new ViewTrangChu();
	    pnView.removeAll();
	    pnView.setLayout(new BorderLayout());
	    pnView.add(node);
	    pnView.validate();
	    pnView.repaint();
	}
	
	public void setChangeBackground(String kind) {
		for (ModelMenu item : listMenu) {
			if(item.getKind().equalsIgnoreCase(kind)) {
				item.getLabel().setOpaque(true);
				item.getLabel().setBackground(new Color(61,61,107));
			}
			else {
				item.getLabel().setOpaque(true);
				item.getLabel().setBackground(new Color(23,35,55));
			}
		} 
	}
	
	class LabelEvent implements MouseListener {
	     private JPanel node;
	     private String kind;
	     private JLabel label;

	     public LabelEvent(String kind, JLabel label) {
	          this.kind = kind;
	          this.label = label;
	     }

	     @Override
	     public void mouseClicked(MouseEvent e) {
	    	 switch (kind) {
	               case "Trang chu": node = new ViewTrangChu(); break;
                       case "Khach hang": node = new ViewKhachHang(); break;
	               case "Sach": node = new ViewSach(); break;
	               case "Hoa don": node = new ViewHoaDon(); break;
                       case "Ban hang": node = new ViewBanHang(); break;
	               case "Thong ke du lieu": node = new ViewThongKe(); break;
	               default: break;
	         }
	    	 pnView.removeAll();
	    	 pnView.setLayout(new BorderLayout());
	    	 pnView.add(node);
	    	 pnView.validate();
	    	 pnView.repaint();
	         setChangeBackground(kind);
	     }

	     @Override
	     public void mousePressed(MouseEvent e) {
	          kindMenu = kind;
	          label.setOpaque(true);
	          label.setBackground(new Color(61,61,107));
	     }

	     @Override
	     public void mouseEntered(MouseEvent e) {
	    	 if (!kindMenu.equalsIgnoreCase(kind)) {
	    		 label.setOpaque(true);
	    		 label.setBackground(new Color(50,69,90));
	    	 }
	     }

	     @Override
	     public void mouseExited(MouseEvent e) {
	         if (!kindMenu.equalsIgnoreCase(kind)) {
	        	 label.setOpaque(true);
	        	 label.setBackground(new Color(23,35,55));
	         }
	         else {
	        	 label.setOpaque(true);
	        	 label.setBackground(new Color(61,61,107));
	         }
	     }

		@Override
		public void mouseReleased(MouseEvent e) {
			if (!kindMenu.equalsIgnoreCase(kind)) {
	        	 label.setOpaque(true);
	        	 label.setBackground(new Color(23,35,55));
	         }	
		}
	}
	class LabelEventAdmin implements MouseListener {
	     private JPanel node;
	     private String kind;
	     private JLabel label;

	     public LabelEventAdmin(String kind, JLabel label) {
	          this.kind = kind;
	          this.label = label;
	     }

	     @Override
	     public void mouseClicked(MouseEvent e) {
	    	 switch (kind) {
	               case "Trang chu": node = new ViewTrangChu(); break;
                       case "Khach hang": node = new ViewKhachHang(); break;
	               case "Sach": node = new ViewSach(); break;
	               case "Hoa don": node = new ViewHoaDon(); break;
                       case "Ban hang": node = new ViewBanHang(); break;
	               case "Thong ke du lieu": node = new ViewThongKe(); break;
	               case "User": node = new ViewUser(); break;
	               default: break;
	         }
	    	 pnView.removeAll();
	    	 pnView.setLayout(new BorderLayout());
	    	 pnView.add(node);
	    	 pnView.validate();
	    	 pnView.repaint();
	         setChangeBackground(kind);
	     }

	     @Override
	     public void mousePressed(MouseEvent e) {
	          kindMenu = kind;
	          label.setOpaque(true);
	          label.setBackground(new Color(61,61,107));
	     }

	     @Override
	     public void mouseEntered(MouseEvent e) {
	    	 if (!kindMenu.equalsIgnoreCase(kind)) {
	    		 label.setOpaque(true);
	    		 label.setBackground(new Color(50,69,90));
	    	 }
	     }

	     @Override
	     public void mouseExited(MouseEvent e) {
	         if (!kindMenu.equalsIgnoreCase(kind)) {
	        	 label.setOpaque(true);
	        	 label.setBackground(new Color(23,35,55));
	         }
	         else {
	        	 label.setOpaque(true);
	        	 label.setBackground(new Color(61,61,107));
	         }
	     }

		@Override
		public void mouseReleased(MouseEvent e) {
			if (!kindMenu.equalsIgnoreCase(kind)) {
	        	 label.setOpaque(true);
	        	 label.setBackground(new Color(23,35,55));
	         }	
		}
	}
	
	public void setEvent(List<ModelMenu> listMenu) {
	    this.listMenu = listMenu;
	    for (ModelMenu item : listMenu) {
	    	item.getLabel().addMouseListener(new LabelEvent(item.getKind(), item.getLabel()));
	    }
	}
	public void setEventAdmin(List<ModelMenu> listMenu) {
	    this.listMenu = listMenu;
	    for (ModelMenu item : listMenu) {
	    	item.getLabel().addMouseListener(new LabelEventAdmin(item.getKind(), item.getLabel()));
	    }
	}
	
}


