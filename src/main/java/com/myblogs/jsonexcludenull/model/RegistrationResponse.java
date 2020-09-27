package com.myblogs.jsonexcludenull.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class RegistrationResponse   {
	
	  @JsonProperty("success")
	  private Boolean success = null;

	  @JsonProperty("message")
	  private String message = null;

	  @JsonProperty("data")
	  private String data = null;

	  @JsonProperty("error_code")
	  private Integer errorCode = null;

	  public RegistrationResponse success(Boolean success) {
	    this.success = success;
	    return this;
	  }

	  @NotNull
	  public Boolean isSuccess() {
	    return success;
	  }

	  public void setSuccess(Boolean success) {
	    this.success = success;
	  }

	  public RegistrationResponse message(String message) {
	    this.message = message;
	    return this;
	  }

	  @NotNull
	  public String getMessage() {
	    return message;
	  }

	  public void setMessage(String message) {
	    this.message = message;
	  }

	  public RegistrationResponse data(String data) {
	    this.data = data;
	    return this;
	  }

	  @Valid
	  public String getData() {
	    return data;
	  }

	  public void setData(String data) {
	    this.data = data;
	  }
	  
	  public RegistrationResponse errorCode(Integer errorCode) {
	    this.errorCode = errorCode;
	    return this;
	  }

	  @NotNull
	  public Integer getErrorCode() {
	    return errorCode;
	  }

	  public void setErrorCode(Integer errorCode) {
	    this.errorCode = errorCode;
	  }
}
