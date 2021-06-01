package entities;

public class Financing {
	
	public static double ENTRY_PERCENTAGE = 0.20;
	public static double QUOTA_PERCENTAGE = 0.80;
	
	private Double totalAmount;
	private Double income;
	private Integer months;

	public Financing(Double totalAmount, Double income, Integer months) {
		validateFinancing(totalAmount, income, months);
		this.totalAmount = totalAmount;	
		this.income = income;		
		this.months = months;		
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		validateFinancing(totalAmount, income, months);
		this.totalAmount = totalAmount;
	}

	public Double getIncome() {		
		return income;
	}

	public void setIncome(Double income) {
		validateFinancing(totalAmount, income, months);
		this.income = income;
	}	

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		validateFinancing(totalAmount, income, months);
		this.months = months;
	}
	
	public double entry() {
		return totalAmount * ENTRY_PERCENTAGE;
		
	}
	
	public double quota() {
		return totalAmount * QUOTA_PERCENTAGE / months;
	}
	
	private void validateFinancing(Double totalAmount, Double income, Integer months) {		
		if(totalAmount * QUOTA_PERCENTAGE / months > income / 2.0) {
			throw new IllegalArgumentException("A prestação não pode ser maior que a metade da renda");
		}
	}
}
