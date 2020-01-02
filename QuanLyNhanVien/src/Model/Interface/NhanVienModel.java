package Model.Interface;

import Model.NhanVien;

import java.util.List;

public interface NhanVienModel {
        List<NhanVien> getAllEmployees();
        NhanVien getEmployeesByID(int id);
        void AddNewEmployees(NhanVien nhanVien);
        void DeleteInfoNV(int id);
        void UpdateNV(NhanVien nhanVien);
        void NotifyEmployees();
        void  RegisterObserver(EmployeesTabelObserver tabelObserver);
        void UnRegisterObserver(EmployeesTabelObserver tabelObserver);

}
