package com.netcracker.petrusev.project2.beans.utils;

import java.util.Scanner;

/**
 * Created by Asus on 26.10.2016.
 */
public class ExecutedUtils {


    public int tryParse(String string){
        int answer = -1;
        try {
            answer = Integer.parseInt(string);
        }catch (NumberFormatException e) {
            System.err.println("Wrong Format");
        }
        return answer;
    }

    public int handler(String type, int lowerData, int upperData){
        int result = -1;
        Scanner input = new Scanner(System.in);
        while (result == -1) {

            result  = -1;
            while (result == -1){
                result = tryParse(input.nextLine());
                if (result < lowerData || result > upperData) {

                    result = -1;
                }
            }
        }
        return result;
    }

}
