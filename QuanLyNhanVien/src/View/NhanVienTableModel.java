package View;

import Model.NhanVien;
import Model.Interface.EmployeesTabelObserver;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class NhanVienTableModel extends AbstractTableModel implements EmployeesTabelObserver {
    List<NhanVien> nhanVienList = new ArrayList<>();

    public NhanVienTableModel(List<NhanVien> nhanVienList){
        this.nhanVienList = nhanVienList;
    }
    public NhanVienTableModel(){

    }
    private static final String [] COLUMN_NAME = {"ID","Họ Tên","Giới tính"};
    private static final int ID = 0;
    private static final int FULL_NAME = 1;
    private static final int BIRTH_YEAR = 2;
    @Override
    public int getRowCount() {
        return nhanVienList.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAME.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAME[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NhanVien nhanVien = nhanVienList.get(rowIndex);
        if (columnIndex == ID){
            return nhanVien.getID();
        }
        else if(columnIndex == FULL_NAME){
            return nhanVien.getFullName();
        }
        else if(columnIndex ==BIRTH_YEAR){
            return nhanVien.getGender();
        }
        return null;
    }

    @Override
    public void updateobserver(List<NhanVien> list) {
        nhanVienList.clear();
        nhanVienList.addAll(list);
        fireTableDataChanged();
    }
}
