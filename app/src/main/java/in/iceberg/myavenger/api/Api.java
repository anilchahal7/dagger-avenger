package in.iceberg.myavenger.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("marvel")
    Call<List<Avenger>> getAvengers();
}
