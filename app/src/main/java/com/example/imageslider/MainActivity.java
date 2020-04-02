package com.example.imageslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView cityNames;
    private ViewPager citiesViewPager;
    private RadioGroup rgCities;
    private TabLayout tabLayout;

    private ArrayList<City> cities ;

    private ViewPagerAdapter adapter;

    private City selectedCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();




        cities = new ArrayList<>();
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        initializeCities();
        selectedCity = getCityByName("London");
        ArrayList<ImageFragment> fragments = new ArrayList<>();

        for (int i = 0; i < selectedCity.getImageUrls().size(); i++) {
            ImageFragment imageFragment = new ImageFragment();
            Bundle bundle = new Bundle();
            bundle.putString("imageUrl",selectedCity.getImageUrls().get(i));
            imageFragment.setArguments(bundle);
            fragments.add(imageFragment);
        }
        adapter.setFragments(fragments);
        cityNames.setText(selectedCity.getName());

        citiesViewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(citiesViewPager);

        rgCities.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                cityChanged(checkedId);
            }
        });

    }

    private void initViews() {
        Log.d(TAG, "initViews: started");
        citiesViewPager = (ViewPager) findViewById(R.id.citiesViewPager);
        cityNames = (TextView) findViewById(R.id.txtCityName);
        rgCities = (RadioGroup) findViewById(R.id.rgCities);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        Log.d(TAG, "initViews: ended");
    }
    public void initializeCities(){
        Log.d(TAG, "initializeCities: started");
        City london = new City();
        ArrayList<String> londonImageUrls = new ArrayList<>();
        londonImageUrls.add("https://cdn.pixabay.com/photo/2015/04/20/13/18/animals-731213__480.jpg");
        londonImageUrls.add("https://cdn.pixabay.com/photo/2014/11/13/23/34/london-530055__480.jpg");
        londonImageUrls.add("https://cdn.pixabay.com/photo/2013/06/23/15/54/london-140785__480.jpg");
        londonImageUrls.add("https://cdn.pixabay.com/photo/2015/09/18/11/47/london-eye-945497__480.jpg");
//        londonImageUrls.add("https://cdn.pixabay.com/photo/2015/12/08/00/32/london-1081820__480.jpg");

        london.setImageUrls(londonImageUrls);
        london.setName("London");


        City tokyo = new City();
        ArrayList<String> tokyoImageUrls = new ArrayList<>();
        tokyoImageUrls.add("https://cdn.pixabay.com/photo/2013/11/25/09/47/japan-217878__480.jpg");
        tokyoImageUrls.add("https://cdn.pixabay.com/photo/2019/04/20/11/39/japan-4141578__480.jpg");
        tokyoImageUrls.add("https://cdn.pixabay.com/photo/2019/06/08/11/30/japan-4259948__480.jpg");
        tokyoImageUrls.add("https://cdn.pixabay.com/photo/2017/10/01/13/27/tokyo-2805500__480.jpg");

        tokyo.setImageUrls(tokyoImageUrls);
        tokyo.setName("Tokyo");


        City NewYork = new City();
        ArrayList<String> newYorkImageUrls= new ArrayList<>();
        newYorkImageUrls.add("https://cdn.pixabay.com/photo/2015/05/01/14/46/new-york-748595__480.jpg");
        newYorkImageUrls.add("https://cdn.pixabay.com/photo/2020/03/06/08/15/night-4906358__480.jpg");
        newYorkImageUrls.add("https://cdn.pixabay.com/photo/2018/11/30/16/06/new-york-3848059__480.jpg");
        newYorkImageUrls.add("https://cdn.pixabay.com/photo/2018/07/30/14/26/newyork-3572763__480.jpg");

        NewYork.setImageUrls(newYorkImageUrls);
        NewYork.setName("NewYork");


        City Delhi = new City();
        ArrayList<String> delhiImageUrls = new ArrayList<>();
        delhiImageUrls.add("https://cdn.pixabay.com/photo/2013/03/14/05/55/temple-93446_1280.jpg");
        delhiImageUrls.add("https://cdn.pixabay.com/photo/2020/01/25/18/47/lahore-4793144_1280.jpg");
        delhiImageUrls.add("https://cdn.pixabay.com/photo/2018/06/22/20/07/qutb-minar-3491558__480.jpg");
        delhiImageUrls.add("https://cdn.pixabay.com/photo/2013/03/14/05/55/temple-93446__480.jpg");


        Delhi.setImageUrls(delhiImageUrls);
        Delhi.setName("Delhi");

        cities.add(Delhi);
        cities.add(london);
        cities.add(NewYork);
        cities.add(tokyo);

        cities.add(london);




    }

    private void cityChanged(int rbId){
        Log.d(TAG, "cityChanged: started");
        switch (rbId){
            case R.id.rbLondon:
                selectedCity = getCityByName("London");
                break;
            case R.id.rbDelhi:
                selectedCity = getCityByName("Delhi");
                break;
            case R.id.rbNewYork:
                selectedCity = getCityByName("NewYork");
                break;
            case R.id.rbTokyo:
                selectedCity = getCityByName("Tokyo");
                break;
            default:
                break;
        }

        if (selectedCity != null) {
            cityNames.setText(selectedCity.getName());

            ArrayList<ImageFragment> fragments = new ArrayList<>();

            for (int i = 0; i < selectedCity.getImageUrls().size(); i++) {
                ImageFragment imageFragment = new ImageFragment();
                Bundle bundle = new Bundle();
                bundle.putString("imageUrl",selectedCity.getImageUrls().get(i));
                imageFragment.setArguments(bundle);
                fragments.add(imageFragment);
            }
            adapter.setFragments(fragments);
        }
    }
    private City getCityByName(String name){
        Log.d(TAG, "getCityByName: started");
        for (City city: cities ){
            if(city.getName().equals(name)){
                return city;
            }

        }

        return null;


    }
}
