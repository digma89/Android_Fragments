package rodriguez.diego.com.week_6_fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        //to get the sended varibales
        String arguments  = getArguments().getString("key");


        Button submitButton = (Button) view.findViewById(R.id.submitFragment1);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox option1 = (CheckBox) getActivity().findViewById(R.id.option1);
                Toast.makeText(getActivity(), "Checkbox one isChecked=" + option1.isChecked(), Toast.LENGTH_LONG).show();
                // here you may start the next activity

                Intent intent = new Intent(getActivity().getApplicationContext(), Activity2.class);
                //add whatever data you want to pass to Activity2
                //intent.putExtra(...);
                startActivity(intent);


            }
        });

        return view;
    }

    //To send variables from the activity to the fragment
    public static Fragment1 newInstance(String i){
        Bundle args = new Bundle();
        args.putString("key", i);
        Fragment1 fragment = new Fragment1();
        fragment.setArguments(args);
        return fragment;
    }
}
