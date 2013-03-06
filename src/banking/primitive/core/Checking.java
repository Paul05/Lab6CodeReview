/*
  File:	Checking.java
  Author:	foo
  Date:	bar
  
  Description: baz
*/
package banking.primitive.core;



/**
Class:	Checking

Description:	The checking class
*/
//Lab6cwroger added class header
public class Checking extends Account {

<<<<<<< HEAD
	private static final long _SERIALVERSIONUID = 11L; //caps and _ lab6pspaude
	private int _numWithdraws = 0; //added _ lab6pspaude
=======
	private static final long serialVersionUID = 11L;
	private int _numWithdraws = 0; //Lab6cwroger added _
>>>>>>> 1ebb02392982cf1ac21be66e24a2893267b69fcc
	
	/**
	 * added comment lab6pspaude
	 * @param name
	 */
	private Checking(String name) {
		super(name);
	}

	/**
	 * added comment lab6pspaude
	 * @param name
	 * @return
	 */
    public static Checking createChecking(String name) {
        return new Checking(name);
    }

    /**
     * Added comment lab6pspaude
     * @param name
     * @param balance
     */
	public Checking(String name, float balance) {
		super(name, balance);
	}

	/**
	 * A deposit may be made unless the Checking account is closed
	 * @param float is the deposit amount
	 */
	public boolean deposit(float amount) {
		if (getState() != STATE.CLOSED && amount > 0.0f) {
			balance = balance + amount;
			if (balance >= 0.0f) {
				setState(STATE.OPEN);
			}
			return true;
		}
		return false;
	}

	/**
	 * Withdrawal. After 10 withdrawals a fee of $2 is charged per transaction You may 
	 * continue to withdraw an overdrawn account until the balance is below -$100
	 */
	public boolean withdraw(float amount) {
		if (amount > 0.0f) {		
			// KG: incorrect, last balance check should be >=
			if (getState() == STATE.OPEN || (getState() == STATE.OVERDRAWN && balance > -100.0f)) {
				balance = balance - amount;
				_numWithdraws++;
				if (_numWithdraws > 10)
					balance = balance - 2.0f;
				if (balance < 0.0f) {
					setState(STATE.OVERDRAWN);
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * added comment lab6pspaude
	 */
	public String getType() { return "Checking"; }
	
	/**
	 * added comment lab6pspaude
	 */
	public String toString() {
		return "Checking: " + getName() + ": " + getBalance();
	}
}
