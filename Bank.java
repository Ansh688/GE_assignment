package ge;

import java.util.HashMap;
import java.util.Map;


public class Bank {
	
	//private static final Logger logger = LogManager.getLogger(Bank.class);
    private Map<String, Account> accountMap;

    public Bank() {
        accountMap = new HashMap<>();
    }

    public Account getAccount(String accountNumber) {
        return accountMap.get(accountNumber);
    }

    public void addAccount(Account account) {
        accountMap.put(account.getAccountNumber(), account);
    }

    public void depositToAccount(String accountNumber, float amount) {
        getAccount(accountNumber).deposit(amount);
    }

    public void withdrawFromAccount(String accountNumber, float amount) {
        getAccount(accountNumber).withdraw(amount);
    }

    public int numAccounts() {
        return accountMap.size();
    }
    
    public float getCurrentHoldings()
    {
    	float sum = 0.0f;
    	for(Map.Entry<String,Account> entry:accountMap.entrySet())
    	{
    		sum = sum + entry.getValue().getBalance();
    	}
    	return sum;
    }
    
    public float getValuesNextMonth()
    {
    	float sum = 0.0f;
    	for(Map.Entry<String,Account> entry:accountMap.entrySet())
    	{
    		sum = sum + entry.getValue().valueNextMonth();
    	}
    	return sum;
    }
    
    public String profitOrLoss()
    {
    	float feeSum = 0;
    	float interestSum = 0;
    	for(Map.Entry<String,Account> entry:accountMap.entrySet())
    	{
    		feeSum = feeSum + entry.getValue().getMonthlyFee();
    		interestSum = interestSum + (entry.getValue().valueNextMonth() - entry.getValue().getBalance());
    	}
    	if(interestSum>feeSum)
    	{
    		return "loss for bank";
    	}
    	return "profit for bank";
    }
}

