package pers.lls.demo;

public enum DateFormEnum {
//	sdf1("yyyy-MM-dd HH:mm:ss"),
	sdf2("yyyy/MM/dd HH:mm:ss"),
	sdf3("yyyy/MM/dd - HH:mm:ss"),
	sdf4("yyyy/MM/dd-HH:mm:ss");
	
	private String code;
	
	DateFormEnum(String code){
		this.code=code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
