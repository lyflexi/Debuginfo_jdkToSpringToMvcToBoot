package org.lyflexi.commandPattern;

/**
 * @Author: ly
 * @Date: 2024/4/25 9:02
 */

public class LsCommand implements ICommand {
    private LinuxSystem linuxSystem;

    public LsCommand(LinuxSystem linuxSystem) {
        this.linuxSystem = linuxSystem;
    }

    @Override
    public void execute() {
        linuxSystem.ls();
    }
}
