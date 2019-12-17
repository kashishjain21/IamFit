package abc.a.iamfit1;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlanFragment extends Fragment {

    TextView textView;
    TextView tvtot;
    EditText etexc,etcalory;
    String caltemp,exname;
    int total,cal=99945;
    Button buttadd;
    ArrayList<String> addArray = new ArrayList<String>();
    ListView list;
    Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_plan, container, false);

        context = container.getContext();
        etcalory = rootView.findViewById(R.id.etcalory);
        etexc = rootView.findViewById(R.id.etexc);
        buttadd = rootView.findViewById(R.id.buttadd);
        tvtot = rootView.findViewById(R.id.tvtot);
        list = rootView.findViewById(R.id.list);

        total=0;



        buttadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String getInput = etexc.getText().toString();


                caltemp= etcalory.getText().toString();
                if(caltemp.isEmpty())
                {
                    cal=99945;
                }
                else cal=Integer.parseInt(caltemp);

                if(addArray.contains(getInput))
                {
                    Toast.makeText(getActivity(), "Item already added!", Toast.LENGTH_LONG).show();


                    total = total + cal;
                    tvtot.setText("Total calories burnt: "+total);
                }
                else if (getInput.trim().equals("") || cal==99945)
                {
                    Toast.makeText(getActivity(), "Field Empty", Toast.LENGTH_LONG).show();

                }
                else
                {
                    addArray.add(getInput);
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(context, R.layout.listxml,R.id.textView3,addArray);
                    list.setAdapter(adapter);



                    total = total + cal;
                    tvtot.setText("Total calories burnt: "+total);
                }

                /*if(getInput.trim().equals("") || cal==)
                {

                }
                else
                {
                    caltemp= etcalory.getText().toString();
                    cal=Integer.parseInt(caltemp);

                    Log.i( "147 ", String.valueOf(cal));

                    total = total + cal;
                    tvtot.setText("Total calories burnt: "+total);
                } */

            }
        });





        return rootView;




    }

}