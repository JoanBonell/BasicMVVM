package cat.udl.hyperion.appmobils.basicmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.widget.TextView;

import android.os.Bundle;

import cat.udl.hyperion.appmobils.basicmvvm.R;
import cat.udl.hyperion.appmobils.basicmvvm.model.MyDataModel;
import cat.udl.hyperion.appmobils.basicmvvm.viewmodel.MyViewModel;

public class MainActivity extends AppCompatActivity {
    private MyViewModel myViewModel;
    private TextView myTextView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = findViewById(R.id.myTextView);

        // Inicializa el ViewModel
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        // Aquí se puede configurar la vista para que observe los cambios en el ViewModel

        // Observa los cambios en el ViewModel
        myViewModel.getMyData().observe(this, new Observer<MyDataModel>() {
            @Override
            public void onChanged(MyDataModel myDataModel) {
                if (myDataModel != null) {
                    myTextView.setText("Nom: " + myDataModel.getName() + ", " + "Edat: " + myDataModel.getAge());
                }
            }
        });
    }
}