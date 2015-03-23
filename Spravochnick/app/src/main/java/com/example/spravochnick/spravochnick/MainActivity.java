package com.example.spravochnick.spravochnick;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    //Создаем массив разделов:


        ArrayAdapter<String> adapter;   //benny переносим объявление адаптера сюда, чтобы он стал доступен внутри листенера
        //Создаем массив разделов:


        protected ArrayList<String> readUrlFromFile() throws IOException {

            InputStream inputStream = this.getResources().openRawResource(R.raw.file);

            InputStreamReader inputReader = new InputStreamReader(inputStream);
            BufferedReader buffReader = new BufferedReader(inputReader);
            String line;
            ArrayList<String> head_array = new ArrayList<String>();
            while(( line = buffReader.readLine()) != null){
                head_array.add(line);

            }

            return head_array;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);

            // JAVA CODE BEGINS
// INSERT FOLLOWING CODE INTO MAIN ACTIVITY

// Do not modify this line
            InitAds( 0, null, MyAdActivity.FLAG_ALL );
            AddBannerToView( R.id.adview );
            getSupportActionBar().hide();

            setContentView(R.layout.activity_main);
            final ListView listView = (ListView) findViewById(R.id.listView);
            try {
                String[] array = readUrlFromFile().toArray(new String[readUrlFromFile().size()]);



                adapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, array);


                // Привяжем массив через адаптер к ListView
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {        //benny переносим весь блок с листенером внутрь блока try, потому что вся прога по китайски выполняется здесь
                    public void onItemClick(AdapterView<?> a, View v, int position, long id) {  //benny здесь внутрь листенера передается position по которому клацнули
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, DetailActivity.class);
                        String catListItem = adapter.getItem(position);  //benny из адаптера получаем строку, по которой клацнули
                        intent.putExtra("header", catListItem);  //benny кладем эту строку с ключом в наш интент



                        //запускаем вторую активность
                        startActivity(intent);
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }



        }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        System.out.println("AdsConfig initialization..");
        AdsManager ads = new AdsManager();
        ads.initAds(this);
        System.out.println("AdsConfig DONE");
    }

    @Override
    protected void onResume () {
        super.onResume();
        FirstStartAd();
    }
    }
