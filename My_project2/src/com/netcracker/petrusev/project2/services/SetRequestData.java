package com.netcracker.petrusev.project2.services;

import com.netcracker.petrusev.project2.DAO.DAOFlightImpl;
import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.DAO.employee.*;
import com.netcracker.petrusev.project2.DAO.teams.DAOBrigadeImpl;
import com.netcracker.petrusev.project2.beans.entities.office.Navigator;
import com.netcracker.petrusev.project2.beans.entities.office.Pilot;
import com.netcracker.petrusev.project2.beans.entities.office.Radioman;
import com.netcracker.petrusev.project2.beans.entities.office.Stewardess;
import com.netcracker.petrusev.project2.beans.entities.teams.Brigade;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.EntityConstants;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

/**
 * @author Petrusev
 * @version 1.0
 *
 */
public class SetRequestData {


    public void setFlight(HttpServletRequest request) throws SQLException {
        DAOFlightImpl daoFlight = new DAOFlightImpl();
        request.setAttribute(CommandConstants.FLIGHT, daoFlight.getAllData());
        request.setAttribute(CommandConstants.DATE, Calendar.DATE);
        request.setAttribute(CommandConstants.YEAR, Calendar.YEAR);
        request.setAttribute(CommandConstants.MONTH, Calendar.MONTH);
    }

    public void setEmployee(HttpServletRequest request) throws SQLException{
        DAOInterface<Stewardess> daoStewardess = new DAOStewardessImpl();
        List<Stewardess> stewardesses = daoStewardess.getAllData();
        DAOInterface<Pilot> daoPilot = new DAOPilotImpl();
        List<Pilot> pilots = daoPilot.getAllData();
        DAOInterface<Navigator> daoNavigator = new DAONavigatorImpl();
        List<Navigator> navigators = daoNavigator.getAllData();
        DAOInterface<Radioman>  daoRadioman = new DAORadiomanImpl();
        List<Radioman> radiomans = daoRadioman.getAllData();
        request.setAttribute(EntityConstants.RADIOMAN, radiomans);
        request.setAttribute(EntityConstants.PILOT, pilots);
        request.setAttribute(EntityConstants.STEWARDESS, stewardesses);
        request.setAttribute(EntityConstants.NAVIGATOR , navigators);
    }

    public void setBrigades(HttpServletRequest request) throws  SQLException{
        DAOInterface<Brigade> daoBrigade = new DAOBrigadeImpl();
        List<Brigade> brigades = daoBrigade.getAllData();
        request.setAttribute(CommandConstants.BRIGADES, brigades);
    }
}
