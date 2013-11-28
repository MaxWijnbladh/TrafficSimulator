// Haller i en bil och kanner till sina "grannar". 
public class CarPosition{
        
    private Car currentCar = null; //null om ingen bil finns pa positionen
    private Lane owner;
    private CarPosition forward;
    private CarPosition turn;
    public Light light = null;

    public void setLight(Light light) {
        this.light = light;
    }

    public CarPosition(Lane a_Owner)
    {
        owner = a_Owner;
    }
        
    public boolean isEnd(CarPosition target)
    {
        return owner.matchEnd(target);
    }
        
    public boolean moveForward()
    {
        if (currentCar != null && forward != null && forward.currentCar == null && ((light != null && light.isGreen()) || light == null)) {
            currentCar.setCurrentPosition(forward);
            forward.currentCar = currentCar;
            currentCar = null;
            return true;
        }
        else {
            return false;
        }
    }

    
    public boolean turn()
    {
        return false;
        // Flytta bilen till turn
    }

    public void setTurn(CarPosition turn) {
        this.turn = turn;
    }

    public CarPosition getTurn() {
        return turn;
    }

    public Car getCurrentCar() {
        return currentCar;
    }

    public void setCurrentCar(Car car) {
        currentCar = car;
    }

    public Light getLight() {
        return light;
    }

    public void setForward(CarPosition forward) {
        this.forward = forward;
    }
    
    public String toString() {
        return "CarPosition(currentCar=" + currentCar + "," +
            "owner=" + owner + "," +
            "forward=" + forward + "," +
            "turn=" + turn + ")";
    }
        
}
