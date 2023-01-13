package fileClass;
import mediaElements.Reproducible;
import mediaElements.mediaType;
import mediaInterface.playInterface;


public class Audio extends Reproducible implements playInterface {


	public Audio(mediaType type, String title, int duration, int volume) {
		super(type, title, volume, duration);

	}
	
	public static boolean checkduration(int x) {
		if (x < 1 || x > 10) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean checkVolume(int x) {
		if (x < 1 || x > 10) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void play() {
		String x = "";
		for(int i = 0; i < this.volume; i++) {
			x = "!";}
		for(int i = 0; i<this.duration; i++) {
		System.out.println(this.title + x);}
	}
	

}
