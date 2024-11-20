/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.util.Date;

/**
 *
 * @author user
 */
public class Fuel_Entry_Exit_Obj {

    int Id;
    String Vehicle_License_Plate;
    int Dispenser_Id;
    Float Fuel_Amount;
    int Buy_Id;
    double Mileage;
    Date Date;
    String Transaction_Type;
    int Status;

    public Fuel_Entry_Exit_Obj(int Id, String Vehicle_License_Plate, int Dispenser_Id, Float Fuel_Amount, double Mileage, Date Date, String Transaction_Type, int Status) {
        this.Id = Id;
        this.Vehicle_License_Plate = Vehicle_License_Plate;
        this.Dispenser_Id = Dispenser_Id;
        this.Fuel_Amount = Fuel_Amount;
        this.Mileage = Mileage;
        this.Date = Date;
        this.Transaction_Type = Transaction_Type;
        this.Status = Status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getVehicle_License_Plate() {
        return Vehicle_License_Plate;
    }

    public void setVehicle_License_Plate(String Vehicle_License_Plate) {
        this.Vehicle_License_Plate = Vehicle_License_Plate;
    }

    public int getDispenser_Id() {
        return Dispenser_Id;
    }

    public void setDispenser_Id(int Dispenser_Id) {
        this.Dispenser_Id = Dispenser_Id;
    }

    public double getFuel_Amount() {
        return Fuel_Amount;
    }

    public void setFuel_Amount(Float Fuel_Amount) {
        this.Fuel_Amount = Fuel_Amount;
    }

    public int getBuy_Id() {
        return Buy_Id;
    }

    public void setBuy_Id(int Buy_Id) {
        this.Buy_Id = Buy_Id;
    }

    public double getMileage() {
        return Mileage;
    }

    public void setMileage(double Mileage) {
        this.Mileage = Mileage;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getTransaction_Type() {
        return Transaction_Type;
    }

    public void setTransaction_Type(String Transaction_Type) {
        this.Transaction_Type = Transaction_Type;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

}
