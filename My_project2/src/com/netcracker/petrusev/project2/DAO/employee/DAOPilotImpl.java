package com.netcracker.petrusev.project2.DAO.employee;

import com.netcracker.petrusev.project2.DAO.DAOEmployeeImpl;
import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.beans.entities.office.Employee;
import com.netcracker.petrusev.project2.beans.entities.office.Pilot;
import com.netcracker.petrusev.project2.connections.ConnectionPool;
import com.netcracker.petrusev.project2.connections.DataMemory;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.SQLConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Petrusev
 * @version 1.0
 *
 */
public class DAOPilotImpl implements DAOInterface<Pilot> {
    @Override
    public void create(Pilot obj) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.ADD_PILOT);
        DAOInterface<Employee> daoInformation = new DAOEmployeeImpl();
        daoInformation.create(obj);
        statement.setInt(1, obj.getMileage());
        statement.setInt(2 , DataMemory.INSTANCE.getId());
        statement.execute();
        statement.close();
        ConnectionPool.INSTANCE.putBack(connection);
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.DELETE_PILOT);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            DAOInterface<Employee> daoInformation = new DAOEmployeeImpl();
            daoInformation.delete(Integer.valueOf(set.getString(CommandConstants.ID_INFORMATION)));
        }
        set.close();
        statement.close();
        ConnectionPool.INSTANCE.putBack(connection);
    }

    @Override
    public Pilot find(Integer id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.FIND_PILOT);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        Pilot pilot = new Pilot();
        while(set.next()){
            DAOInterface<Employee> daoInformation = new DAOEmployeeImpl();
            daoInformation.find(Integer.valueOf(set.getString(CommandConstants.ID_INFORMATION)));
            Employee employee =(Employee) daoInformation.find(Integer.valueOf(set.getString(CommandConstants.ID_INFORMATION)));
            pilot.setName(employee.getName());
            pilot.setAge(employee.getAge());
            pilot.setExperience(employee.getExperience());
            pilot.setHeight(employee.getHeight());
            pilot.setPassportData(employee.getPassportData());
            pilot.setMileage(set.getInt(CommandConstants.MILEAGE));
        }
        ConnectionPool.INSTANCE.putBack(connection);
        set.close();
        statement.close();
        return pilot;
    }

    @Override
    public void update(Pilot obj) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Pilot> getAllData() throws SQLException {
        List<Pilot> answer = new ArrayList<>();
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_PILOT);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            DAOInterface daoInformation = new DAOEmployeeImpl();
            Pilot pilot = new Pilot();
            Employee employee = (Employee) daoInformation.find(set.getInt(CommandConstants.ID_INFORMATION));
            pilot.setName(employee.getName());
            pilot.setAge(employee.getAge());
            pilot.setExperience(employee.getExperience());
            pilot.setHeight(employee.getHeight());
            pilot.setPassportData(employee.getPassportData());
            pilot.setMileage(set.getInt(CommandConstants.MILEAGE));
            pilot.setId(set.getInt(CommandConstants.ID));
            answer.add(pilot);
        }
        ConnectionPool.INSTANCE.putBack(connection);
        set.close();
        statement.close();
        return answer;
    }

    @Override
    public Pilot find(Pilot obj) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
