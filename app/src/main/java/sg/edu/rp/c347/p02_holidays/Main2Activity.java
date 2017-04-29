package sg.edu.rp.c347.p02_holidays;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Holiday>holidays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv = (ListView) this.findViewById(R.id.lvHolidays);

        //create a few food obj in food array
        holidays = new ArrayList<Holiday>();
        holidays.add(new Holiday("New Year's Day"+
                                 "1 Jan 2017"));
        holidays.add(new Holiday("Labour Day"+
                                 "1 May 2017"));

        //Link this activity object, the row.xml layout for each row and the food String array together
        aa = new HolidayAdapter(this, R.layout.row,holidays);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedDate = holidays.get(position);

                Toast.makeText(Main2Activity.this, selectedDate.getHoliday(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
