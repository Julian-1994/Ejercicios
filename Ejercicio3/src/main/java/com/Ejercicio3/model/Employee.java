package com.Ejercicio3.model;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	
	@Entity
	public class Employee {
		
		@Column(name = "userName")
	    private String userName;
	    @Id
	    @Column(name = "userId")	
	    private String userId;
	    @Column(name = "transactionDate")
	    private Date transactionDate;
	    @Column(name = "transactionAmount")
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


