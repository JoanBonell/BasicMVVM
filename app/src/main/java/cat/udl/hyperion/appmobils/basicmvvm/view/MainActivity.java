package cat.udl.hyperion.appmobils.basicmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import cat.udl.hyperion.appmobils.basicmvvm.R;
import cat.udl.hyperion.appmobils.basicmvvm.viewmodel.MyViewModel;

public class MainActivity extends AppCompatActivity {
    private MyViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa el ViewModel
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        // Aquí se puede configurar la vista para que observe los cambios en el ViewModel
    }
}