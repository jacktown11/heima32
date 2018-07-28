package accountmanager.domain;


/**
 * 对应一条账目的javabean
 * 数据库的查询结果将是该类型的对象的集合
 * @author tjk11
 *
 */
public class AccountItem {
	private int aid;
    private String aname;
    private String atype;
    private double amount;
    private String paymethod;
    private String createtime;
    private String description;
    
    public AccountItem() {
    	
    }
    
	public AccountItem(int aid, String aname, String atype, double amount,
			String paymethod, String createtime, String description) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.atype = atype;
		this.amount = amount;
		this.paymethod = paymethod;
		this.createtime = createtime;
		this.description = description;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "AccountItem [aid=" + aid + ", aname=" + aname + ", atype="
				+ atype + ", amount=" + amount + ", paymethod=" + paymethod
				+ ", createtime=" + createtime + ", description=" + description
				+ "]";
	}
    
    
}
