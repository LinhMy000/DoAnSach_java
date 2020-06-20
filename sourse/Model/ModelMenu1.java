package Model;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModelMenu1 {
    private String kind;
    private JPanel panel, ind;    

    public ModelMenu1() {}
    public ModelMenu1(String kind, JPanel panel, JPanel ind) {
        this.kind = kind;
        this.panel = panel;
        this.ind = ind;
    }

    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    public JPanel getPanel() {
		return panel;
    }
    public void setPanel(JPanel panel) {
		this.panel = panel;
    }	
    
    public JPanel getInd() {
        return ind;
    }
    public void setInd(JPanel ind) {
        this.ind = ind;
    }

}
