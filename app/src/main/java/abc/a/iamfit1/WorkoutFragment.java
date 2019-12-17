package abc.a.iamfit1;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutFragment extends Fragment {

    TextView textView;
    RecyclerView workoutrv;
    ArrayList<String> workoutlist = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /// Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_workout, container, false);

        workoutlist.add("Abs");
        workoutlist.add("Biceps");

        Log.i("list123 : ",workoutlist.toString());
        textView = rootView.findViewById(R.id.textView2);
        workoutrv = rootView.findViewById(R.id.rv_workout);
        settingDataToRecyclerView(workoutlist);
        return rootView;
    }

    private void settingDataToRecyclerView(ArrayList dataArrayList) {
        WorkoutAdapter workoutAdapter = new WorkoutAdapter(getContext(),dataArrayList);
        workoutrv.setAdapter(workoutAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        workoutrv.setLayoutManager(linearLayoutManager);
    }
}
