package org.lyflexi.commandPattern;

/**
 * @Author: ly
 * @Date: 2024/4/25 9:02
 */

public class CdCommand implements ICommand {
    private LinuxSystem linuxSystem;

    public CdCommand(LinuxSystem linuxSystem) {
        this.linuxSystem = linuxSystem;
    }

    @Override
    public void execute() {
        linuxSystem.cd();
    }
}

