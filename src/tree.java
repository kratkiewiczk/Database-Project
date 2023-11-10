public class tree 
{
		protected int treeID;
		protected int height;
	 	protected String nearBuild;
	 	protected int quoteID;
	 
	    //constructors
	    public tree() {
	    }
	 
	    public tree(int treeID) 
	    {
	        this.treeID = treeID;
	    }
	    
	    public tree(int treeID, int height, String nearBuild, int quoteID) 
	    {
	    	this(height, nearBuild, quoteID);
	    	this.treeID = treeID;
	    }
	    public tree(int height, String nearBuild, int quoteID) 
	    {
	    	this.height = height;
	    	this.nearBuild = nearBuild;
	    	this.quoteID = quoteID;
	    }
	    
	   //getter and setter methods
	    public int getTreeID() {
	        return treeID;
	    }
	    public void setTreeID(int treeID) {
	        this.treeID = treeID;
	    }
	    public int getHeight() {
	        return height;
	    }
	    public void setHeight(int height) {
	        this.height = height;
	    }
	    public String getNearBuild() {
	        return nearBuild;
	    }
	    public void setNearBuild(String nearBuild) {
	        this.nearBuild = nearBuild;
	    }
	    public int getQuoteID() {
	        return quoteID;
	    }
	    public void setQuoteID(int quoteID) {
	        this.quoteID = quoteID;
	    }
	}