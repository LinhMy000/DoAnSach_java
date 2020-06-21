package Controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.ModelMenu1;


public class ControllerMenu1 {
    private JPanel pnView;
    private String kindMenu = "";
    List<ModelMenu1> listMenu = null;

    public ControllerMenu1(JPanel pnView) {
	this.pnView = pnView;
    }
	
    public void setView(JPanel pnMenu, JPanel ind_1) {
	kindMenu = "Trang chu";
	ind_1.setOpaque(true);
	pnMenu.setBackground(new Color(39,57,82));
    }
	
    public void setChangeBackground(String kind) {
	for (ModelMenu1 item : listMenu) {
            if(item.getKind().equalsIgnoreCase(kind)) {
		item.getInd().setOpaque(true);
		item.getPanel().setBackground(new Color(50, 69, 90));
            }
            else {
		item.getInd().setOpaque(false);
		item.getPanel().setBackground(new Color(23,35,55));
            }
	} 
    }
	
    class PanelEvent implements MouseListener {
	private JLabel node;
	private String kind;
        private JPanel panel, ind;

        public PanelEvent(String kind, JPanel panel) {
            this.kind = kind;
            this.panel = panel;
        }

	@Override
	public void mouseClicked(MouseEvent e) {
            setChangeBackground(kind);
        }

	@Override
	public void mousePressed(MouseEvent e) {
	    kindMenu = kind;
	         
	    panel.setBackground(new Color(50, 69, 90));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	    if (!kindMenu.equalsIgnoreCase(kind)) {
                panel.setBackground(new Color(39,57,82));
	    }
	}

	     @Override
	     public void mouseExited(MouseEvent e) {
	         if (!kindMenu.equalsIgnoreCase(kind)) {
	        	 
	        	 panel.setBackground(new Color(23,35,55));
	         }
	         else {
	        	 
	        	 panel.setBackground(new Color(39,57,82));
	         }
	     }

		@Override
		public void mouseReleased(MouseEvent e) {
			if (!kindMenu.equalsIgnoreCase(kind)) {
	        	
	        	 panel.setBackground(new Color(39,57,82));
	         }	
		}
	}
	class PanelEventAdmin implements MouseListener {
	     private JLabel node;
	     private String kind;
	     private JPanel panel, ind;

	     public PanelEventAdmin(String kind, JPanel panel) {
	          this.kind = kind;
	          this.panel = panel;
	     }

	     @Override
	     public void mouseClicked(MouseEvent e) {
                 setChangeBackground(kind);
                 
	     }

	     @Override
	     public void mousePressed(MouseEvent e) {
	          kindMenu = kind;
                  
	          panel.setBackground(new Color(50, 69, 90));
	     }

	     @Override
	     public void mouseEntered(MouseEvent e) {
	    	 if (!kindMenu.equalsIgnoreCase(kind)) {
	    		 
	    		 panel.setBackground(new Color(39,57,82));
	    	 }
	     }

	     @Override
	     public void mouseExited(MouseEvent e) {
	        if (!kindMenu.equalsIgnoreCase(kind)) {
	        	 
                    panel.setBackground(new Color(23,35,55));
	        }
	        else {
	        	
	        	 panel.setBackground(new Color(39,57,82));
	        }
	    }

            @Override
            public void mouseReleased(MouseEvent e) {
			if (!kindMenu.equalsIgnoreCase(kind)) {
                         
	        	 panel.setBackground(new Color(39,57,82));
                        }	
		}
	}
	
	public void setEvent(List<ModelMenu1> listMenu) {
	    this.listMenu = listMenu;
	    for (ModelMenu1 item : listMenu) {
	    	item.getPanel().addMouseListener(new PanelEvent(item.getKind(), item.getPanel()));
	    }
	}
	public void setEventAdmin(List<ModelMenu1> listMenu) {
	    this.listMenu = listMenu;
	    for (ModelMenu1 item : listMenu) {
	    	item.getPanel().addMouseListener(new PanelEventAdmin(item.getKind(), item.getPanel()));
	    }
	}
	
}

