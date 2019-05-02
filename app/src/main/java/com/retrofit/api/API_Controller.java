package com.retrofit.api;

import android.content.Context;
import android.widget.Toast;

import com.retrofit.api.pojo.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class API_Controller implements SendToController {
    APIInterface apiInterface;
    Context context;
    UpdateView updateView;

    API_Controller(Context context,UpdateView updateView) {
        this.context = context;
        this.updateView=updateView;
    }

    @Override
    public void sendDataToController() {
        apiInterface = APIClient.getClient().create(APIInterface.class);
        User user = new User("RAJAN", "leader");
        Call<ResponseBody> call1 = apiInterface.createUser();
        call1.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                System.out.println("updateViewdata "+response.body());
                updateView.updateViewdata(response.body());
               // Toast.makeText(context, user1.name + " " + user1.job + " " + user1.id + " " + user1.createdAt, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
              //  call.cancel();
                System.out.println("tt "+t.getMessage());
            }
        });

    }
}
