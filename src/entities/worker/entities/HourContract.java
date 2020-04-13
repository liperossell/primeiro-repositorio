package entities.worker.entities;

import java.util.Date;

public class HourContract {
    private Date date;
    private double valuePerHour;
    private int hours;
    
    public HourContract(Date date, double valuePerHour, int hours) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }
    
    public double totalValue(){
        return valuePerHour * hours;
    }

    public Date getDate(){
        return this.date;
    }

}