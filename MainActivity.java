package listviewassignment.com.listviewassignment;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    ListView details;
    String[] names= {"Johnny deep","Leonardo Decaprio","John Wayne","Angelina Jolie","Dido","Adele"};
    String[] emailid = {"Johnny_deep@gmail.com","Leo_capri@gmail.com","JohnWayne@gmail.com","Angelina@gmail.com","Dido@gmail.com","adele@gmail.com"};
    String[] phno= {"123454","456345","7893434","1221353","363634345","6754554"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        details= (ListView)findViewById(R.id.Nameslistview);

//        final ArrayList<String> list = new ArrayList<String>();
//        for (int i = 0; i < names.length; ++i) {
//            list.add(names[i]);
//        }

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,names);

        final CustomAdapter customAdapter = new CustomAdapter();
        details.setAdapter(customAdapter);
        //TODO : setting onclick listener

        details.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Toast.makeText(MainActivity.this, "You have clicked on  " + names[position], Toast.LENGTH_SHORT).show();

            }
        });


    }
    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolderPattern viewHolderPattern;
            if(convertView == null){
                viewHolderPattern = new ViewHolderPattern();
                convertView = getLayoutInflater().inflate(R.layout.custom_list_layout, null);

                viewHolderPattern.txt1 = (TextView) convertView.findViewById(R.id.text1);
                viewHolderPattern.txt2 = (TextView) convertView.findViewById(R.id.text2);
                viewHolderPattern.txt3 = (TextView) convertView.findViewById(R.id.text3);

                convertView.setTag(viewHolderPattern);
            } else {
                viewHolderPattern = (ViewHolderPattern)convertView.getTag();
            }

            viewHolderPattern.txt1.setText(names[position]);
            viewHolderPattern.txt2.setText(emailid[position]);
            viewHolderPattern.txt3.setText(phno[position]);

            return convertView;



        }

    }
        private static class ViewHolderPattern{

            TextView txt1;
            TextView txt2;
            TextView txt3;

        }

}
