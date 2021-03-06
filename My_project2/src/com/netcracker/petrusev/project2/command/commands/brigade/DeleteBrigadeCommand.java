package com.netcracker.petrusev.project2.command.commands.brigade;

import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.DAO.teams.DAOBrigadeImpl;
import com.netcracker.petrusev.project2.beans.entities.teams.Brigade;
import com.netcracker.petrusev.project2.command.ActionCommandInterface;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.properties.LocaleData;
import com.netcracker.petrusev.project2.logger.LoggerError;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


/**
 * @author Petrusev
 * @version 1.0
 *
 */
public class DeleteBrigadeCommand implements ActionCommandInterface {
    @Override
    public String execute(HttpServletRequest request) {
        try {
            DAOInterface<Brigade> daoBrigade = new DAOBrigadeImpl();
            daoBrigade.delete(Integer.valueOf(request.getParameter(CommandConstants.ID)));
            request.setAttribute(CommandConstants.MESSAGE, LocaleData.INSTANCE.getProperty(CommandConstants.DELETE_BRIGADE));
            return PageConstants.USER_CONTENT;
        }
        catch (SQLException ex){
            request.setAttribute(CommandConstants.MESSAGE, LocaleData.INSTANCE.getProperty(CommandConstants.DONT_DELETE_BRIGADE));
            LoggerError.INSTANCE.logError(DeleteBrigadeCommand.class, ex.getMessage());
            return PageConstants.USER_CONTENT;
        }
    }
}
