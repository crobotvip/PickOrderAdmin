package com.crobot.pickorderadmin.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.crobot.pickorderadmin.R;
import com.crobot.pickorderadmin.api.PickOrderAdminService;
import com.crobot.pickorderadmin.api.RetrofitHelper;
import com.crobot.pickorderadmin.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/2/19 0019.
 */
public class SearchFragment extends Fragment {
    private View mView;
    private EditText et_username;
    private EditText et_password;
    private EditText et_email;
    private EditText et_phone;
    private Button btn_register;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.aty_login, container, false);

        }

        ViewGroup parent = (ViewGroup) mView.getParent();
        if (parent != null) {
            parent.removeView(mView);
        }


        et_username = (EditText) mView.findViewById(R.id.et_username);
        et_password = (EditText) mView.findViewById(R.id.et_password);
        et_email = (EditText) mView.findViewById(R.id.et_email);
        et_phone = (EditText) mView.findViewById(R.id.et_phone);
        btn_register = (Button) mView.findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user =new User();
                user.setUsername(et_username.getText().toString());
                user.setPassword(et_password.getText().toString());
                user.setEmail(et_email.getText().toString());
                user.setMobile(et_phone.getText().toString());
                Call<User> call= RetrofitHelper.getInstance().create(PickOrderAdminService.class).createUser(user);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Toast.makeText(getContext(),"成功",Toast.LENGTH_SHORT).show();

                        response.body();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(getContext(),"失败",Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

        return mView;
    }
}
