package drawing;

public class Observer {
	private Paint paint;
	
	public Observer(Paint paint){
		this.paint = paint;
	}
	
	public void update(String message){
		paint.setStatus(message);
	}
}