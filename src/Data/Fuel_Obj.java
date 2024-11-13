/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author Admin
 */
public class Fuel_Obj {

    int Fuel_Id;
    String Name;
    String Type;
    float Price_Per_Liter;
    int Status;

    public Fuel_Obj(int Fuel_Id, String Name, String Type, float Price_Per_Liter, int Status) {
        this.Fuel_Id = Fuel_Id;
        this.Name = Name;
        this.Type = Type;
        this.Price_Per_Liter = Price_Per_Liter;
        this.Status = Status;
    }

    public int getFuel_Id() {
        return Fuel_Id;
    }

    public void setFuel_Id(int Fuel_Id) {
        this.Fuel_Id = Fuel_Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public float getPrice_Per_Liter() {
        return Price_Per_Liter;
    }

    public void setPrice_Per_Liter(float Price_Per_Liter) {
        this.Price_Per_Liter = Price_Per_Liter;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

}
