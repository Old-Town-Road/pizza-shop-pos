package database;

/**
 * This class is filled with the database constants including static functions for the read procedures.
 * @author Ian Wilhelmsen
 * last updated: 4/30/2020
 */
import java.util.LinkedHashMap;

import models.ModelConstants;

public class DatabaseConstants {
	//Database keys for the annotations.
	public static final String TABLE_NAME_ANNOTATION = "TableName";
	public static final String DB_COLUMN_NAME_KEY = "colName";

	//Database table name values.
	public static final String DB_TABLE_MENU_TABLE_VALUE = "Menu";
	public static final String DB_TABLE_MENU_ITEM_VALUE = "MenuItem";
	public static final String DB_TABLE_CHECK_VALUE = "PosCheck";
	public static final String DB_TABLE_TABLES_VALUE = "PosTables";
	public static final String DB_TABLE_STORE_VALUE = "Store";
	public static final String DB_TABLE_TICKET_VALUE = "Ticket";
	public static final String DB_TABLE_USER_VALUE = "UserLU";
	public static final String DB_TABLE_TICKET_ITEM_VALUE = "TicketItem";
	public static final String DB_TABLE_TRANSACTION_HISTORY_VALUE = "TransactionHistory";
	
	//All class names.
	public static final String MENU_CLASS_NAME = "Menu";
	public static final String MENU_ITEM_CLASS_NAME = "MenuItem";
	public static final String TABLE_CLASS_NAME = "Table";
	public static final String TICKET_CLASS_NAME = "Ticket";
	public static final String USER_CLASS_NAME = "User";
	public static final String CHECK_CLASS_NAME = "Check";
	public static final String TICKET_ITEM_CLASS_NAME = "TicketItem";
	public static final String TRANSACTION_HISTORY_CLASS_NAME = "TransactionHistory";
	public static final String MODEL_OBJECT_CLASS_NAME = "ModelObject";
	public static final String MODELS_PACKAGE_NAME = "models.";

	public static final String TARGET_SUPER_CLASS = "java.lang.Object";
	public static final int STORE_ID_CONSTANT = 1;
	public static final int DEFAULT_SORT_VALUE = 999;
	public static final int DEFAULT_ID_VALUE = 0;
	public static final String BOOLEAN_TO_STRING_TRUE_VALUE = "1";
	public static final String BOOLEAN_TO_STRING_FALSE_VALUE = "0";

	//Column names from the database for the main object
	public static final String DB_ID_VALUE = "ID";
	public static final String DB_UUID_VALUE = "UUID";
	public static final String DB_IS_ACTIVE_VALUE = "IsActive";
	public static final String DB_SORT_VALUE_VALUE = "SortValue";

	//Menu object database column constants.
	public static final String DB_STORE_ID_VALUE = "StoreID"; 
	public static final String DB_MENU_TYPE_VALUE = "MenuType";
	public static final String DB_MENU_NAME_VALUE = "MenuName";

	//MenuItem object database column constants.
	public static final String DB_MENU_ID_VALUE = "MenuID";
	public static final String DB_ITEM_NAME_VALUE = "ItemName";
	public static final String DB_PRICE_VALUE = "Price";
	public static final String DB_PRIORITY_SCORE_VALUE = "PriorityScore";
	public static final String DB_EXECUTION_TIME_VALUE = "ExecutionTime";

	//Check object database column constants.
	public static final String DB_TABLE_ID_VALUE = "TableID";
	public static final String DB_USER_ID_VALUE = "UserID";
	public static final String DB_CHECK_STATUS_VALUE = "CheckStatus";
	public static final String DB_DATE_STARTED_VALUE = "DateStarted";
	public static final String DB_DATE_CLOSED_VALUE = "DateClosed";

	//Tables object database column constants.
	public static final String DB_TABLE_NAME_VALUE = "TableName";
	public static final String DB_TABLE_STATUS_VALUE = "TableStatus";

	//Ticket object database column constants.
	public static final String DB_TICKET_STATUS_VALUE = "TicketStatus";
	public static final String DB_TICKET_TYPE_VALUE = "TicketType";

	//User object database column constants.
	public static final String DB_USER_USERNAME_VALUE = "UserName";
	public static final String DB_USER_FIRST_NAME_VALUE = "FirstName";
	public static final String DB_USER_LAST_NAME_VALUE = "LastName";
	public static final String DB_USER_ROLEID_VALUE = "RoleID";

