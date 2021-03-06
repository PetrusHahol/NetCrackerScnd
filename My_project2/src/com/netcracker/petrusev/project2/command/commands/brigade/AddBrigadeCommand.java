package com.netcracker.petrusev.project2.command.commands.brigade;

import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.DAO.teams.DAOBrigadeImpl;
import com.netcracker.petrusev.project2.beans.entities.teams.Brigade;
import com.netcracker.petrusev.project2.command.ActionCommandInterface;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.constants.PermissionsConstants;
import com.netcracker.petrusev.project2.logger.LoggerError;
import com.netcracker.petrusev.project2.properties.LocaleData;
import com.netcracker.petrusev.project2.services.SetRequestData;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * @author Petrusev
 * @version 1.0
 *
 */
public class AddBrigadeCommand implements ActionCommandInterface {
    @Override
    public String execute(HttpServletRequest request) {
            try {
            if (request.getSession().getAttribute(CommandConstants.PRIORITY).toString().equals(PermissionsConstants.DISPATCHER)) {
                if (request.getParameter(CommandConstants.REG).equals(CommandConstants.TRUE)) {

                    Brigade brigade = new Brigade();
                    brigade.setId_first_pilot(Integer.valueOf(request.getParameter(CommandConstants.ID_FIRST_PILOT)));
                    brigade.setId_second_pilot(Integer.valueOf(request.getParameter(CommandConstants.ID_SECOND_PILOT)));
                    brigade.setId_navigator(Integer.valueOf(request.getParameter(CommandConstants.ID_NAVIGATOR)));
                    brigade.setId_radioman(Integer.valueOf(request.getParameter(CommandConstants.ID_RADIOMAN)));
                    brigade.setId_stewardess(Integer.valueOf(request.getParameter(CommandConstants.ID_STEWARDESS)));
                    brigade.setId_flight(Integer.valueOf(request.getParameter(CommandConstants.ID_FLIGHT)));
                    DAOInterface<Brigade> daoBrigade = new DAOBrigadeImpl();
                    daoBrigade.create(brigade);
                    request.setAttribute(CommandConstants.MESSAGE, LocaleData.INSTANCE.getProperty(CommandConstants.ADD_BRIGADE));

                } else {
                    SetRequestData requestData = new SetRequestData();
                    requestData.setEmployee(request);
                    requestData.setFlight(request);
                    return PageConstants.ADDBRIGADE;
                }
            }
        } catch (SQLException ex) {
            request.setAttribute(CommandConstants.MESSAGE, LocaleData.INSTANCE.getProperty(CommandConstants.DONT_ADD_BRIGADE));
            LoggerError.INSTANCE.logError(AddBrigadeCommand.class, ex.getMessage());
            return PageConstants.ADDBRIGADE;

        }
        return PageConstants.USER_CONTENT;
    }
}
