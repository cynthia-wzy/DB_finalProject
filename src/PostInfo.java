public class PostInfo {
	private byte[] image;
    private String foodName;
    private String foodLocation;
    private int foodAmount;
    private String pickupDDL;
    private int minPrice;

    public PostInfo(byte[] image, String foodName, String foodLocation, int foodAmount, String pickupDDL, int minPrice) {
        this.image = image;
    	this.foodName = foodName;
        this.foodLocation = foodLocation;
        this.foodAmount = foodAmount;
        this.pickupDDL = pickupDDL;
        this.minPrice = minPrice;
    }

    // getter & setter
    public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public String getFoodName() {
        return foodName;
    }

	public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodLocation() {
        return foodLocation;
    }

    public void setFoodLocation(String foodLocation) {
        this.foodLocation = foodLocation;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public String getPickupDDL() {
        return pickupDDL;
    }

    public void setPickupDDL(String pickupDDL) {
        this.pickupDDL = pickupDDL;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }
}
