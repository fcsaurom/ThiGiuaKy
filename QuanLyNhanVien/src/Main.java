import Model.NhanVienModel;
import View.ListNhanVien;

public class Main {
    public static  void main(String [] args){
        ListNhanVien AllEmployees = new ListNhanVien(new NhanVienModel());
    }
}
