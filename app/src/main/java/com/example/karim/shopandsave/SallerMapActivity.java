package com.example.karim.shopandsave;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import org.osmdroid.api.IMapController;
import org.osmdroid.events.MapEventsReceiver;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.MapEventsOverlay;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;

public class SallerMapActivity extends AppCompatActivity {
    MapView map = null;
    IMapController mapController;
    GeoPoint touchPoint, myLocalPoint;
    Marker myMarker, startMarker;
    String provider;
    double latitude,longitude,marketLongitude,marketLatatitude;
    private int cnt=0;
    private ItemizedIconOverlay.OnItemGestureListener<OverlayItem> myOnItemGestureListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_saller_map);
        map = findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(false);
        map.setMinZoomLevel(9.0);
        ImageButton goToMyLocalisation =findViewById(R.id.goToMyLocalisation);


//        ==================zoom ===============
        final ImageButton zoomin=findViewById(R.id.zoomin);
        final ImageButton zoomout=findViewById(R.id.zoomout);
        zoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(map.getZoomLevelDouble()==map.getMaxZoomLevel()){
                zoomin.setBackground(getResources().getDrawable(R.drawable.bg_circle_dark));
                    map.invalidate();

                } else {   mapController.setZoom(map.getZoomLevelDouble()+1);
                zoomout.setBackground(getResources().getDrawable(R.drawable.bg_circle));}
                map.invalidate();
            }
        });
        zoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(map.getZoomLevelDouble()==map.getMinZoomLevel()){
                zoomout.setBackground(getResources().getDrawable(R.drawable.bg_circle_dark));
                    map.invalidate();

                }else{ mapController.setZoom(map.getZoomLevelDouble()-1);
                    map.invalidate();

                    zoomin.setBackground(getResources().getDrawable(R.drawable.bg_circle));}    }

        });
//          ============end zoom =====

//       ============== location
        locationMethode(this);
        goToMyLocalisation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myLocalPoint = new GeoPoint(latitude, longitude);
                startMarker.setPosition(myLocalPoint);
                mapController.setCenter(myLocalPoint);
                mapController.setZoom(17.0);
            }
        });
//       ============== location end

//      ================add location of my market

        MapEventsReceiver mReceive=new MapEventsReceiver() {
            @Override
            public boolean singleTapConfirmedHelper(GeoPoint p) {
                return false;
            }

            @Override
            public boolean longPressHelper(GeoPoint p) {
                addMarker(p,R.drawable.ic_location_on_black_24dp);
                Toast.makeText(SallerMapActivity.this, "location :\n" + marketLatatitude+"\n"+marketLongitude, Toast.LENGTH_SHORT).show();
                return false;
            }
        };
        MapEventsOverlay OverlayEventos = new MapEventsOverlay(this.getBaseContext(), mReceive);
        map.getOverlays().add(OverlayEventos);
        map.invalidate();

//      ================ end of add location of my market


    }


    protected void addMarker(GeoPoint arg0,int resource) {
        GeoPoint touchPoint =  arg0;
        myOnItemGestureListener = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemLongPress(int arg0, OverlayItem arg1) {
                return false;
            }

            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }
        };

        if (cnt==0){
            myMarker= new Marker(map);
            myMarker.setIcon( getResources().getDrawable(resource));
            myMarker.setPosition(touchPoint);
            map.getOverlays().add(myMarker);
            cnt++;

        }else {
            myMarker.setPosition(touchPoint);
            map.invalidate();
        }

        marketLatatitude=touchPoint.getLatitude();
        marketLongitude=touchPoint.getLongitude();
        Vibrator vibrator = (Vibrator)this.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);
        map.invalidate();
    }
    public void locationMethode(Context ctx) {

        LocationManager locationManager = (LocationManager) ctx.getSystemService(Context.LOCATION_SERVICE);
        if (provider != null) {
            Criteria cr = new Criteria();
            cr.setAccuracy(Criteria.ACCURACY_FINE); // précision
            cr.setAltitudeRequired(true); // altitude
            cr.setBearingRequired(true); // direction
            cr.setCostAllowed(false); // payant/gratuit
            cr.setPowerRequirement(Criteria.POWER_HIGH);  // consommation
            cr.setSpeedRequired(true);  // vitesse
            provider = locationManager.getBestProvider(cr, false);

        } else provider = LocationManager.GPS_PROVIDER;


        mapController = map.getController();
        mapController.setZoom(15.0);
        startMarker = new Marker(map);
        startMarker.setIcon(getResources().getDrawable(R.drawable.ic_person_pin_black_24dp));
        map.getOverlays().add(startMarker);
        mapController.setCenter(startMarker.getPosition());
        if (ContextCompat.checkSelfPermission(ctx, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
        if (ContextCompat.checkSelfPermission(ctx, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
        if (ContextCompat.checkSelfPermission(ctx, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }

        Location lastKnownLocation = locationManager.getLastKnownLocation(provider);
        if (lastKnownLocation!=null) {
            latitude = lastKnownLocation.getLatitude();
            longitude = lastKnownLocation.getLongitude();
            GeoPoint lastGeoPoint=new GeoPoint(latitude,longitude);
            mapController.setCenter(lastGeoPoint);
            startMarker.setPosition(lastGeoPoint);
        }



        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
                //            altitude = location.getAltitude();
                myLocalPoint = new GeoPoint(latitude, longitude);
                mapController.setCenter(myLocalPoint);
                startMarker.setPosition(myLocalPoint);
            }
            @Override public void onStatusChanged(String provider, int status, Bundle extras) {

            }
            @Override public void onProviderEnabled(String provider) {

            }
            @Override public void onProviderDisabled(String provider) { }

        };
        locationManager.requestLocationUpdates(provider,5000,10,locationListener);

    }
}
