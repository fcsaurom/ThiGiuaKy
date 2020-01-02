package Controller;

import Model.Interface.NhanVienModel;
import View.NhanVien;

import javax.swing.*;
import java.awt.*;

public class NhanVienController implements AddInfoNV, DeleteInfoNV, UpdateInfoNV {


    private Component component;
    private NhanVienModel nhanVienModel;
    private NhanVien view;
    public NhanVienController(NhanVienModel nhanVienModel){
        this.nhanVienModel = nhanVienModel;
    }

    public NhanVienController(Component component, NhanVienModel nhanVienModel, NhanVien view){
        this.component = component;
        this.nhanVienModel = nhanVienModel;
        this.view = view;
    }
    @Override
    public void OpenDialogAddInfoNV() {
       int Option= JOptionPane.showConfirmDialog(component,view.getRootpanel(),"Thêm Nhân viên mới",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
        if (JOptionPane.YES_OPTION ==Option){
            String Fullname= view.getTfFullName();
            boolean Male = view.getMaleCheckBox();
            Model.NhanVien nhanVien = new Model.NhanVien(Fullname,Male);
            nhanVienModel.AddNewEmployees(nhanVien);
            nhanVienModel.NotifyEmployees();
        }
    }

    @Override
    public void DeleteInfoNV(int id) {
        nhanVienModel.DeleteInfoNV(id);
        nhanVienModel.NotifyEmployees();
    }

    @Override
    public void UpdateNV(Model.NhanVien nhanVien) {
        view.getTF().setText(nhanVien.getFullName());
        if (nhanVien.getGender()) {
            view.getRdNam().setSelected(true);
        } else {
            view.getRdNu().setSelected(false);
        }



        int Option= JOptionPane.showConfirmDialog(component,view.getRootpanel(),"Update Employees",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);

        if (JOptionPane.YES_OPTION ==Option){
            String Fullname= view.getTfFullName();
            boolean Male = view.getMaleCheckBox();
            Model.NhanVien updateNhanVien = new Model.NhanVien(nhanVien.getID(),Fullname,Male);
            nhanVienModel.UpdateNV(updateNhanVien);
            nhanVienModel.NotifyEmployees();
        }
    }
}
