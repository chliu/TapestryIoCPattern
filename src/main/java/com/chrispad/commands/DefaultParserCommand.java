package com.chrispad.commands;


import java.text.SimpleDateFormat;

public class DefaultParserCommand extends AbstractCommand {

    @Override
    public SimpleDateFormat getDateFormat() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");

        return sdf;

    }
}
