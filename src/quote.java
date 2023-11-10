public class quote 
{
		protected int quoteID;
		protected double price;
		protected String timeWindow;
	 	protected String stat;
	 	protected String email;
	 
	    //constructors
	    public quote() {
	    }
	 
	    public quote(int quoteID) 
	    {
	        this.quoteID = quoteID;
	    }
	    
	    public quote(int quoteID, double price, String timeWindow, String stat, String email) 
	    {
	    	this(price, timeWindow, stat, email);
	    	this.quoteID = quoteID;
	    }
	    public quote(double price, String timeWindow, String stat, String email) 
	    {
	    	this.price = price;
	    	this.timeWindow = timeWindow;
	    	this.stat = stat;
	    	this.email = email;
	    }
	    
	   //getter and setter methods
	    public int getQuoteID() {
	        return quoteID;
	    }
	    public void setQuoteID(int quoteID) {
	        this.quoteID = quoteID;
	    }
	    public double getPrice() {
	        return price;
	    }
	    public void setPrice(double price) {
	        this.price = price;
	    }
	    public String getTimeWindow() {
	        return timeWindow;
	    }
	    public void setTimeWindow(String timeWindow) {
	        this.timeWindow = timeWindow;
	    }
	    public String getStat() {
	        return stat;
	    }
	    public void setStat(String stat) {
	        this.stat = stat;
	    }
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	}