import java.util.Observable;
import java.util.Observer;

public class AktuelleBedingungen implements Observer{
	private MessDaten daten;

	public AktuelleBedingungen(MessDaten daten) {
		this.daten = daten;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("aktuell: "
				+ daten.getTemperatur() + " C "
				+ daten.getFeuchtigkeit() + "% "
				+ daten.getDruck() + " hPa ");
	}
}
