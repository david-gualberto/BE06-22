package mediaElements;

public abstract class Reproducible extends MediaElements {
		public int volume;
		protected int duration;
	
	public Reproducible(mediaType type, String title, int volume, int duration) {
		super(type, title);
		this.volume = volume;
		this.duration = duration;
		
	}
	
	public void setVolume(int volume) {
		if ( volume >= 0 && volume <= 10) {
			this.volume = volume; }
		else { 
			System.out.println("Inserire un valore da 1 a 10");
			}
	}
	
	public void setDuration(int duration) {
		if ( duration >= 0 && duration <= 10) {
			this.volume = duration; }
		else { 
			System.out.println("Inserire un valore da 1 a 10");
			}
	}


	public void highVolume() {
		this.volume++;
	}
	
	public void lowVolume() {
		this.volume--;
	}
}
