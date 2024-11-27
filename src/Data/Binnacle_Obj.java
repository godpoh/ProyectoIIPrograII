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
public class Binnacle_Obj {

    int Id_Binnacle;
    String Operation;
    int User_Binnacle;
    String Place;
    Date Date_Binnacle;

    public Binnacle_Obj(String Operation, int User_Binnacle, String Place, Date Date_Binnacle) {
        this.Operation = Operation;
        this.User_Binnacle = User_Binnacle;
        this.Place = Place;
        this.Date_Binnacle = Date_Binnacle;
    }

    public int getId_Binnacle() {
        return Id_Binnacle;
    }

    public void setId_Binnacle(int Id_Binnacle) {
        this.Id_Binnacle = Id_Binnacle;
    }

    public String getOperation() {
        return Operation;
    }

    public void setOperation(String Operation) {
        this.Operation = Operation;
    }

    public int getUser_Binnacle() {
        return User_Binnacle;
    }

    public void setUser_Binnacle(int User_Binnacle) {
        this.User_Binnacle = User_Binnacle;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String Place) {
        this.Place = Place;
    }

    public Date getDate_Binnacle() {
        return Date_Binnacle;
    }

    public void setDate_Binnacle(Date Date_Binnacle) {
        this.Date_Binnacle = Date_Binnacle;
    }

}
