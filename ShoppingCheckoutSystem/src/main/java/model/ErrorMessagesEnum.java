/**
 * 
 */
package model;

/**
 * @author vijay
 *
 */
public enum ErrorMessagesEnum {
	
	IS_NOT_A_NUMBER(1,"IS_NOT_A_NUMBER"),
	NUMBER_FORMAT_INCORRECT(2,"NUMBER_FORMAT_INCORRECT"),
	GENERIC_ERROR(3,"GENERIC_ERROR"),
	EMPTY_CART(4,"EMPTY_CART"),
	EMPTY_OBJECT(4,"EMPTY_OBJECT");
	
	private int errorCode;
	private String errorDescription;
	  
    public int getErrorCode(){
        return this.errorCode;
    }
    
    public String getErrorDescription(){
        return this.errorDescription;
    }
    
    private ErrorMessagesEnum(int errorCode, String errorDescription){
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

}
