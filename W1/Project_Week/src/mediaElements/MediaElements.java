package mediaElements;

public abstract class MediaElements {
		
		public mediaType type;
		protected String title;
		
		//Costruttore
		public MediaElements(mediaType type, String title ) {
			this.type = type;
			this.title = title;
		}

		public void show() {
			
		}

		public void play() {
			
		}

	
}
