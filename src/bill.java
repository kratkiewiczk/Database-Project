public class bill 
{
		protected int billID;
		protected double amount;
	 	protected String stat;
	 	protected int ordID;
	 	protected String email;
	 
	    //constructors
	    public bill() {
	    }
	 
	    public bill(int billID) 
	    {
	        this.billID = billID;
	    }
	    
	    public bill(int billID, double amount, String stat, int ordID, String email) 
	    {
	    	this(amount, stat, ordID, email);
	    	this.billID = billID;
	    }
	    public bill(double amount, String stat, int ordID, String email) 
	    {
	    	this.amount = amount;
	    	this.stat = stat;
	    	this.ordID = ordID;
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
	    public int getOrdID() {
	        return ordID;
	    }
	    public void setOrdID(int ordID) {
	        this.ordID = ordID;
	    }
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	}