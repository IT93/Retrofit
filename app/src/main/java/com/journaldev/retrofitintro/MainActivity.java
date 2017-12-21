package com.journaldev.retrofitintro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        list.add("6");
//        HeadMarkAdapter adapter = new HeadMarkAdapter(getApplicationContext(), list);
//        listView.setAdapter(adapter);
        getHeadMark();
    }

    private void getHeadMark() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.100.195:7777/weltesinformationcenter/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIClient api = retrofit.create(APIClient.class);

        Call<List<String>> call = api.getHeadmark();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
//                Log.d("hasil", response.body().get(0).toString());
//                for (String hm:response.body()) {
//                    Log.d("head mark", hm);
//                }
                HeadMarkAdapter adapter = new HeadMarkAdapter(getApplicationContext(), response.body());
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Log.d("error adalah", t.getMessage());
            }
        });

        /*(call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                List<Model> headList = response.body();

                String[] head = new String[headList.size()];

                for (int i = 0; i < headList.size(); i++) {
                    head[i] = String.valueOf(headList.get(i).getHeadmark());
                }

                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.list.simple_list_item_1, head));

            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.d("coba", t.getMessage());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });*/
    }

}
