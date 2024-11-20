/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author user
 */
public class Dispenser_Obj {

    int Id;
    String Description;
    int Fuel_Tank_Id;
    int Status;

    public Dispenser_Obj(int Id, String Description, int Fuel_Tank_Id, int Status) {
        this.Id = Id;
        this.Description = Description;
        this.Fuel_Tank_Id = Fuel_Tank_Id;
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

    public int getFuel_Tank_Id() {
        return Fuel_Tank_Id;
    }

    public void setFuel_Tank_Id(int Fuel_Tank_Id) {
        this.Fuel_Tank_Id = Fuel_Tank_Id;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

}
