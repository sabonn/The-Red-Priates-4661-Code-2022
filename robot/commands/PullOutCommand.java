package frc.robot.commands;

import static frc.robot.Robot.m_robotContainer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

public class PullOutCommand extends CommandBase{
    static boolean interrupted = false;
    @Override
    public void initialize() {
        addRequirements(m_robotContainer.getClimbingSubSystem());
    }
    @Override
    public void execute() {
        if(m_robotContainer.getClimbingSubSystem().getSwitch() && !interrupted)//pulling the string to climb until the limit switch tells us to stop
            m_robotContainer.getClimbingSubSystem().pull(-Constants.Climb.PullUpPower);
        else
        {
            interrupted = true;//stoping the entire command using the WPILib.
            end(true);
        }
    }
    @Override
    public void end(boolean interrupted) {
        m_robotContainer.getClimbingSubSystem().stop();
    }
}
