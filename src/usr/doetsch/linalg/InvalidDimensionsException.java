package usr.doetsch.linalg;

public class InvalidDimensionsException extends RuntimeException {

	private String message;
	
	public InvalidDimensionsException (String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage () {
		return this.message + " " + super.getMessage();
	}
	
}
