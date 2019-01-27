package com.github.templateapp.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.github.templateapp.R;
import com.github.templateapp.model.Planets;
import com.github.templateapp.model.Result;
import com.github.templateapp.rest.ApiService;
import com.github.templateapp.rest.RetrofitClient;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.github.templateapp.utils.Constants.TAG;
import static com.github.templateapp.utils.Constants.URL;


public class MainFragment extends Fragment {

    private Context fragmentContext;
    private ApiService apiService;
    private CompositeDisposable disposable = new CompositeDisposable();
    private Button btnConnection;

    public MainFragment() {
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: " + MainFragment.class.getName());
        apiService = RetrofitClient.getRetrofit(URL, fragmentContext).create(ApiService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Log.d(TAG, "onCreateView: " + MainFragment.class.getName());
        btnConnection = (Button)view.findViewById(R.id.btn_connection);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated: " + MainFragment.class.getName());
        btnConnection.setOnClickListener(firstButton -> makeHttpConnection());
    }

    private void makeHttpConnection() {
        disposable.add(apiService.getResult()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe( result -> {
                        Log.d(TAG, "Successful Connection: " + result.getPlanets().get(0).getName());
                        Toast.makeText(fragmentContext, "Successful Connection", Toast.LENGTH_SHORT).show();

                        iterateDataOfPlanets(result);

                    }, throwable -> {
                        Log.d(TAG, "Connection Error: " + throwable.getMessage() + " "
                                + throwable.getCause());
                        Log.d(TAG, "Error: " + throwable.getMessage());
                    })
        );
    }

    private void iterateDataOfPlanets(Result result) {
        for (Planets planet : result.getPlanets()){
            Log.d(TAG, "Planet list: " + planet.getName());
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: " + MainFragment.class.getName());
        fragmentContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: " + MainFragment.class.getName());
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: " + MainFragment.class.getName());
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: " + MainFragment.class.getName());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
