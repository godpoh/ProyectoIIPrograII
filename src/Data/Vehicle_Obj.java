/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author Admin
 */
public class Vehicle_Obj {

    private int Id;
    private String LicensePlate;
    private String Brand;
    private String Model;
    private int Year;
    private String Color;
    private String Type;
    private int SeatCount;
    private float Load_Capacity;
    private int Status;

    public Vehicle_Obj(String LicensePlate, String Brand, String Model, int Year, String Color, String Type, int SeatCount, float Load_Capacity, int Status) {
        this.LicensePlate = LicensePlate;
        this.Brand = Brand;
        this.Model = Model;
        this.Year = Year;
        this.Color = Color;
        this.Type = Type;
        this.SeatCount = SeatCount;
        this.Load_Capacity = Load_Capacity;
        this.Status = Status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getLicensePlate() {
        return LicensePlate;
    }

    public void setLicensePlate(String LicensePlate) {
        this.LicensePlate = LicensePlate;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getSeatCount() {
        return SeatCount;
    }

    public void setSeatCount(int SeatCount) {
        this.SeatCount = SeatCount;
    }

    public float getLoad_Capacity() {
        return Load_Capacity;
    }

    public void setLoad_Capacity(float Load_Capacity) {
        this.Load_Capacity = Load_Capacity;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

}
