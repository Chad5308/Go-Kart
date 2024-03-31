package frc.robot.commands;

import edu.wpi.first.math.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Drive;

public class DriveCommand extends Command{

    public Drive drive;
    public CommandXboxController controller;
    public boolean inPlace = false;

    public double cruiseXSpeed = 0;
    public boolean cruiseControl;

    public DriveCommand(Drive drive){
        this.drive = drive;
        controller = new CommandXboxController(0);
        addRequirements(drive);
    }


    @Override
    public void execute(){


        if(cruiseControl){
            drive.drive(cruiseXSpeed, -1*controller.getRightX(), inPlace);
        }else{
            drive.drive(-1*controller.getLeftY(), -1*controller.getRightX(), inPlace);
        }
    }

    public void increaseSpeed(){
        cruiseXSpeed += 0.1;
    }

    public void decreaseSpeed(){
        cruiseXSpeed -= 0.1;
    }

    public void resetSpeed(){
        cruiseXSpeed = 0;
    }

    public void cruiseControl(){
        cruiseControl = !cruiseControl;
        resetSpeed();
    }

    public void resume(){
        cruiseControl = true;
    }

    public void cancel(){
        cruiseControl = false;
    }


    public void inPlace(){
      inPlace = !inPlace;
    }


    
}
