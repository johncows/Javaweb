package jdbc工具类;
public class product {
	String pname;
	double price;
	String  category_id;
	String pid;
	

	/*
	 * 特别注意此处不能使用构造函数 ，这会覆盖原始构造函数，导致数据无法写入
	 * 
	 * */
	
	
//	public product(String pid, String pname, double price, String category_id) {
//		this.pid = pid;
//		this.pname = pname;
//		this.price = price;
//		this.category_id = category_id;
//	}
	
	
	
	
	@Override
	public String toString() {
		return "product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", category_id=" + category_id + "]";
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
}
