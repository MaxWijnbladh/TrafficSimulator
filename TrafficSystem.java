public class TrafficSystem {
    // Definierar de vagar och signaler som ingar i det 
    // system som skall studeras.
    // Samlar statistik
    
    // Attribut som beskriver bestandsdelarna i systemet
    private Lane  r0;
    private Lane  r1;
    private Lane  r2;
    private Light s1;
    private Light s2;

    // Diverse attribut for simuleringsparametrar (ankomstintensiteter,
    // destinationer...)

    // Diverse attribut for statistiksamling
    //....    
    
    private int time = 0;

    public TrafficSystem() {
            //...
            }

    public void readParameters() {
        // Laser in parametrar for simuleringen
        // Metoden kan lasa fran terminalfonster, dialogrutor
        // eller fran en parameterfil. Det sista alternativet
        // ar att foredra vid uttestning av programmet eftersom
        // man inte da behover mata in vardena vid varje korning.
        // Standardklassen Properties ar anvandbar for detta. 
    }

    public void step() {
        // Stega systemet ett tidssteg m h a komponenternas step-metoder
        // Skapa bilar, lagg in och ta ur pa de olika Lane-kompenenterna
    }

    public void printStatistics() {
        // Skriv statistiken samlad sa har langt
    }

    public void print() {
        // Skriv ut en grafisk representation av kosituationen
        // med hjalp av klassernas toString-metoder
    }

}
