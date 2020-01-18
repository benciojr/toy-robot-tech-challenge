package com.reagroup.app.model.command;

import com.reagroup.app.exception.AttemptToNavigateBeyondBoundaryException;

public interface Command {
    public void execute() throws AttemptToNavigateBeyondBoundaryException;
}
