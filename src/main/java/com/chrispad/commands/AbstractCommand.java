package com.chrispad.commands;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public abstract class AbstractCommand implements Command {

    public static final String DATE_STRING = "date_string";

    public static final String PARSED_DATE = "parsed_date";

    public abstract SimpleDateFormat getDateFormat();

    public boolean execute(Map<String, Object> context) {

        boolean flag = true;

        String dateStr = (String) context.get(DATE_STRING);

        SimpleDateFormat sdf = getDateFormat();

        try {

            Date parsedDate = sdf.parse(dateStr);

            context.put(PARSED_DATE, parsedDate);

        } catch (ParseException p) {

            flag = false;

        }


        return flag;
    }

}