	//Transaction history model database column constants.
	public static final String DB_TRANSACTION_HISTORY_CHECK_ID_VALUE = "CheckID";
	public static final String DB_TRANSACTION_HISTORY_FINAL_TOTAL_VALUE = "FinalTotal";
	public static final String DB_TRANSACTION_HISTORY_PAYMENT_TYPE_VALUE = "PaymentType";
	public static final String DB_TRANSACTION_HISTORY_PAYMENT_DATE_VALUE = "PaymentDate";
	public static final String DB_TRANSACTION_HISTORY_PAYMENT_STATUS_VALUE = "PaymentStatus";

	//Ticket Item model database column constants.
	public static final String DB_TICKET_ITEM_TICKET_ID_VALUE = "TicketID";
	public static final String DB_TICKET_ITEM_MENU_ITEM_ID_VALUE = "MenuItemID";
	public static final String DB_TICKET_ITEM_ITEM_PRICE_VALUE = "ItemPrice";

	/**
	 * Next three methods are all about providing the key value pairs that are
	 * associated with getting menus from the db.
	 * @param _isActive
	 * @param _storeID
	 * @return
	 */
	public static LinkedHashMap<String, String> getReadMenuKVPairs(boolean _isActive, int _storeID) {
		LinkedHashMap<String, String> retVal = new LinkedHashMap<String,String>();
		retVal.put(DB_IS_ACTIVE_VALUE, booleanToBit(_isActive));
		retVal.put(DB_STORE_ID_VALUE, String.valueOf(_storeID));
		return retVal;
	}

	/**
	 * This is an off shoot method of the base getreadmenukvpairs but this only brings the active ones.
	 * @return
	 */
	public static LinkedHashMap<String, String> getReadActiveMenuKVPairs() {
		return getReadMenuKVPairs(true, STORE_ID_CONSTANT);
	}

	/**
	 * Next methods are all about providing the key value pairs that are
	 * associated with getting menu items from the db
	 * @param _isActive
	 * @param _menuId
	 * @return
	 */
	public static LinkedHashMap<String, String> getReadMenuItemKVPairs(boolean _isActive, int _menuId) {
		LinkedHashMap<String, String> retVal = new LinkedHashMap<String, String>();
		retVal.put(DB_MENU_ID_VALUE, String.valueOf(_menuId));
		retVal.put(DB_IS_ACTIVE_VALUE, booleanToBit(_isActive));
		return retVal;
	}

	/**
	 * This method returns the active menu items from the database from getreadmenuutemkvpairs.
	 * @param _menuId
	 * @return
	 */
	public static LinkedHashMap<String, String> getReadActiveMenuItemKVPairs(int _menuId) {
		return getReadMenuItemKVPairs(true, _menuId);
	}

	/**
	 * Next Methods are all about providing the key value pairs that are associated
	 * with getting the table items from the db.
	 * @param _isActive
	 * @param _storeId
	 * @return
	 */
	public static LinkedHashMap<String, String> getReadTableKVPairs(boolean _isActive, int _storeId) {
		LinkedHashMap<String, String> retVal = new LinkedHashMap<String, String>();
		retVal.put(DB_STORE_ID_VALUE, String.valueOf(_storeId));
		retVal.put(DB_IS_ACTIVE_VALUE, booleanToBit(_isActive));
		return retVal;
	}

	/**
	 * This method only returns the kv pairs from the active tables from the database.
	 * @return
	 */
	public static LinkedHashMap<String, String> getReadActiveTableKVPairs() {
		return getReadTableKVPairs(true, STORE_ID_CONSTANT);
	}

	/**
	 * These next functions supply the key value pairs for getting the tickets from
	 * db.
	 * @param _userId
	 * @param _tableId
	 * @param _isActive
	 * @return
	 */
	public static LinkedHashMap<String, String> getReadTicketKVPairs(int _userId, int _tableId, boolean _isActive) {
		LinkedHashMap<String, String> retVal = new LinkedHashMap<String, String>();
		retVal.put(DB_USER_ID_VALUE, String.valueOf(_userId));
		retVal.put(DB_TABLE_ID_VALUE, String.valueOf(_tableId));
		retVal.put(DB_IS_ACTIVE_VALUE, booleanToBit(_isActive));
		return retVal;
	}

	/**
	 * This method provides the kv pairs for getting the active tickets from the database.
	 * @param _userId
	 * @param _tableId
	 * @return
	 */
	public static LinkedHashMap<String, String> getReadActiveTicketKVPairs(int _userId, int _tableId) {
		return getReadTicketKVPairs(_userId, _tableId, true);
	}

