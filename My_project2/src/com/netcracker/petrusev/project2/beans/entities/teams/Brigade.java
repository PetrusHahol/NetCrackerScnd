package com.netcracker.petrusev.project2.beans.entities.teams;


import com.netcracker.petrusev.project2.beans.entities.flights.Flight;
import com.netcracker.petrusev.project2.beans.entities.office.Navigator;
import com.netcracker.petrusev.project2.beans.entities.office.Pilot;
import com.netcracker.petrusev.project2.beans.entities.office.Radioman;
import com.netcracker.petrusev.project2.beans.entities.office.Stewardess;

/**
 * Created by Asus on 14.10.2016.
 */
public class Brigade {
    private static int objectsCounter;

    private Pilot firstPilot = null;
    private Pilot secondPilot =  null;
    private Stewardess stewardess = null;
    private Radioman radioman = null;
    private Navigator navigator = null;
    private Flight flight = null;;
    private int id = 0;
    private int id_first_pilot = 0;
    private int id_second_pilot = 0;
    private int id_navigator = 0;
    private int id_radioman = 0;
    private int id_stewardess = 0;
    private int id_flight = 0;


    public Brigade(Pilot firstPilot, Pilot secondPilot, Navigator navigator, Stewardess stewardess, Radioman radioman ) {
        setFirstPilot(firstPilot);
        setSecondPilot(secondPilot);
        setStewardess(stewardess);
        setRadioman(radioman);
        setNavigator(navigator);
        objectsCounter++;
    }

    public Brigade(){
        objectsCounter++;
    }

    @Override
    public int hashCode() {
        int result = firstPilot.hashCode();
        result = 31 * result + secondPilot.hashCode();
        result = 31 * result + stewardess.hashCode();
        result = 31 * result + radioman.hashCode();
        result = 31 * result + navigator.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) {
            return false;
        }
        Brigade temp =  (Brigade) obj;
        return (temp.firstPilot.equals(this.firstPilot) &&  temp.secondPilot.equals(this.secondPilot)
                && temp.navigator.equals(this.navigator)&& temp.stewardess.equals(this.stewardess)
                && temp.radioman.equals(this.radioman));
    }

    @Override
    public String toString() {
        return ("Brigade :\n" + "\t" + firstPilot + "\t" + secondPilot
                + "\t" + stewardess + "\t" + navigator + "\t" + radioman);
    }

    public int getId_first_pilot() {
        return id_first_pilot;
    }
    public void setId_first_pilot(int id_first_pilot) {
        this.id_first_pilot = id_first_pilot;
    }
    public int getId_second_pilot() {
        return id_second_pilot;
    }
    public void setId_second_pilot(int id_second_pilot) {
        this.id_second_pilot = id_second_pilot;
    }
    public int getId_navigator() {
        return id_navigator;
    }
    public void setId_navigator(int id_navigator) {
        this.id_navigator = id_navigator;
    }
    public int getId_radioman() {
        return id_radioman;
    }
    public void setId_radioman(int id_radioman) {
        this.id_radioman = id_radioman;
    }
    public int getId_stewardess() {
        return id_stewardess;
    }
    public void setId_stewardess(int id_stewardess) {
        this.id_stewardess = id_stewardess;
    }
    public int getId_flight() {
        return id_flight;
    }
    public void setId_flight(int id_flight) {
        this.id_flight = id_flight;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    public Pilot getFirstPilot() {
        return this.firstPilot;
    }

    public Pilot getSecondPilot() {
        return this.secondPilot;
    }

    public Stewardess getStewardess() {
        return this.stewardess;
    }

    public Radioman getRadioman() {
        return this.radioman;
    }

    public Navigator getNavigator() {
        return this.navigator;
    }

    public void setFirstPilot(Pilot firstPilot) {
        this.firstPilot = firstPilot;
    }

    public void setSecondPilot(Pilot secondPilot) {
        this.secondPilot = secondPilot;
    }

    public void setStewardess(Stewardess stewardess) {
        this.stewardess = stewardess;
    }

    public void setRadioman(Radioman radioman) {
        this.radioman = radioman;
    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    public void setFlight(Flight flight){
        this.flight = flight;
    }

    public Flight getFlight(){ return this.flight;}

}
