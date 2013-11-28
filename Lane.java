public class Lane {

    public static class OverflowException extends RuntimeException {
        // Undantag som kastas nar det inte gick att lagga 
        // in en ny bil pa vagen
    }

    public CarPosition[] theLane; // ---- i en lane
    private Lane otherLane;

    public Lane(int n, int laneType){
	
        
	        
	theLane = new CarPosition[n];

        for(int i = 0; i < n; i++) {
            theLane[i] = new CarPosition(this);
            
	    

            if (i >= 1)
                theLane[i].setForward(theLane[i-1]);
        }
    }

    public void enterLane(Lane nextLane, Lane leftLane) {
	
       	if (firstFree() == false) {
	
	Car carChoice = firstCar();
	int choice = carChoice.destination;
	if (choice  == 0) {
	theLane[0].setForward(nextLane.theLane[nextLane.theLane.length - 1]);
	}
	else {
	   theLane[0].setForward(leftLane.theLane[leftLane.theLane.length - 1]);
	}
	}
	
	if ((nextLane.firstFree() == false) && (nextLane.theLane[1].light.isGreen() == false))
	    {
		nextLane.getFirst();
	    } 
	if ((leftLane.firstFree() == false) && (leftLane.theLane[1].light.isGreen() == false)) 
	    {
        	leftLane.getFirst();
	    }
}
	
    
    // Konstruerar ett Lane-objekt med plats for n fordon
    // Samt lanker ihop varje CarPosition med forward for den framfor
    
    public boolean matchEnd(CarPosition target)
    {
        return theLane[0] == target;
    }
    
    public int getLength(){
            return theLane.length;
    }
    
    public void setParallel(Lane sideLane)
    {
            int i = 0;
            
            while(i < sideLane.getLength() && i < theLane.length) {
            theLane[i].setTurn(sideLane.theLane[i]);
            i++;
        }
    }

    public void step() {

        for(int i = 0; i < theLane.length; i++) {
            CarPosition spot = theLane[i];
 
		spot.moveForward(); 
	    
            if (spot.getLight() != null)
                spot.getLight().step();
        }
       
        // Stega fram alla fordon (utom det pa plats 0) ett steg 
        // (om det gar). (Fordonet pa plats 0 tas bort utifran 
        // mm h a metoden nedan.)
    }

    public Car getFirst() {
        Car tmp = theLane[0].getCurrentCar();
        theLane[0].setCurrentCar(null);
        return tmp;
    }

    public Car firstCar() {
            return theLane[0].getCurrentCar();
    }

    public CarPosition lastPosition(CarPosition[] someLane) {
	int a = someLane.length -1;
	return someLane[a];
    }

    public CarPosition firstCarPos() {
	return theLane[0];
    }

    public boolean firstFree() {
	return (theLane[0].getCurrentCar() == null);
    }

    public boolean lastFree() {
            return theLane[theLane.length-1].getCurrentCar() == null;
    }

    public void putLast(Car c) throws OverflowException {
        if (theLane[theLane.length-1].getCurrentCar() == null) {        
            theLane[theLane.length-1].setCurrentCar(c);
        }
        // Stall en bil pa sista platsen pa vagen
        // (om det gar).
    }
    public String toString() {
        
        String s1 = "";
        String s2 = "";
        
        for (int i = 0; i < theLane.length; i++) {
            if (theLane[i].getLight() != null)
                s1 += theLane[i].getLight().isGreen() ? "G" : "R";          
	    else
                s1 += "";
            s2 += theLane[i].getCurrentCar() == null ? "-" : "@";
	}

	    return s1 + "" + s2 + "";	 	
 
    }
 
   public void createLight(int position, int period, int green) {
        theLane[position].setLight(new Light(period, green));
    }
}



