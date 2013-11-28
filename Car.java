import java.util.Random;

public class Car {

    private int bornTime;
    public int destination;
    private CarPosition currentPosition;

    public Car() {
	
	destination = (int)Math.round(Math.random());
    }
    
    public void step()
    {
            currentPosition.moveForward();
    }


    // public int getDest() {
    //	return this.destination;
    // }

    public void setCurrentPosition(CarPosition position) {
        currentPosition = position;
    }

    public String toString() {
            return "Car(bornTime=" + bornTime + ","
            //"destination=" + destination + "," +
            //"currenPosition" + currentPosition + ")";
            ;
    }        
}
