package org.lyflexi.commandPattern;

/**
 * @Author: ly
 * @Date: 2024/4/25 9:03
 */

public class RestartCommand implements ICommand {
    private LinuxSystem linuxSystem;

    public RestartCommand(LinuxSystem linuxSystem) {
        this.linuxSystem = linuxSystem;
    }

    @Override
    public void execute() {
        this.linuxSystem.restart();
    }
}

