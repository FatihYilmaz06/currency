package fthylmz.currently;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.saveButton) Button savebtn;
    @BindView(R.id.lastRequestButton) Button lastRequestbtn;
    @BindView(R.id.listview) ListView listView;
    RestInterface restInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        restInterface=ApiClient.getClient().create(RestInterface.class);
        Call<List<ResponseREPO>> call=restInterface.getRepo();
        call.enqueue(new Callback<List<ResponseREPO>>() {
            @Override
            public void onResponse(Call<List<ResponseREPO>> call, Response<List<ResponseREPO>> response) {
                List<ResponseREPO> responseREPOList = new ArrayList<>();
                responseREPOList = response.body();
                for (int i = 0; i < responseREPOList.size(); i++) {

                }
                }

            }

            @Override
            public void onFailure(Call<List<ResponseREPO>> call, Throwable t) {
            }
        });

        @OnClick(R.id.saveButton)
                public void save(){
            Spacecraft s = new Spacecraft();
            s.setName(nameEditText.getText().toString());
            s.setPropellant(propellantEditTxt.getText().toString());
            s.setDestination(destEditTxt.getText().toString());
            if (new DBAdapter(MainActivity.this).saveSpacecraft(s)) {
                nameEditText.setText("");
                propellantEditTxt.setText("");
                destEditTxt.setText("");
                tb.setDataAdapter(new SimpleTableDataAdapter(MainActivity.this, tableHelper.getSpaceProbes()));
            } else {
                Toast.makeText(MainActivity.this, "Not Saved", Toast.LENGTH_SHORT).show();
            }

        }
        @OnClick(R.id.lastRequestButton)
    public void lastRequest(){
            Intent i =new Intent(this,lastResponse.class);
            startActivity(i);

        }


        }
