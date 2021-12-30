package com.example.mobile_app.ui.stat;

public class StatVac {

    //From JSON we don't need all the information so this class is made to reduce fields

    // Declare variables
    private final String refDate;
    private final int dayTotal;
    private final int dailyDoseOne;
    private final int dailyDoseTwo;
    private final int totalVac;

    //Constructor
    public StatVac(String refDate, int dayTotal, int dailyDoseOne, int dailyDoseTwo, int totalVac) {
        this.refDate = refDate;
        this.dayTotal = dayTotal;
        this.dailyDoseOne = dailyDoseOne;
        this.dailyDoseTwo = dailyDoseTwo;
        this.totalVac = totalVac;
    }

    //Getters
    public String getRefDate() {
        return refDate;
    }

    public int getDayTotal() {
        return dayTotal;
    }

    public int getDailyDoseOne() {
        return dailyDoseOne;
    }

    public int getDailyDoseTwo() {
        return dailyDoseTwo;
    }

    public int getTotalVac() {
        return totalVac;
    }
}
