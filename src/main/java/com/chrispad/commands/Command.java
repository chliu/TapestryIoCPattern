package com.chrispad.commands;

import java.text.ParseException;
import java.util.Map;

public interface Command {

    public boolean execute(Map<String, Object> context);

}
