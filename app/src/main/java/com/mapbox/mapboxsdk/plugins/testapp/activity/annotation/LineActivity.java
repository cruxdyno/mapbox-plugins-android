package com.mapbox.mapboxsdk.plugins.testapp.activity.annotation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.plugins.annotation.Line;
import com.mapbox.mapboxsdk.plugins.annotation.LineManager;
import com.mapbox.mapboxsdk.plugins.testapp.R;
import com.mapbox.mapboxsdk.style.layers.PropertyFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Activity showcasing adding lines using the annotation plugin
 */
public class LineActivity extends AppCompatActivity {

  private final Random random = new Random();

  private MapView mapView;
  private Line line;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_annotation);
    mapView = findViewById(R.id.mapView);
    mapView.onCreate(savedInstanceState);
    mapView.getMapAsync(mapboxMap -> {
      mapboxMap.moveCamera(CameraUpdateFactory.zoomTo(2));

      // create line manager
      // set non data driven properties

      // create a line
      List<LatLng> latLngs = new ArrayList<>();
      latLngs.add(new LatLng(-2.178992, -4.375974));
      latLngs.add(new LatLng(-4.107888, -7.639772));
      latLngs.add(new LatLng(2.798737, -11.439207));

      LineManager lineManager = new LineManager(mapboxMap);
      line = lineManager.createLine(latLngs);

      // random add lines across the globe
      Line currentLine;
      for (int i = 0; i < 100; i++) {
        currentLine = lineManager.createLine(createRandomLatLngs());
        int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        currentLine.setLineColor(PropertyFactory.colorToRgbaString(color));
      }
    });
  }

  private List<LatLng> createRandomLatLngs() {
    List<LatLng> latLngs = new ArrayList<>();
    for (int i = 0; i < random.nextInt(10); i++) {
      latLngs.add(new LatLng((random.nextDouble() * -180.0) + 90.0,
        (random.nextDouble() * -360.0) + 180.0));
    }
    return latLngs;
  }


  @Override
  protected void onStart() {
    super.onStart();
    mapView.onStart();
  }

  @Override
  protected void onResume() {
    super.onResume();
    mapView.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
    mapView.onPause();
  }

  @Override
  protected void onStop() {
    super.onStop();
    mapView.onStop();
  }

  @Override
  public void onLowMemory() {
    super.onLowMemory();
    mapView.onLowMemory();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mapView.onDestroy();
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    mapView.onSaveInstanceState(outState);
  }
}