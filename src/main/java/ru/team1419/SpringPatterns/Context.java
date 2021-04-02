package ru.team1419.SpringPatterns;

public class Context {
    public static State state;
    public Context(State state)
    {
        this.state = state;
    }

    public State getThisState()
    {
        return state;
    }



    public void Request()
    {
        this.state.getData(this);
    }
}
