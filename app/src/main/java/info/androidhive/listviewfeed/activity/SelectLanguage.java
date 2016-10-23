package info.androidhive.listviewfeed.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import info.androidhive.listviewfeed.R;

import static info.androidhive.listviewfeed.imagelibrary.UrlFeed.URL_FEED;
import static info.androidhive.listviewfeed.imagelibrary.UrlFeed.URL_FEED_CHURCH_NEWS;
import static info.androidhive.listviewfeed.imagelibrary.UrlFeed.URL_FEED_CHAT_GROUP;
import static info.androidhive.listviewfeed.imagelibrary.UrlFeed.URL_FEED_ABOUT;
import static info.androidhive.listviewfeed.imagelibrary.UrlFeed.URL_READ_MSG;
import static info.androidhive.listviewfeed.imagelibrary.UrlFeed.URL_CHARITY_INFO;

public class SelectLanguage extends Activity {



    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    Button okeybtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        String languageToLoad = "kn"; // your language
//        Locale locale = new Locale(languageToLoad);
//        Locale.setDefault(locale);
//        Configuration config = new Configuration();
//        config.locale = locale;
//        getBaseContext().getResources().updateConfiguration(config,
//                getBaseContext().getResources().getDisplayMetrics());
//        this.setContentView(R.layout.activity_select_language);


  setContentView(R.layout.activity_select_language);

        okeybtn = (Button) findViewById(R.id.okbtn);


        spinner =(Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              if(position == 0){

                  URL_FEED = "http://52.89.46.93/singleChurchApp/admin/feed_eng.json?random=888998";
                  URL_FEED_CHAT_GROUP="http://52.89.46.93/singleChurchApp/admin/group_eng.json?random=888998";
                  URL_FEED_CHURCH_NEWS="http://52.89.46.93/singleChurchApp/admin/news_eng.json?random=888998";
                  URL_FEED_ABOUT="http://52.89.46.93/singleChurchApp/admin/about_eng.json?random=888998";
                  URL_READ_MSG="http://52.89.46.93/singleChurchApp/admin/read_eng.json?random=888998";
                  URL_CHARITY_INFO="http://52.89.46.93/singleChurchApp/admin/charity_eng.json?random=888998";

              }
               else
              {
                  URL_FEED ="http://52.89.46.93/singleChurchApp/admin/feed_knd.json?random=888998";
                  URL_FEED_CHURCH_NEWS="http://52.89.46.93/singleChurchApp/admin/news_knd.json?random=888998";
                  URL_FEED_CHAT_GROUP="http://52.89.46.93/singleChurchApp/admin/group_knd.json?random=888998";
                  URL_FEED_ABOUT=" http://52.89.46.93/singleChurchApp/admin/about_knd.json?random=888998";
                  URL_READ_MSG="http://52.89.46.93/singleChurchApp/admin/read_knd.json?random=888998";
                  URL_CHARITY_INFO="http://52.89.46.93/singleChurchApp/admin/charity_knd.json?random=888998";

              }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        okeybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMainactivity = new Intent(getApplication(),Home.class);
                startActivity(openMainactivity);
                finish();
            }
        });
    }
}
