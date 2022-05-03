// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: SequentialCommandGroup.

package robot.commands.auto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import robot.commands.*;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import robot.subsystems.drivetrainSubSys;
import robot.subsystems.payloadSubSys;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class autoDoubleCenterCmdGrp extends SequentialCommandGroup {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    public autoDoubleCenterCmdGrp(drivetrainSubSys drivetrainSubSys, payloadSubSys payloadSubSys){

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    addCommands(
        // Add Commands here:
        // Also add parallel commands using the
        //
        // addCommands(
        //      new command1(argsN, subsystem),
        //      parallel(
        //          new command2(argsN, subsystem),
        //          new command3(argsN, subsystem)
        //      )    
        //  );

        // ***************************************************************
        // **** Line up the robot parallel with the left outside line ****
        // ***************************************************************

        // Reset Gyro and Encoders prior to auto run
        new resetGyroCmd(drivetrainSubSys),
        new clearEncodersCmd(drivetrainSubSys),
        
        // Extend the intake mechanism
        new intakeExtendCmd(payloadSubSys),
       
        // Drive reverse with a large reverse clockwise arc to get ball
        // driveSwingTurnCmd(speed, rotation, dist, hdg, mode, brakeFlag, timeOut, subsystem)
        new driveSwingTurnCmd(-0.20, 0.42, -56, 0, "DIST", false, 7, drivetrainSubSys),

        // Drive backwards 8 inches after reverse arc 
        new driveCmd(-8.0, -0.4, 0, "CURRENT_HEADING", 3, true, drivetrainSubSys),
        
        // delay for ball intaking
        new delayCmd(1),

        // Retract intake mechanism
        new intakeRetractCmd(payloadSubSys),

        // Delay to make sure intake gets up before rotating the robot
        new delayCmd(1),

        // clear the gyro for the pickly little point turn in the next few lines
        new resetGyroCmd(drivetrainSubSys),

        // Point turn towards the goal
        new drivePointTurnCmd(-0.2, -50, true, 5, drivetrainSubSys),

        // Drive forward to the goal
        new driveCmd(60, 0.5, 0, "CURRENT_HEADING", 10, true, drivetrainSubSys),

        new resetGyroCmd(drivetrainSubSys),
        
        new drivePointTurnCmd(0.2, 18, true, 3, drivetrainSubSys),

        new driveCmd(16, 0.5, 0, "CURRENT_HEADING", 3, true, drivetrainSubSys),

        new shooterFireCmd(payloadSubSys)

        /*
        // Drive forward with a tighter turn radius
        new driveSwingTurnCmd(0.20, -0.42, 52, 0, "DIST", false, 7, drivetrainSubSys),

        // Add some distance towards the center of the goal
        new driveCmd(8, 0.5, 0, "CURRENT_HEADING", 5, false, drivetrainSubSys),
        
        // Drive a small 20" arc to line up for shooring the ball straight in
        new driveSwingTurnCmd(0.25, 0.4, 12, 0, "DIST", false, 6, drivetrainSubSys),

        // Drive forwards 12 inches in order to get closer to the fender for a better shot
        new driveCmd(16, 0.4, 0, "CURRENT_HEADING", 3, true, drivetrainSubSys),

        // Point turn to angle more towards the goal
        new drivePointTurnCmd(0.3, 22.5, true, 3, drivetrainSubSys),

        // were there so shoot the ball
        new shooterFireCmd(payloadSubSys)
        */
        );
    }

    @Override
    public boolean runsWhenDisabled() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
        return false;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DISABLED
    }
}















        // DOUBLE LEFT ROUTINE
        /*
        parallel(
            new intakeExtendCmd(payloadSubSys),
            new driveCmd(-57, -0.5, 0, "CURRENT_HEADING", 6, true, drivetrainSubSys)
        ),
        new delayCmd(2.0),
        new intakeRetractOnCmd( payloadSubSys),
        new intakeRetractOffCmd(true, payloadSubSys),

        new driveCmd(57, 0.5, 0, "CURRENT_HEADING", 6, true, drivetrainSubSys),
        new drivePointTurnCmd(-0.15, -10.0, true, 5, drivetrainSubSys),

        new shooterFireOnCmd(true, payloadSubSys)
        */