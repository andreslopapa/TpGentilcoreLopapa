package tools;

public class AppDataException {

	String message;
	Throwable innerException;
	
	
	
	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public Throwable getInnerException() {
		return innerException;
	}



	public void setInnerException(Throwable innerException) {
		this.innerException = innerException;
	}



	public AppDataException(Throwable e,String message){
		this.setInnerException(e);
		this.setMessage(message);
	}
	
}
