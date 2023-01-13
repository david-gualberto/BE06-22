package fileClass;

import mediaElements.MediaElements;
import mediaElements.mediaType;
import mediaInterface.brightnessInterface;


public class Image extends MediaElements implements brightnessInterface {
		int brightness;
			
		public Image(mediaType type, String title, int brightness) {
		super(type, title);
		this.brightness = brightness;
		}
		
		@Override
		public void show() {
			String x = "";
			for (int i =0; i< this.brightness; i++) {
				x += "*";
			}
			System.out.println(this.title + x);
		}
		
		public static boolean checkBrightness(int x) {
			if (x < 1 || x > 10) {
				return false;
			} else {
				return true;
			}
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
