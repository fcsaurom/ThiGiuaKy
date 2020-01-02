package View;

import javax.swing.*;

public class NhanVien {
    private JTextField tfFullName;
    private JPanel rootpanel;
    private JRadioButton rdNam;
    private JRadioButton rdNu;

    public JPanel getRootpanel() {
        return rootpanel;
    }

   public JTextField  getTF(){
        return this.tfFullName;
   }
    public JRadioButton getRdNam(){ return this.rdNam; }
    public JRadioButton getRdNu(){ return this.rdNu; }

    public String getTfFullName() {
        return tfFullName.getText();
    }

    public boolean getMaleCheckBox() {
        if (rdNam.isSelected()){
            return true;
        }
        return false;
    }
}
