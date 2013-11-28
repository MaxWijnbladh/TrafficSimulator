public class Light {
    private int period;
    private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
    private int green; // Signalen gron nar time<green 

    public Light(int period, int green) {
	this.period = period;
        this.green = green;
        this.time = 0;
    }

    public void step() { 
        if (time >= period) {
            time = 0;
        }
        else {
            time++;
        }
    }

    public boolean isGreen()   {
        return time<green;
	// Returnerar true om time<green, annars false
    }

    public String  toString()  {
            return "Light(period=" + period + "," +
            "time=" + time + "," +
            "green=" + green + ")";
    }
        
}
