package View;

import Controller.NhanVienController;
import Model.Interface.NhanVienModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListNhanVien extends  JFrame {
    private JPanel rootpanel;
    private JTable tableEmployees;
    private JButton ADDButton;
    private JButton DELETEButton;
    private NhanVienModel model;
    public ListNhanVien(NhanVienModel model){
        this.model = model;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,500));
        setContentPane(rootpanel);
        pack();
        setVisible(true);
        NhanVienTableModel modelTable = new NhanVienTableModel(model.getAllEmployees());

        model.RegisterObserver(modelTable);

        tableEmployees.setModel(modelTable);

        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddNewEmployees();
            }
        });
        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = tableEmployees.getSelectedRow();

                if (index != -1){
                    int id = (int) tableEmployees.getValueAt(index,0);
                    DeleteInfoNV(id);
                }

            }
        });
        tableEmployees.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = tableEmployees.getSelectedRow();

                if (index != -1){
                    String FullName = (String) tableEmployees.getValueAt(index,1);
                    boolean Gender = (boolean) tableEmployees.getValueAt(index,2);
                    int id = (int) tableEmployees.getValueAt(index,0);
                    Model.NhanVien nhanVien = new Model.NhanVien(id,FullName,Gender);
                    updateNV(nhanVien);
                }
            }
        });
    }

    private void updateNV(Model.NhanVien nhanVien) {
        NhanVienController UpdateNV = new NhanVienController(this,model,new NhanVien());
        UpdateNV.UpdateNV(nhanVien);
    }

    private void DeleteInfoNV(int id) {
        NhanVienController DeleteInfoNV = new NhanVienController(model);
        DeleteInfoNV.DeleteInfoNV(id);

    }

    private void AddNewEmployees() {
        NhanVienController addEmployees = new NhanVienController(this,model,new NhanVien());
        addEmployees.OpenDialogAddInfoNV();


    }


    public JPanel getRootpanel() {
        return rootpanel;
    }


}
