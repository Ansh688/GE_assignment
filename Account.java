package ge;

public class Account {

	
    //private static final Logger logger = LogManager.getLogger(Account.class);
	
	private float monthlyInterestRate = 0.0f;
    private float monthlyFee = 0.0f;

    private String accountNumber;
    private String accountType;
    private float balance;

    public Account(String accountNumber, String accountType, float balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        if (accountType == "Savings") {
            monthlyInterestRate = 1.0f;
        }
    }

    public Account(String accountNumber, String accountType) {
    	 this.accountNumber = accountNumber;
         this.accountType = accountType;
         this.balance = 0.0f;
         if (accountType == "Savings") {
             monthlyInterestRate = 1.0f;
         }
    }

    public Account(String accountNumber) {
    	 this.accountNumber = accountNumber;
         this.accountType = "Savings";
         this.balance = 0.0f;
         if (accountType == "Savings") {
             monthlyInterestRate = 1.0f;
         }
    }

    public float valueNextMonth() {
    	return balance*(1+(monthlyInterestRate/100)) - monthlyFee;
    	
    }

    @Override
    public String toString() {
        if (accountType == "Checking") {
            if (monthlyFee == 0.0f) {
                return "No fee checking account #" + accountNumber;
            } else {
                return "Checking account #" + accountNumber;
            }
        } else {
            if (monthlyInterestRate > 1.01) {
                if (monthlyFee == 0.0f) {
                    return "High interest no fee savings account #" + accountNumber;
                } else {
                    return "High interest savings account #" + accountNumber;
                }
            } else {
                if (monthlyFee == 0.0f) {
                    return "No fee savings account #" + accountNumber;
                } else {
                    return "Savings account #" + accountNumber;
                }
            }
        }
    }

    public void deposit(float amount) {
        balance += amount;
    }

    public void withdraw(float amount) {
    	if(accountType == "Checking")
    	{
    		if(amount > 100.0f)
    		{
    		System.out.println("Cannot be withdrawn");
    		return;
    		}
    	}
    	float newBalance = balance - amount;
    	if(accountType == "Savings")
    	{
    		if(newBalance < 0.0f)
    		{
    		System.out.println("Cannot have negative balance");
    		return;
    		}
    	}
        balance -= amount;
    }

    public float getMonthlyInterestRate() {
        return this.monthlyInterestRate;
    }

    public void setMonthlyInterestRate(float monthlyInterestRate) {
        this.monthlyInterestRate = monthlyInterestRate;
    }

    public float getMonthlyFee() {
        return this.monthlyFee;
    }

    public void setMonthlyFee(float monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
 
    public float getBalance() {
        return this.balance;
    }

    void setBalance(float balance) {
        this.balance = balance;
    }
}

