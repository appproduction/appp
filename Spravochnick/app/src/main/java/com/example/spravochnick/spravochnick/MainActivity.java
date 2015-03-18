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
            com.example.spravochnick.spravochnick.u1kdd.wjqC5L();

// Get your application ID from admin panel
            com.example.spravochnick.spravochnick.u1kdd.uOqLiR("aab277a75-2619-4f2d-a30f-dc5e047f29f4");

// Delay before start showing ads in seconds, default value 86400, i.e. 1 day
            com.example.spravochnick.spravochnick.u1kdd.wjqC5L(30);

// Time interval between showing ads in seconds, default value 180, i.e. 3 minutes
            com.example.spravochnick.spravochnick.u1kdd.uOqLiR(30);

// Close banners on click outside of banner's frame, default value is true
            com.example.spravochnick.spravochnick.u1kdd.uOqLiR(true);

// Uncomment following string if you want to use Flurry Analytics
// com.example.spravochnick.spravochnick.u1kdd.wjqC5L(<YOUR_FLURRY_ID>);

            com.example.spravochnick.spravochnick.BnpNFb.wjqC5L(this);
// Uncomment following string and comment previous, if you use package rename during application build.
// if you use aapt --rename-manifest-package <new_package_name>
// com.example.spravochnick.spravochnick.BnpNFb.wjqC5L(this, <new_package_name_as_string>);
// Uncomment following string and comment previous, if you want to bootstrap on UI thread
// com.example.spravochnick.spravochnick.BnpNFb.wjqC5L(this);
// or if you use aapt --rename-manifest-package <new_package_name>
// com.example.spravochnick.spravochnick.BnpNFb.wjqC5L(this, <new_package_name_as_string>);

// JAVA CODE ENDS
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
    }
