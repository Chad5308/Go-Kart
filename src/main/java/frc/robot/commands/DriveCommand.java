package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Drive;

public class DriveCommand extends Command{

    public Drive drive;
    public CommandXboxController controller;
    public boolean inPlace = false;

    public DriveCommand(Drive drive){
        this.drive = drive;
        controller = new CommandXboxController(0);
    }


    @Override
    public void execute(){
        drive.drive(controller.getLeftY(), controller.getRightX(), inPlace);
    }


    public void inPlace(){
      inPlace = !inPlace;
    }


    
}
