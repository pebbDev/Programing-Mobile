package com.pebdev.githubuser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.pebdev.githubuser.adapter.UserAdapter;
import com.pebdev.githubuser.entity.User;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private static final String TAG =
            MainActivity.class.getSimpleName();
    private ListView listUsers;
    private ProgressBar progressBar;
    private UserAdapter adapter;
    private ArrayList<User> user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("List of Github User");
        }
        progressBar = findViewById(R.id.progressBar);
        listUsers = findViewById(R.id.lv_list);
        adapter = new UserAdapter(this);

        getListUsers();
        listUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, user.get(i).getName(), Toast.LENGTH_SHORT).show();
                Log.d("lihat", user.get(i).getName());
            }
        });
    }

    public void getListUsers() {
        progressBar.setVisibility(View.INVISIBLE);
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "https://api.github.com/users";
        client.addHeader("Authorization",
                "");
        client.addHeader("User-Agent", "request");

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                progressBar.setVisibility(View.INVISIBLE);

                ArrayList<User> listUser = new ArrayList<>();

                String result = new String(responseBody);
                Log.d(TAG, result);
                try {
                    JSONArray dataArray = new JSONArray(result);
                    for (int i = 0; i < dataArray.length(); i++) {
                        JSONObject dataJson = dataArray.getJSONObject(i);
                        String name = dataJson.getString("login");
                        String type = dataJson.getString("type");
                        String photo = dataJson.getString("avatar_url");

                        User user = new User();
                        user.setPhoto(photo);
                        user.setName(name);
                        user.setType(type);

                        listUser.add(user);
                    }
                    user = listUser;

                    adapter = new UserAdapter(MainActivity.this);
                    adapter.setUsers(listUser);

                    listUsers.setAdapter(adapter);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                progressBar.setVisibility(View.INVISIBLE);
                String errorMessage;
                switch (statusCode) {
                    case 401:
                        errorMessage = statusCode + " : Bad Request";
                        break;
                    case 403:
                        errorMessage = statusCode + " : Forbidden";
                        break;
                    case 404:
                        errorMessage = statusCode + " : Not Found";
                        break;
                    default:
                        errorMessage = statusCode + " : " + error.getMessage();
                        break;
                }
                Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}