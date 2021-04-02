package ru.team1419.SpringPatterns;

public interface State {
    void setData(String name, int amount, Boolean milk);
    void getData(Context context);
}
