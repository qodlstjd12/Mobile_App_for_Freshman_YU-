package com.example.please.Home.fragment;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.please.Data.HotPlace;
import com.example.please.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Random;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class FoodFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    Marker m = null;
    Marker m1 = null;
    GoogleMap gmap = null;
    Location my_locate = null;
    double my_latitude;
    double my_longitude;
    private MapView mapView;

    HotPlace 달우찜닭 = new HotPlace(35.837370,128.752175, "달우찜닭","0538189989");
    HotPlace 경주국밥 = new HotPlace(35.838653, 128.754602, "경주국밥","0538179309");
    HotPlace 에이바이트키친 = new HotPlace(35.836588,128.751590, "에이바이트키친","01044961326");
    HotPlace 해시 = new HotPlace(35.838425, 128.752422, "해시"," ");
    HotPlace 롯데리아 = new HotPlace(35.838077, 128.756132, "롯데리아","0538119266");
    HotPlace 맘스터치 = new HotPlace(35.837548, 128.752394, "맘스터치","0538117792");
    HotPlace 도쿄라멘 = new HotPlace(35.837709, 128.752178, "도쿄라멘","0538123901");
    HotPlace 손시스시 = new HotPlace(35.839114, 128.756724, "손시스시","0532633964");
    HotPlace 칭구짬뽕 = new HotPlace(35.836448, 128.752760, "칭구짬뽕","0537959494");
    HotPlace 씨옌 = new HotPlace(35.837636, 128.752669, "씨옌","0538181191");

        ImageView 사진;
        TextView 음식점이름;
        TextView 음식점전화;
        TextView 분;

        public View onCreateView(@NonNull LayoutInflater inflater,
                ViewGroup container, Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.food, container, false);

        this.mapView = (MapView)root.findViewById(R.id.mapview);
        this.mapView.onCreate(savedInstanceState);
        this.mapView.getMapAsync(this);

        사진 = (ImageView)root.findViewById(R.id.picture);
        음식점이름 = (TextView)root.findViewById(R.id.foodtitle);
        음식점전화 = (TextView)root.findViewById(R.id.tel);
        분 = (TextView)root.findViewById(R.id.min);

        Button 한식 = (Button) root.findViewById(R.id.한식);
        Button 양식 = (Button) root.findViewById(R.id.양식);
        Button 패스트푸드 = (Button) root.findViewById(R.id.패스트푸드);
        Button 일식 = (Button) root.findViewById(R.id.일식);
        Button 중식 = (Button) root.findViewById(R.id.중식);
        Button 오늘의맛집 = (Button) root.findViewById(R.id.오늘의맛집);

        한식.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(m != null)
                    m.remove();
                if(m1 != null)
                    m1.remove();
                float distance[] = new float[1];
                Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                        35.837370,128.752175, distance);
                float distance1[] = new float[1];
                Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                        35.838653, 128.754602, distance1);

                m = gmap.addMarker(new MarkerOptions().title("달우찜닭").snippet(String.valueOf(distance[0]) + "m").
                        position(달우찜닭.getLatLng()));
                m1 = gmap.addMarker(new MarkerOptions().title("경주국밥").snippet(String.valueOf(distance1[0] + "m")).
                        position(경주국밥.getLatLng()));
            }
        });
        양식.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(m != null)
                    m.remove();
                if(m1 != null)
                    m1.remove();
                float distance[] = new float[1];
                Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                        35.836588,128.751590, distance);
                float distance1[] = new float[1];
                Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                        35.838425, 128.752422, distance1);
                m = gmap.addMarker(new MarkerOptions().title("에이바이트키친").snippet(String.valueOf(distance[0])+ "m").
                        position(에이바이트키친.getLatLng()));
                m1 = gmap.addMarker(new MarkerOptions().title("해시").snippet(String.valueOf(distance1[0])+ "m").
                        position(해시.getLatLng()));
            }
        });
        패스트푸드.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(m != null)
                    m.remove();
                if(m1 != null)
                    m1.remove();
                float distance[] = new float[1];
                Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                        35.838077, 128.756132, distance);
                float distance1[] = new float[1];
                Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                        35.837548, 128.752394, distance1);
                m = gmap.addMarker(new MarkerOptions().title("롯데리아").snippet(String.valueOf(distance[0])+ "m").
                        position(롯데리아.getLatLng()));
                m1 = gmap.addMarker(new MarkerOptions().title("맘스터치").snippet(String.valueOf(distance1[0])+ "m").
                        position(맘스터치.getLatLng()));
            }
        });
        일식.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(m != null)
                    m.remove();
                if(m1 != null)
                    m1.remove();
                float distance[] = new float[1];
                Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                        35.837709, 128.752178, distance);
                float distance1[] = new float[1];
                Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                        35.839114, 128.756724, distance1);
                m = gmap.addMarker(new MarkerOptions().title("도쿄라멘").snippet(String.valueOf(distance[0])+ "m").
                        position(도쿄라멘.getLatLng()));


                m1 = gmap.addMarker(new MarkerOptions().title("손시스시").snippet(String.valueOf(distance1[0])+ "m").
                        position(손시스시.getLatLng()));
            }
        });
        중식.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(m != null)
                    m.remove();
                if(m1 != null)
                    m1.remove();
                float distance[] = new float[1];
                Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                        35.836448, 128.752760, distance);
                float distance1[] = new float[1];
                Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                        35.837636, 128.752669, distance1);
                m = gmap.addMarker(new MarkerOptions().title("칭구짬뽕").snippet(String.valueOf(distance[0])+ "m").
                        position(칭구짬뽕.getLatLng()));
                m1 = gmap.addMarker(new MarkerOptions().title("씨옌").snippet(String.valueOf(distance1[0])+ "m").
                        position(씨옌.getLatLng()));
            }
        });
        오늘의맛집.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(m != null)
                    m.remove();
                if(m1 != null)
                    m1.remove();
                Random rand = new Random();
                float distance[] = new float[1];
                int a;
                switch (rand.nextInt(9)){
                    case 0:
                        Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                                35.837370,128.752175,distance);
                        m = gmap.addMarker(new MarkerOptions().title("달우찜닭").
                                snippet(String.valueOf(distance[0]) + "m").
                                position(달우찜닭.getLatLng()));
                        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(달우찜닭.getLatLng(),16));
                        음식점이름.setText("달우찜닭");
                        음식점전화.setText(달우찜닭.getHP());
                        사진.setImageDrawable(getResources().getDrawable(R.drawable.dal));
                        a =(int)distance[0]/60;
                        분.setText("도보 " + a + "분");
                        break;
                    case 1:
                        Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                                35.838653, 128.754602,distance);
                        m = gmap.addMarker(new MarkerOptions().title("경주국밥").
                                snippet(String.valueOf(distance[0]) + "m").
                                position(경주국밥.getLatLng()));
                        음식점이름.setText("경주국밥");
                        음식점전화.setText(경주국밥.getHP());
                        사진.setImageDrawable(getResources().getDrawable(R.drawable.gy));
                        a =(int)distance[0]/60;
                        분.setText("도보 " + a + "분");
                        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(경주국밥.getLatLng(),16));
                        break;
                    case 2:
                        Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                                35.836588,128.751590,distance);
                        m = gmap.addMarker(new MarkerOptions().title("에이바이트키친").
                                snippet(String.valueOf(distance[0]) + "m").
                                position(에이바이트키친.getLatLng()));
                        음식점이름.setText("에어바이트치킨");
                        음식점전화.setText(에이바이트키친.getHP());
                        사진.setImageDrawable(getResources().getDrawable(R.drawable.abite));
                        a =(int)distance[0]/60;
                        분.setText("도보 " + a + "분");
                        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(에이바이트키친.getLatLng(),16));
                        break;
                    case 3:
                        Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                                35.838425, 128.752422,distance);
                        m = gmap.addMarker(new MarkerOptions().title("해시").
                                snippet(String.valueOf(distance[0]) + "m").
                                position(해시.getLatLng()));
                        음식점이름.setText("해시");
                        음식점전화.setText(해시.getHP());
                        사진.setImageDrawable(getResources().getDrawable(R.drawable.hash));
                         a =(int)distance[0]/60;
                        분.setText("도보 " + a + "분");
                        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(해시.getLatLng(),16));
                        break;
                    case 4:
                        Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                                35.838077, 128.756132,distance);
                        m = gmap.addMarker(new MarkerOptions().title("롯데리아").
                                snippet(String.valueOf(distance[0]) + "m").
                                position(롯데리아.getLatLng()));
                        음식점이름.setText("롯데리아");
                        음식점전화.setText(롯데리아.getHP());
                        사진.setImageDrawable(getResources().getDrawable(R.drawable.lottera));
                         a =(int)distance[0]/60;
                        분.setText("도보 " + a + "분");
                        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(롯데리아.getLatLng(),16));
                        break;
                    case 5:
                        Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                                35.837548, 128.752394,distance);
                        m = gmap.addMarker(new MarkerOptions().title("맘스터치").
                                snippet(String.valueOf(distance[0]) + "m").
                                position(맘스터치.getLatLng()));
                         음식점이름.setText("맘스터치");
                        음식점전화.setText(맘스터치.getHP());
                        사진.setImageDrawable(getResources().getDrawable(R.drawable.mom));
                         a =(int)distance[0]/60;
                        분.setText("도보 " + a + "분");
                        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(맘스터치.getLatLng(),16));
                        break;
                    case 6:
                        Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                                35.837709, 128.752178,distance);
                        m = gmap.addMarker(new MarkerOptions().title("도쿄라멘").
                                snippet(String.valueOf(distance[0]) + "m").
                                position(도쿄라멘.getLatLng()));
                        음식점이름.setText("도쿄라멘");
                        음식점전화.setText(도쿄라멘.getHP());
                        사진.setImageDrawable(getResources().getDrawable(R.drawable.ra));
                         a =(int)distance[0]/60;
                        분.setText("도보 " + a + "분");

                        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(도쿄라멘.getLatLng(),16));
                        break;
                    case 7:
                        Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                                35.839114, 128.756724,distance);
                        m = gmap.addMarker(new MarkerOptions().title("손시스시").
                                snippet(String.valueOf(distance[0]) + "m").
                                position(손시스시.getLatLng()));
                        음식점이름.setText("손시스시");
                        음식점전화.setText(손시스시.getHP());
                        사진.setImageDrawable(getResources().getDrawable(R.drawable.son));
                      a =(int)distance[0]/60;
                        분.setText("도보 " + a + "분");
                        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(손시스시.getLatLng(),16));
                        break;
                    case 8:
                        Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                                35.836448, 128.752760,distance);
                        m = gmap.addMarker(new MarkerOptions().title("칭구짬뽕").
                                snippet(String.valueOf(distance[0]) + "m").
                                position(칭구짬뽕.getLatLng()));
                        음식점이름.setText("칭구짬뽕");
                        음식점전화.setText(칭구짬뽕.getHP());
                        사진.setImageDrawable(getResources().getDrawable(R.drawable.friend));
                       a =(int)distance[0]/60;
                        분.setText("도보 " + a + "분");
                        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(칭구짬뽕.getLatLng(),16));
                        break;
                    case 9:
                        Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                                35.837636, 128.752669,distance);
                        m = gmap.addMarker(new MarkerOptions().title("씨옌").
                                snippet(String.valueOf(distance[0]) + "m").
                                position(씨옌.getLatLng()));
                        음식점이름.setText("씨옌");
                        음식점전화.setText(씨옌.getHP());
                        사진.setImageDrawable(getResources().getDrawable(R.drawable.see));
                         a =(int)distance[0]/60;
                        분.setText("도보 " + a + "분");
                        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(씨옌.getLatLng(),16));
                }
            }
        });
        return root;

    }
    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }
    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.gmap = googleMap;
        gmap.setOnMarkerClickListener(this);
        if ( Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission( getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {
            ActivityCompat.requestPermissions( getActivity(), new String[] {  android.Manifest.permission.ACCESS_FINE_LOCATION  },
                    0 );
        }
        else {
            LocationManager lm = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            LocationListener ll = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {

                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            };
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 10, ll);
            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(location!=null) {
                my_locate = new Location(location);
                my_latitude = location.getLatitude();
                my_longitude = location.getLongitude();
                LatLng locate = new LatLng(location.getLatitude(), location.getLongitude());
                my_locate.setLatitude(my_latitude);
                my_locate.setLongitude(my_longitude);

                Marker my = gmap.addMarker(new MarkerOptions().title("현재 내 위치").snippet(String.valueOf(my_latitude)
                        + String.valueOf(my_longitude)).position(locate));
                gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(locate, 16));
            }
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Toast.makeText(getActivity(),marker.getTitle(), Toast.LENGTH_SHORT).show();
        if(marker.getTitle().equals("달우찜닭")) {
            float distance[] = new float[1];
            Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                    35.837370,128.752175, distance);
            음식점이름.setText(marker.getTitle());
            음식점전화.setText(달우찜닭.getHP());
            사진.setImageDrawable(getResources().getDrawable(R.drawable.dal));
            int a =(int)distance[0]/60;
            분.setText("도보 " + a + "분");

        }
        if(marker.getTitle().equals("경주국밥")) {
            float distance[] = new float[1];
            Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                    35.838653, 128.754602, distance);
            음식점이름.setText(marker.getTitle());
            음식점전화.setText(경주국밥.getHP());
            사진.setImageDrawable(getResources().getDrawable(R.drawable.gy));
            int a =(int)distance[0]/60;
            분.setText("도보 " + a + "분");
        }
        if(marker.getTitle().equals("에이바이트키친")) {
            float distance[] = new float[1];
            Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                    35.836588,128.751590, distance);
            음식점이름.setText(marker.getTitle());
            음식점전화.setText(에이바이트키친.getHP());
            사진.setImageDrawable(getResources().getDrawable(R.drawable.abite));
            int a =(int)distance[0]/60;
            분.setText("도보 " + a + "분");
        }
        if(marker.getTitle().equals("해시")) {
            float distance[] = new float[1];
            Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                    35.838425, 128.752422, distance);
            음식점이름.setText(marker.getTitle());
            음식점전화.setText(해시.getHP());
            사진.setImageDrawable(getResources().getDrawable(R.drawable.hash));
            int a =(int)distance[0]/60;
            분.setText("도보 " + a + "분");
        }
        if(marker.getTitle().equals("롯데리아")) {
            float distance[] = new float[1];
            Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                    35.838077, 128.756132, distance);
            음식점이름.setText(marker.getTitle());
            음식점전화.setText(롯데리아.getHP());
            사진.setImageDrawable(getResources().getDrawable(R.drawable.lottera));
            int a =(int)distance[0]/60;
            분.setText("도보 " + a + "분");
        }
        if(marker.getTitle().equals("맘스터치")) {
            float distance[] = new float[1];
            Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                    35.838077, 128.756132, distance);
            음식점이름.setText(marker.getTitle());
            음식점전화.setText(맘스터치.getHP());
            사진.setImageDrawable(getResources().getDrawable(R.drawable.mom));
            int a =(int)distance[0]/60;
            분.setText("도보 " + a + "분");
        }
        if(marker.getTitle().equals("도쿄라멘")) {
            float distance[] = new float[1];
            Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                    35.837709, 128.752178, distance);
            음식점이름.setText(marker.getTitle());
            음식점전화.setText(도쿄라멘.getHP());
            사진.setImageDrawable(getResources().getDrawable(R.drawable.ra));
            int a =(int)distance[0]/60;
            분.setText("도보 " + a + "분");
        }
        if(marker.getTitle().equals("손시스시")) {
            float distance[] = new float[1];
            Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                    35.839114, 128.756724, distance);
            음식점이름.setText(marker.getTitle());
            음식점전화.setText(손시스시.getHP());
            사진.setImageDrawable(getResources().getDrawable(R.drawable.son));
            int a =(int)distance[0]/60;
            분.setText("도보 " + a + "분");
        }
        if(marker.getTitle().equals("칭구짬뽕")) {
            float distance[] = new float[1];
            Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                    35.836448, 128.752760, distance);
            음식점이름.setText(marker.getTitle());
            음식점전화.setText(칭구짬뽕.getHP());
            사진.setImageDrawable(getResources().getDrawable(R.drawable.friend));
            int a =(int)distance[0]/60;
            분.setText("도보 " + a + "분");
        }
        if(marker.getTitle().equals("씨옌")) {

            float distance[] = new float[1];
            Location.distanceBetween(my_locate.getLatitude(),my_locate.getLongitude(),
                    35.837636, 128.752669, distance);
            음식점이름.setText(marker.getTitle());
            음식점전화.setText(씨옌.getHP());
            사진.setImageDrawable(getResources().getDrawable(R.drawable.see));
            int a =(int)distance[0]/60;
            분.setText("도보 " + a + "분");
        }


        return true;
    }
}