package com.reagroup.app.factory;

import com.reagroup.app.model.command.CommandFactory;

public class FactoryProvider {
    public static AbstractFactory getFactory(String choice){
        if("Command".equalsIgnoreCase(choice)){
            return new CommandFactory();
        }
        return null;
    }
}