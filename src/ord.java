public class ord 
{
		protected int ordID;
	 	protected String stat;
		protected int quoteID;
	 	protected String email;
	 
	    //constructors
	    public ord() {
	    }
	 
	    public ord(int ordID) 
	    {
	        this.ordID = ordID;
	    }
	    
	    public ord(int ordID, String stat, int quoteID, String email) 
	    {
	    	this(stat, quoteID, email);
	    	this.ordID = ordID;
	    }
	    public ord(String stat, int quoteID, String email) 
	    {
	    	this.stat = stat;
	    	this.quoteID = quoteID;
	    	this.email = email;
	    }
	    
	   //getter and setter methods
	    public int getOrdID() {
	        return ordID;
	    }
	    public void setOrdID(int ordID) {
	        this.ordID = ordID;
	    }
	    public String getStat() {
	        return stat;
	    }
	    public void setStat(String stat) {
	        this.stat = stat;
	    }
	    public int getQuoteID() {
	        return quoteID;
	    }
	    public void setQuoteID(int quoteID) {
	        this.quoteID = quoteID;
	    }
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	}