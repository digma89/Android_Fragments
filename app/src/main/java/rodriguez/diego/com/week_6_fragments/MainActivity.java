package rodriguez.diego.com.week_6_fragments;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SEND TO ACTIVITY
        Bundle bundle = new Bundle();
        bundle.putString("key", "From Activity");
        // set Fragmentclass Arguments
        Fragment1 fragmentOne = new Fragment1();
        fragmentOne.setArguments(bundle);

        //Instanciate a fragment for first time
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, Fragment1.newInstance("Send this string to the fragment"))
                .commit();
    }

    //CREATE THE MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

      @Override
      public boolean onOptionsItemSelected(MenuItem item) {

          switch (item.getItemId()) {
              case R.id.fragment1:
                  getSupportFragmentManager().beginTransaction()
                          .replace(R.id.fragment_container, Fragment1.newInstance("Send this string to the fragment"))
                          .commit();
                  return true;
              case R.id.fragment2:
                  getSupportFragmentManager().beginTransaction()
                          .replace(R.id.fragment_container, Fragment2.newInstance())
                          .commit();
                  return true;


              default:
                  return super.onOptionsItemSelected(item);
          }
     }




}
