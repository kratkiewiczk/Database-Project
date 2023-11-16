public class bill 
{
		protected int billID;
		protected double amount;
	 	protected String stat;
	 	protected int quoteID;
	 	protected String email;
	 
	    //constructors
	    public bill() {
	    }
	 
	    public bill(int billID) 
	    {
	        this.billID = billID;
	    }
	    
	    public bill(int billID, double amount, String stat, int quoteID, String email) 
	    {
	    	this(amount, stat, quoteID, email);
	    	this.billID = billID;
	    }
	    public bill(double amount, String stat, int quoteID, String email) 
	    {
	    	this.amount = amount;
	    	this.stat = stat;
	    	this.quoteID = quoteID;
	    	this.email = email;
	    }
	    
	   //getter and setter methods
	    public int getBillID() {
	        return billID;
	    }
	    public void setBillID(int billID) {
	        this.billID = billID;
	    }
	    public double getAmount() {
	        return amount;
	    }
	    public void setAmount(double amount) {
	        this.amount = amount;
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