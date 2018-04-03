package bean;

public class mycart {
	
	int good_ID;
	int cart_ID;
	public mycart() {
		// TODO 自动生成的构造函数存根
	}
	public mycart(int good_ID, int cart_ID) {
		super();
		this.good_ID = good_ID;
		this.cart_ID = cart_ID;
	}
	public int getGood_ID() {
		return good_ID;
	}
	public void setGood_ID(int good_ID) {
		this.good_ID = good_ID;
	}
	public int getCart_ID() {
		return cart_ID;
	}
	public void setCart_ID(int cart_ID) {
		this.cart_ID = cart_ID;
	}
	

}
