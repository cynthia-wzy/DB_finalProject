public class ProcessData {
	
	private String name;
	private String postContent;
	private byte[] graph;
	private String location;
	private String type;
	private int amount;
	private String startTime;
	private String endTime;
	private int price;
	private String account;
	private String password;
	private int postID;
	private int peopleWaiting;
	
	//WindowDemo模板用
	public ProcessData(String name,String postContent, byte[] graph, String location, String type, int amount, String startTime, String endTime, int price ) {
		this.name = name;
		this.postContent = postContent;
		this.graph = graph;
		this.location = location;
		this.type = type;
		this.amount = amount;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
	}
	
	//RegisterPage用
	public ProcessData(String account,String password) {
		this.account = account;
		this.password = password;
	}
	
	public ProcessData() {
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public byte[] getGraph() {
		return graph;
	}
	public void setGraph(byte[] graph) {
		this.graph = graph;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public int getPeopleWaiting() {
		return peopleWaiting;
	}
	public void setPeopleWaiting(int peopleWaiting) {
		this.peopleWaiting = peopleWaiting;
	}
	
}
