package com.burning8393.command;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Content c = new Content();

        InsertCommand insertCommand = new InsertCommand(c);
        insertCommand.doit();
        insertCommand.undo();
        System.out.println(c.msg);

        CopyCommand copyCommand = new CopyCommand(c);
        copyCommand.doit();
        copyCommand.undo();
        System.out.println(c.msg);

        DeleteCommand deleteCommand = new DeleteCommand(c);
        deleteCommand.doit();
        deleteCommand.undo();
        System.out.println(c.msg);

        List<Command> commands = new ArrayList<>();
        commands.add(new InsertCommand(c));
        commands.add(new CopyCommand(c));
        commands.add(new DeleteCommand(c));

        for (Command command : commands) {
            command.doit();
        }

        System.out.println(c.msg);

        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }

        System.out.println(c.msg);
    }
}
