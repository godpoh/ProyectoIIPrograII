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
public class Header_Obj {

    int Id;
    String License_Plate;
    Date Date;
    String Mechanic_Name;
    String Driver_Name;
    double Mileage;
    int Status;

    public Header_Obj(int Id, String License_Plate, Date Date, String Mechanic_Name, String Driver_Name, double Mileage, int Status) {
        this.Id = Id;
        this.License_Plate = License_Plate;
        this.Date = Date;
        this.Mechanic_Name = Mechanic_Name;
        this.Driver_Name = Driver_Name;
        this.Mileage = Mileage;
        this.Status = Status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getLicense_Plate() {
        return License_Plate;
    }

    public void setLicense_Plate(String License_Plate) {
        this.License_Plate = License_Plate;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getMechanic_Name() {
        return Mechanic_Name;
    }

    public void setMechanic_Name(String Mechanic_Name) {
        this.Mechanic_Name = Mechanic_Name;
    }

    public String getDriver_Name() {
        return Driver_Name;
    }

    public void setDriver_Name(String Driver_Name) {
        this.Driver_Name = Driver_Name;
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
