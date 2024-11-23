/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author Admin
 */
public class Details_Obj {

    int Detail_Id;
    int Header_Id;
    int Part_Id;
    int Maintenance_Id;

    public Details_Obj(int Detail_Id, int Header_Id, int Part_Id, int Maintenance_Id) {
        this.Detail_Id = Detail_Id;
        this.Header_Id = Header_Id;
        this.Part_Id = Part_Id;
        this.Maintenance_Id = Maintenance_Id;
    }

    public int getDetail_Id() {
        return Detail_Id;
    }

    public void setDetail_Id(int Detail_Id) {
        this.Detail_Id = Detail_Id;
    }

    public int getHeader_Id() {
        return Header_Id;
    }

    public void setHeader_Id(int Header_Id) {
        this.Header_Id = Header_Id;
    }

    public int getPart_Id() {
        return Part_Id;
    }

    public void setPart_Id(int Part_Id) {
        this.Part_Id = Part_Id;
    }

    public int getMaintenance_Id() {
        return Maintenance_Id;
    }

    public void setMaintenance_Id(int Maintenance_Id) {
        this.Maintenance_Id = Maintenance_Id;
    }

}
