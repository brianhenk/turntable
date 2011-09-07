package turntable.stylus;

public class Turntable {
	
	public Turntable() {
		
	}
	
	public void run() {
		StylusFrame stylus = new StylusFrame();
		stylus.display();
	}
	
	public static void main(String[] args) {
		Turntable turntable = new Turntable();
		turntable.run();
	}	

}
