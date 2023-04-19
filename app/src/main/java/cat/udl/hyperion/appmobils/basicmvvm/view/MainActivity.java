package cat.udl.hyperion.appmobils.basicmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;

import cat.udl.hyperion.appmobils.basicmvvm.databinding.ActivityMainBinding;
import cat.udl.hyperion.appmobils.basicmvvm.viewmodel.MyViewModel;
import cat.udl.hyperion.appmobils.basicmvvm.R;

public class MainActivity extends AppCompatActivity {
    private MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Inicializa el ViewModel
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        // Asocia el ViewModel con el Data Binding
        binding.setViewModel(myViewModel);
        binding.setLifecycleOwner(this);
    }
}