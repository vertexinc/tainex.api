package com.tie.model;

public class TieMsgState {
	private int tieMsgStateId;
	private String name;
	private String code;
	private String description;
	private String countryCodeA2;
	
	//ToDo static all know state for a message
	public static TieMsgState CREATED = new TieMsgState( 1,"Created", "Created", "The message is created in the system", "");
	public static TieMsgState SENT = new TieMsgState( 2,"Sent", "Sent", "The message is sent in the system", "");
	public static TieMsgState DELIVEREDTOALL = new TieMsgState( 3,"DeliveredToAll", "DeliveredToAll", "The message is delivered to all in the system", "");
	public static TieMsgState DELETED = new TieMsgState( 4,"Deleted", "Deleted", "The message is deleted in the system", "");
	public static TieMsgState ARCHIVED = new TieMsgState( 5,"Archived", "Archived", "The message is archived in the system", "");
	public static TieMsgState ERROR = new TieMsgState( 6,"Error", "Error", "The message is an error in the system", "");
	/**
	 * 
	 * @param tieMsgStateId
	 * @return
	 */
	public static TieMsgState findById( int tieMsgStateId )
	{
		TieMsgState retval = null;
		
		//switch based on the given id
		//if tieMsgStateId == CREATED.getTieMsgStateId(); then retval = CREATED;
		 switch (tieMsgStateId) {
         case 1:  retval = CREATED;
                  break;
         case 2:  retval = SENT;
                  break;
         case 3:  retval = DELIVEREDTOALL;
                  break;
         case 4:  retval = DELETED;
                  break;
         case 5:  retval = ARCHIVED;
                  break;
         case 6:  retval = ERROR;
                  break;
     }
		return retval;
	}//end findById(.)
	
	
	
	
	public TieMsgState() {
		//super();
	}

	public TieMsgState(int tieMsgStateId, String name, String code, String description, String countryCodeA2) {
		super();
		this.tieMsgStateId = tieMsgStateId;
		this.name = name;
		this.code = code;
		this.description = description;
		this.countryCodeA2 = countryCodeA2;
	}

	public int getTieMsgStateId() {
		return tieMsgStateId;
	}

	public void setTieMsgStateId(int tieMsgStateId) {
		this.tieMsgStateId = tieMsgStateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCountryCodeA2() {
		return countryCodeA2;
	}

	public void setCountryCodeA2(String countryCodeA2) {
		this.countryCodeA2 = countryCodeA2;
	}

	@Override
	public String toString() {
		return "TieMsgState [tieMsgStateId=" + tieMsgStateId + ", name=" + name + ", code=" + code + ", description="
				+ description + ", countryCodeA2=" + countryCodeA2 + "]";
	}

}
