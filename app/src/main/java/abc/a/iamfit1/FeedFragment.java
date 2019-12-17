package abc.a.iamfit1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {

    TextView bmi,res;
    EditText hgt,wgt;
    int ht,wt;
    float  bbmi,fht,fwt;
    Button calc;
    String htemp, wtemp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_feed, container, false);

        hgt = rootView.findViewById(R.id.tvh);
        wgt = rootView.findViewById(R.id.tvw);
        bmi = rootView.findViewById(R.id.tvbmi);
        calc= rootView.findViewById(R.id.buttcalc);
        res= rootView.findViewById(R.id.tvres);






        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                htemp= hgt.getText().toString();

                if(htemp.isEmpty())
                {
                    ht=0;
                    Toast.makeText(getActivity(), "Field Empty", Toast.LENGTH_LONG).show();
                }
                else
                {
                    ht=Integer.parseInt(htemp);
                }



                Log.i( "654: ", String.valueOf(ht));

                wtemp= wgt.getText().toString();
                if(wtemp.isEmpty())
                {
                    ht=0;
                    Toast.makeText(getActivity(), "Field Empty", Toast.LENGTH_LONG).show();
                }
                else wt=Integer.parseInt(wtemp);

                Log.i( "789: ", String.valueOf(wt));

                fht=ht;
                fwt=wt;


                bbmi = fht/100;
                Log.i( "asd1: ", String.valueOf(bbmi));
                bbmi = bbmi*bbmi;
                Log.i( "asd2: ", String.valueOf(bbmi));
                bbmi = fwt/bbmi;

                Log.i( "asd3: ", String.valueOf(bbmi));



                bmi.setText("BMI: "+ bbmi);

                if(wt!=0 && ht!=0)
                {
                    if(bbmi<18)
                    {
                        res.setText("Result: Underweight");
                    }
                    else if(bbmi>24)
                    {
                        res.setText("Result: Overweight");
                    }
                    else
                    {
                        res.setText("Result: Healthy");
                    }
                }
                else
                {
                    Toast.makeText(getActivity(), "Field Empty", Toast.LENGTH_LONG).show();
                }

            }
        });



        return rootView;
    }

}