	/**
	 * The next functions supply the key value pairs for getting the users from the database.
	 * @param _isActive
	 * @param _userName
	 * @return
	 */
	public static LinkedHashMap<String, String> getReadUserKVPairs(boolean _isActive, String _userName) {
		LinkedHashMap<String, String> retVal = new LinkedHashMap<String, String>();
		retVal.put(DB_IS_ACTIVE_VALUE, booleanToBit(_isActive));
		retVal.put(DB_USER_USERNAME_VALUE, _userName);
		return retVal;
	}

	/**
	 * This method provideds the kv pairs to pull active users matching the username provided.
	 * @param _userName
	 * @return
	 */
	public static LinkedHashMap<String, String> getReadActiveUserKVPairs(String _userName) {
		return getReadUserKVPairs(true, _userName);
	}

	/**
	 * The next functions supply the key value pairs for getting the tickets from the database.
	 * @param _isActive
	 * @param _tableId
	 * @param _userId
	 * @param _checkStatus
	 * @return
	 */
	public static LinkedHashMap<String, String> getReadCheckKVPairs(boolean _isActive, int _tableId, int _userId, int _checkStatus){
		LinkedHashMap<String, String> retVal = new LinkedHashMap<String, String>();
		retVal.put(DB_IS_ACTIVE_VALUE, booleanToBit(_isActive));
		retVal.put(DB_TABLE_ID_VALUE, String.valueOf(_tableId));
		retVal.put(DB_USER_ID_VALUE, String.valueOf(_userId));
		retVal.put(DB_CHECK_STATUS_VALUE, String.valueOf(_checkStatus));
		return retVal;
	}

	/**
	 * This method provides the kv pairs that return the open active checks in the database.
	 * @param _tableId
	 * @param _userId
	 * @return
	 */
	public static LinkedHashMap<String, String> getReadActiveOpenCheckKVPairs(int _tableId, int _userId) {
		return getReadCheckKVPairs(true, _tableId, _userId, ModelConstants.CHECK_TYPE_OPEN);
	}

	/**
	 * This method grabs the key value pairs for ticket items.
	 * @param _isActive
	 * @param _menuID
	 * @return
	 */
	public static LinkedHashMap<String, String> getReadTicketItemKVPairs(boolean _isActive, int _menuID) {
		LinkedHashMap<String, String> retVal = new LinkedHashMap<String, String>();
		retVal.put(DB_IS_ACTIVE_VALUE, booleanToBit(_isActive));
		retVal.put(DB_MENU_ID_VALUE, String.valueOf(_menuID));
		return retVal;
	}

	/**
	 * This method grabs the key value pairs for the active ticket items.
	 * @param _menuID
	 * @return
	 */
	public static LinkedHashMap<String, String> getReadActiveTicketItemKVPairs(int _menuID) {
		return getReadTicketItemKVPairs(true, _menuID);
	}

	/**
	 * This methods grabs the key value pairs for transaction history from the database.
	 * @param _isActive
	 * @param _userId
	 * @param _paymentStatus
	 * @return
	 */
	public static LinkedHashMap<String, String> getReadTransactionHistory(boolean _isActive, int _userId, int _paymentStatus) {
		LinkedHashMap<String, String> retVal = new LinkedHashMap<String, String>();
		retVal.put(DB_IS_ACTIVE_VALUE, booleanToBit(_isActive));
		retVal.put(DB_USER_ID_VALUE, String.valueOf(_userId));
		retVal.put(DB_TRANSACTION_HISTORY_PAYMENT_STATUS_VALUE, String.valueOf(_paymentStatus));
		return retVal;
	}

	/**
	 * This method grabs the key value pairs for active open transaction history from the database.
	 * @param _userId
	 * @return
	 */
	public static LinkedHashMap<String, String> getReadActiveOpenTransactionHistoryByUserId(int _userId) {
		return getReadTransactionHistory(true, _userId, ModelConstants.PAYMENT_STATUS_OPEN);
	}

	/**
	 * This method grabs the key value pairs for active paid transaction histories by userId.
	 * @param _userId
	 * @return
	 */
	public static LinkedHashMap<String, String> getReadPaidTransactionHistoryByUserId(int _userId) {
		return getReadTransactionHistory(true, _userId, ModelConstants.PAYMENT_STATUS_PAID);
	}

	/**
	 * This method returns a string based on the boolean provided.
	 * @param _value
	 * @return
	 */
	public static String booleanToBit(boolean _value) {
		return (_value ? BOOLEAN_TO_STRING_TRUE_VALUE : BOOLEAN_TO_STRING_FALSE_VALUE);
	}
}