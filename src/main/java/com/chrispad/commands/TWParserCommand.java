package com.chrispad.commands;

import java.text.SimpleDateFormat;

public class TWParserCommand extends AbstractCommand {

    @Override
    public SimpleDateFormat getDateFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf;
    }

}
