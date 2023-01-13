package fileClass;

import mediaElements.Reproducible;
import mediaElements.mediaType;
import mediaInterface.brightnessInterface;
import mediaInterface.playInterface;

public class Video extends Reproducible implements playInterface, brightnessInterface {
		int brightness;
		
		public Video(mediaType type, String title, int volume, int duration, int brightness) {
		super(type, title, volume, duration);
		this.brightness = brightness;
		
	}	
		
		public static boolean checkBrightness(int x) {
			if (x < 1 || x > 10) {
				return false;
			} else {
				return true;
			}
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
			String point = "";
			String star = "";
			for (int i = 0; i < this.volume; i++) {
					point = "!";
				}
			for (int i = 0; i<this.brightness; i++) {
					star = "*";
				}
			for (int i= 0; i<this.duration; i++) {
			System.out.println(this.title + point);
			System.out.println(this.title + star);}
		}

		@Override
		public void lowBrightness() {
			this.brightness--;
			
		}

		@Override
		public void highBrightness() {
			this.brightness++;
			
		}



		
}
