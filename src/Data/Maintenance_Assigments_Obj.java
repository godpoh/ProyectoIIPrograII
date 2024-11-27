/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Maintenance_Assigments_Obj {

    String License_Plate;
    int Maintenance_Type_Id;
    int Part_Id;
    int Frecuency_Days;
    double Mileage;
    int Status;

    public Maintenance_Assigments_Obj(String License_Plate, int Maintenance_Type_Id, int Part_Id, int Frecuency_Days, double Mileage, int Status) {
        this.License_Plate = License_Plate;
        this.Maintenance_Type_Id = Maintenance_Type_Id;
        this.Part_Id = Part_Id;
        this.Frecuency_Days = Frecuency_Days;
        this.Mileage = Mileage;
        this.Status = Status;
    }

    public String getLicense_Plate() {
        return License_Plate;
    }

    public void setLicense_Plate(String License_Plate) {
        this.License_Plate = License_Plate;
    }

    public int getMaintenance_Type_Id() {
        return Maintenance_Type_Id;
    }

    public void setMaintenance_Type_Id(int Maintenance_Type_Id) {
        this.Maintenance_Type_Id = Maintenance_Type_Id;
    }

    public int getPart_Id() {
        return Part_Id;
    }

    public void setPart_Id(int Part_Id) {
        this.Part_Id = Part_Id;
    }

    public int getFrecuency_Days() {
        return Frecuency_Days;
    }

    public void setFrecuency_Days(int Frecuency_Days) {
        this.Frecuency_Days = Frecuency_Days;
    }

    public double getMileage() {
        return Mileage;
    }

    public void setMileage(double Mileage) {
        this.Mileage = Mileage;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

}
