package com.ejercicios.model;
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
		
        public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public Date getTransactionDate() {
			return transactionDate;
		}
		public void setTransactionDate(Date transactionDate) {
			this.transactionDate = transactionDate;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public int getTransactionAmount() {
			return transactionAmount;
		}
		public void setTransactionAmount(int transactionAmount) {
			this.transactionAmount = transactionAmount;
		}

    }
