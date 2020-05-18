package Model;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModelMenu {
	private String kind;
    private JLabel label;

    public ModelMenu() {}
    public ModelMenu(String kind, JLabel label) {
        this.kind = kind;
        this.label = label;
    }

    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}

}
