public class message 
{
		protected int messageID;
	 	protected String note;
	 	protected int quoteID;
	 	protected String email;
	 	
	 
	    //constructors
	    public message() {
	    }
	 
	    public message(int messageID) 
	    {
	        this.messageID = messageID;
	    }
	    
	    public message(int messageID, String note, int quoteID, String email) 
	    {
	    	this(note, quoteID, email);
	    	this.messageID = messageID;
	    }
	    public message(String note, int quoteID, String email) 
	    {
	    	this.note = note;
	    	this.quoteID = quoteID;
	    	this.email = email;
	    }
	    
	   //getter and setter methods
	    public int getMessageID() {
	        return messageID;
	    }
	    public void setMessageID(int messageID) {
	        this.messageID = messageID;
	    }
	    public String getNote() {
	        return note;
	    }
	    public void setNote(String note) {
	        this.note = note;
	    }
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    public int getQuoteID() {
	        return quoteID;
	    }
	    public void setQuoteID(int quoteID) {
	        this.quoteID = quoteID;
	    }
	}