public class stats
{
		protected String email;
		protected int trees;
	 	protected String date;
	 
	    //constructors
	    public stats() {
	    }
	 
	    public stats(String email) 
	    {
	        this.email = email;
	    }
	    
	    public stats(String email, int trees, String date) 
	    {
	    	this(trees, date);
	    	this.email = email;
	    }
	    public stats(int trees, String date) 
	    {
	    	this.trees = trees;
	    	this.date = date;
	    }
	    
	   //getter and setter methods
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    public int getTrees() {
	        return trees;
	    }
	    public void setTrees(int trees) {
	        this.trees = trees;
	    }
	    public String getDate() {
	        return date;
	    }
	    public void setDate(String date) {
	        this.date = date;
	    }
	}