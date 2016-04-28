package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationResponse {
	
	private String validationStatus;
	
    private Map<String,List<String>>  validationErrors;

	public Map<String, List<String>> getValidationErrors() {
		
		if(this.validationErrors == null){
			validationErrors = new HashMap<String, List<String>>();
		}
		return validationErrors;
	}
	
	public  List<String> getValidationErrorsById(int id) {
		List<String> errorList;
		
		if(id == 0){
			
			errorList = new ArrayList<String>();
			errorList.add(ErrorMessagesEnum.EMPTY_CART.getErrorDescription());
			
		} else if(id != 0 && this.validationErrors == null){
			
			validationErrors = new HashMap<String, List<String>>();
			errorList = new ArrayList<String>();
			validationErrors.put(String.valueOf(id), errorList);
		}else{
			errorList = validationErrors.get(String.valueOf(id));
			if(errorList == null){
				errorList = new ArrayList<String>();
			}
		}
		return errorList; 
	}

	public void addValidationErrors(String id, String error) {
		Map<String, List<String>> errors = this.getValidationErrors();
		List<String> errorList = errors.get(id);
		
		if(errorList == null){
			errorList = new ArrayList<String>();
		}
		errorList.add(error);
		validationErrors.put(id, errorList);
	}

	public String getValidationStatus() {
		return validationStatus;
	}

	public void setValidationStatus(String validationStatus) {
		this.validationStatus = validationStatus;
	}
     
	
}
