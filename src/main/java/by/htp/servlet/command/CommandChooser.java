package by.htp.servlet.command;

import by.htp.servlet.FillAndChooseAction;

/**
 * This class serves for choose user action
 * 
 * @author Anton Mazets
 * @version 1.0
 */
public class CommandChooser {
	/**
	 * This method receive string with user action from web page and returns new
	 * instance of required object
	 * 
	 * @param action
	 * @return
	 */

	public static CommandAction chooseAction(String action) {

		FillAndChooseAction currentAction = new FillAndChooseAction();
		return currentAction.map().get(action);
	}

}
