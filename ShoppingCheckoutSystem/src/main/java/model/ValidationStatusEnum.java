/**
 * 
 */
package model;

/**
 * @author vijay
 *
 */
public enum ValidationStatusEnum {
	
	SUCCESS(0,"SUCCESS"),
	FAIL(1,"FAIL");
	
	
	private int validationStatusCode;
	private String validationStatusDescription;
	  
    public int getValidationStatusCode(){
        return this.validationStatusCode;
    }
    
    public String getValidationStatusDescription(){
        return this.validationStatusDescription;
    }
    
    private ValidationStatusEnum(int validationStatusCode, String validationStatusDescription){
        this.validationStatusCode = validationStatusCode;
        this.validationStatusDescription = validationStatusDescription;
    }

}
