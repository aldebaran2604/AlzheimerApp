package AlzheimerApp.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.activeandroid.ActiveAndroid;

import AlzheimerApp.Database.Sexo;
import AlzheimerApp.Database.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user = new User(getApplicationContext());
        user.Open();
        user.nombre = "luis jose";
        user.apellidoPaterno = "Padilla";
        user.apellidoMaterno = "Benitez";
        user.sexo = Sexo.Masculino;
        user.password = "12345";
        user.DBInser();
        user.Close();

    }
}
