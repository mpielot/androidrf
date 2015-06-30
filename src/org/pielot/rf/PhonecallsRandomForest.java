

package org.pielot.rf;

import java.util.List;

public class PhonecallsRandomForest extends RandomForest {

public double Hour;
public double ScreenOn;
public double TimeSinceLastCall;
public double ChargingChangedMin;
public double LastCallPicked;
public double Charging;
public double Proximity;
public String RingerMode;
public double CalledHowManyTimes;
public double Pitch;
public double ScreenChangedMin;
public double RingerModeChangedMin;
public double Day;
public double MaxAcc;

public String toString() {
StringBuilder b = new StringBuilder();
b.append("MyClass: ");
b.append(MyClass);
b.append(", Hour: ");
b.append(Hour);
b.append(", ScreenOn: ");
b.append(ScreenOn);
b.append(", TimeSinceLastCall: ");
b.append(TimeSinceLastCall);
b.append(", ChargingChangedMin: ");
b.append(ChargingChangedMin);
b.append(", LastCallPicked: ");
b.append(LastCallPicked);
b.append(", Charging: ");
b.append(Charging);
b.append(", Proximity: ");
b.append(Proximity);
b.append(", RingerMode: ");
b.append(RingerMode);
b.append(", CalledHowManyTimes: ");
b.append(CalledHowManyTimes);
b.append(", Pitch: ");
b.append(Pitch);
b.append(", ScreenChangedMin: ");
b.append(ScreenChangedMin);
b.append(", RingerModeChangedMin: ");
b.append(RingerModeChangedMin);
b.append(", Day: ");
b.append(Day);
b.append(", MaxAcc: ");
b.append(MaxAcc);
return b.toString();
}

protected void runClassifiers(List<Prediction> predictions) {
	predictions.add(runTree0());
	predictions.add(runTree1());
	predictions.add(runTree2());
	predictions.add(runTree3());
	predictions.add(runTree4());
	predictions.add(runTree5());
	predictions.add(runTree6());
	predictions.add(runTree7());
	predictions.add(runTree8());
	predictions.add(runTree9());
}

private Prediction runTree0() {
	if( "Normal".equals(RingerMode) ) { 
	if( RingerModeChangedMin >= 0.56 ) { 
	if( LastCallPicked >= 0.5 ) { 
	if( CalledHowManyTimes < 283 ) { 
	if( CalledHowManyTimes < 149.5 ) { 
	if( ScreenOn >= 0.5 ) { 
		if( Hour >= 8.5 ) { return new Prediction("Picked", 523, 164); }
		if( Hour < 8.5 ) { return new Prediction("Baseline", 36, 11); }
	}
	if( ScreenOn < 0.5 ) { 
		if( ScreenChangedMin < 5.4 ) { return new Prediction("Picked", 687, 46); }
		if( ScreenChangedMin >= 5.4 ) { return new Prediction("Baseline", 92, 41); }
	}
	}
	if( CalledHowManyTimes >= 149.5 ) { 
	if( RingerModeChangedMin >= 12.39 ) { 
		if( CalledHowManyTimes >= 227.5 ) { return new Prediction("Picked", 16, 0); }
		if( CalledHowManyTimes < 227.5 ) { return new Prediction("Picked", 43, 15); }
	}
	if( RingerModeChangedMin < 12.39 ) { 
		if( MaxAcc < 0.06 ) { return new Prediction("Baseline", 10, 0); }
		if( MaxAcc >= 0.06 ) { return new Prediction("Picked", 4, 1); }
	}
	}
	}
	if( CalledHowManyTimes >= 283 ) { 
	if( ChargingChangedMin >= 17.16 ) { 
	if( CalledHowManyTimes >= 362 ) { 
		if( CalledHowManyTimes >= 575 ) { return new Prediction("Baseline", 2, 0); }
		if( CalledHowManyTimes < 575 ) { return new Prediction("Picked", 7, 0); }
	}
		if( CalledHowManyTimes < 362 ) { return new Prediction("Baseline", 3, 0); }
	}
	if( ChargingChangedMin < 17.16 ) { 
	if( RingerModeChangedMin < 6.78 ) { 
		if( Hour >= 10 ) { return new Prediction("Baseline", 4, 0); }
		if( Hour < 10 ) { return new Prediction("Picked", 1, 0); }
	}
		if( RingerModeChangedMin >= 6.78 ) { return new Prediction("Baseline", 12, 0); }
	}
	}
	}
	if( LastCallPicked < 0.5 ) { 
	if( ScreenOn >= 0.5 ) { 
	if( ScreenChangedMin >= 1.26 ) { 
	if( MaxAcc < 0.26 ) { 
		if( ChargingChangedMin < 164.58 ) { return new Prediction("Baseline", 41, 16); }
		if( ChargingChangedMin >= 164.58 ) { return new Prediction("Picked", 15, 2); }
	}
		if( MaxAcc >= 0.26 ) { return new Prediction("Picked", 31, 0); }
	}
	if( ScreenChangedMin < 1.26 ) { 
	if( MaxAcc >= 0.22 ) { 
		if( MaxAcc < 3.81 ) { return new Prediction("Picked", 43, 14); }
		if( MaxAcc >= 3.81 ) { return new Prediction("Baseline", 34, 5); }
	}
	if( MaxAcc < 0.22 ) { 
		if( Hour >= 12.5 ) { return new Prediction("Baseline", 144, 13); }
		if( Hour < 12.5 ) { return new Prediction("Baseline", 86, 26); }
	}
	}
	}
	if( ScreenOn < 0.5 ) { 
	if( RingerModeChangedMin >= 205.76 ) { 
	if( ScreenChangedMin < 21.67 ) { 
		if( CalledHowManyTimes < 37 ) { return new Prediction("Picked", 52, 3); }
		if( CalledHowManyTimes >= 37 ) { return new Prediction("Baseline", 3, 0); }
	}
		if( ScreenChangedMin >= 21.67 ) { return new Prediction("Baseline", 3, 0); }
	}
	if( RingerModeChangedMin < 205.76 ) { 
	if( CalledHowManyTimes < 122.5 ) { 
		if( TimeSinceLastCall < 1.49 ) { return new Prediction("Baseline", 21, 3); }
		if( TimeSinceLastCall >= 1.49 ) { return new Prediction("Picked", 218, 38); }
	}
	if( CalledHowManyTimes >= 122.5 ) { 
		if( Hour >= 18.5 ) { return new Prediction("Picked", 13, 2); }
		if( Hour < 18.5 ) { return new Prediction("Baseline", 68, 10); }
	}
	}
	}
	}
	}
	if( RingerModeChangedMin < 0.56 ) { 
		if( ChargingChangedMin < 8.62 ) { return new Prediction("Baseline", 26, 0); }
	if( ChargingChangedMin >= 8.62 ) { 
		if( Day >= 3.5 ) { return new Prediction("Picked", 2, 0); }
		if( Day < 3.5 ) { return new Prediction("Baseline", 4, 0); }
	}
	}
	}
	if( "Silent".equals(RingerMode) ) { 
		if( ChargingChangedMin >= 453.91 ) { return new Prediction("Baseline", 24, 0); }
	if( ChargingChangedMin < 453.91 ) { 
	if( ScreenChangedMin < 8.88 ) { 
	if( Pitch < -12.5 ) { 
	if( MaxAcc < 2.17 ) { 
		if( CalledHowManyTimes >= 194 ) { return new Prediction("Baseline", 7, 0); }
	if( CalledHowManyTimes < 194 ) { 
		if( ScreenChangedMin >= 2.61 ) { return new Prediction("Picked", 9, 0); }
		if( ScreenChangedMin < 2.61 ) { return new Prediction("Picked", 53, 22); }
	}
	}
		if( MaxAcc >= 2.17 ) { return new Prediction("Baseline", 5, 0); }
	}
	if( Pitch >= -12.5 ) { 
	if( ChargingChangedMin >= 83.34 ) { 
		if( TimeSinceLastCall < 2.51 ) { return new Prediction("Baseline", 12, 0); }
	if( TimeSinceLastCall >= 2.51 ) { 
		if( ScreenChangedMin >= 0.76 ) { return new Prediction("Picked", 23, 6); }
		if( ScreenChangedMin < 0.76 ) { return new Prediction("Baseline", 10, 1); }
	}
	}
	if( ChargingChangedMin < 83.34 ) { 
	if( ScreenChangedMin >= 0.05 ) { 
		if( ScreenChangedMin >= 0.55 ) { return new Prediction("Baseline", 58, 5); }
		if( ScreenChangedMin < 0.55 ) { return new Prediction("Baseline", 50, 0); }
	}
	if( ScreenChangedMin < 0.05 ) { 
		if( Day < 5 ) { return new Prediction("Picked", 6, 0); }
		if( Day >= 5 ) { return new Prediction("Baseline", 3, 0); }
	}
	}
	}
	}
	if( ScreenChangedMin >= 8.88 ) { 
		if( Pitch >= -127.5 ) { return new Prediction("Baseline", 45, 0); }
	if( Pitch < -127.5 ) { 
		if( ChargingChangedMin >= 57.72 ) { return new Prediction("Baseline", 5, 0); }
		if( ChargingChangedMin < 57.72 ) { return new Prediction("Picked", 1, 0); }
	}
	}
	}
	}
	if( "Vibrate".equals(RingerMode) ) { 
	if( Hour >= 9.5 ) { 
	if( ScreenOn >= 0.5 ) { 
	if( Pitch < -37 ) { 
	if( ScreenChangedMin < 0.09 ) { 
		if( Pitch < -107.5 ) { return new Prediction("Baseline", 1, 0); }
		if( Pitch >= -107.5 ) { return new Prediction("Picked", 12, 0); }
	}
	if( ScreenChangedMin >= 0.09 ) { 
		if( CalledHowManyTimes >= 66.5 ) { return new Prediction("Baseline", 7, 0); }
	if( CalledHowManyTimes < 66.5 ) { 
		if( MaxAcc >= 0.94 ) { return new Prediction("Picked", 10, 1); }
		if( MaxAcc < 0.94 ) { return new Prediction("Baseline", 23, 4); }
	}
	}
	}
	if( Pitch >= -37 ) { 
	if( ScreenChangedMin < 0.53 ) { 
	if( RingerModeChangedMin < 1384.9 ) { 
		if( ScreenChangedMin >= 0.31 ) { return new Prediction("Baseline", 58, 0); }
		if( ScreenChangedMin < 0.31 ) { return new Prediction("Baseline", 49, 12); }
	}
	if( RingerModeChangedMin >= 1384.9 ) { 
		if( ChargingChangedMin >= 52.26 ) { return new Prediction("Baseline", 2, 0); }
		if( ChargingChangedMin < 52.26 ) { return new Prediction("Picked", 5, 0); }
	}
	}
	if( ScreenChangedMin >= 0.53 ) { 
	if( TimeSinceLastCall < 292.05 ) { 
		if( RingerModeChangedMin < 22.09 ) { return new Prediction("Picked", 12, 0); }
		if( RingerModeChangedMin >= 22.09 ) { return new Prediction("Baseline", 11, 3); }
	}
		if( TimeSinceLastCall >= 292.05 ) { return new Prediction("Picked", 13, 0); }
	}
	}
	}
	if( ScreenOn < 0.5 ) { 
	if( ScreenChangedMin >= 1.26 ) { 
	if( Pitch >= -14 ) { 
	if( RingerModeChangedMin >= 101.03 ) { 
		if( Hour >= 18 ) { return new Prediction("Baseline", 1, 0); }
		if( Hour < 18 ) { return new Prediction("Picked", 4, 0); }
	}
	if( RingerModeChangedMin < 101.03 ) { 
		if( Pitch >= -4 ) { return new Prediction("Baseline", 8.78, 0); }
		if( Pitch < -4 ) { return new Prediction("Picked", 3.29, 1.29); }
	}
	}
	if( Pitch < -14 ) { 
		if( LastCallPicked >= 0.5 ) { return new Prediction("Picked", 13, 0); }
		if( LastCallPicked < 0.5 ) { return new Prediction("Picked", 1.93, 0.93); }
	}
	}
	if( ScreenChangedMin < 1.26 ) { 
	if( Pitch < -70.5 ) { 
	if( Hour >= 12.5 ) { 
		if( MaxAcc >= 0.09 ) { return new Prediction("Picked", 5, 0); }
		if( MaxAcc < 0.09 ) { return new Prediction("Baseline", 2, 1); }
	}
		if( Hour < 12.5 ) { return new Prediction("Baseline", 2, 0); }
	}
		if( Pitch >= -70.5 ) { return new Prediction("Picked", 55, 0); }
	}
	}
	}
	if( Hour < 9.5 ) { 
	if( ScreenOn >= 0.5 ) { 
	if( TimeSinceLastCall < 13.22 ) { 
		if( ScreenChangedMin >= 0.2 ) { return new Prediction("Baseline", 9, 0); }
		if( ScreenChangedMin < 0.2 ) { return new Prediction("Picked", 2, 0); }
	}
		if( TimeSinceLastCall >= 13.22 ) { return new Prediction("Baseline", 64, 0); }
	}
	if( ScreenOn < 0.5 ) { 
	if( ScreenChangedMin < 10.3 ) { 
		if( CalledHowManyTimes >= 165.5 ) { return new Prediction("Baseline", 16, 0); }
	if( CalledHowManyTimes < 165.5 ) { 
		if( RingerModeChangedMin < 7.77 ) { return new Prediction("Baseline", 3, 0); }
	if( RingerModeChangedMin >= 7.77 ) { 
		if( MaxAcc >= 0 ) { return new Prediction("Picked", 26, 2); }
		if( MaxAcc < 0 ) { return new Prediction("Baseline", 2, 0); }
	}
	}
	}
		if( ScreenChangedMin >= 10.3 ) { return new Prediction("Baseline", 23, 0); }
	}
	}
	}
return null;
}
private Prediction runTree1() {
	if( MaxAcc < 0.07 ) { 
	if( ScreenOn >= 0.5 ) { 
	if( Pitch >= -5.5 ) { 
	if( ScreenChangedMin >= 2.13 ) { 
	if( ChargingChangedMin >= 13.23 ) { 
	if( TimeSinceLastCall >= 33.2 ) { 
		if( ChargingChangedMin >= 87.14 ) { return new Prediction("Picked", 12, 0); }
		if( ChargingChangedMin < 87.14 ) { return new Prediction("Picked", 7.6, 2); }
	}
	if( TimeSinceLastCall < 33.2 ) { 
		if( RingerModeChangedMin < 651.67 ) { return new Prediction("Picked", 15.8, 7.2); }
		if( RingerModeChangedMin >= 651.67 ) { return new Prediction("Picked", 6.4, 0); }
	}
	}
	if( ChargingChangedMin < 13.23 ) { 
		if( ScreenChangedMin >= 8.06 ) { return new Prediction("Picked", 3, 0); }
	if( ScreenChangedMin < 8.06 ) { 
		if( Pitch >= 3.5 ) { return new Prediction("Picked", 1, 0); }
		if( Pitch < 3.5 ) { return new Prediction("Baseline", 12, 1); }
	}
	}
	}
	if( ScreenChangedMin < 2.13 ) { 
	if( TimeSinceLastCall >= 1.26 ) { 
	if( Day >= 3.5 ) { 
		if( RingerModeChangedMin < 35.91 ) { return new Prediction("Picked", 55, 27); }
		if( RingerModeChangedMin >= 35.91 ) { return new Prediction("Baseline", 90, 16); }
	}
	if( Day < 3.5 ) { 
		if( CalledHowManyTimes < 264.5 ) { return new Prediction("Baseline", 244.79, 43.59); }
		if( CalledHowManyTimes >= 264.5 ) { return new Prediction("Baseline", 40, 0); }
	}
	}
	if( TimeSinceLastCall < 1.26 ) { 
	if( TimeSinceLastCall < 0.73 ) { 
		if( Pitch < -1.5 ) { return new Prediction("Picked", 2.33, 0.29); }
		if( Pitch >= -1.5 ) { return new Prediction("Baseline", 31.47, 1.56); }
	}
		if( TimeSinceLastCall >= 0.73 ) { return new Prediction("Baseline", 26.6, 0); }
	}
	}
	}
	if( Pitch < -5.5 ) { 
	if( CalledHowManyTimes < 255.5 ) { 
	if( RingerModeChangedMin < 71.88 ) { 
		if( RingerModeChangedMin >= 64.79 ) { return new Prediction("Picked", 11, 0); }
	if( RingerModeChangedMin < 64.79 ) { 
		if( CalledHowManyTimes >= 5.5 ) { return new Prediction("Picked", 121, 41); }
		if( CalledHowManyTimes < 5.5 ) { return new Prediction("Baseline", 78.8, 26.2); }
	}
	}
	if( RingerModeChangedMin >= 71.88 ) { 
	if( ChargingChangedMin < 255.43 ) { 
		if( Hour < 13.5 ) { return new Prediction("Baseline", 45.6, 4.4); }
		if( Hour >= 13.5 ) { return new Prediction("Baseline", 47.41, 18.8); }
	}
	if( ChargingChangedMin >= 255.43 ) { 
		if( MaxAcc >= 0.01 ) { return new Prediction("Picked", 15.2, 1.8); }
		if( MaxAcc < 0.01 ) { return new Prediction("Baseline", 11, 3.4); }
	}
	}
	}
	if( CalledHowManyTimes >= 255.5 ) { 
		if( ChargingChangedMin < 46.49 ) { return new Prediction("Baseline", 34, 0); }
	if( ChargingChangedMin >= 46.49 ) { 
		if( Day >= 0.5 ) { return new Prediction("Baseline", 1, 0); }
		if( Day < 0.5 ) { return new Prediction("Picked", 1, 0); }
	}
	}
	}
	}
	if( ScreenOn < 0.5 ) { 
	if( CalledHowManyTimes < 211.5 ) { 
	if( ScreenChangedMin < 6.19 ) { 
	if( MaxAcc >= 0 ) { 
	if( ScreenChangedMin >= 1.54 ) { 
		if( Pitch < 4 ) { return new Prediction("Picked", 125.73, 24); }
		if( Pitch >= 4 ) { return new Prediction("Baseline", 19.27, 6.27); }
	}
	if( ScreenChangedMin < 1.54 ) { 
		if( RingerModeChangedMin < 0.28 ) { return new Prediction("Baseline", 4, 0); }
		if( RingerModeChangedMin >= 0.28 ) { return new Prediction("Picked", 393, 24); }
	}
	}
	if( MaxAcc < 0 ) { 
	if( ChargingChangedMin < 14.5 ) { 
		if( RingerModeChangedMin < 6.63 ) { return new Prediction("Baseline", 3, 0); }
		if( RingerModeChangedMin >= 6.63 ) { return new Prediction("Picked", 2, 0); }
	}
		if( ChargingChangedMin >= 14.5 ) { return new Prediction("Baseline", 9, 0); }
	}
	}
	if( ScreenChangedMin >= 6.19 ) { 
	if( ScreenChangedMin < 16.09 ) { 
	if( "Normal".equals(RingerMode) ) { 
		if( RingerModeChangedMin >= 26.55 ) { return new Prediction("Picked", 36, 12); }
		if( RingerModeChangedMin < 26.55 ) { return new Prediction("Baseline", 22, 5); }
	}
	if( "Silent".equals(RingerMode) ) { 
		if( ScreenChangedMin >= 6.81 ) { return new Prediction("Baseline", 17, 0); }
		if( ScreenChangedMin < 6.81 ) { return new Prediction("Picked", 3, 0); }
	}
		if( "Vibrate".equals(RingerMode) ) { return new Prediction("Picked", 2, 0); }
	}
	if( ScreenChangedMin >= 16.09 ) { 
	if( RingerModeChangedMin >= 332.28 ) { 
		if( Day < 4.5 ) { return new Prediction("Picked", 7, 2); }
		if( Day >= 4.5 ) { return new Prediction("Baseline", 4, 0); }
	}
		if( RingerModeChangedMin < 332.28 ) { return new Prediction("Baseline", 64, 0); }
	}
	}
	}
	if( CalledHowManyTimes >= 211.5 ) { 
	if( "Normal".equals(RingerMode) ) { 
	if( ScreenChangedMin < 1.43 ) { 
		if( CalledHowManyTimes >= 533.5 ) { return new Prediction("Baseline", 10, 0); }
	if( CalledHowManyTimes < 533.5 ) { 
		if( TimeSinceLastCall < 25.79 ) { return new Prediction("Picked", 5, 0); }
		if( TimeSinceLastCall >= 25.79 ) { return new Prediction("Picked", 5, 1); }
	}
	}
		if( ScreenChangedMin >= 1.43 ) { return new Prediction("Baseline", 40, 0); }
	}
		if( "Silent".equals(RingerMode) ) { return new Prediction("Baseline", 2, 0); }
		if( "Vibrate".equals(RingerMode) ) { return new Prediction("Baseline", 31, 0); }
	}
	}
	}
	if( MaxAcc >= 0.07 ) { 
	if( Hour >= 8.5 ) { 
	if( "Normal".equals(RingerMode) ) { 
	if( LastCallPicked >= 0.5 ) { 
	if( ScreenChangedMin >= 0.76 ) { 
		if( RingerModeChangedMin >= 260.77 ) { return new Prediction("Picked", 86, 0); }
	if( RingerModeChangedMin < 260.77 ) { 
		if( MaxAcc >= 0.28 ) { return new Prediction("Picked", 146, 7); }
		if( MaxAcc < 0.28 ) { return new Prediction("Picked", 65, 11); }
	}
	}
	if( ScreenChangedMin < 0.76 ) { 
	if( MaxAcc >= 0.89 ) { 
		if( ScreenOn >= 0.5 ) { return new Prediction("Baseline", 99, 48); }
		if( ScreenOn < 0.5 ) { return new Prediction("Picked", 111, 15); }
	}
	if( MaxAcc < 0.89 ) { 
		if( ScreenChangedMin >= 0.31 ) { return new Prediction("Picked", 55, 11); }
		if( ScreenChangedMin < 0.31 ) { return new Prediction("Picked", 73, 0); }
	}
	}
	}
	if( LastCallPicked < 0.5 ) { 
	if( CalledHowManyTimes < 224.5 ) { 
		if( TimeSinceLastCall < 1.17 ) { return new Prediction("Baseline", 15, 0); }
	if( TimeSinceLastCall >= 1.17 ) { 
		if( ScreenChangedMin >= 0.74 ) { return new Prediction("Picked", 113, 10); }
		if( ScreenChangedMin < 0.74 ) { return new Prediction("Picked", 153, 42); }
	}
	}
	if( CalledHowManyTimes >= 224.5 ) { 
	if( ScreenChangedMin >= 0.14 ) { 
		if( ScreenChangedMin >= 1.45 ) { return new Prediction("Baseline", 17, 5); }
		if( ScreenChangedMin < 1.45 ) { return new Prediction("Picked", 9, 1); }
	}
		if( ScreenChangedMin < 0.14 ) { return new Prediction("Baseline", 17, 0); }
	}
	}
	}
	if( "Silent".equals(RingerMode) ) { 
	if( TimeSinceLastCall >= 13.55 ) { 
	if( MaxAcc >= 2.01 ) { 
	if( Pitch >= -5 ) { 
		if( Proximity < 0.5 ) { return new Prediction("Picked", 6, 2); }
		if( Proximity >= 0.5 ) { return new Prediction("Baseline", 10, 0); }
	}
		if( Pitch < -5 ) { return new Prediction("Baseline", 7, 0); }
	}
	if( MaxAcc < 2.01 ) { 
		if( ChargingChangedMin >= 162.44 ) { return new Prediction("Baseline", 2, 0); }
		if( ChargingChangedMin < 162.44 ) { return new Prediction("Picked", 6, 0); }
	}
	}
	if( TimeSinceLastCall < 13.55 ) { 
	if( ScreenChangedMin < 1.23 ) { 
	if( ScreenChangedMin >= 0.69 ) { 
		if( Day >= 0.5 ) { return new Prediction("Baseline", 6, 0); }
		if( Day < 0.5 ) { return new Prediction("Picked", 1, 0); }
	}
		if( ScreenChangedMin < 0.69 ) { return new Prediction("Picked", 4, 0); }
	}
	if( ScreenChangedMin >= 1.23 ) { 
		if( CalledHowManyTimes < 3.5 ) { return new Prediction("Picked", 9, 0); }
	if( CalledHowManyTimes >= 3.5 ) { 
		if( ScreenChangedMin >= 1.69 ) { return new Prediction("Baseline", 4, 1); }
		if( ScreenChangedMin < 1.69 ) { return new Prediction("Picked", 4, 0); }
	}
	}
	}
	}
	if( "Vibrate".equals(RingerMode) ) { 
	if( LastCallPicked >= 0.5 ) { 
	if( Pitch >= 6.5 ) { 
		if( Proximity < 0.5 ) { return new Prediction("Picked", 1, 0); }
		if( Proximity >= 0.5 ) { return new Prediction("Baseline", 10, 0); }
	}
	if( Pitch < 6.5 ) { 
	if( ChargingChangedMin < 9.57 ) { 
		if( MaxAcc >= 0.1 ) { return new Prediction("Baseline", 6, 1); }
		if( MaxAcc < 0.1 ) { return new Prediction("Picked", 1, 0); }
	}
	if( ChargingChangedMin >= 9.57 ) { 
		if( ChargingChangedMin >= 650.73 ) { return new Prediction("Baseline", 2, 0); }
		if( ChargingChangedMin < 650.73 ) { return new Prediction("Picked", 62, 9); }
	}
	}
	}
	if( LastCallPicked < 0.5 ) { 
		if( TimeSinceLastCall >= 873.9 ) { return new Prediction("Picked", 10, 0); }
	if( TimeSinceLastCall < 873.9 ) { 
	if( ScreenOn >= 0.5 ) { 
		if( MaxAcc < 5.14 ) { return new Prediction("Baseline", 38, 5); }
		if( MaxAcc >= 5.14 ) { return new Prediction("Picked", 2, 0); }
	}
		if( ScreenOn < 0.5 ) { return new Prediction("Picked", 18, 0); }
	}
	}
	}
	}
	if( Hour < 8.5 ) { 
		if( TimeSinceLastCall >= 845.89 ) { return new Prediction("Picked", 11, 0); }
	if( TimeSinceLastCall < 845.89 ) { 
	if( TimeSinceLastCall >= 0.75 ) { 
	if( Hour >= 0.5 ) { 
	if( "Normal".equals(RingerMode) ) { 
		if( CalledHowManyTimes >= 62 ) { return new Prediction("Baseline", 10, 0); }
		if( CalledHowManyTimes < 62 ) { return new Prediction("Picked", 43, 20); }
	}
		if( "Silent".equals(RingerMode) ) { return new Prediction("Picked", 1, 0); }
	if( "Vibrate".equals(RingerMode) ) { 
		if( Hour < 7.5 ) { return new Prediction("Baseline", 25, 0); }
		if( Hour >= 7.5 ) { return new Prediction("Baseline", 16, 5); }
	}
	}
		if( Hour < 0.5 ) { return new Prediction("Picked", 4, 0); }
	}
		if( TimeSinceLastCall < 0.75 ) { return new Prediction("Picked", 3, 0); }
	}
	}
	}
return null;
}
private Prediction runTree2() {
	if( LastCallPicked >= 0.5 ) { 
	if( ScreenOn >= 0.5 ) { 
	if( "Normal".equals(RingerMode) ) { 
	if( TimeSinceLastCall >= 7.47 ) { 
	if( ScreenChangedMin < 0.53 ) { 
	if( ChargingChangedMin < 98.55 ) { 
		if( Hour < 4 ) { return new Prediction("Picked", 8, 0); }
		if( Hour >= 4 ) { return new Prediction("Picked", 288, 142); }
	}
	if( ChargingChangedMin >= 98.55 ) { 
		if( ScreenChangedMin >= 0.04 ) { return new Prediction("Baseline", 78, 12); }
		if( ScreenChangedMin < 0.04 ) { return new Prediction("Picked", 10, 1); }
	}
	}
	if( ScreenChangedMin >= 0.53 ) { 
	if( CalledHowManyTimes >= 7.5 ) { 
		if( Hour >= 9.5 ) { return new Prediction("Picked", 47, 8); }
		if( Hour < 9.5 ) { return new Prediction("Baseline", 3, 0); }
	}
	if( CalledHowManyTimes < 7.5 ) { 
		if( Pitch >= -0.5 ) { return new Prediction("Picked", 27.65, 2); }
		if( Pitch < -0.5 ) { return new Prediction("Picked", 73.35, 0); }
	}
	}
	}
	if( TimeSinceLastCall < 7.47 ) { 
	if( ChargingChangedMin >= 22.46 ) { 
	if( MaxAcc < 0.04 ) { 
		if( CalledHowManyTimes < 1.5 ) { return new Prediction("Picked", 6, 0); }
		if( CalledHowManyTimes >= 1.5 ) { return new Prediction("Picked", 24, 6); }
	}
		if( MaxAcc >= 0.04 ) { return new Prediction("Picked", 34, 0); }
	}
	if( ChargingChangedMin < 22.46 ) { 
	if( RingerModeChangedMin >= 20.41 ) { 
		if( ScreenChangedMin < 0.26 ) { return new Prediction("Baseline", 2, 0); }
		if( ScreenChangedMin >= 0.26 ) { return new Prediction("Baseline", 7, 3); }
	}
	if( RingerModeChangedMin < 20.41 ) { 
		if( TimeSinceLastCall < 5.75 ) { return new Prediction("Picked", 15, 2); }
		if( TimeSinceLastCall >= 5.75 ) { return new Prediction("Baseline", 2, 0); }
	}
	}
	}
	}
	if( "Silent".equals(RingerMode) ) { 
	if( TimeSinceLastCall >= 9.82 ) { 
	if( ScreenChangedMin < 1.02 ) { 
	if( ChargingChangedMin >= 320.65 ) { 
		if( Pitch < -93.5 ) { return new Prediction("Baseline", 2, 0); }
		if( Pitch >= -93.5 ) { return new Prediction("Picked", 4, 0); }
	}
	if( ChargingChangedMin < 320.65 ) { 
		if( MaxAcc >= 0 ) { return new Prediction("Baseline", 31, 0); }
		if( MaxAcc < 0 ) { return new Prediction("Baseline", 2, 1); }
	}
	}
		if( ScreenChangedMin >= 1.02 ) { return new Prediction("Picked", 5, 0); }
	}
	if( TimeSinceLastCall < 9.82 ) { 
	if( RingerModeChangedMin < 199.89 ) { 
		if( MaxAcc >= 0.33 ) { return new Prediction("Baseline", 1, 0); }
		if( MaxAcc < 0.33 ) { return new Prediction("Picked", 12, 0); }
	}
	if( RingerModeChangedMin >= 199.89 ) { 
		if( ChargingChangedMin < 317.92 ) { return new Prediction("Baseline", 3, 0); }
		if( ChargingChangedMin >= 317.92 ) { return new Prediction("Picked", 1, 0); }
	}
	}
	}
	if( "Vibrate".equals(RingerMode) ) { 
	if( ScreenChangedMin >= 0.19 ) { 
	if( Pitch >= -101 ) { 
	if( Hour >= 12.5 ) { 
		if( MaxAcc < 1.41 ) { return new Prediction("Baseline", 47, 1); }
		if( MaxAcc >= 1.41 ) { return new Prediction("Baseline", 9, 3); }
	}
	if( Hour < 12.5 ) { 
		if( Pitch >= -2.5 ) { return new Prediction("Baseline", 23, 1); }
		if( Pitch < -2.5 ) { return new Prediction("Baseline", 24, 12); }
	}
	}
	if( Pitch < -101 ) { 
	if( Pitch >= -175 ) { 
		if( ChargingChangedMin < 169.14 ) { return new Prediction("Picked", 8, 0); }
		if( ChargingChangedMin >= 169.14 ) { return new Prediction("Baseline", 1, 0); }
	}
		if( Pitch < -175 ) { return new Prediction("Baseline", 1, 0); }
	}
	}
	if( ScreenChangedMin < 0.19 ) { 
	if( CalledHowManyTimes >= 30 ) { 
	if( CalledHowManyTimes < 242.5 ) { 
		if( TimeSinceLastCall < 195.85 ) { return new Prediction("Picked", 12, 1); }
		if( TimeSinceLastCall >= 195.85 ) { return new Prediction("Baseline", 5, 0); }
	}
		if( CalledHowManyTimes >= 242.5 ) { return new Prediction("Baseline", 4, 0); }
	}
		if( CalledHowManyTimes < 30 ) { return new Prediction("Picked", 14, 0); }
	}
	}
	}
	if( ScreenOn < 0.5 ) { 
	if( ScreenChangedMin >= 4.01 ) { 
	if( "Normal".equals(RingerMode) ) { 
	if( RingerModeChangedMin < 34.25 ) { 
	if( MaxAcc >= 0 ) { 
		if( TimeSinceLastCall < 28.46 ) { return new Prediction("Picked", 12, 4); }
		if( TimeSinceLastCall >= 28.46 ) { return new Prediction("Baseline", 17, 0); }
	}
		if( MaxAcc < 0 ) { return new Prediction("Baseline", 5, 0); }
	}
	if( RingerModeChangedMin >= 34.25 ) { 
	if( ChargingChangedMin >= 43.1 ) { 
		if( TimeSinceLastCall >= 147.07 ) { return new Prediction("Baseline", 28, 12); }
		if( TimeSinceLastCall < 147.07 ) { return new Prediction("Picked", 40, 11); }
	}
		if( ChargingChangedMin < 43.1 ) { return new Prediction("Picked", 12, 0); }
	}
	}
		if( "Silent".equals(RingerMode) ) { return new Prediction("Baseline", 11, 0); }
	if( "Vibrate".equals(RingerMode) ) { 
	if( CalledHowManyTimes < 21 ) { 
		if( TimeSinceLastCall < 62.13 ) { return new Prediction("Picked", 8, 0); }
	if( TimeSinceLastCall >= 62.13 ) { 
		if( ChargingChangedMin < 10.56 ) { return new Prediction("Picked", 3, 0); }
		if( ChargingChangedMin >= 10.56 ) { return new Prediction("Baseline", 1, 0); }
	}
	}
		if( CalledHowManyTimes >= 21 ) { return new Prediction("Baseline", 6, 0); }
	}
	}
	if( ScreenChangedMin < 4.01 ) { 
	if( "Normal".equals(RingerMode) ) { 
	if( Hour >= 10.5 ) { 
	if( ChargingChangedMin >= 353.16 ) { 
		if( RingerModeChangedMin < 443.39 ) { return new Prediction("Picked", 31, 14); }
		if( RingerModeChangedMin >= 443.39 ) { return new Prediction("Picked", 40, 1); }
	}
	if( ChargingChangedMin < 353.16 ) { 
		if( MaxAcc >= 0 ) { return new Prediction("Picked", 482, 25); }
		if( MaxAcc < 0 ) { return new Prediction("Baseline", 2, 0); }
	}
	}
		if( Hour < 10.5 ) { return new Prediction("Picked", 129, 0); }
	}
	if( "Silent".equals(RingerMode) ) { 
		if( Pitch < -116.5 ) { return new Prediction("Baseline", 5, 0); }
	if( Pitch >= -116.5 ) { 
	if( Pitch >= -0.5 ) { 
		if( MaxAcc >= 0 ) { return new Prediction("Picked", 3, 1); }
		if( MaxAcc < 0 ) { return new Prediction("Baseline", 2, 0); }
	}
		if( Pitch < -0.5 ) { return new Prediction("Picked", 13, 0); }
	}
	}
	if( "Vibrate".equals(RingerMode) ) { 
	if( RingerModeChangedMin < 9.79 ) { 
	if( MaxAcc >= 0.02 ) { 
		if( Day < 5 ) { return new Prediction("Picked", 9, 0); }
		if( Day >= 5 ) { return new Prediction("Baseline", 1, 0); }
	}
		if( MaxAcc < 0.02 ) { return new Prediction("Baseline", 6, 0); }
	}
	if( RingerModeChangedMin >= 9.79 ) { 
		if( ScreenChangedMin < 1.8 ) { return new Prediction("Picked", 39, 0); }
	if( ScreenChangedMin >= 1.8 ) { 
		if( Day >= 2 ) { return new Prediction("Picked", 6, 2); }
		if( Day < 2 ) { return new Prediction("Picked", 7, 0); }
	}
	}
	}
	}
	}
	}
	if( LastCallPicked < 0.5 ) { 
	if( MaxAcc < 0.07 ) { 
	if( ScreenOn >= 0.5 ) { 
	if( CalledHowManyTimes < 180.5 ) { 
	if( Pitch >= -8.5 ) { 
	if( "Normal".equals(RingerMode) ) { 
		if( ScreenChangedMin >= 0.55 ) { return new Prediction("Picked", 26.95, 9.71); }
		if( ScreenChangedMin < 0.55 ) { return new Prediction("Baseline", 92.77, 16); }
	}
	if( "Silent".equals(RingerMode) ) { 
		if( RingerModeChangedMin >= 816.7 ) { return new Prediction("Picked", 1, 0); }
		if( RingerModeChangedMin < 816.7 ) { return new Prediction("Baseline", 51, 0); }
	}
	if( "Vibrate".equals(RingerMode) ) { 
		if( Hour < 13.5 ) { return new Prediction("Baseline", 43, 2); }
		if( Hour >= 13.5 ) { return new Prediction("Baseline", 17, 7); }
	}
	}
	if( Pitch < -8.5 ) { 
	if( MaxAcc >= 0 ) { 
		if( ScreenChangedMin < 0.08 ) { return new Prediction("Picked", 7.88, 0.88); }
		if( ScreenChangedMin >= 0.08 ) { return new Prediction("Baseline", 78.23, 19.76); }
	}
	if( MaxAcc < 0 ) { 
		if( ChargingChangedMin < 15.59 ) { return new Prediction("Picked", 7, 0); }
		if( ChargingChangedMin >= 15.59 ) { return new Prediction("Picked", 3.17, 1.17); }
	}
	}
	}
	if( CalledHowManyTimes >= 180.5 ) { 
		if( TimeSinceLastCall >= 20.26 ) { return new Prediction("Baseline", 77, 0); }
	if( TimeSinceLastCall < 20.26 ) { 
	if( MaxAcc >= 0.02 ) { 
		if( Hour >= 21.5 ) { return new Prediction("Baseline", 9, 4); }
		if( Hour < 21.5 ) { return new Prediction("Baseline", 11, 0); }
	}
		if( MaxAcc < 0.02 ) { return new Prediction("Baseline", 24, 0); }
	}
	}
	}
	if( ScreenOn < 0.5 ) { 
	if( Charging >= 0.5 ) { 
	if( Hour < 22.5 ) { 
		if( CalledHowManyTimes >= 8 ) { return new Prediction("Baseline", 19, 0); }
	if( CalledHowManyTimes < 8 ) { 
		if( ChargingChangedMin < 12.88 ) { return new Prediction("Picked", 2, 0); }
		if( ChargingChangedMin >= 12.88 ) { return new Prediction("Baseline", 5, 0); }
	}
	}
		if( Hour >= 22.5 ) { return new Prediction("Picked", 2, 0); }
	}
	if( Charging < 0.5 ) { 
	if( CalledHowManyTimes < 242.5 ) { 
	if( RingerModeChangedMin < 25.2 ) { 
		if( TimeSinceLastCall >= 2.2 ) { return new Prediction("Picked", 70, 10); }
		if( TimeSinceLastCall < 2.2 ) { return new Prediction("Baseline", 9, 1); }
	}
	if( RingerModeChangedMin >= 25.2 ) { 
		if( "Normal".equals(RingerMode) ) { return new Prediction("Picked", 97, 40); }
		if( "Silent".equals(RingerMode) ) { return new Prediction("Baseline", 44, 7); }
		if( "Vibrate".equals(RingerMode) ) { return new Prediction("Baseline", 15, 3); }
	}
	}
	if( CalledHowManyTimes >= 242.5 ) { 
		if( Pitch < -22 ) { return new Prediction("Picked", 1, 0); }
		if( Pitch >= -22 ) { return new Prediction("Baseline", 38, 0); }
	}
	}
	}
	}
	if( MaxAcc >= 0.07 ) { 
	if( ScreenOn >= 0.5 ) { 
	if( CalledHowManyTimes < 235 ) { 
	if( RingerModeChangedMin < 87.84 ) { 
		if( CalledHowManyTimes >= 173 ) { return new Prediction("Picked", 11, 0); }
	if( CalledHowManyTimes < 173 ) { 
		if( MaxAcc < 0.07 ) { return new Prediction("Baseline", 4, 0); }
		if( MaxAcc >= 0.07 ) { return new Prediction("Baseline", 132, 50); }
	}
	}
	if( RingerModeChangedMin >= 87.84 ) { 
	if( CalledHowManyTimes < 3.5 ) { 
		if( ScreenChangedMin >= 0.84 ) { return new Prediction("Picked", 9, 0); }
		if( ScreenChangedMin < 0.84 ) { return new Prediction("Baseline", 23, 9); }
	}
	if( CalledHowManyTimes >= 3.5 ) { 
		if( ChargingChangedMin < 94.03 ) { return new Prediction("Picked", 15, 4); }
		if( ChargingChangedMin >= 94.03 ) { return new Prediction("Picked", 29, 0); }
	}
	}
	}
	if( CalledHowManyTimes >= 235 ) { 
		if( TimeSinceLastCall >= 11.57 ) { return new Prediction("Baseline", 38, 0); }
	if( TimeSinceLastCall < 11.57 ) { 
		if( ScreenChangedMin < 1.07 ) { return new Prediction("Baseline", 2, 0); }
		if( ScreenChangedMin >= 1.07 ) { return new Prediction("Picked", 3, 0); }
	}
	}
	}
	if( ScreenOn < 0.5 ) { 
	if( Hour < 7.5 ) { 
		if( ChargingChangedMin < 202.35 ) { return new Prediction("Baseline", 7, 0); }
		if( ChargingChangedMin >= 202.35 ) { return new Prediction("Picked", 1, 0); }
	}
	if( Hour >= 7.5 ) { 
	if( TimeSinceLastCall >= 1.62 ) { 
		if( RingerModeChangedMin < 0.6 ) { return new Prediction("Baseline", 7, 0); }
	if( RingerModeChangedMin >= 0.6 ) { 
		if( Pitch < 88.5 ) { return new Prediction("Picked", 180.64, 30.64); }
		if( Pitch >= 88.5 ) { return new Prediction("Picked", 24.36, 8.36); }
	}
	}
		if( TimeSinceLastCall < 1.62 ) { return new Prediction("Baseline", 10, 0); }
	}
	}
	}
	}
return null;
}
private Prediction runTree3() {
	if( ScreenOn >= 0.5 ) { 
	if( Pitch >= -8.5 ) { 
	if( CalledHowManyTimes >= 223 ) { 
	if( ScreenChangedMin >= 5.23 ) { 
		if( Pitch < 2.5 ) { return new Prediction("Picked", 4, 0); }
		if( Pitch >= 2.5 ) { return new Prediction("Baseline", 1, 0); }
	}
	if( ScreenChangedMin < 5.23 ) { 
	if( CalledHowManyTimes < 291.5 ) { 
	if( LastCallPicked >= 0.5 ) { 
		if( ScreenChangedMin < 0.6 ) { return new Prediction("Picked", 3, 0); }
		if( ScreenChangedMin >= 0.6 ) { return new Prediction("Baseline", 5, 0); }
	}
		if( LastCallPicked < 0.5 ) { return new Prediction("Baseline", 20, 0); }
	}
	if( CalledHowManyTimes >= 291.5 ) { 
	if( TimeSinceLastCall >= 48.77 ) { 
		if( LastCallPicked >= 0.5 ) { return new Prediction("Baseline", 18, 2); }
		if( LastCallPicked < 0.5 ) { return new Prediction("Baseline", 29, 0); }
	}
		if( TimeSinceLastCall < 48.77 ) { return new Prediction("Baseline", 78, 0); }
	}
	}
	}
	if( CalledHowManyTimes < 223 ) { 
	if( Charging >= 0.5 ) { 
	if( ChargingChangedMin < 838.11 ) { 
	if( MaxAcc < 0.05 ) { 
		if( ScreenChangedMin >= 0.05 ) { return new Prediction("Baseline", 59, 0); }
		if( ScreenChangedMin < 0.05 ) { return new Prediction("Picked", 4, 0); }
	}
	if( MaxAcc >= 0.05 ) { 
		if( MaxAcc >= 0.08 ) { return new Prediction("Baseline", 23.02, 6.51); }
		if( MaxAcc < 0.08 ) { return new Prediction("Picked", 3, 0); }
	}
	}
	if( ChargingChangedMin >= 838.11 ) { 
		if( "Normal".equals(RingerMode) ) { return new Prediction("Picked", 4, 0); }
		if( "Silent".equals(RingerMode) ) { return new Prediction("Baseline", 1, 0); }
		if( "Vibrate".equals(RingerMode) ) { return new Prediction("Baseline", 0, 0); }
	}
	}
	if( Charging < 0.5 ) { 
	if( ScreenChangedMin >= 0.77 ) { 
	if( ChargingChangedMin < 83.92 ) { 
		if( Pitch >= -6 ) { return new Prediction("Picked", 80.43, 22.21); }
		if( Pitch < -6 ) { return new Prediction("Baseline", 3.22, 0.17); }
	}
	if( ChargingChangedMin >= 83.92 ) { 
		if( Day < 4.5 ) { return new Prediction("Picked", 98.09, 4.88); }
		if( Day >= 4.5 ) { return new Prediction("Baseline", 6, 3); }
	}
	}
	if( ScreenChangedMin < 0.77 ) { 
	if( ScreenChangedMin >= 0.06 ) { 
		if( ScreenChangedMin >= 0.51 ) { return new Prediction("Picked", 64.14, 29.26); }
		if( ScreenChangedMin < 0.51 ) { return new Prediction("Baseline", 370.34, 72.79); }
	}
	if( ScreenChangedMin < 0.06 ) { 
		if( TimeSinceLastCall >= 662.78 ) { return new Prediction("Picked", 12, 0); }
		if( TimeSinceLastCall < 662.78 ) { return new Prediction("Picked", 76, 17); }
	}
	}
	}
	}
	}
	if( Pitch < -8.5 ) { 
	if( RingerModeChangedMin < 1.78 ) { 
		if( CalledHowManyTimes >= 2.5 ) { return new Prediction("Baseline", 21, 0); }
	if( CalledHowManyTimes < 2.5 ) { 
	if( "Normal".equals(RingerMode) ) { 
		if( Day < 4 ) { return new Prediction("Baseline", 4, 0); }
		if( Day >= 4 ) { return new Prediction("Picked", 3, 0); }
	}
		if( "Silent".equals(RingerMode) ) { return new Prediction("Baseline", 4, 0); }
		if( "Vibrate".equals(RingerMode) ) { return new Prediction("Picked", 1, 0); }
	}
	}
	if( RingerModeChangedMin >= 1.78 ) { 
	if( LastCallPicked >= 0.5 ) { 
	if( MaxAcc >= 0.03 ) { 
		if( MaxAcc < 0.04 ) { return new Prediction("Picked", 22.49, 0); }
	if( MaxAcc >= 0.04 ) { 
		if( MaxAcc >= 5.07 ) { return new Prediction("Picked", 17.37, 0); }
		if( MaxAcc < 5.07 ) { return new Prediction("Picked", 147.54, 41.23); }
	}
	}
	if( MaxAcc < 0.03 ) { 
	if( Proximity < 0.5 ) { 
		if( CalledHowManyTimes < 4.5 ) { return new Prediction("Baseline", 34.35, 11.35); }
		if( CalledHowManyTimes >= 4.5 ) { return new Prediction("Picked", 75.75, 23.38); }
	}
	if( Proximity >= 0.5 ) { 
		if( ChargingChangedMin < 90.54 ) { return new Prediction("Baseline", 20.23, 7.23); }
		if( ChargingChangedMin >= 90.54 ) { return new Prediction("Baseline", 12.48, 0.26); }
	}
	}
	}
	if( LastCallPicked < 0.5 ) { 
	if( Pitch >= -163.5 ) { 
	if( MaxAcc < 4.39 ) { 
		if( "Normal".equals(RingerMode) ) { return new Prediction("Picked", 111.31, 50.99); }
		if( "Silent".equals(RingerMode) ) { return new Prediction("Baseline", 28.33, 13); }
		if( "Vibrate".equals(RingerMode) ) { return new Prediction("Baseline", 38, 10); }
	}
		if( MaxAcc >= 4.39 ) { return new Prediction("Baseline", 7.66, 0); }
	}
	if( Pitch < -163.5 ) { 
	if( CalledHowManyTimes >= 5.5 ) { 
		if( RingerModeChangedMin < 1114.22 ) { return new Prediction("Baseline", 20.44, 0.08); }
		if( RingerModeChangedMin >= 1114.22 ) { return new Prediction("Picked", 0.04, 0); }
	}
		if( CalledHowManyTimes < 5.5 ) { return new Prediction("Baseline", 1.76, 0.4); }
	}
	}
	}
	}
	}
	if( ScreenOn < 0.5 ) { 
	if( CalledHowManyTimes < 258.5 ) { 
	if( ScreenChangedMin >= 11.43 ) { 
		if( ScreenChangedMin >= 19.73 ) { return new Prediction("Baseline", 81, 0); }
	if( ScreenChangedMin < 19.73 ) { 
	if( CalledHowManyTimes < 18 ) { 
	if( MaxAcc >= 0.1 ) { 
		if( Pitch >= 1.5 ) { return new Prediction("Picked", 3, 0); }
		if( Pitch < 1.5 ) { return new Prediction("Baseline", 6, 3); }
	}
	if( MaxAcc < 0.1 ) { 
		if( ScreenChangedMin >= 11.79 ) { return new Prediction("Baseline", 21, 0); }
		if( ScreenChangedMin < 11.79 ) { return new Prediction("Baseline", 4, 1); }
	}
	}
	if( CalledHowManyTimes >= 18 ) { 
	if( Pitch < 0.5 ) { 
		if( RingerModeChangedMin >= 40.55 ) { return new Prediction("Picked", 4, 1); }
		if( RingerModeChangedMin < 40.55 ) { return new Prediction("Baseline", 3, 0); }
	}
		if( Pitch >= 0.5 ) { return new Prediction("Picked", 6, 0); }
	}
	}
	}
	if( ScreenChangedMin < 11.43 ) { 
	if( MaxAcc >= 0 ) { 
	if( "Normal".equals(RingerMode) ) { 
	if( LastCallPicked >= 0.5 ) { 
		if( Pitch < 176 ) { return new Prediction("Picked", 731.87, 52.97); }
		if( Pitch >= 176 ) { return new Prediction("Picked", 12.13, 6.03); }
	}
	if( LastCallPicked < 0.5 ) { 
		if( TimeSinceLastCall < 1.65 ) { return new Prediction("Baseline", 8, 1); }
		if( TimeSinceLastCall >= 1.65 ) { return new Prediction("Picked", 276, 37); }
	}
	}
	if( "Silent".equals(RingerMode) ) { 
	if( Pitch < -11 ) { 
		if( MaxAcc >= 2.29 ) { return new Prediction("Baseline", 1, 0); }
		if( MaxAcc < 2.29 ) { return new Prediction("Picked", 40, 4); }
	}
	if( Pitch >= -11 ) { 
		if( Hour >= 12.5 ) { return new Prediction("Baseline", 18, 1); }
		if( Hour < 12.5 ) { return new Prediction("Picked", 17, 8); }
	}
	}
	if( "Vibrate".equals(RingerMode) ) { 
		if( RingerModeChangedMin < 1.3 ) { return new Prediction("Baseline", 3, 0); }
	if( RingerModeChangedMin >= 1.3 ) { 
		if( Day < 4.5 ) { return new Prediction("Picked", 85, 8); }
		if( Day >= 4.5 ) { return new Prediction("Baseline", 14, 7); }
	}
	}
	}
	if( MaxAcc < 0 ) { 
		if( ChargingChangedMin >= 10.18 ) { return new Prediction("Baseline", 11, 0); }
	if( ChargingChangedMin < 10.18 ) { 
		if( Day >= 2.5 ) { return new Prediction("Baseline", 2, 0); }
	if( Day < 2.5 ) { 
		if( TimeSinceLastCall >= 15.53 ) { return new Prediction("Baseline", 1, 0); }
		if( TimeSinceLastCall < 15.53 ) { return new Prediction("Picked", 1, 0); }
	}
	}
	}
	}
	}
	if( CalledHowManyTimes >= 258.5 ) { 
	if( ScreenChangedMin >= 1.79 ) { 
	if( MaxAcc >= 0.17 ) { 
		if( "Normal".equals(RingerMode) ) { return new Prediction("Picked", 1, 0); }
		if( "Silent".equals(RingerMode) ) { return new Prediction("Baseline", 0, 0); }
		if( "Vibrate".equals(RingerMode) ) { return new Prediction("Baseline", 6, 0); }
	}
		if( MaxAcc < 0.17 ) { return new Prediction("Baseline", 70, 0); }
	}
	if( ScreenChangedMin < 1.79 ) { 
		if( CalledHowManyTimes >= 868.5 ) { return new Prediction("Baseline", 5, 0); }
	if( CalledHowManyTimes < 868.5 ) { 
	if( Day < 4.5 ) { 
	if( MaxAcc < 0.43 ) { 
		if( ScreenChangedMin >= 0.42 ) { return new Prediction("Baseline", 14, 6); }
		if( ScreenChangedMin < 0.42 ) { return new Prediction("Baseline", 7, 0); }
	}
		if( MaxAcc >= 0.43 ) { return new Prediction("Picked", 7, 0); }
	}
		if( Day >= 4.5 ) { return new Prediction("Picked", 7, 0); }
	}
	}
	}
	}
return null;
}
private Prediction runTree4() {
	if( CalledHowManyTimes < 258.5 ) { 
	if( LastCallPicked >= 0.5 ) { 
	if( TimeSinceLastCall >= 66.68 ) { 
	if( MaxAcc >= 0.03 ) { 
	if( Pitch >= 64.5 ) { 
	if( ChargingChangedMin < 398.39 ) { 
		if( ScreenChangedMin < 0.7 ) { return new Prediction("Baseline", 23.17, 7.17); }
		if( ScreenChangedMin >= 0.7 ) { return new Prediction("Picked", 6.78, 2); }
	}
	if( ChargingChangedMin >= 398.39 ) { 
		if( Hour >= 8.5 ) { return new Prediction("Picked", 6, 0); }
		if( Hour < 8.5 ) { return new Prediction("Baseline", 0.17, 0.09); }
	}
	}
	if( Pitch < 64.5 ) { 
	if( "Normal".equals(RingerMode) ) { 
		if( CalledHowManyTimes >= 7.5 ) { return new Prediction("Picked", 110.65, 26); }
		if( CalledHowManyTimes < 7.5 ) { return new Prediction("Picked", 217.22, 22.91); }
	}
	if( "Silent".equals(RingerMode) ) { 
		if( ScreenOn >= 0.5 ) { return new Prediction("Baseline", 11, 1); }
		if( ScreenOn < 0.5 ) { return new Prediction("Picked", 3, 0); }
	}
	if( "Vibrate".equals(RingerMode) ) { 
		if( ScreenChangedMin < 0.79 ) { return new Prediction("Baseline", 25, 10); }
		if( ScreenChangedMin >= 0.79 ) { return new Prediction("Picked", 12, 1); }
	}
	}
	}
	if( MaxAcc < 0.03 ) { 
	if( "Normal".equals(RingerMode) ) { 
	if( Day >= 2.5 ) { 
		if( MaxAcc >= 0 ) { return new Prediction("Picked", 66, 27); }
		if( MaxAcc < 0 ) { return new Prediction("Picked", 51, 8); }
	}
	if( Day < 2.5 ) { 
		if( MaxAcc >= 0.02 ) { return new Prediction("Picked", 18, 2); }
		if( MaxAcc < 0.02 ) { return new Prediction("Baseline", 85, 38); }
	}
	}
	if( "Silent".equals(RingerMode) ) { 
	if( ChargingChangedMin < 89.82 ) { 
		if( Hour < 16 ) { return new Prediction("Baseline", 6, 0); }
		if( Hour >= 16 ) { return new Prediction("Baseline", 6, 3); }
	}
		if( ChargingChangedMin >= 89.82 ) { return new Prediction("Baseline", 24, 0); }
	}
	if( "Vibrate".equals(RingerMode) ) { 
		if( MaxAcc >= 0.02 ) { return new Prediction("Baseline", 15, 0); }
	if( MaxAcc < 0.02 ) { 
		if( Hour >= 10.5 ) { return new Prediction("Baseline", 42, 10); }
		if( Hour < 10.5 ) { return new Prediction("Picked", 14, 3); }
	}
	}
	}
	}
	if( TimeSinceLastCall < 66.68 ) { 
	if( ScreenOn >= 0.5 ) { 
	if( ScreenChangedMin >= 0.06 ) { 
	if( MaxAcc >= 0.03 ) { 
		if( Proximity < 0.5 ) { return new Prediction("Picked", 139.71, 25); }
		if( Proximity >= 0.5 ) { return new Prediction("Baseline", 56.29, 26.29); }
	}
	if( MaxAcc < 0.03 ) { 
		if( ChargingChangedMin < 85 ) { return new Prediction("Baseline", 98, 36); }
		if( ChargingChangedMin >= 85 ) { return new Prediction("Picked", 52, 19); }
	}
	}
	if( ScreenChangedMin < 0.06 ) { 
	if( Proximity < 0.5 ) { 
		if( ChargingChangedMin < 241.96 ) { return new Prediction("Picked", 77, 8); }
		if( ChargingChangedMin >= 241.96 ) { return new Prediction("Baseline", 3, 0); }
	}
		if( Proximity >= 0.5 ) { return new Prediction("Picked", 38, 0); }
	}
	}
	if( ScreenOn < 0.5 ) { 
	if( Pitch < -1.5 ) { 
	if( TimeSinceLastCall >= 11.35 ) { 
		if( Pitch < -159 ) { return new Prediction("Baseline", 5.05, 2); }
		if( Pitch >= -159 ) { return new Prediction("Picked", 184.76, 20.76); }
	}
	if( TimeSinceLastCall < 11.35 ) { 
		if( Pitch >= -11.5 ) { return new Prediction("Picked", 22.53, 3); }
		if( Pitch < -11.5 ) { return new Prediction("Picked", 104.47, 0); }
	}
	}
	if( Pitch >= -1.5 ) { 
	if( MaxAcc >= 0.03 ) { 
		if( ChargingChangedMin < 39.71 ) { return new Prediction("Picked", 47.4, 3); }
		if( ChargingChangedMin >= 39.71 ) { return new Prediction("Picked", 87.6, 18.4); }
	}
	if( MaxAcc < 0.03 ) { 
		if( ScreenChangedMin < 10.58 ) { return new Prediction("Picked", 62.8, 14.4); }
		if( ScreenChangedMin >= 10.58 ) { return new Prediction("Baseline", 12.4, 0); }
	}
	}
	}
	}
	}
	if( LastCallPicked < 0.5 ) { 
	if( Pitch < -9.5 ) { 
	if( ScreenOn >= 0.5 ) { 
	if( RingerModeChangedMin < 5.98 ) { 
	if( MaxAcc < 0.06 ) { 
		if( ChargingChangedMin >= 5.1 ) { return new Prediction("Picked", 4, 1); }
		if( ChargingChangedMin < 5.1 ) { return new Prediction("Baseline", 3, 0); }
	}
		if( MaxAcc >= 0.06 ) { return new Prediction("Picked", 12, 0); }
	}
	if( RingerModeChangedMin >= 5.98 ) { 
	if( TimeSinceLastCall < 20.11 ) { 
		if( TimeSinceLastCall >= 0.57 ) { return new Prediction("Baseline", 44.53, 8.6); }
		if( TimeSinceLastCall < 0.57 ) { return new Prediction("Baseline", 9.33, 0); }
	}
	if( TimeSinceLastCall >= 20.11 ) { 
		if( ScreenChangedMin < 0.83 ) { return new Prediction("Baseline", 49.95, 20); }
		if( ScreenChangedMin >= 0.83 ) { return new Prediction("Picked", 19.63, 3); }
	}
	}
	}
	if( ScreenOn < 0.5 ) { 
	if( MaxAcc >= 0.01 ) { 
	if( CalledHowManyTimes >= 2.5 ) { 
		if( ChargingChangedMin >= 118.94 ) { return new Prediction("Picked", 19.98, 1.98); }
		if( ChargingChangedMin < 118.94 ) { return new Prediction("Picked", 76, 0); }
	}
	if( CalledHowManyTimes < 2.5 ) { 
		if( Pitch < -72.5 ) { return new Prediction("Picked", 11, 5); }
		if( Pitch >= -72.5 ) { return new Prediction("Picked", 26, 0); }
	}
	}
	if( MaxAcc < 0.01 ) { 
	if( Pitch >= -59 ) { 
		if( Hour >= 8 ) { return new Prediction("Picked", 24.51, 2.51); }
		if( Hour < 8 ) { return new Prediction("Baseline", 2.17, 0); }
	}
	if( Pitch < -59 ) { 
		if( MaxAcc >= 0 ) { return new Prediction("Baseline", 17, 8); }
		if( MaxAcc < 0 ) { return new Prediction("Baseline", 7.62, 0); }
	}
	}
	}
	}
	if( Pitch >= -9.5 ) { 
	if( TimeSinceLastCall < 2.22 ) { 
		if( RingerModeChangedMin < 1.63 ) { return new Prediction("Picked", 1, 0); }
	if( RingerModeChangedMin >= 1.63 ) { 
		if( ScreenChangedMin >= 0.19 ) { return new Prediction("Baseline", 71.72, 0); }
	if( ScreenChangedMin < 0.19 ) { 
		if( CalledHowManyTimes >= 44.5 ) { return new Prediction("Picked", 3, 1); }
		if( CalledHowManyTimes < 44.5 ) { return new Prediction("Baseline", 9.02, 1); }
	}
	}
	}
	if( TimeSinceLastCall >= 2.22 ) { 
	if( MaxAcc >= 0.08 ) { 
	if( ScreenChangedMin >= 0.77 ) { 
		if( Pitch >= 11 ) { return new Prediction("Picked", 18.92, 5); }
		if( Pitch < 11 ) { return new Prediction("Picked", 64.13, 2); }
	}
	if( ScreenChangedMin < 0.77 ) { 
		if( RingerModeChangedMin < 6.85 ) { return new Prediction("Baseline", 19, 3); }
		if( RingerModeChangedMin >= 6.85 ) { return new Prediction("Picked", 109.72, 38.05); }
	}
	}
	if( MaxAcc < 0.08 ) { 
		if( ScreenChangedMin >= 11.58 ) { return new Prediction("Baseline", 47.67, 0); }
	if( ScreenChangedMin < 11.58 ) { 
		if( CalledHowManyTimes >= 212 ) { return new Prediction("Baseline", 13, 0); }
		if( CalledHowManyTimes < 212 ) { return new Prediction("Baseline", 321.1, 120.05); }
	}
	}
	}
	}
	}
	}
	if( CalledHowManyTimes >= 258.5 ) { 
		if( CalledHowManyTimes >= 779 ) { return new Prediction("Baseline", 37, 0); }
	if( CalledHowManyTimes < 779 ) { 
	if( ChargingChangedMin < 21.89 ) { 
	if( CalledHowManyTimes < 633 ) { 
		if( MaxAcc >= 0.01 ) { return new Prediction("Baseline", 89, 0); }
	if( MaxAcc < 0.01 ) { 
	if( LastCallPicked >= 0.5 ) { 
		if( Day >= 2 ) { return new Prediction("Baseline", 2, 0); }
		if( Day < 2 ) { return new Prediction("Picked", 1, 0); }
	}
		if( LastCallPicked < 0.5 ) { return new Prediction("Baseline", 11, 0); }
	}
	}
	if( CalledHowManyTimes >= 633 ) { 
	if( CalledHowManyTimes >= 660 ) { 
		if( Hour >= 20 ) { return new Prediction("Picked", 1, 0); }
	if( Hour < 20 ) { 
		if( LastCallPicked >= 0.5 ) { return new Prediction("Baseline", 3, 1); }
		if( LastCallPicked < 0.5 ) { return new Prediction("Baseline", 23, 0); }
	}
	}
	if( CalledHowManyTimes < 660 ) { 
		if( ChargingChangedMin >= 9.79 ) { return new Prediction("Baseline", 2, 0); }
		if( ChargingChangedMin < 9.79 ) { return new Prediction("Picked", 3, 0); }
	}
	}
	}
	if( ChargingChangedMin >= 21.89 ) { 
	if( CalledHowManyTimes < 605.5 ) { 
	if( Hour >= 9 ) { 
	if( MaxAcc >= 0.33 ) { 
		if( Hour < 15 ) { return new Prediction("Baseline", 1, 0); }
		if( Hour >= 15 ) { return new Prediction("Picked", 5, 0); }
	}
	if( MaxAcc < 0.33 ) { 
		if( Hour >= 20 ) { return new Prediction("Baseline", 11, 0); }
		if( Hour < 20 ) { return new Prediction("Baseline", 30, 12); }
	}
	}
		if( Hour < 9 ) { return new Prediction("Baseline", 31, 0); }
	}
	if( CalledHowManyTimes >= 605.5 ) { 
	if( ChargingChangedMin < 39.36 ) { 
	if( TimeSinceLastCall < 96.73 ) { 
		if( Day >= 2 ) { return new Prediction("Baseline", 2, 0); }
		if( Day < 2 ) { return new Prediction("Baseline", 2, 1); }
	}
		if( TimeSinceLastCall >= 96.73 ) { return new Prediction("Picked", 3, 0); }
	}
		if( ChargingChangedMin >= 39.36 ) { return new Prediction("Picked", 4, 0); }
	}
	}
	}
	}
return null;
}
private Prediction runTree5() {
	if( "Normal".equals(RingerMode) ) { 
	if( CalledHowManyTimes >= 217.5 ) { 
	if( LastCallPicked >= 0.5 ) { 
	if( ChargingChangedMin < 16.67 ) { 
		if( RingerModeChangedMin < 5.57 ) { return new Prediction("Picked", 3, 0); }
	if( RingerModeChangedMin >= 5.57 ) { 
	if( CalledHowManyTimes < 237.5 ) { 
		if( TimeSinceLastCall >= 48.29 ) { return new Prediction("Picked", 3, 1); }
		if( TimeSinceLastCall < 48.29 ) { return new Prediction("Baseline", 3, 0); }
	}
		if( CalledHowManyTimes >= 237.5 ) { return new Prediction("Baseline", 16, 0); }
	}
	}
	if( ChargingChangedMin >= 16.67 ) { 
	if( CalledHowManyTimes < 224.5 ) { 
		if( TimeSinceLastCall >= 238.25 ) { return new Prediction("Picked", 1, 0); }
		if( TimeSinceLastCall < 238.25 ) { return new Prediction("Baseline", 7, 0); }
	}
	if( CalledHowManyTimes >= 224.5 ) { 
	if( CalledHowManyTimes >= 292.5 ) { 
		if( RingerModeChangedMin >= 13.69 ) { return new Prediction("Picked", 14, 2); }
		if( RingerModeChangedMin < 13.69 ) { return new Prediction("Baseline", 2, 0); }
	}
		if( CalledHowManyTimes < 292.5 ) { return new Prediction("Picked", 17, 0); }
	}
	}
	}
	if( LastCallPicked < 0.5 ) { 
		if( ScreenChangedMin < 0.13 ) { return new Prediction("Baseline", 51, 0); }
	if( ScreenChangedMin >= 0.13 ) { 
	if( ScreenOn >= 0.5 ) { 
	if( MaxAcc >= 0.1 ) { 
		if( RingerModeChangedMin < 25.39 ) { return new Prediction("Baseline", 3, 0); }
		if( RingerModeChangedMin >= 25.39 ) { return new Prediction("Picked", 3, 0); }
	}
		if( MaxAcc < 0.1 ) { return new Prediction("Baseline", 32, 0); }
	}
	if( ScreenOn < 0.5 ) { 
		if( Hour >= 18.5 ) { return new Prediction("Picked", 10, 0); }
	if( Hour < 18.5 ) { 
		if( Day >= 0.5 ) { return new Prediction("Baseline", 49, 9); }
		if( Day < 0.5 ) { return new Prediction("Baseline", 13, 0); }
	}
	}
	}
	}
	}
	if( CalledHowManyTimes < 217.5 ) { 
	if( MaxAcc >= 0.02 ) { 
	if( LastCallPicked >= 0.5 ) { 
	if( Pitch >= 20.5 ) { 
	if( RingerModeChangedMin < 20.45 ) { 
		if( Hour >= 10.5 ) { return new Prediction("Picked", 27, 0); }
		if( Hour < 10.5 ) { return new Prediction("Picked", 3, 1); }
	}
	if( RingerModeChangedMin >= 20.45 ) { 
		if( ScreenChangedMin >= 0.49 ) { return new Prediction("Picked", 30.78, 5.11); }
		if( ScreenChangedMin < 0.49 ) { return new Prediction("Baseline", 38.11, 14); }
	}
	}
	if( Pitch < 20.5 ) { 
	if( ScreenOn >= 0.5 ) { 
		if( ScreenChangedMin >= 0.04 ) { return new Prediction("Picked", 258.11, 95.89); }
		if( ScreenChangedMin < 0.04 ) { return new Prediction("Picked", 56, 0); }
	}
	if( ScreenOn < 0.5 ) { 
		if( ScreenChangedMin >= 3.65 ) { return new Prediction("Picked", 66, 20); }
		if( ScreenChangedMin < 3.65 ) { return new Prediction("Picked", 411, 10.89); }
	}
	}
	}
	if( LastCallPicked < 0.5 ) { 
	if( Pitch >= 1.5 ) { 
		if( ChargingChangedMin < 6.87 ) { return new Prediction("Baseline", 9, 0); }
	if( ChargingChangedMin >= 6.87 ) { 
		if( RingerModeChangedMin < 31.75 ) { return new Prediction("Picked", 27, 4); }
		if( RingerModeChangedMin >= 31.75 ) { return new Prediction("Baseline", 55.42, 20.3); }
	}
	}
	if( Pitch < 1.5 ) { 
	if( ScreenOn >= 0.5 ) { 
		if( TimeSinceLastCall < 1.17 ) { return new Prediction("Baseline", 15.81, 0); }
		if( TimeSinceLastCall >= 1.17 ) { return new Prediction("Picked", 162.97, 72.27); }
	}
	if( ScreenOn < 0.5 ) { 
		if( RingerModeChangedMin < 0.94 ) { return new Prediction("Baseline", 2, 0); }
		if( RingerModeChangedMin >= 0.94 ) { return new Prediction("Picked", 203.81, 34.81); }
	}
	}
	}
	}
	if( MaxAcc < 0.02 ) { 
	if( Pitch >= -2.5 ) { 
		if( ScreenChangedMin >= 20.15 ) { return new Prediction("Baseline", 18.08, 0); }
	if( ScreenChangedMin < 20.15 ) { 
	if( ScreenChangedMin >= 0.51 ) { 
		if( TimeSinceLastCall >= 5.99 ) { return new Prediction("Picked", 128.29, 37.08); }
		if( TimeSinceLastCall < 5.99 ) { return new Prediction("Baseline", 15.56, 3.04); }
	}
	if( ScreenChangedMin < 0.51 ) { 
		if( ScreenChangedMin < 0.09 ) { return new Prediction("Picked", 48.52, 11.52); }
		if( ScreenChangedMin >= 0.09 ) { return new Prediction("Baseline", 114.08, 24.52); }
	}
	}
	}
	if( Pitch < -2.5 ) { 
	if( CalledHowManyTimes >= 45 ) { 
	if( RingerModeChangedMin < 63.95 ) { 
		if( ScreenChangedMin < 6.43 ) { return new Prediction("Picked", 49.96, 8.96); }
		if( ScreenChangedMin >= 6.43 ) { return new Prediction("Baseline", 6, 0); }
	}
		if( RingerModeChangedMin >= 63.95 ) { return new Prediction("Picked", 15, 0); }
	}
	if( CalledHowManyTimes < 45 ) { 
	if( Pitch >= -103 ) { 
		if( Pitch >= -27.5 ) { return new Prediction("Picked", 96.9, 43.24); }
		if( Pitch < -27.5 ) { return new Prediction("Picked", 85.31, 21.98); }
	}
	if( Pitch < -103 ) { 
		if( Pitch >= -144 ) { return new Prediction("Baseline", 24.22, 2.66); }
		if( Pitch < -144 ) { return new Prediction("Picked", 21.06, 8.49); }
	}
	}
	}
	}
	}
	}
	if( "Silent".equals(RingerMode) ) { 
	if( Pitch < -13.5 ) { 
	if( Day < 5.5 ) { 
	if( TimeSinceLastCall < 49.36 ) { 
	if( MaxAcc >= 0.01 ) { 
	if( ChargingChangedMin >= 140.21 ) { 
		if( ChargingChangedMin < 363.5 ) { return new Prediction("Baseline", 5, 1); }
		if( ChargingChangedMin >= 363.5 ) { return new Prediction("Picked", 1, 0); }
	}
	if( ChargingChangedMin < 140.21 ) { 
		if( CalledHowManyTimes >= 231.5 ) { return new Prediction("Baseline", 1, 0); }
		if( CalledHowManyTimes < 231.5 ) { return new Prediction("Picked", 41, 0); }
	}
	}
	if( MaxAcc < 0.01 ) { 
	if( RingerModeChangedMin < 73.51 ) { 
		if( MaxAcc >= 0 ) { return new Prediction("Baseline", 6, 0); }
		if( MaxAcc < 0 ) { return new Prediction("Picked", 1, 0); }
	}
		if( RingerModeChangedMin >= 73.51 ) { return new Prediction("Picked", 2, 0); }
	}
	}
	if( TimeSinceLastCall >= 49.36 ) { 
	if( Day >= 3.5 ) { 
	if( ScreenChangedMin < 11.53 ) { 
		if( RingerModeChangedMin >= 887.5 ) { return new Prediction("Baseline", 1, 0); }
		if( RingerModeChangedMin < 887.5 ) { return new Prediction("Picked", 8, 0); }
	}
		if( ScreenChangedMin >= 11.53 ) { return new Prediction("Baseline", 3, 0); }
	}
		if( Day < 3.5 ) { return new Prediction("Baseline", 17.63, 0); }
	}
	}
		if( Day >= 5.5 ) { return new Prediction("Baseline", 14, 0); }
	}
	if( Pitch >= -13.5 ) { 
	if( ChargingChangedMin >= 81.22 ) { 
		if( TimeSinceLastCall < 2.39 ) { return new Prediction("Baseline", 16, 0); }
	if( TimeSinceLastCall >= 2.39 ) { 
	if( Proximity < 0.5 ) { 
		if( Pitch < -3 ) { return new Prediction("Baseline", 5, 0); }
	if( Pitch >= -3 ) { 
		if( Day >= 2.5 ) { return new Prediction("Picked", 27, 6); }
		if( Day < 2.5 ) { return new Prediction("Baseline", 17, 7); }
	}
	}
	if( Proximity >= 0.5 ) { 
	if( TimeSinceLastCall >= 222.05 ) { 
		if( ScreenChangedMin < 0.46 ) { return new Prediction("Baseline", 3, 0); }
		if( ScreenChangedMin >= 0.46 ) { return new Prediction("Picked", 2, 0); }
	}
		if( TimeSinceLastCall < 222.05 ) { return new Prediction("Baseline", 15, 0); }
	}
	}
	}
	if( ChargingChangedMin < 81.22 ) { 
	if( CalledHowManyTimes >= 34.5 ) { 
		if( Charging >= 0.5 ) { return new Prediction("Baseline", 15, 0); }
	if( Charging < 0.5 ) { 
	if( Day >= 2.5 ) { 
		if( ChargingChangedMin >= 0.52 ) { return new Prediction("Baseline", 22, 0); }
		if( ChargingChangedMin < 0.52 ) { return new Prediction("Baseline", 2, 1); }
	}
	if( Day < 2.5 ) { 
		if( MaxAcc >= 0.02 ) { return new Prediction("Picked", 7, 1); }
		if( MaxAcc < 0.02 ) { return new Prediction("Baseline", 3, 0); }
	}
	}
	}
	if( CalledHowManyTimes < 34.5 ) { 
	if( ScreenChangedMin >= 0.05 ) { 
		if( Day < 5.5 ) { return new Prediction("Baseline", 81.37, 0); }
	if( Day >= 5.5 ) { 
		if( ChargingChangedMin < 22.6 ) { return new Prediction("Baseline", 2, 0); }
		if( ChargingChangedMin >= 22.6 ) { return new Prediction("Picked", 1, 0); }
	}
	}
		if( ScreenChangedMin < 0.05 ) { return new Prediction("Picked", 2, 0); }
	}
	}
	}
	}
	if( "Vibrate".equals(RingerMode) ) { 
	if( Hour >= 9.5 ) { 
	if( ScreenOn >= 0.5 ) { 
	if( Day >= 2.5 ) { 
	if( ScreenChangedMin >= 0.69 ) { 
	if( TimeSinceLastCall >= 2.99 ) { 
		if( CalledHowManyTimes < 162.5 ) { return new Prediction("Picked", 14, 1); }
		if( CalledHowManyTimes >= 162.5 ) { return new Prediction("Baseline", 4, 0); }
	}
		if( TimeSinceLastCall < 2.99 ) { return new Prediction("Baseline", 5, 0); }
	}
	if( ScreenChangedMin < 0.69 ) { 
		if( RingerModeChangedMin < 0.08 ) { return new Prediction("Picked", 2, 0); }
	if( RingerModeChangedMin >= 0.08 ) { 
		if( ChargingChangedMin >= 40.49 ) { return new Prediction("Baseline", 43, 0); }
		if( ChargingChangedMin < 40.49 ) { return new Prediction("Baseline", 49, 7); }
	}
	}
	}
	if( Day < 2.5 ) { 
	if( Pitch >= -27.5 ) { 
	if( RingerModeChangedMin < 18.62 ) { 
		if( ScreenChangedMin >= 0.1 ) { return new Prediction("Picked", 23, 6); }
		if( ScreenChangedMin < 0.1 ) { return new Prediction("Baseline", 5, 0); }
	}
	if( RingerModeChangedMin >= 18.62 ) { 
		if( ChargingChangedMin < 30.95 ) { return new Prediction("Baseline", 16, 0); }
		if( ChargingChangedMin >= 30.95 ) { return new Prediction("Baseline", 36, 10); }
	}
	}
	if( Pitch < -27.5 ) { 
		if( Pitch < -171.5 ) { return new Prediction("Baseline", 2, 0); }
	if( Pitch >= -171.5 ) { 
		if( TimeSinceLastCall < 78.68 ) { return new Prediction("Picked", 13, 5); }
		if( TimeSinceLastCall >= 78.68 ) { return new Prediction("Picked", 13, 0); }
	}
	}
	}
	}
	if( ScreenOn < 0.5 ) { 
	if( ScreenChangedMin < 10.68 ) { 
	if( RingerModeChangedMin < 24.4 ) { 
	if( Hour >= 17.5 ) { 
		if( Pitch >= 1 ) { return new Prediction("Picked", 2, 0); }
		if( Pitch < 1 ) { return new Prediction("Baseline", 4, 1); }
	}
	if( Hour < 17.5 ) { 
		if( TimeSinceLastCall >= 1121.33 ) { return new Prediction("Baseline", 1, 0); }
		if( TimeSinceLastCall < 1121.33 ) { return new Prediction("Picked", 33, 1); }
	}
	}
	if( RingerModeChangedMin >= 24.4 ) { 
	if( CalledHowManyTimes < 1.5 ) { 
		if( LastCallPicked >= 0.5 ) { return new Prediction("Picked", 6, 0); }
		if( LastCallPicked < 0.5 ) { return new Prediction("Baseline", 2, 1); }
	}
		if( CalledHowManyTimes >= 1.5 ) { return new Prediction("Picked", 42, 0); }
	}
	}
		if( ScreenChangedMin >= 10.68 ) { return new Prediction("Baseline", 5, 0); }
	}
	}
	if( Hour < 9.5 ) { 
		if( MaxAcc >= 0.15 ) { return new Prediction("Baseline", 44, 0); }
	if( MaxAcc < 0.15 ) { 
	if( CalledHowManyTimes < 185.5 ) { 
	if( ScreenOn >= 0.5 ) { 
	if( MaxAcc < 0.06 ) { 
		if( TimeSinceLastCall < 2.89 ) { return new Prediction("Baseline", 7, 1); }
		if( TimeSinceLastCall >= 2.89 ) { return new Prediction("Baseline", 16, 0); }
	}
		if( MaxAcc >= 0.06 ) { return new Prediction("Picked", 3, 0); }
	}
	if( ScreenOn < 0.5 ) { 
	if( CalledHowManyTimes >= 44.5 ) { 
		if( LastCallPicked >= 0.5 ) { return new Prediction("Picked", 4, 0); }
		if( LastCallPicked < 0.5 ) { return new Prediction("Baseline", 10, 0); }
	}
	if( CalledHowManyTimes < 44.5 ) { 
		if( ScreenChangedMin >= 40.74 ) { return new Prediction("Baseline", 3, 0); }
		if( ScreenChangedMin < 40.74 ) { return new Prediction("Picked", 16, 1); }
	}
	}
	}
		if( CalledHowManyTimes >= 185.5 ) { return new Prediction("Baseline", 39, 0); }
	}
	}
	}
return null;
}
private Prediction runTree6() {
	if( "Normal".equals(RingerMode) ) { 
	if( ScreenChangedMin >= 0.51 ) { 
	if( MaxAcc < 0.04 ) { 
	if( ScreenChangedMin >= 5.48 ) { 
	if( MaxAcc >= 0 ) { 
	if( RingerModeChangedMin >= 107.57 ) { 
		if( Pitch < 6 ) { return new Prediction("Picked", 24.67, 3); }
		if( Pitch >= 6 ) { return new Prediction("Baseline", 12.33, 0.33); }
	}
	if( RingerModeChangedMin < 107.57 ) { 
		if( ScreenChangedMin < 9.07 ) { return new Prediction("Baseline", 20, 7); }
		if( ScreenChangedMin >= 9.07 ) { return new Prediction("Baseline", 50, 1); }
	}
	}
	if( MaxAcc < 0 ) { 
	if( Day < 1.5 ) { 
		if( MaxAcc >= 0 ) { return new Prediction("Baseline", 3, 0); }
		if( MaxAcc < 0 ) { return new Prediction("Baseline", 2, 1); }
	}
		if( Day >= 1.5 ) { return new Prediction("Baseline", 28, 0); }
	}
	}
	if( ScreenChangedMin < 5.48 ) { 
	if( CalledHowManyTimes < 73 ) { 
	if( ScreenOn >= 0.5 ) { 
		if( MaxAcc < 0.04 ) { return new Prediction("Picked", 86, 36); }
		if( MaxAcc >= 0.04 ) { return new Prediction("Picked", 9, 0); }
	}
	if( ScreenOn < 0.5 ) { 
		if( Pitch < -171 ) { return new Prediction("Baseline", 6.06, 1.06); }
		if( Pitch >= -171 ) { return new Prediction("Picked", 181.94, 18); }
	}
	}
	if( CalledHowManyTimes >= 73 ) { 
	if( Pitch < -2 ) { 
		if( MaxAcc >= 0.01 ) { return new Prediction("Baseline", 10, 3); }
		if( MaxAcc < 0.01 ) { return new Prediction("Picked", 15, 1); }
	}
	if( Pitch >= -2 ) { 
		if( TimeSinceLastCall < 435.77 ) { return new Prediction("Baseline", 47, 7); }
		if( TimeSinceLastCall >= 435.77 ) { return new Prediction("Picked", 3, 0); }
	}
	}
	}
	}
	if( MaxAcc >= 0.04 ) { 
	if( LastCallPicked >= 0.5 ) { 
	if( TimeSinceLastCall < 95.86 ) { 
	if( CalledHowManyTimes >= 155.5 ) { 
		if( ChargingChangedMin >= 7.31 ) { return new Prediction("Picked", 15, 4); }
		if( ChargingChangedMin < 7.31 ) { return new Prediction("Baseline", 2, 0); }
	}
	if( CalledHowManyTimes < 155.5 ) { 
		if( ChargingChangedMin < 509.3 ) { return new Prediction("Picked", 242, 13); }
		if( ChargingChangedMin >= 509.3 ) { return new Prediction("Picked", 25, 5); }
	}
	}
	if( TimeSinceLastCall >= 95.86 ) { 
		if( ScreenChangedMin < 0.53 ) { return new Prediction("Baseline", 1, 0); }
		if( ScreenChangedMin >= 0.53 ) { return new Prediction("Picked", 139, 0); }
	}
	}
	if( LastCallPicked < 0.5 ) { 
	if( MaxAcc >= 0.29 ) { 
	if( TimeSinceLastCall >= 6.58 ) { 
		if( ScreenChangedMin >= 20.77 ) { return new Prediction("Baseline", 2, 0); }
		if( ScreenChangedMin < 20.77 ) { return new Prediction("Picked", 98, 5); }
	}
	if( TimeSinceLastCall < 6.58 ) { 
		if( ScreenChangedMin < 1.06 ) { return new Prediction("Baseline", 6, 0); }
		if( ScreenChangedMin >= 1.06 ) { return new Prediction("Picked", 8, 2); }
	}
	}
	if( MaxAcc < 0.29 ) { 
	if( ChargingChangedMin < 17.67 ) { 
		if( RingerModeChangedMin < 9.05 ) { return new Prediction("Baseline", 24, 4); }
		if( RingerModeChangedMin >= 9.05 ) { return new Prediction("Picked", 10, 3); }
	}
	if( ChargingChangedMin >= 17.67 ) { 
		if( ScreenChangedMin >= 3.75 ) { return new Prediction("Picked", 26, 11); }
		if( ScreenChangedMin < 3.75 ) { return new Prediction("Picked", 43, 4); }
	}
	}
	}
	}
	}
	if( ScreenChangedMin < 0.51 ) { 
	if( ScreenOn >= 0.5 ) { 
	if( TimeSinceLastCall < 1.04 ) { 
	if( ChargingChangedMin >= 39.77 ) { 
		if( LastCallPicked >= 0.5 ) { return new Prediction("Picked", 3, 0); }
		if( LastCallPicked < 0.5 ) { return new Prediction("Baseline", 9, 0); }
	}
		if( ChargingChangedMin < 39.77 ) { return new Prediction("Baseline", 22, 0); }
	}
	if( TimeSinceLastCall >= 1.04 ) { 
	if( ScreenChangedMin < 0.09 ) { 
	if( ChargingChangedMin < 14.51 ) { 
		if( LastCallPicked >= 0.5 ) { return new Prediction("Picked", 58, 16); }
		if( LastCallPicked < 0.5 ) { return new Prediction("Baseline", 48, 8); }
	}
	if( ChargingChangedMin >= 14.51 ) { 
		if( CalledHowManyTimes < 265.5 ) { return new Prediction("Picked", 159, 28); }
		if( CalledHowManyTimes >= 265.5 ) { return new Prediction("Baseline", 17, 2); }
	}
	}
	if( ScreenChangedMin >= 0.09 ) { 
	if( LastCallPicked >= 0.5 ) { 
		if( MaxAcc >= 0.01 ) { return new Prediction("Baseline", 169, 66); }
		if( MaxAcc < 0.01 ) { return new Prediction("Baseline", 63, 4); }
	}
	if( LastCallPicked < 0.5 ) { 
		if( MaxAcc >= 0 ) { return new Prediction("Baseline", 143, 19); }
		if( MaxAcc < 0 ) { return new Prediction("Picked", 2, 0); }
	}
	}
	}
	}
	if( ScreenOn < 0.5 ) { 
	if( RingerModeChangedMin >= 0.57 ) { 
	if( MaxAcc < 4.22 ) { 
	if( ScreenChangedMin < 0.16 ) { 
		if( LastCallPicked >= 0.5 ) { return new Prediction("Picked", 81, 0); }
		if( LastCallPicked < 0.5 ) { return new Prediction("Picked", 25, 1); }
	}
	if( ScreenChangedMin >= 0.16 ) { 
		if( ScreenChangedMin < 0.44 ) { return new Prediction("Picked", 192, 23); }
		if( ScreenChangedMin >= 0.44 ) { return new Prediction("Picked", 48, 1); }
	}
	}
	if( MaxAcc >= 4.22 ) { 
	if( TimeSinceLastCall >= 3.13 ) { 
		if( Pitch >= -153.5 ) { return new Prediction("Picked", 52.96, 5.96); }
		if( Pitch < -153.5 ) { return new Prediction("Baseline", 2.04, 0); }
	}
	if( TimeSinceLastCall < 3.13 ) { 
		if( Day >= 2 ) { return new Prediction("Baseline", 6, 0); }
		if( Day < 2 ) { return new Prediction("Picked", 2, 0); }
	}
	}
	}
	if( RingerModeChangedMin < 0.57 ) { 
	if( ScreenChangedMin >= 0.2 ) { 
		if( Pitch < -23.5 ) { return new Prediction("Picked", 1, 0); }
		if( Pitch >= -23.5 ) { return new Prediction("Baseline", 1, 0); }
	}
		if( ScreenChangedMin < 0.2 ) { return new Prediction("Baseline", 8, 0); }
	}
	}
	}
	}
	if( "Silent".equals(RingerMode) ) { 
	if( Pitch < -12.5 ) { 
	if( ScreenChangedMin < 8.45 ) { 
	if( MaxAcc < 0.05 ) { 
	if( ScreenOn >= 0.5 ) { 
	if( LastCallPicked >= 0.5 ) { 
		if( CalledHowManyTimes < 35.5 ) { return new Prediction("Baseline", 9, 0); }
		if( CalledHowManyTimes >= 35.5 ) { return new Prediction("Picked", 2, 0); }
	}
		if( LastCallPicked < 0.5 ) { return new Prediction("Baseline", 20.35, 0); }
	}
	if( ScreenOn < 0.5 ) { 
		if( Charging >= 0.5 ) { return new Prediction("Baseline", 1, 0); }
	if( Charging < 0.5 ) { 
		if( Pitch >= -25.5 ) { return new Prediction("Baseline", 3.1, 1); }
		if( Pitch < -25.5 ) { return new Prediction("Picked", 17.57, 1.57); }
	}
	}
	}
	if( MaxAcc >= 0.05 ) { 
	if( RingerModeChangedMin >= 31 ) { 
	if( Pitch < -44.5 ) { 
		if( Day >= 3.5 ) { return new Prediction("Baseline", 1, 0); }
		if( Day < 3.5 ) { return new Prediction("Picked", 4, 0); }
	}
		if( Pitch >= -44.5 ) { return new Prediction("Picked", 14, 0); }
	}
	if( RingerModeChangedMin < 31 ) { 
	if( ScreenChangedMin >= 0.33 ) { 
		if( CalledHowManyTimes >= 2.5 ) { return new Prediction("Baseline", 8, 0); }
		if( CalledHowManyTimes < 2.5 ) { return new Prediction("Picked", 3, 1); }
	}
		if( ScreenChangedMin < 0.33 ) { return new Prediction("Picked", 4, 0); }
	}
	}
	}
		if( ScreenChangedMin >= 8.45 ) { return new Prediction("Baseline", 18, 0); }
	}
	if( Pitch >= -12.5 ) { 
		if( ScreenChangedMin >= 4.25 ) { return new Prediction("Baseline", 48.33, 0); }
	if( ScreenChangedMin < 4.25 ) { 
	if( LastCallPicked >= 0.5 ) { 
	if( ScreenChangedMin < 0.79 ) { 
	if( ScreenOn >= 0.5 ) { 
		if( MaxAcc >= 0 ) { return new Prediction("Baseline", 20, 0); }
		if( MaxAcc < 0 ) { return new Prediction("Picked", 3, 1); }
	}
		if( ScreenOn < 0.5 ) { return new Prediction("Picked", 5, 0); }
	}
	if( ScreenChangedMin >= 0.79 ) { 
		if( ChargingChangedMin >= 399.77 ) { return new Prediction("Baseline", 2, 0); }
		if( ChargingChangedMin < 399.77 ) { return new Prediction("Picked", 19, 0); }
	}
	}
	if( LastCallPicked < 0.5 ) { 
	if( MaxAcc < 0.07 ) { 
		if( ChargingChangedMin < 57.25 ) { return new Prediction("Baseline", 48, 0); }
	if( ChargingChangedMin >= 57.25 ) { 
		if( Hour < 13.5 ) { return new Prediction("Baseline", 13, 2); }
		if( Hour >= 13.5 ) { return new Prediction("Baseline", 26.65, 0); }
	}
	}
	if( MaxAcc >= 0.07 ) { 
	if( Proximity < 0.5 ) { 
		if( ScreenChangedMin >= 0.28 ) { return new Prediction("Picked", 9, 4); }
		if( ScreenChangedMin < 0.28 ) { return new Prediction("Baseline", 2, 0); }
	}
	if( Proximity >= 0.5 ) { 
		if( ChargingChangedMin >= 76.31 ) { return new Prediction("Baseline", 8, 0); }
		if( ChargingChangedMin < 76.31 ) { return new Prediction("Baseline", 3, 1); }
	}
	}
	}
	}
	}
	}
	if( "Vibrate".equals(RingerMode) ) { 
	if( Pitch < -7.5 ) { 
	if( CalledHowManyTimes >= 249 ) { 
		if( MaxAcc >= 0.22 ) { return new Prediction("Picked", 1, 0); }
		if( MaxAcc < 0.22 ) { return new Prediction("Baseline", 15, 0); }
	}
	if( CalledHowManyTimes < 249 ) { 
	if( ScreenOn >= 0.5 ) { 
	if( ScreenChangedMin >= 0.06 ) { 
	if( ScreenChangedMin < 0.56 ) { 
		if( CalledHowManyTimes < 3.5 ) { return new Prediction("Baseline", 18, 0); }
		if( CalledHowManyTimes >= 3.5 ) { return new Prediction("Baseline", 31, 13); }
	}
	if( ScreenChangedMin >= 0.56 ) { 
		if( MaxAcc < 3.9 ) { return new Prediction("Picked", 16, 3); }
		if( MaxAcc >= 3.9 ) { return new Prediction("Baseline", 3, 0); }
	}
	}
		if( ScreenChangedMin < 0.06 ) { return new Prediction("Picked", 17, 0); }
	}
	if( ScreenOn < 0.5 ) { 
	if( Pitch >= -87.5 ) { 
		if( ScreenChangedMin < 4.84 ) { return new Prediction("Picked", 39, 0); }
	if( ScreenChangedMin >= 4.84 ) { 
		if( Pitch < -29.5 ) { return new Prediction("Picked", 2.38, 0.38); }
		if( Pitch >= -29.5 ) { return new Prediction("Baseline", 3.57, 0); }
	}
	}
	if( Pitch < -87.5 ) { 
		if( Day >= 0.5 ) { return new Prediction("Baseline", 3.09, 0); }
		if( Day < 0.5 ) { return new Prediction("Picked", 1, 0); }
	}
	}
	}
	}
	if( Pitch >= -7.5 ) { 
	if( ScreenOn >= 0.5 ) { 
	if( MaxAcc < 1.21 ) { 
	if( Day >= 2.5 ) { 
	if( ScreenChangedMin < 0.17 ) { 
		if( Proximity < 0.5 ) { return new Prediction("Baseline", 10.56, 3); }
		if( Proximity >= 0.5 ) { return new Prediction("Baseline", 8.44, 0); }
	}
		if( ScreenChangedMin >= 0.17 ) { return new Prediction("Baseline", 58, 0); }
	}
	if( Day < 2.5 ) { 
		if( Charging >= 0.5 ) { return new Prediction("Baseline", 5, 0); }
	if( Charging < 0.5 ) { 
		if( ScreenChangedMin < 0.53 ) { return new Prediction("Baseline", 43, 4); }
		if( ScreenChangedMin >= 0.53 ) { return new Prediction("Picked", 15, 3); }
	}
	}
	}
	if( MaxAcc >= 1.21 ) { 
		if( Day < 1.5 ) { return new Prediction("Picked", 11, 0); }
	if( Day >= 1.5 ) { 
	if( Pitch >= 1 ) { 
		if( ScreenChangedMin >= 3.05 ) { return new Prediction("Picked", 2, 0); }
		if( ScreenChangedMin < 3.05 ) { return new Prediction("Baseline", 11, 0); }
	}
	if( Pitch < 1 ) { 
		if( TimeSinceLastCall < 40.71 ) { return new Prediction("Picked", 7, 0); }
		if( TimeSinceLastCall >= 40.71 ) { return new Prediction("Picked", 13, 6); }
	}
	}
	}
	}
	if( ScreenOn < 0.5 ) { 
	if( CalledHowManyTimes < 122.5 ) { 
		if( Hour < 7.5 ) { return new Prediction("Baseline", 4, 0); }
	if( Hour >= 7.5 ) { 
	if( CalledHowManyTimes < 10 ) { 
		if( TimeSinceLastCall >= 70.36 ) { return new Prediction("Baseline", 10.66, 3); }
		if( TimeSinceLastCall < 70.36 ) { return new Prediction("Picked", 17, 2); }
	}
	if( CalledHowManyTimes >= 10 ) { 
		if( MaxAcc >= 0 ) { return new Prediction("Picked", 25, 0); }
		if( MaxAcc < 0 ) { return new Prediction("Baseline", 1.31, 0); }
	}
	}
	}
	if( CalledHowManyTimes >= 122.5 ) { 
	if( ScreenChangedMin < 1.94 ) { 
		if( Day >= 2.5 ) { return new Prediction("Baseline", 5, 0); }
		if( Day < 2.5 ) { return new Prediction("Picked", 5, 0); }
	}
		if( ScreenChangedMin >= 1.94 ) { return new Prediction("Baseline", 34, 0); }
	}
	}
	}
	}
return null;
}
private Prediction runTree7() {
	if( ScreenChangedMin < 9.66 ) { 
	if( ScreenOn >= 0.5 ) { 
	if( LastCallPicked >= 0.5 ) { 
	if( Pitch < 37.5 ) { 
	if( TimeSinceLastCall < 10.03 ) { 
	if( ChargingChangedMin < 21.13 ) { 
		if( Pitch < -47.5 ) { return new Prediction("Picked", 4.13, 0.13); }
		if( Pitch >= -47.5 ) { return new Prediction("Baseline", 23.76, 11); }
	}
	if( ChargingChangedMin >= 21.13 ) { 
		if( Pitch < -1.5 ) { return new Prediction("Picked", 52.67, 0.54); }
		if( Pitch >= -1.5 ) { return new Prediction("Picked", 33.52, 5.34); }
	}
	}
	if( TimeSinceLastCall >= 10.03 ) { 
	if( "Normal".equals(RingerMode) ) { 
		if( Hour < 13.5 ) { return new Prediction("Picked", 202.98, 93); }
		if( Hour >= 13.5 ) { return new Prediction("Picked", 227.18, 75.66); }
	}
	if( "Silent".equals(RingerMode) ) { 
		if( ScreenChangedMin < 1.02 ) { return new Prediction("Baseline", 31, 5); }
		if( ScreenChangedMin >= 1.02 ) { return new Prediction("Picked", 9, 0); }
	}
	if( "Vibrate".equals(RingerMode) ) { 
		if( MaxAcc >= 1.72 ) { return new Prediction("Picked", 22, 4); }
		if( MaxAcc < 1.72 ) { return new Prediction("Baseline", 91, 25); }
	}
	}
	}
	if( Pitch >= 37.5 ) { 
	if( Day >= 2.5 ) { 
	if( MaxAcc >= 0.02 ) { 
		if( MaxAcc < 4.66 ) { return new Prediction("Picked", 18.48, 3.45); }
		if( MaxAcc >= 4.66 ) { return new Prediction("Baseline", 11, 3); }
	}
	if( MaxAcc < 0.02 ) { 
		if( Hour >= 13 ) { return new Prediction("Baseline", 8, 0); }
		if( Hour < 13 ) { return new Prediction("Baseline", 5.34, 1.34); }
	}
	}
	if( Day < 2.5 ) { 
	if( "Normal".equals(RingerMode) ) { 
		if( ScreenChangedMin < 0.5 ) { return new Prediction("Baseline", 34.02, 3.02); }
		if( ScreenChangedMin >= 0.5 ) { return new Prediction("Picked", 2.92, 1.11); }
	}
		if( "Silent".equals(RingerMode) ) { return new Prediction("Baseline", 0, 0); }
		if( "Vibrate".equals(RingerMode) ) { return new Prediction("Baseline", 9, 0); }
	}
	}
	}
	if( LastCallPicked < 0.5 ) { 
	if( CalledHowManyTimes < 236.5 ) { 
	if( MaxAcc < 0.07 ) { 
	if( "Normal".equals(RingerMode) ) { 
		if( ScreenChangedMin >= 0.04 ) { return new Prediction("Baseline", 167, 32); }
		if( ScreenChangedMin < 0.04 ) { return new Prediction("Picked", 26, 10); }
	}
	if( "Silent".equals(RingerMode) ) { 
		if( CalledHowManyTimes >= 210.5 ) { return new Prediction("Picked", 2, 0); }
		if( CalledHowManyTimes < 210.5 ) { return new Prediction("Baseline", 59, 3); }
	}
	if( "Vibrate".equals(RingerMode) ) { 
		if( ScreenChangedMin >= 0.07 ) { return new Prediction("Baseline", 49, 4); }
		if( ScreenChangedMin < 0.07 ) { return new Prediction("Picked", 4, 1); }
	}
	}
	if( MaxAcc >= 0.07 ) { 
	if( RingerModeChangedMin < 1.74 ) { 
		if( MaxAcc < 1.93 ) { return new Prediction("Baseline", 14, 0); }
		if( MaxAcc >= 1.93 ) { return new Prediction("Baseline", 9, 2); }
	}
	if( RingerModeChangedMin >= 1.74 ) { 
		if( ScreenChangedMin >= 0.77 ) { return new Prediction("Picked", 53, 4); }
		if( ScreenChangedMin < 0.77 ) { return new Prediction("Baseline", 159, 57); }
	}
	}
	}
		if( CalledHowManyTimes >= 236.5 ) { return new Prediction("Baseline", 150, 0); }
	}
	}
	if( ScreenOn < 0.5 ) { 
	if( CalledHowManyTimes < 211.5 ) { 
	if( "Normal".equals(RingerMode) ) { 
	if( ChargingChangedMin >= 0.15 ) { 
	if( MaxAcc >= 0 ) { 
		if( Pitch < 25 ) { return new Prediction("Picked", 862.1, 60.89); }
		if( Pitch >= 25 ) { return new Prediction("Picked", 109.9, 30.11); }
	}
	if( MaxAcc < 0 ) { 
		if( TimeSinceLastCall >= 20.27 ) { return new Prediction("Baseline", 6, 0); }
		if( TimeSinceLastCall < 20.27 ) { return new Prediction("Picked", 2, 0); }
	}
	}
		if( ChargingChangedMin < 0.15 ) { return new Prediction("Baseline", 3, 0); }
	}
	if( "Silent".equals(RingerMode) ) { 
	if( ScreenChangedMin >= 2.05 ) { 
		if( Pitch >= 6.5 ) { return new Prediction("Baseline", 15.48, 0); }
	if( Pitch < 6.5 ) { 
		if( CalledHowManyTimes < 32.5 ) { return new Prediction("Picked", 13.52, 5.52); }
		if( CalledHowManyTimes >= 32.5 ) { return new Prediction("Baseline", 3, 0); }
	}
	}
	if( ScreenChangedMin < 2.05 ) { 
	if( Pitch < -11 ) { 
		if( RingerModeChangedMin >= 2.7 ) { return new Prediction("Picked", 34, 0); }
		if( RingerModeChangedMin < 2.7 ) { return new Prediction("Baseline", 3, 1); }
	}
	if( Pitch >= -11 ) { 
		if( ChargingChangedMin < 113.76 ) { return new Prediction("Picked", 21, 5); }
		if( ChargingChangedMin >= 113.76 ) { return new Prediction("Baseline", 9, 0); }
	}
	}
	}
	if( "Vibrate".equals(RingerMode) ) { 
	if( RingerModeChangedMin >= 7.49 ) { 
		if( RingerModeChangedMin >= 42.6 ) { return new Prediction("Picked", 29, 0); }
	if( RingerModeChangedMin < 42.6 ) { 
		if( TimeSinceLastCall >= 924.28 ) { return new Prediction("Baseline", 1, 0); }
		if( TimeSinceLastCall < 924.28 ) { return new Prediction("Picked", 40, 2); }
	}
	}
	if( RingerModeChangedMin < 7.49 ) { 
		if( MaxAcc >= 0.08 ) { return new Prediction("Picked", 7, 0); }
	if( MaxAcc < 0.08 ) { 
		if( Hour >= 12 ) { return new Prediction("Picked", 1, 0); }
		if( Hour < 12 ) { return new Prediction("Baseline", 5, 0); }
	}
	}
	}
	}
	if( CalledHowManyTimes >= 211.5 ) { 
	if( ScreenChangedMin >= 1.55 ) { 
	if( Pitch < -1.5 ) { 
	if( Hour >= 8.5 ) { 
		if( ScreenChangedMin >= 3.51 ) { return new Prediction("Baseline", 3, 1); }
		if( ScreenChangedMin < 3.51 ) { return new Prediction("Picked", 3, 0); }
	}
		if( Hour < 8.5 ) { return new Prediction("Baseline", 10, 0); }
	}
	if( Pitch >= -1.5 ) { 
	if( Day < 1.5 ) { 
		if( MaxAcc >= 0.16 ) { return new Prediction("Baseline", 2, 1); }
		if( MaxAcc < 0.16 ) { return new Prediction("Baseline", 15, 0); }
	}
		if( Day >= 1.5 ) { return new Prediction("Baseline", 25, 0); }
	}
	}
	if( ScreenChangedMin < 1.55 ) { 
	if( MaxAcc < 0.48 ) { 
		if( ChargingChangedMin < 0.67 ) { return new Prediction("Baseline", 9, 0); }
	if( ChargingChangedMin >= 0.67 ) { 
		if( ScreenChangedMin >= 0.55 ) { return new Prediction("Picked", 13, 2); }
		if( ScreenChangedMin < 0.55 ) { return new Prediction("Baseline", 29, 8); }
	}
	}
		if( MaxAcc >= 0.48 ) { return new Prediction("Picked", 13, 0); }
	}
	}
	}
	}
	if( ScreenChangedMin >= 9.66 ) { 
	if( MaxAcc < 0.04 ) { 
	if( ScreenChangedMin < 26.77 ) { 
	if( RingerModeChangedMin < 98.81 ) { 
		if( Day < 5.5 ) { return new Prediction("Baseline", 61, 0); }
	if( Day >= 5.5 ) { 
		if( ScreenChangedMin >= 15.61 ) { return new Prediction("Baseline", 5, 0); }
		if( ScreenChangedMin < 15.61 ) { return new Prediction("Picked", 1, 0); }
	}
	}
	if( RingerModeChangedMin >= 98.81 ) { 
	if( MaxAcc >= 0.01 ) { 
		if( RingerModeChangedMin >= 711.3 ) { return new Prediction("Picked", 4, 0); }
		if( RingerModeChangedMin < 711.3 ) { return new Prediction("Baseline", 18, 0); }
	}
	if( MaxAcc < 0.01 ) { 
	if( Hour < 16.5 ) { 
		if( ScreenChangedMin < 18.8 ) { return new Prediction("Baseline", 8, 2); }
		if( ScreenChangedMin >= 18.8 ) { return new Prediction("Picked", 2, 0); }
	}
		if( Hour >= 16.5 ) { return new Prediction("Picked", 7, 0); }
	}
	}
	}
		if( ScreenChangedMin >= 26.77 ) { return new Prediction("Baseline", 43, 0); }
	}
	if( MaxAcc >= 0.04 ) { 
	if( Proximity < 0.5 ) { 
	if( ScreenChangedMin < 21.03 ) { 
		if( Day >= 3.5 ) { return new Prediction("Picked", 15, 0); }
	if( Day < 3.5 ) { 
	if( TimeSinceLastCall < 56.1 ) { 
		if( CalledHowManyTimes >= 8 ) { return new Prediction("Baseline", 7, 3); }
		if( CalledHowManyTimes < 8 ) { return new Prediction("Picked", 5, 0); }
	}
		if( TimeSinceLastCall >= 56.1 ) { return new Prediction("Picked", 13, 0); }
	}
	}
	if( ScreenChangedMin >= 21.03 ) { 
		if( Hour < 13.5 ) { return new Prediction("Baseline", 11, 0); }
	if( Hour >= 13.5 ) { 
		if( Pitch < 14 ) { return new Prediction("Picked", 10, 0); }
		if( Pitch >= 14 ) { return new Prediction("Baseline", 1, 0); }
	}
	}
	}
	if( Proximity >= 0.5 ) { 
	if( CalledHowManyTimes < 3 ) { 
	if( RingerModeChangedMin >= 145.07 ) { 
		if( MaxAcc >= 4.99 ) { return new Prediction("Baseline", 1, 0); }
		if( MaxAcc < 4.99 ) { return new Prediction("Picked", 3, 0); }
	}
		if( RingerModeChangedMin < 145.07 ) { return new Prediction("Baseline", 2, 0); }
	}
		if( CalledHowManyTimes >= 3 ) { return new Prediction("Baseline", 17, 0); }
	}
	}
	}
return null;
}
private Prediction runTree8() {
	if( ScreenOn >= 0.5 ) { 
	if( Pitch < -9.5 ) { 
	if( ScreenChangedMin < 0.08 ) { 
	if( CalledHowManyTimes < 277.5 ) { 
	if( Pitch >= -177.5 ) { 
	if( RingerModeChangedMin < 3.34 ) { 
		if( Day >= 3.5 ) { return new Prediction("Baseline", 2, 0); }
		if( Day < 3.5 ) { return new Prediction("Picked", 6, 1); }
	}
	if( RingerModeChangedMin >= 3.34 ) { 
		if( CalledHowManyTimes >= 22 ) { return new Prediction("Picked", 59.33, 0.33); }
		if( CalledHowManyTimes < 22 ) { return new Prediction("Picked", 60.99, 6.99); }
	}
	}
	if( Pitch < -177.5 ) { 
		if( CalledHowManyTimes < 29 ) { return new Prediction("Picked", 1.02, 0.02); }
		if( CalledHowManyTimes >= 29 ) { return new Prediction("Baseline", 2.01, 0); }
	}
	}
		if( CalledHowManyTimes >= 277.5 ) { return new Prediction("Baseline", 9, 0); }
	}
	if( ScreenChangedMin >= 0.08 ) { 
	if( MaxAcc >= 0.01 ) { 
	if( TimeSinceLastCall < 1.21 ) { 
	if( ChargingChangedMin >= 80.56 ) { 
		if( ScreenChangedMin >= 1.25 ) { return new Prediction("Picked", 2, 0); }
		if( ScreenChangedMin < 1.25 ) { return new Prediction("Baseline", 4.34, 1); }
	}
	if( ChargingChangedMin < 80.56 ) { 
		if( ScreenChangedMin < 2.29 ) { return new Prediction("Baseline", 22.34, 0); }
		if( ScreenChangedMin >= 2.29 ) { return new Prediction("Baseline", 3, 1); }
	}
	}
	if( TimeSinceLastCall >= 1.21 ) { 
	if( Hour >= 18.5 ) { 
		if( MaxAcc < 0.07 ) { return new Prediction("Picked", 25.02, 10); }
		if( MaxAcc >= 0.07 ) { return new Prediction("Picked", 28.05, 2); }
	}
	if( Hour < 18.5 ) { 
		if( RingerModeChangedMin < 0.38 ) { return new Prediction("Baseline", 6, 0); }
		if( RingerModeChangedMin >= 0.38 ) { return new Prediction("Baseline", 191.48, 94.42); }
	}
	}
	}
	if( MaxAcc < 0.01 ) { 
		if( TimeSinceLastCall >= 118.45 ) { return new Prediction("Baseline", 28, 0); }
	if( TimeSinceLastCall < 118.45 ) { 
	if( ScreenChangedMin < 0.52 ) { 
		if( ChargingChangedMin < 39.67 ) { return new Prediction("Baseline", 21.67, 5); }
		if( ChargingChangedMin >= 39.67 ) { return new Prediction("Baseline", 21.67, 0.34); }
	}
	if( ScreenChangedMin >= 0.52 ) { 
		if( ChargingChangedMin >= 49.74 ) { return new Prediction("Picked", 3.67, 0); }
		if( ChargingChangedMin < 49.74 ) { return new Prediction("Picked", 1.34, 0.34); }
	}
	}
	}
	}
	}
	if( Pitch >= -9.5 ) { 
	if( "Normal".equals(RingerMode) ) { 
	if( LastCallPicked >= 0.5 ) { 
	if( Pitch < 50 ) { 
	if( MaxAcc >= 0.02 ) { 
		if( ChargingChangedMin < 0.42 ) { return new Prediction("Baseline", 7.58, 0.58); }
		if( ChargingChangedMin >= 0.42 ) { return new Prediction("Picked", 184.95, 54.62); }
	}
	if( MaxAcc < 0.02 ) { 
		if( ScreenChangedMin < 2.22 ) { return new Prediction("Baseline", 109.47, 35.73); }
		if( ScreenChangedMin >= 2.22 ) { return new Prediction("Picked", 24.04, 4); }
	}
	}
	if( Pitch >= 50 ) { 
	if( RingerModeChangedMin >= 655.43 ) { 
		if( Pitch >= 83.5 ) { return new Prediction("Picked", 4.67, 0.39); }
		if( Pitch < 83.5 ) { return new Prediction("Baseline", 1.56, 0.43); }
	}
	if( RingerModeChangedMin < 655.43 ) { 
		if( ScreenChangedMin < 0.7 ) { return new Prediction("Baseline", 37.86, 10.52); }
		if( ScreenChangedMin >= 0.7 ) { return new Prediction("Picked", 4.37, 1.09); }
	}
	}
	}
	if( LastCallPicked < 0.5 ) { 
		if( CalledHowManyTimes >= 223 ) { return new Prediction("Baseline", 57, 0); }
	if( CalledHowManyTimes < 223 ) { 
	if( ScreenChangedMin >= 0.04 ) { 
		if( ScreenChangedMin >= 0.51 ) { return new Prediction("Picked", 53.95, 24.65); }
		if( ScreenChangedMin < 0.51 ) { return new Prediction("Baseline", 128.3, 19); }
	}
	if( ScreenChangedMin < 0.04 ) { 
		if( CalledHowManyTimes < 156 ) { return new Prediction("Picked", 28.66, 2.66); }
		if( CalledHowManyTimes >= 156 ) { return new Prediction("Baseline", 8, 0); }
	}
	}
	}
	}
	if( "Silent".equals(RingerMode) ) { 
	if( CalledHowManyTimes < 300.5 ) { 
		if( ChargingChangedMin < 0.34 ) { return new Prediction("Picked", 2, 0); }
	if( ChargingChangedMin >= 0.34 ) { 
	if( CalledHowManyTimes < 272.5 ) { 
		if( Hour < 11.5 ) { return new Prediction("Baseline", 22, 0); }
		if( Hour >= 11.5 ) { return new Prediction("Baseline", 69.66, 11); }
	}
		if( CalledHowManyTimes >= 272.5 ) { return new Prediction("Picked", 2, 0); }
	}
	}
		if( CalledHowManyTimes >= 300.5 ) { return new Prediction("Baseline", 24, 0); }
	}
	if( "Vibrate".equals(RingerMode) ) { 
	if( ChargingChangedMin >= 28.14 ) { 
		if( RingerModeChangedMin < 4.58 ) { return new Prediction("Picked", 8, 0); }
	if( RingerModeChangedMin >= 4.58 ) { 
	if( MaxAcc < 2.59 ) { 
		if( Proximity < 0.5 ) { return new Prediction("Baseline", 75.45, 20); }
		if( Proximity >= 0.5 ) { return new Prediction("Baseline", 28.55, 1); }
	}
	if( MaxAcc >= 2.59 ) { 
		if( LastCallPicked >= 0.5 ) { return new Prediction("Picked", 16, 5); }
		if( LastCallPicked < 0.5 ) { return new Prediction("Picked", 4, 0); }
	}
	}
	}
	if( ChargingChangedMin < 28.14 ) { 
	if( ScreenChangedMin < 0.56 ) { 
	if( MaxAcc >= 4.55 ) { 
		if( Hour >= 15.5 ) { return new Prediction("Baseline", 3, 0); }
		if( Hour < 15.5 ) { return new Prediction("Picked", 5, 2); }
	}
		if( MaxAcc < 4.55 ) { return new Prediction("Baseline", 57, 0); }
	}
	if( ScreenChangedMin >= 0.56 ) { 
	if( TimeSinceLastCall >= 9.58 ) { 
		if( Hour >= 10 ) { return new Prediction("Picked", 6, 1); }
		if( Hour < 10 ) { return new Prediction("Baseline", 3, 0); }
	}
		if( TimeSinceLastCall < 9.58 ) { return new Prediction("Baseline", 8, 0); }
	}
	}
	}
	}
	}
	if( ScreenOn < 0.5 ) { 
	if( MaxAcc >= 0.02 ) { 
	if( ScreenChangedMin >= 5.44 ) { 
		if( CalledHowManyTimes >= 92.5 ) { return new Prediction("Baseline", 28, 0); }
	if( CalledHowManyTimes < 92.5 ) { 
	if( TimeSinceLastCall >= 11.78 ) { 
	if( MaxAcc >= 3.46 ) { 
		if( TimeSinceLastCall >= 105.82 ) { return new Prediction("Picked", 13, 0); }
		if( TimeSinceLastCall < 105.82 ) { return new Prediction("Picked", 5, 2); }
	}
	if( MaxAcc < 3.46 ) { 
		if( ScreenChangedMin >= 22.85 ) { return new Prediction("Baseline", 16, 0); }
		if( ScreenChangedMin < 22.85 ) { return new Prediction("Picked", 29, 9); }
	}
	}
		if( TimeSinceLastCall < 11.78 ) { return new Prediction("Baseline", 11, 0); }
	}
	}
	if( ScreenChangedMin < 5.44 ) { 
	if( CalledHowManyTimes < 251 ) { 
	if( MaxAcc < 3.04 ) { 
	if( TimeSinceLastCall < 44.44 ) { 
		if( ScreenChangedMin < 3.93 ) { return new Prediction("Picked", 261, 11); }
		if( ScreenChangedMin >= 3.93 ) { return new Prediction("Picked", 19, 7); }
	}
	if( TimeSinceLastCall >= 44.44 ) { 
		if( MaxAcc < 0.06 ) { return new Prediction("Picked", 90, 0); }
		if( MaxAcc >= 0.06 ) { return new Prediction("Picked", 188, 5); }
	}
	}
	if( MaxAcc >= 3.04 ) { 
	if( "Normal".equals(RingerMode) ) { 
		if( Pitch < 2.5 ) { return new Prediction("Picked", 193.26, 14.26); }
		if( Pitch >= 2.5 ) { return new Prediction("Picked", 62.74, 13.74); }
	}
	if( "Silent".equals(RingerMode) ) { 
		if( Hour < 16 ) { return new Prediction("Picked", 5, 2); }
		if( Hour >= 16 ) { return new Prediction("Baseline", 2, 0); }
	}
	if( "Vibrate".equals(RingerMode) ) { 
		if( Proximity < 0.5 ) { return new Prediction("Picked", 6, 1); }
		if( Proximity >= 0.5 ) { return new Prediction("Picked", 10, 0); }
	}
	}
	}
	if( CalledHowManyTimes >= 251 ) { 
	if( CalledHowManyTimes >= 601.5 ) { 
		if( MaxAcc >= 0.88 ) { return new Prediction("Picked", 13, 0); }
	if( MaxAcc < 0.88 ) { 
		if( TimeSinceLastCall < 12.55 ) { return new Prediction("Picked", 1, 0); }
		if( TimeSinceLastCall >= 12.55 ) { return new Prediction("Baseline", 15, 3); }
	}
	}
	if( CalledHowManyTimes < 601.5 ) { 
	if( ScreenChangedMin < 1.46 ) { 
		if( CalledHowManyTimes >= 532.5 ) { return new Prediction("Baseline", 5, 0); }
		if( CalledHowManyTimes < 532.5 ) { return new Prediction("Baseline", 8, 4); }
	}
		if( ScreenChangedMin >= 1.46 ) { return new Prediction("Baseline", 21, 0); }
	}
	}
	}
	}
	if( MaxAcc < 0.02 ) { 
	if( "Normal".equals(RingerMode) ) { 
	if( ScreenChangedMin >= 2.35 ) { 
	if( CalledHowManyTimes >= 110 ) { 
		if( ScreenChangedMin >= 2.55 ) { return new Prediction("Baseline", 32, 0); }
		if( ScreenChangedMin < 2.55 ) { return new Prediction("Picked", 1, 0); }
	}
	if( CalledHowManyTimes < 110 ) { 
	if( CalledHowManyTimes < 6.5 ) { 
		if( Hour >= 8.5 ) { return new Prediction("Baseline", 58, 13); }
		if( Hour < 8.5 ) { return new Prediction("Picked", 1, 0); }
	}
	if( CalledHowManyTimes >= 6.5 ) { 
		if( MaxAcc >= 0 ) { return new Prediction("Picked", 24, 2); }
		if( MaxAcc < 0 ) { return new Prediction("Baseline", 15, 7); }
	}
	}
	}
	if( ScreenChangedMin < 2.35 ) { 
	if( ChargingChangedMin >= 71.93 ) { 
		if( ChargingChangedMin < 382.92 ) { return new Prediction("Picked", 53, 0); }
	if( ChargingChangedMin >= 382.92 ) { 
		if( ChargingChangedMin >= 401.65 ) { return new Prediction("Picked", 18, 0); }
		if( ChargingChangedMin < 401.65 ) { return new Prediction("Baseline", 2, 0); }
	}
	}
	if( ChargingChangedMin < 71.93 ) { 
	if( TimeSinceLastCall >= 0.77 ) { 
		if( RingerModeChangedMin < 1.85 ) { return new Prediction("Baseline", 14, 6); }
		if( RingerModeChangedMin >= 1.85 ) { return new Prediction("Picked", 157, 14); }
	}
	if( TimeSinceLastCall < 0.77 ) { 
		if( Hour >= 10.5 ) { return new Prediction("Picked", 4, 1); }
		if( Hour < 10.5 ) { return new Prediction("Baseline", 4, 0); }
	}
	}
	}
	}
	if( "Silent".equals(RingerMode) ) { 
	if( ChargingChangedMin >= 32.93 ) { 
	if( RingerModeChangedMin < 845.08 ) { 
		if( Pitch >= 6.5 ) { return new Prediction("Baseline", 23.88, 0); }
	if( Pitch < 6.5 ) { 
		if( ScreenChangedMin < 2.95 ) { return new Prediction("Baseline", 10, 3); }
		if( ScreenChangedMin >= 2.95 ) { return new Prediction("Baseline", 20.12, 0); }
	}
	}
		if( RingerModeChangedMin >= 845.08 ) { return new Prediction("Picked", 2, 0); }
	}
	if( ChargingChangedMin < 32.93 ) { 
		if( Charging >= 0.5 ) { return new Prediction("Baseline", 6, 0); }
	if( Charging < 0.5 ) { 
		if( ScreenChangedMin < 13.19 ) { return new Prediction("Picked", 9, 0); }
		if( ScreenChangedMin >= 13.19 ) { return new Prediction("Baseline", 1, 0); }
	}
	}
	}
	if( "Vibrate".equals(RingerMode) ) { 
	if( ScreenChangedMin < 3.9 ) { 
	if( RingerModeChangedMin >= 45.44 ) { 
		if( ScreenChangedMin >= 0.85 ) { return new Prediction("Picked", 12, 0); }
	if( ScreenChangedMin < 0.85 ) { 
		if( RingerModeChangedMin < 333.98 ) { return new Prediction("Picked", 3, 0); }
		if( RingerModeChangedMin >= 333.98 ) { return new Prediction("Baseline", 1, 0); }
	}
	}
	if( RingerModeChangedMin < 45.44 ) { 
		if( TimeSinceLastCall >= 529.84 ) { return new Prediction("Baseline", 7, 0); }
	if( TimeSinceLastCall < 529.84 ) { 
		if( CalledHowManyTimes < 227 ) { return new Prediction("Picked", 7, 1); }
		if( CalledHowManyTimes >= 227 ) { return new Prediction("Baseline", 8, 0); }
	}
	}
	}
	if( ScreenChangedMin >= 3.9 ) { 
		if( Pitch < -24.5 ) { return new Prediction("Picked", 1, 0); }
		if( Pitch >= -24.5 ) { return new Prediction("Baseline", 20, 0); }
	}
	}
	}
	}
return null;
}
private Prediction runTree9() {
	if( ScreenOn >= 0.5 ) { 
	if( LastCallPicked >= 0.5 ) { 
	if( Proximity < 0.5 ) { 
	if( MaxAcc >= 0.02 ) { 
	if( ScreenChangedMin >= 0.76 ) { 
	if( CalledHowManyTimes < 29.5 ) { 
		if( Day < 1.5 ) { return new Prediction("Picked", 52.17, 5); }
		if( Day >= 1.5 ) { return new Prediction("Picked", 67, 0); }
	}
	if( CalledHowManyTimes >= 29.5 ) { 
		if( CalledHowManyTimes < 45.5 ) { return new Prediction("Baseline", 5, 0); }
		if( CalledHowManyTimes >= 45.5 ) { return new Prediction("Picked", 27.45, 8); }
	}
	}
	if( ScreenChangedMin < 0.76 ) { 
	if( ChargingChangedMin < 92.13 ) { 
		if( RingerModeChangedMin < 28.76 ) { return new Prediction("Picked", 95.34, 43); }
		if( RingerModeChangedMin >= 28.76 ) { return new Prediction("Picked", 81, 17); }
	}
	if( ChargingChangedMin >= 92.13 ) { 
		if( TimeSinceLastCall >= 11.85 ) { return new Prediction("Baseline", 44.45, 14.72); }
		if( TimeSinceLastCall < 11.85 ) { return new Prediction("Picked", 12, 1); }
	}
	}
	}
	if( MaxAcc < 0.02 ) { 
	if( CalledHowManyTimes >= 88.5 ) { 
	if( CalledHowManyTimes < 175 ) { 
		if( Hour < 19.5 ) { return new Prediction("Picked", 16, 0); }
		if( Hour >= 19.5 ) { return new Prediction("Picked", 4, 1); }
	}
	if( CalledHowManyTimes >= 175 ) { 
		if( Hour < 16.5 ) { return new Prediction("Picked", 6, 1); }
		if( Hour >= 16.5 ) { return new Prediction("Baseline", 6, 1); }
	}
	}
	if( CalledHowManyTimes < 88.5 ) { 
	if( "Normal".equals(RingerMode) ) { 
		if( ScreenChangedMin < 2.22 ) { return new Prediction("Baseline", 114.62, 39.17); }
		if( ScreenChangedMin >= 2.22 ) { return new Prediction("Picked", 20, 0); }
	}
		if( "Silent".equals(RingerMode) ) { return new Prediction("Baseline", 11, 0); }
	if( "Vibrate".equals(RingerMode) ) { 
		if( MaxAcc >= 0 ) { return new Prediction("Baseline", 23, 5); }
		if( MaxAcc < 0 ) { return new Prediction("Baseline", 8, 0); }
	}
	}
	}
	}
	if( Proximity >= 0.5 ) { 
	if( CalledHowManyTimes >= 157.5 ) { 
	if( RingerModeChangedMin >= 12.39 ) { 
		if( MaxAcc < 0.05 ) { return new Prediction("Baseline", 6, 0); }
	if( MaxAcc >= 0.05 ) { 
		if( "Normal".equals(RingerMode) ) { return new Prediction("Baseline", 3.55, 0.55); }
		if( "Silent".equals(RingerMode) ) { return new Prediction("Baseline", 0, 0); }
		if( "Vibrate".equals(RingerMode) ) { return new Prediction("Picked", 1.28, 0); }
	}
	}
		if( RingerModeChangedMin < 12.39 ) { return new Prediction("Baseline", 7, 0); }
	}
	if( CalledHowManyTimes < 157.5 ) { 
	if( CalledHowManyTimes >= 5.5 ) { 
		if( CalledHowManyTimes < 6.5 ) { return new Prediction("Picked", 12, 0); }
	if( CalledHowManyTimes >= 6.5 ) { 
		if( CalledHowManyTimes >= 13.5 ) { return new Prediction("Picked", 96.66, 42.28); }
		if( CalledHowManyTimes < 13.5 ) { return new Prediction("Baseline", 24.83, 6.83); }
	}
	}
	if( CalledHowManyTimes < 5.5 ) { 
	if( ScreenChangedMin >= 0.04 ) { 
		if( Day < 1.5 ) { return new Prediction("Baseline", 36.1, 2.83); }
		if( Day >= 1.5 ) { return new Prediction("Baseline", 30.55, 11.28); }
	}
	if( ScreenChangedMin < 0.04 ) { 
		if( Hour >= 17.5 ) { return new Prediction("Baseline", 1, 0); }
		if( Hour < 17.5 ) { return new Prediction("Picked", 7, 0); }
	}
	}
	}
	}
	}
	if( LastCallPicked < 0.5 ) { 
	if( TimeSinceLastCall < 1.13 ) { 
		if( MaxAcc < 0.37 ) { return new Prediction("Baseline", 93, 0); }
	if( MaxAcc >= 0.37 ) { 
		if( Hour >= 20 ) { return new Prediction("Picked", 2, 0); }
		if( Hour < 20 ) { return new Prediction("Baseline", 4, 0); }
	}
	}
	if( TimeSinceLastCall >= 1.13 ) { 
	if( CalledHowManyTimes >= 234.5 ) { 
	if( ScreenChangedMin >= 2.84 ) { 
		if( RingerModeChangedMin < 32.32 ) { return new Prediction("Baseline", 8, 0); }
		if( RingerModeChangedMin >= 32.32 ) { return new Prediction("Picked", 3, 0); }
	}
		if( ScreenChangedMin < 2.84 ) { return new Prediction("Baseline", 102, 0); }
	}
	if( CalledHowManyTimes < 234.5 ) { 
	if( ScreenChangedMin >= 0.06 ) { 
	if( MaxAcc < 0.04 ) { 
		if( "Normal".equals(RingerMode) ) { return new Prediction("Baseline", 127, 30); }
		if( "Silent".equals(RingerMode) ) { return new Prediction("Baseline", 53, 1); }
		if( "Vibrate".equals(RingerMode) ) { return new Prediction("Baseline", 56, 5); }
	}
	if( MaxAcc >= 0.04 ) { 
		if( ScreenChangedMin >= 0.85 ) { return new Prediction("Picked", 58, 4); }
		if( ScreenChangedMin < 0.85 ) { return new Prediction("Baseline", 161, 44); }
	}
	}
	if( ScreenChangedMin < 0.06 ) { 
	if( TimeSinceLastCall < 42.15 ) { 
		if( TimeSinceLastCall >= 24.88 ) { return new Prediction("Baseline", 9, 0); }
		if( TimeSinceLastCall < 24.88 ) { return new Prediction("Picked", 17, 6); }
	}
	if( TimeSinceLastCall >= 42.15 ) { 
		if( ChargingChangedMin < 10.32 ) { return new Prediction("Picked", 11, 4); }
		if( ChargingChangedMin >= 10.32 ) { return new Prediction("Picked", 40, 0); }
	}
	}
	}
	}
	}
	}
	if( ScreenOn < 0.5 ) { 
	if( CalledHowManyTimes < 211.5 ) { 
	if( Pitch >= 11.5 ) { 
	if( TimeSinceLastCall >= 3.92 ) { 
	if( ScreenChangedMin < 5.76 ) { 
	if( Hour < 20.5 ) { 
		if( CalledHowManyTimes < 3.5 ) { return new Prediction("Picked", 51.48, 16); }
		if( CalledHowManyTimes >= 3.5 ) { return new Prediction("Picked", 92.43, 6.64); }
	}
		if( Hour >= 20.5 ) { return new Prediction("Baseline", 4, 0); }
	}
	if( ScreenChangedMin >= 5.76 ) { 
		if( MaxAcc >= 2.46 ) { return new Prediction("Picked", 3, 0); }
	if( MaxAcc < 2.46 ) { 
		if( Pitch < 179.5 ) { return new Prediction("Baseline", 32.62, 0); }
		if( Pitch >= 179.5 ) { return new Prediction("Picked", 1.02, 0.02); }
	}
	}
	}
	if( TimeSinceLastCall < 3.92 ) { 
		if( CalledHowManyTimes < 1.5 ) { return new Prediction("Picked", 3, 0); }
	if( CalledHowManyTimes >= 1.5 ) { 
		if( ChargingChangedMin >= 43.84 ) { return new Prediction("Baseline", 15.16, 0); }
	if( ChargingChangedMin < 43.84 ) { 
		if( Proximity < 0.5 ) { return new Prediction("Baseline", 4, 0); }
		if( Proximity >= 0.5 ) { return new Prediction("Picked", 1, 0); }
	}
	}
	}
	}
	if( Pitch < 11.5 ) { 
	if( ScreenChangedMin < 16.09 ) { 
	if( MaxAcc >= 0 ) { 
	if( "Normal".equals(RingerMode) ) { 
		if( ScreenChangedMin >= 3.39 ) { return new Prediction("Picked", 152, 35); }
		if( ScreenChangedMin < 3.39 ) { return new Prediction("Picked", 705.57, 46.84); }
	}
	if( "Silent".equals(RingerMode) ) { 
		if( Day >= 3.5 ) { return new Prediction("Baseline", 26, 11); }
		if( Day < 3.5 ) { return new Prediction("Picked", 35, 4); }
	}
	if( "Vibrate".equals(RingerMode) ) { 
		if( CalledHowManyTimes >= 88.5 ) { return new Prediction("Picked", 15, 3); }
		if( CalledHowManyTimes < 88.5 ) { return new Prediction("Picked", 77, 0); }
	}
	}
	if( MaxAcc < 0 ) { 
		if( RingerModeChangedMin < 138.44 ) { return new Prediction("Baseline", 10.05, 0); }
		if( RingerModeChangedMin >= 138.44 ) { return new Prediction("Picked", 4, 0); }
	}
	}
	if( ScreenChangedMin >= 16.09 ) { 
	if( LastCallPicked >= 0.5 ) { 
	if( RingerModeChangedMin >= 171.62 ) { 
		if( RingerModeChangedMin >= 194.82 ) { return new Prediction("Baseline", 5, 1); }
		if( RingerModeChangedMin < 194.82 ) { return new Prediction("Picked", 1, 0); }
	}
		if( RingerModeChangedMin < 171.62 ) { return new Prediction("Baseline", 13, 0); }
	}
		if( LastCallPicked < 0.5 ) { return new Prediction("Baseline", 54.68, 0); }
	}
	}
	}
	if( CalledHowManyTimes >= 211.5 ) { 
	if( Hour >= 12.5 ) { 
		if( MaxAcc >= 0.32 ) { return new Prediction("Picked", 15, 0); }
	if( MaxAcc < 0.32 ) { 
	if( Pitch < -6.5 ) { 
	if( CalledHowManyTimes >= 280.5 ) { 
		if( "Normal".equals(RingerMode) ) { return new Prediction("Baseline", 3, 1); }
		if( "Silent".equals(RingerMode) ) { return new Prediction("Baseline", 2, 0); }
		if( "Vibrate".equals(RingerMode) ) { return new Prediction("Picked", 1, 0); }
	}
		if( CalledHowManyTimes < 280.5 ) { return new Prediction("Picked", 6, 0); }
	}
	if( Pitch >= -6.5 ) { 
	if( MaxAcc >= 0.01 ) { 
		if( ChargingChangedMin < 11.34 ) { return new Prediction("Baseline", 11, 2); }
		if( ChargingChangedMin >= 11.34 ) { return new Prediction("Baseline", 11, 0); }
	}
	if( MaxAcc < 0.01 ) { 
		if( RingerModeChangedMin >= 14.24 ) { return new Prediction("Picked", 6, 2); }
		if( RingerModeChangedMin < 14.24 ) { return new Prediction("Baseline", 3, 0); }
	}
	}
	}
	}
	if( Hour < 12.5 ) { 
	if( MaxAcc >= 0.22 ) { 
		if( ScreenChangedMin >= 4.47 ) { return new Prediction("Baseline", 6, 0); }
	if( ScreenChangedMin < 4.47 ) { 
		if( Hour >= 8.5 ) { return new Prediction("Picked", 2, 0); }
	if( Hour < 8.5 ) { 
		if( Day >= 2 ) { return new Prediction("Baseline", 1, 0); }
		if( Day < 2 ) { return new Prediction("Picked", 1, 0); }
	}
	}
	}
	if( MaxAcc < 0.22 ) { 
		if( ScreenChangedMin >= 1.09 ) { return new Prediction("Baseline", 53, 0); }
	if( ScreenChangedMin < 1.09 ) { 
	if( ScreenChangedMin >= 0.14 ) { 
		if( ScreenChangedMin >= 0.61 ) { return new Prediction("Picked", 1, 0); }
		if( ScreenChangedMin < 0.61 ) { return new Prediction("Baseline", 7, 0); }
	}
		if( ScreenChangedMin < 0.14 ) { return new Prediction("Picked", 1, 0); }
	}
	}
	}
	}
	}
return null;
}
}

