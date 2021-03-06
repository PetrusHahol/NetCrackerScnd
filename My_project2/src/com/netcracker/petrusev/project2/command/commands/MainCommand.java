package com.netcracker.petrusev.project2.command.commands;
import com.netcracker.petrusev.project2.command.ActionCommandInterface;
import com.netcracker.petrusev.project2.command.commands.brigade.AddBrigadeCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.logger.LoggerError;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Petrusev
 * @version 1.0
 *
 */
public class MainCommand implements ActionCommandInterface {

 @Override
 public String execute(HttpServletRequest request) {
  try {
   if (request.getSession().getAttribute(CommandConstants.LOGIN).toString() != null)
    return PageConstants.USER_CONTENT_REQUEST;
  } catch (Exception ex) {
    LoggerError.INSTANCE.logError(AddBrigadeCommand.class, ex.getMessage());
    return PageConstants.MAIN;
  }
  return PageConstants.MAIN;
 }
}