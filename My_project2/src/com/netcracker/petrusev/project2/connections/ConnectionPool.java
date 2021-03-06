package com.netcracker.petrusev.project2.connections;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @author Petrusev
 * @version 1.0
 *
 */
public enum ConnectionPool {
    INSTANCE;
    private static final int UPPER_BOUND_COUNT = 100;

    private static String url;
    private  Vector<Connection> availableConns = new Vector<Connection>();
    private  Vector<Connection> usedConns = new Vector<Connection>();
    private JDBC jdbc = new JDBC();

    public synchronized Connection retrieve() throws SQLException {

        Connection newConn = null;
        if (usedConns.size() > UPPER_BOUND_COUNT) {
            throw new SQLException("Limit open connections");
        }
        if (availableConns.size() == 0) {
            newConn = getConnection();
        } else {
            newConn = (Connection) availableConns.lastElement();
            availableConns.removeElement(newConn);
        }
        usedConns.addElement(newConn);
        return newConn;
    }

    public synchronized void putBack(Connection c) throws NullPointerException {
        if (c != null) {
            if (usedConns.removeElement(c)) {
                availableConns.addElement(c);
            } else {
                throw new NullPointerException("Error connection");
            }
        }
    }

    public int getAvailableConnsCnt() {
        return availableConns.size();
    }
    private Connection getConnection() {
        return jdbc.getConnection();
    }

}