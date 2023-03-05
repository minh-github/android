package com.example.listviewcustom;

public class MonHoc {
    int idAnh;
    String tenMonHoc;
    String theLoai;

    public MonHoc(int idAnh, String tenMonHoc, String theLoai) {
        this.idAnh = idAnh;
        this.tenMonHoc = tenMonHoc;
        this.theLoai = theLoai;
    }

    public int getIdAnh() {
        return idAnh;
    }

    public void setIdAnh(int idAnh) {
        this.idAnh = idAnh;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
}
