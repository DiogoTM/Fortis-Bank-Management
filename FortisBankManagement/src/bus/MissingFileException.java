package bus;

public class MissingFileException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  static final String message = "Missing file exception...." ;
	public MissingFileException(String msg) {
		super(msg);
	
	}
	public MissingFileException() {
		super(message);
		
	}
}
