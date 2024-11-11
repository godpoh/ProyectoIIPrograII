/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author user
 */
public class Maintenance_Type_Obj {
    int Maintenance_Id; 
    String Type;
    String Description;
    String Frequency;
    float Material_Cost_Estimate;
    int Vehicle_Id;

    public Maintenance_Type_Obj(int Maintenance_Id, String Type, String Description, String Frequency, float Material_Cost_Estimate, int Vehicle_Id) {
        this.Maintenance_Id = Maintenance_Id;
        this.Type = Type;
        this.Description = Description;
        this.Frequency = Frequency;
        this.Material_Cost_Estimate = Material_Cost_Estimate;
        this.Vehicle_Id = Vehicle_Id;
    }

    public int getMaintenance_Id() {
        return Maintenance_Id;
    }

    public void setMaintenance_Id(int Maintenance_Id) {
        this.Maintenance_Id = Maintenance_Id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getFrequency() {
        return Frequency;
    }

    public void setFrequency(String Frequency) {
        this.Frequency = Frequency;
    }

    public float getMaterial_Cost_Estimate() {
        return Material_Cost_Estimate;
    }

    public void setMaterial_Cost_Estimate(float Material_Cost_Estimate) {
        this.Material_Cost_Estimate = Material_Cost_Estimate;
    }

    public int getVehicle_Id() {
        return Vehicle_Id;
    }

    public void setVehicle_Id(int Vehicle_Id) {
        this.Vehicle_Id = Vehicle_Id;
    }
    
}
