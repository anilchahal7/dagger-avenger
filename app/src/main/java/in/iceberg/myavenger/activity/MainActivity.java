package in.iceberg.myavenger.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import in.iceberg.myavenger.R;
import in.iceberg.myavenger.adapter.AvengerAdapter;
import in.iceberg.myavenger.api.Api;
import in.iceberg.myavenger.api.Avenger;
import in.iceberg.myavenger.application.AvengerApplication;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject Retrofit retrofit;
    private AvengerAdapter avengerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((AvengerApplication) getApplication()).getAvengerComponent().inject(this);
        RecyclerView recyclerView = findViewById(R.id.avenger_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        avengerAdapter = new AvengerAdapter(this);
        recyclerView.setAdapter(avengerAdapter);
        getAvengers();
    }

    private void getAvengers() {
        Api api = retrofit.create(Api.class);
        api.getAvengers().enqueue(new Callback<List<Avenger>>() {
            @Override
            public void onResponse(@NonNull Call<List<Avenger>> call, @NonNull Response<List<Avenger>> response) {
                List<Avenger> heroList = response.body();
                avengerAdapter.setHeroList(heroList);
                avengerAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(@NonNull Call<List<Avenger>> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
