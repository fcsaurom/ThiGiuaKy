package Model;

public class NhanVien {
    private int ID;
    private String FullName;
    private boolean Gender;

    public NhanVien(){

    }
    public NhanVien(int ID , String FullName, boolean Gender ){
        this.ID = ID;
        this.FullName=FullName;
        this.Gender = Gender;
    }

    public NhanVien(String FullName, boolean Gender) {
        this.FullName=FullName;
        this.Gender = Gender;
    }

    public int getID() {
        return ID;
    }

    public String getFullName() {
        return FullName;
    }

    public boolean getGender(){
        return Gender;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public void setGender(boolean gender) {
        Gender = gender;
    }
}
