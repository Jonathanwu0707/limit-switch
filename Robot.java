package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Robot extends TimedRobot {
  public Joystick joy1 = new Joystick(0);
  public VictorSPX motor = new VictorSPX(2);
  public TalonSRX talon = new TalonSRX(9);
  public DigitalInput up_limit_switch = new DigitalInput(9);
  public DigitalInput down_limit_switch = new DigitalInput(0);
  public SupplyCurrentLimitConfiguration  supplyCurrentLimitConfiguration = new SupplyCurrentLimitConfiguration(true, 30, 40, 1);

  @Override
  public void robotInit() {
  motor.follow(talon);
  }

  @Override
  public void robotPeriodic() {
  }

  
  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
 
  }

  @Override
  public void teleopPeriodic() {
   double output = -joy1.getY(); //Moves the joystick based on Y value
       
   talon.configSupplyCurrentLimit(supplyCurrentLimitConfiguration);
   
   if (up_limit_switch.get()||down_limit_switch.get()){ 
     output = 0;
   }
    else if(joy1.getRawButton(4)){
     output = 0.5;
   } 
   else if(joy1.getRawButton(5)){
     output = -0.5;
   }
      talon.set(ControlMode.PercentOutput,output);
      SmartDashboard.putNumber("output", output);
     
      
    }
 
    

  @Override
  public void testPeriodic() {
  }
}
