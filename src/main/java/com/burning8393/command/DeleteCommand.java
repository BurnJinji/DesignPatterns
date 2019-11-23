package com.burning8393.command;

public class DeleteCommand extends Command {
    Content c;
    String delete;

    public DeleteCommand(Content c) {
        this.c = c;
    }

    @Override
    public void doit() {
        delete = c.msg.substring(0, 5);
        c.msg = c.msg.substring(5, c.msg.length());
    }

    @Override
    public void undo() {
        c.msg = delete + c.msg;
    }
}
