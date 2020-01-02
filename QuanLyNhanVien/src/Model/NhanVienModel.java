package Model;

import Model.Interface.EmployeesTabelObserver;

import java.util.ArrayList;
import java.util.List;

public class NhanVienModel implements Model.Interface.NhanVienModel {
    private List<EmployeesTabelObserver> tableObserver =new ArrayList<>();;
    @Override
    public List<NhanVien> getAllEmployees() {
        DataModel dataModel = new DataModel();
        return  dataModel.getAllEmployees();
    }

    @Override
    public NhanVien getEmployeesByID(int id) {
        DataModel dataModel = new DataModel();
        dataModel.getEmployeesById(id);
        return dataModel.getEmployeesById(id);
    }

    @Override
    public void AddNewEmployees(NhanVien nhanVien) {
        DataModel dataModel = new DataModel();
        dataModel.Insert(nhanVien);
    }

    @Override
    public void DeleteInfoNV(int id) {
        DataModel dataModel = new DataModel();
        dataModel.Delete(id);
    }

    @Override
    public void UpdateNV(NhanVien nhanVien) {
        DataModel dataModel = new DataModel();
        dataModel.Update(nhanVien);


    }

    @Override
    public void NotifyEmployees() {
        for (EmployeesTabelObserver tableObserver: tableObserver){
            tableObserver.updateobserver( getAllEmployees());
        }
    }

    @Override
    public void RegisterObserver(EmployeesTabelObserver tabelObserver) {
        if(!tableObserver.contains(tabelObserver)){
            tableObserver.add(tabelObserver);
        }
    }

    @Override
    public void UnRegisterObserver(EmployeesTabelObserver tabelObserver) {
        if(tableObserver.contains(tabelObserver)){
            tableObserver.remove(tabelObserver);
        }
    }
}
