package ib.facmed.unam.mx.simexfacmed;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng centro = new LatLng(19.378139, -99.156844);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centro,10));

        // Add a marker in "Palacio de la escuela de medicina" and move the camera
        LatLng palacioMed = new LatLng(19.437815, -99.133386);
        mMap.addMarker(new MarkerOptions().position(palacioMed).title("Palacio de la escuela de medicina"));

        // Add a marker in "Facultad de Medicina" and move the camera
        LatLng facMed = new LatLng(19.333250, -99.180235);
        mMap.addMarker(new MarkerOptions().position(facMed).title("Facultad de Medicina"));

        // Add a marker in "Unidad de posgrado" and move the camera
        LatLng posgrado = new LatLng(19.309583, -99.185448);
        mMap.addMarker(new MarkerOptions().position(posgrado).title("Unidad de posgrado"));
    }
}
