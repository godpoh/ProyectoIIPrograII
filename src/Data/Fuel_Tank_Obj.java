/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author user
 */
public class Fuel_Tank_Obj {
     int Id;
    String Description;
    Float Capacity;
    int Fuel_Id;
    int Status;

    public Fuel_Tank_Obj(int Id, String Description, Float Capacity, int Fuel_Id, int Status) {
        this.Id = Id;
        this.Description = Description;
        this.Capacity = Capacity;
        this.Fuel_Id = Fuel_Id;
        this.Status = Status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Float getCapacity() {
        return Capacity;
    }

    public void setCapacity(Float Capacity) {
        this.Capacity = Capacity;
    }

    public int getFuel_Id() {
        return Fuel_Id;
    }

    public void setFuel_Id(int Fuel_Id) {
        this.Fuel_Id = Fuel_Id;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
    
    
}
