package com.example.sensorcustom;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private TextView txSensor;
    private TextView txProximity;
    private TextView txSuhu;
    private TextView txAccel;
    private TextView txLembab;
    private TextView txGyro;
    private TextView txGrav;
    private Sensor sensorProximity;
    private Sensor sensorAccelerometer;
    private Sensor sensorHumidity;
    private Sensor sensorTemperature;
    private Sensor sensorGyroscope;
    private Sensor sensorGravity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txSuhu=(TextView)findViewById(R.id.temperature);
        txProximity=(TextView)findViewById(R.id.proximity);
        txAccel=(TextView)findViewById(R.id.accelerometer);
        txLembab=(TextView)findViewById(R.id.humidity);
        txGyro=(TextView)findViewById(R.id.gyroscope);
        txGrav=(TextView)findViewById(R.id.gravity);


        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensorProximity=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sensorAccelerometer=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorHumidity=sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        sensorTemperature=sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        sensorGyroscope=sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorGravity=sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        if (sensorProximity==null){
            txProximity.setText("No sensor!");
        }
        if (sensorAccelerometer==null){
            txAccel.setText("No sensor!");
        }
        if (sensorTemperature==null){
            txSuhu.setText("No sensor!");
        }
        if (sensorHumidity==null){
            txLembab.setText("No sensor!");
        }
        if (sensorGyroscope==null){
            txGyro.setText("No sensor!");
        }
        if (sensorGravity==null){
            txGrav.setText("No sensor!");
        }
    }
    public void onStart(){
        super.onStart();
        if(sensorProximity!=null){
            sensorManager.registerListener(this, sensorProximity ,sensorManager.SENSOR_DELAY_NORMAL);
        }
        if(sensorAccelerometer!=null){
            sensorManager.registerListener(this, sensorAccelerometer ,sensorManager.SENSOR_DELAY_NORMAL);
        }
        if(sensorTemperature!=null){
            sensorManager.registerListener(this, sensorTemperature ,sensorManager.SENSOR_DELAY_NORMAL);
        }
        if(sensorHumidity!=null){
            sensorManager.registerListener(this, sensorHumidity ,sensorManager.SENSOR_DELAY_NORMAL);
        }
        if(sensorGyroscope!=null){
            sensorManager.registerListener(this, sensorGyroscope,sensorManager.SENSOR_DELAY_NORMAL);
        }
        if(sensorGravity!=null){
            sensorManager.registerListener(this, sensorGravity,sensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    public void onStop(){
        super.onStop();
        sensorManager.unregisterListener(this);
    }

    public void onSensorChanged(SensorEvent sensorEvent){
        int sensorType=sensorEvent.sensor.getType();
        float value=sensorEvent.values[0];
        if (sensorType==Sensor.TYPE_PROXIMITY){
            txProximity.setText("Proximity Sensor: "+value);
        }

//        final float alpha = 0.8;
//
//        // Isolate the force of gravity with the low-pass filter.
//        gravity[0] = alpha * gravity[0] + (1 - alpha) * event.values[0];
//        gravity[1] = alpha * gravity[1] + (1 - alpha) * event.values[1];
//        gravity[2] = alpha * gravity[2] + (1 - alpha) * event.values[2];
//
//        // Remove the gravity contribution with the high-pass filter.
//        linear_acceleration[0] = event.values[0] - gravity[0];
//        linear_acceleration[1] = event.values[1] - gravity[1];
//        linear_acceleration[2] = event.values[2] - gravity[2];

        if (sensorType==Sensor.TYPE_ACCELEROMETER){
            txAccel.setText("Accelerometer Sensor: "+value);
        }
        if (sensorType==Sensor.TYPE_AMBIENT_TEMPERATURE){
            txSuhu.setText("Temperature Sensor: "+value);
        }
        if (sensorType==Sensor.TYPE_RELATIVE_HUMIDITY){
            txLembab.setText("Humidity Sensor: "+value);
        }
        if (sensorType==Sensor.TYPE_RELATIVE_HUMIDITY){
            txGyro.setText("Gyroscope Sensor: "+value);
        }
        if (sensorType==Sensor.TYPE_RELATIVE_HUMIDITY){
            txGrav.setText("Gravity Sensor: "+value);
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }
}
