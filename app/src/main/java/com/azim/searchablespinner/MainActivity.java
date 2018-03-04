package com.azim.searchablespinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.azim.spinner.SearchableSpinner;

public class MainActivity extends AppCompatActivity {

    private SearchableSpinner spinner1, spinner2;
    private TextView first, second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        first = (TextView) findViewById(R.id.first);
        second = (TextView) findViewById(R.id.second);

        String[] data = getResources().getStringArray(R.array.countries_array);

        spinner1 = (SearchableSpinner) findViewById(R.id.spinner1);
        spinner2 = (SearchableSpinner) findViewById(R.id.spinner2);

        spinner1.setData(data);
        spinner2.setData(data);

        spinner1.setDefaultText("Select country");
        spinner1.setInvalidTextColor(getResources().getColor(R.color.colorAccent));

        spinner1.setSelectionListener(new SearchableSpinner.OnSelectionListener() {
            @Override
            public void onSelect(int spinnerId, int position, String value) {
                Log.i("Select1", "Position : " + position + " : Value : " + value + " : " + spinnerId);
                setText(first, value);

            }
        });

        spinner2.setSelectionListener(new SearchableSpinner.OnSelectionListener() {
            @Override
            public void onSelect(int spinnerId, int position, String value) {
                Log.i("Select2", "Position : " + position + " : Value : " + value + " : " + spinnerId);
                setText(second, value);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getFirstValue(View view) {
        Log.i("First", spinner1.getValue() + "");
        setText(first, spinner1.getValue());
    }

    public void getSecondValue(View view) {
        Log.i("Second", spinner2.getValue() + "");
        setText(second, spinner2.getValue());
    }

    private void setText(TextView textView, String text) {
        if (text != null)
            textView.setText(text);
        else
            textView.setText("Nothing selected...");
    }
}
