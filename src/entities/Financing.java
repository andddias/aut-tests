package entities;

public class Financing {
	
	public static double ENTRY_PERCENTAGE = 0.20;
	public static double QUOTA_PERCENTAGE = 0.80;
	
	private Double totalAmount;
	private Double income;
	private Integer months;
	
	public Financing() {		
	}

	public Financing(Double totalAmount, Double income, Integer months) {
		if(totalAmount * QUOTA_PERCENTAGE / months > income / 2.0) {
			throw new IllegalArgumentException("A prestação não pode ser maior que a metade da renda");
		}
		this.totalAmount = totalAmount;	
		this.income = income;		
		this.months = months;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		if(totalAmount * QUOTA_PERCENTAGE / months > income / 2.0) {
			throw new IllegalArgumentException("A prestação não pode ser maior que a metade da renda");
		}
		this.totalAmount = totalAmount;
	}

	public Double getIncome() {		
		return income;
	}

	public void setIncome(Double income) {
		if(quota() > income / 2.0) {
			throw new IllegalArgumentException("A prestação não pode ser maior que a metade da renda");
		}
		this.income = income;
	}	

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		if(totalAmount * QUOTA_PERCENTAGE / months > income / 2.0) {
			throw new IllegalArgumentException("A prestação não pode ser maior que a metade da renda");
		}
		this.months = months;
	}
	
	public double entry() {
		return totalAmount * ENTRY_PERCENTAGE;
		
	}
	
	public double quota() {
		return totalAmount * QUOTA_PERCENTAGE / months;
	}
}
