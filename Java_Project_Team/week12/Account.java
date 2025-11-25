package week12;

public class Account {
	private String acNumber; // 계좌번호
	private String acOwner; // 예금주
	private double acBalance; // 잔액
	
	// 생성자를 통해 Account 객체 생성
	public Account(String acNumber, String acOwner, double acBalance) {
		this.acNumber = acNumber;
		this.acOwner = acOwner;
		this.acBalance = acBalance;
	}
	
	public String getNumber() {
		return acNumber;
	}
	
	public String getOwner() {
		return acOwner;
	}
	
	public double getBalance() {
		return acBalance;
	}
	
	public void setBalance(double acBalance) {
		this.acBalance = acBalance;
	}
}