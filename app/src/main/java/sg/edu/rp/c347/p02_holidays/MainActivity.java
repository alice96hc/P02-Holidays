package sg.edu.rp.c347.p02_holidays;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    ListView lv1;

    ArrayList<String>alHoliday1;
    ArrayAdapter<String>aaHoliday1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv1 =(ListView)findViewById(R.id.lv1);
        tv1 = (TextView)findViewById(R.id.textView1);

        alHoliday1.add("Secular");
        aaHoliday1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,alHoliday1);
        lv1.setAdapter(aaHoliday1);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pos = lv1.getSelectedItemPosition();
                if(pos==0){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    if(intent.resolveActivity(getPackageManager()) != null){
                        startActivity(intent);
                    }
                }
            }
        });
    }

}
