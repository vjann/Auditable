package com.example.auditable;

import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;

public class Preferences {
    private int minimumRMP = 0;
    private List<String> days = Arrays.asList("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY");
    private int[] classSize = new int[] {0, Integer.MAX_VALUE};
    private List<String> keywords;
    private List<String> departments;
    private boolean lowerDiv = true;
    private boolean upperDiv = true;

    public Preferences(int minimumRMP, List<String> days, int[] classSize, List<String> keywords,
                       List<String> departments, boolean lowerDiv, boolean upperDiv) {
        this.minimumRMP = minimumRMP;
        this.days = days;
        this.classSize = classSize;
        this.keywords = keywords;
        this.departments = departments;
        this.lowerDiv = lowerDiv;
        this.upperDiv = upperDiv;
    }

    public int getMinimumRMP() {
        return minimumRMP;
    }

    public boolean isLowerDiv() {
        return lowerDiv;
    }

    public boolean isUpperDiv() {
        return upperDiv;
    }

    public int[] getClassSize() {
        return classSize;
    }

    public List<String> getDays() {
        return days;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setClassSize(int[] classSize) {
        this.classSize = classSize;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }
    public void addDay(String day) {
        if (!this.days.contains(day)) {
            this.days.add(day);
        }
    }
    public void removeDay(String day) {
        if (this.days.contains(day)) {
            this.days.remove(day);
        }
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public void toggleLowerDiv(boolean lowerDiv) {
        this.lowerDiv = !this.lowerDiv;
    }

    public void toggleUpperDiv(boolean upperDiv) {
        this.upperDiv = !this.upperDiv;
    }
    public void setMinimumRMP(int minimumRMP) {
        this.minimumRMP = minimumRMP;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }
}
