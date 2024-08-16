package com.example.celllife;

import java.util.Random;

public class Cell
{
    public enum State
    {
        life,
        fullLife,
        dead,
        fullDead
    }

    public Cell()
    {
        if(new Random().nextBoolean())
            this.state = State.life;
        else
            this.state = State.dead;
    }

    public Cell(State state)
    {
        this.state = state;
    }

    private State state;
    public State getState()
    {
        return state;
    }
    public void setState(State state)
    {
        this.state = state;
    }


}
