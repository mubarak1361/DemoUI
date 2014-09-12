package com.me.demoui;

public class StorageAccess {

	private static StorageAccess storageAccess;
	private String string;
	
	protected StorageAccess() {
			}
	
	public static StorageAccess getInstance() {
		if(storageAccess ==  null) {
			storageAccess = new StorageAccess();
		}
		return storageAccess;
	}
	
	public void setString(String string) {		
		 this.string = string;
	}
	
	public String getString(){
		return this.string;
	}
		
}
