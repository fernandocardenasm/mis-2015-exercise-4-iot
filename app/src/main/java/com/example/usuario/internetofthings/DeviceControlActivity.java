package com.example.usuario.internetofthings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DeviceControlActivity extends Activity {

    private final static String TAG = DeviceControlActivity.class.getSimpleName();


    private TextView mDataField;
    private TextView mServicesField;
    private Button mServicesShow;
    private String mDeviceAddress;
    private String mDeviceName;
    private String servicesContent;


    public static final String EXTRAS_DEVICE_NAME = "DEVICE_NAME";
    public static final String EXTRAS_DEVICE_ADDRESS = "DEVICE_ADDRESS";
    public static final String EXTRAS_SERVICES = "SERVICES";
    public static final String EXTRAS_BROAD = "BROAD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_control);

        final Intent intent = getIntent();
        mDeviceName = intent.getStringExtra(EXTRAS_DEVICE_NAME);
        mDeviceAddress = intent.getStringExtra(EXTRAS_DEVICE_ADDRESS);
        // Sets up UI references.
                ((TextView) findViewById(R.id.device_address)).setText(mDeviceAddress);
        mDataField = (TextView) findViewById(R.id.data_value);
        mServicesField = (TextView) findViewById(R.id.services_value);
        mServicesShow = (Button) findViewById(R.id.buttonShowServices);

        String broad = intent.getStringExtra(EXTRAS_BROAD);
        servicesContent = intent.getStringExtra(EXTRAS_SERVICES);
        mDataField.setText(broad);

        mServicesShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mServicesField.setText(servicesContent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        //BluetoothGatt bluetoothGatt = bluetoothDevice.connectGatt(context, false, btleGattCallback);
        clearUI();

    }
    @Override
    protected void onPause() {
        super.onPause();

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();

    }

    private void clearUI() {
        mDataField.setText(R.string.no_data);
    }



}
