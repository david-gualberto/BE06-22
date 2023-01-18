
public class ClassThread extends Thread {
			
		String symbol;
		
		public ClassThread(String symbol) {
			this.symbol=symbol;
		}
		
		
		@Override
		public void run() {
			try {
				for (int i = 0; i<10; i++) {
					System.out.println(this.symbol);
					Thread.sleep(1000);
					}
				}
			 catch (InterruptedException e) {
				System.out.println("Error");
				}
		}
		
}
