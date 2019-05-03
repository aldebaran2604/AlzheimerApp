package AlzheimerApp.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;

import AlzheimerApp.Database.Users;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void QueryData(View v){
        Users user = new Users("Luis Jose");
        user.save();

        //Users usuario1 = new Select().from(Users.class).orderBy("user_name ASC").executeSingle();

        //Log.i("SQL", usuario1.userName);
    }
}
