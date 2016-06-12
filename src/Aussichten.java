import java.util.Observable;
import java.util.Observer;
import java.util.Random;


public class Aussichten implements Observer{
	private String vorhersage;
	private MessDaten daten;

	public Aussichten(MessDaten daten) {
		this.daten = daten;
	}
	
	private String[] texte = {
			"regnerisch", "trüb", "neblig", "stürmisch", "wechselhaft bewölkt",
			"sonnig", "heiter", "frostig" 
	};
	private void berechneVorhersage(MessDaten daten){
		Random random = new Random();
		int index1 = random.nextInt(texte.length);
		int index2 = random.nextInt(texte.length);
		while(index2 == index1){
			 index2 = random.nextInt(texte.length);
		}
		vorhersage = texte[index1] + " und " + texte[index2];
	}

	@Override
	public void update(Observable o, Object arg) {
		berechneVorhersage(daten);
		System.out.println("Die weiteren Aussichten: " + vorhersage);
	}
}
