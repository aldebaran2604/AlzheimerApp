package AlzheimerApp.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.activeandroid.ActiveAndroid;

import java.util.List;

import AlzheimerApp.Database.Sexo;
import AlzheimerApp.Database.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user = new User(getApplicationContext());
        user.Open();
        List<User> users =user.GetAll();
        user.Close();

    }
}
