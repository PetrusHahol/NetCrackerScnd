package com.netcracker.petrusev.project2.command.finder;

import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.command.enums.RequestsEnum;
import com.netcracker.petrusev.project2.command.commands.MainCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Asus on 10.11.2016.
 */
public class FindRequest {
    public ActionCommand Command(HttpServletRequest request){
        String command = request.getParameter(CommandConstants.COMMAND);
        ActionCommand current = null;
        try {
            RequestsEnum currentEnum = RequestsEnum.valueOf(command.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            current = new MainCommand();
        }
        return current;
    }
}
