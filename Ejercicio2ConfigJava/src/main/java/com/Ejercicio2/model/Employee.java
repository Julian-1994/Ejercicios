package com.Ejercicio2.model;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String userName;
    private String userId;
    private Date transactionDate;
    private int transactionAmount;
    
    public int getTransactionAmount() {
    	return this.transactionAmount;
    }
	public Date getTransactionDate() {
		// TODO Auto-generated method stub
		return this.transactionDate;
	}

	public void setTransactionDate(Date time) {
		this.transactionDate = time;
					
	}
	public String getuserId() {
		return this.userId;
	}
	
	public void setuserId(String i) {
		this.userId = i;
	}
	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


}
