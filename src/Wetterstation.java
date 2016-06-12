import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Timer;


public class Wetterstation extends Observable{
	MessDaten daten = new MessDaten();

	public void messwerteGeaendert(){
		setChanged();
		notifyObservers();
	}
	
	// Simulation der Wetterdaten ...
	public void messungSimulieren(){
		Thread thread = new Thread(new Runnable(){
			public void run(){
				while (true){
					daten.messen();
					messwerteGeaendert();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		});
		thread.start();
	}

	public Wetterstation(){
		messungSimulieren();
	}

	public static void main(String [] arg){
		MessDaten daten = new MessDaten();
		Observer aussichten = new Aussichten(daten);
		Wetterstation wetterstation = new Wetterstation();
		wetterstation.addObserver(aussichten);
		wetterstation.addObserver(new Tendenz(daten));
	}
}
