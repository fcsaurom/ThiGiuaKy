package Model.Interface;

import Model.NhanVien;

import java.util.List;

public interface DataNhanVien {
    void Insert(NhanVien nhanVien);
    NhanVien getEmployeesById(int id);
    List<NhanVien> getAllEmployees();
    void Update(NhanVien nhanVien);
    void Delete(int id);
}
