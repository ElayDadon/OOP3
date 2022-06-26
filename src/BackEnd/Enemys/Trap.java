package BackEnd.Enemys;

public class Trap extends Enemy{
    public Integer VisibilityTime;
    public Integer InvisibilityTime;
    public Integer TicksCount;
    public boolean Visible;

    public Trap(int invisibilityTime, int visibilityTime)
    {
        Visible = true;
        TicksCount = 0;
        InvisibilityTime = invisibilityTime;
        VisibilityTime = visibilityTime;
    }
}
