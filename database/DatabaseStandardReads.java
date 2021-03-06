package database;

/**
 * This class offers quick methods that pull back basic reads from the database.
 * @author Ian Wilhelmsen
 * last updated: 4/30/2020
 */
import java.util.ArrayList;
import models.*;

public class DatabaseStandardReads {
	/**
	 * This method returns Menus with their MenuItems attached
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Menu> getFilledListOfMenus() throws ClassNotFoundException {
		ArrayList<Menu> retVal = new ArrayList<Menu>();
		Menu targetObject = new Menu();
		ArrayList<ModelObject> tempRetVal = DataStoreAdapter.readObject(DatabaseConstants.getReadActiveMenuKVPairs(),
				targetObject);
		// For each member cast each to the Menu class and assign each it's menu items
		for (ModelObject currObj : tempRetVal) {
			Menu currMenu = (Menu) currObj;
			currMenu.setItems(getListOfMenuItemsByMenuId(currMenu.getId()));
			retVal.add(currMenu);
		}

		return retVal;
	}

	/**
	 * This method returns the active menu items of a menu based off the menuId.
	 * 
	 * @param _menuId
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<MenuItem> getListOfMenuItemsByMenuId(int _menuId) throws ClassNotFoundException {
		ArrayList<MenuItem> retVal = new ArrayList<MenuItem>();
		MenuItem targetObject = new MenuItem();
		ArrayList<ModelObject> tempRetVal = DataStoreAdapter
				.readObject(DatabaseConstants.getReadActiveMenuItemKVPairs(_menuId), targetObject);
		// Cast each member to the MenuItem class.
		for (ModelObject currObj : tempRetVal) {
			retVal.add((MenuItem) currObj);
		}
		return retVal;
	}

	/**
	 * This method returns the tables from database.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Table> getListOfTables() throws ClassNotFoundException {
		ArrayList<Table> retVal = new ArrayList<Table>();
		Table targetObject = new Table();
		ArrayList<ModelObject> tempRetVal = DataStoreAdapter.readObject(DatabaseConstants.getReadActiveTableKVPairs(),
				targetObject);
		// Cast each member as a Table.
		for (ModelObject currObj : tempRetVal) {
			retVal.add((Table) currObj);
		}
		return retVal;
	}

	/**
	 * This methods returns the tickets by the user id and table id.
	 * 
	 * @param _userId
	 * @param _tableId
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Ticket> getListOfTicketsByUserIdTableId(int _userId, int _tableId)
			throws ClassNotFoundException {
		ArrayList<Ticket> retVal = new ArrayList<Ticket>();
		Ticket targetObject = new Ticket();
		ArrayList<ModelObject> tempRetVal = DataStoreAdapter
				.readObject(DatabaseConstants.getReadActiveTicketKVPairs(_userId, _tableId), targetObject);
		for (ModelObject currObj : tempRetVal) {
			retVal.add((Ticket) currObj);
		}
		return retVal;
	}

	/**
	 * This methods returns the users who match the username provided.
	 * 
	 * @param _userName
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<User> getListOfUsersByUserNames(String _userName) throws ClassNotFoundException {
		ArrayList<User> retVal = new ArrayList<User>();
		User targetObject = new User();
		ArrayList<ModelObject> tempRetVal = DataStoreAdapter
				.readObject(DatabaseConstants.getReadActiveUserKVPairs(_userName), targetObject);
		for (ModelObject currObj : tempRetVal) {
			retVal.add((User) currObj);
		}
		return retVal;
	}

	/**
	 * This method returns the active checks of a user id and a table id.
	 * 
	 * @param _userId
	 * @param _tableId
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Check> getCheckByUserIdTableId(int _userId, int _tableId) throws ClassNotFoundException {
		ArrayList<Check> retVal = new ArrayList<Check>();
		Check targetObject = new Check();
		ArrayList<ModelObject> tempRetVal = DataStoreAdapter
				.readObject(DatabaseConstants.getReadActiveOpenCheckKVPairs(_userId, _tableId), targetObject);
		for (ModelObject currObj : tempRetVal) {
			retVal.add((Check) currObj);
		}
		return retVal;
	}
}