package Models;

public class PaymentType {
	private enum paymentType {
		cash, card
	}

	public boolean loadPaymentTypeByStoreID(int StoreID) {
		return true;
	};

	public PaymentType(Object paymentType) {

	}
}
