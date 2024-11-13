/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author Admin
 */
public class Part_Obj {

    int Part_Id;
    String Part_Name;
    String Part_Category;
    String Manu_Facturer;
    String Compatibility;
    int Warrantly_Period;
    float Unit_Cost;
    int Status;

    public Part_Obj(int Part_Id, String Part_Name, String Part_Category, String Manu_Facturer, String Compatibility, int Warrantly_Period, float Unit_Cost, int Status) {
        this.Part_Id = Part_Id;
        this.Part_Name = Part_Name;
        this.Part_Category = Part_Category;
        this.Manu_Facturer = Manu_Facturer;
        this.Compatibility = Compatibility;
        this.Warrantly_Period = Warrantly_Period;
        this.Unit_Cost = Unit_Cost;
        this.Status = Status;
    }

    public int getPart_Id() {
        return Part_Id;
    }

    public void setPart_Id(int Part_Id) {
        this.Part_Id = Part_Id;
    }

    public String getPart_Name() {
        return Part_Name;
    }

    public void setPart_Name(String Part_Name) {
        this.Part_Name = Part_Name;
    }

    public String getPart_Category() {
        return Part_Category;
    }

    public void setPart_Category(String Part_Category) {
        this.Part_Category = Part_Category;
    }

    public String getManu_Facturer() {
        return Manu_Facturer;
    }

    public void setManu_Facturer(String Manu_Facturer) {
        this.Manu_Facturer = Manu_Facturer;
    }

    public String getCompatibility() {
        return Compatibility;
    }

    public void setCompatibility(String Compatibility) {
        this.Compatibility = Compatibility;
    }

    public int getWarrantly_Period() {
        return Warrantly_Period;
    }

    public void setWarrantly_Period(int Warrantly_Period) {
        this.Warrantly_Period = Warrantly_Period;
    }

    public float getUnit_Cost() {
        return Unit_Cost;
    }

    public void setUnit_Cost(float Unit_Cost) {
        this.Unit_Cost = Unit_Cost;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

}
