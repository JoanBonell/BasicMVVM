package cat.udl.hyperion.appmobils.basicmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import cat.udl.hyperion.appmobils.basicmvvm.model.MyDataModel;
import cat.udl.hyperion.appmobils.basicmvvm.viewmodel.MyViewModel;

import cat.udl.hyperion.appmobils.basicmvvm.R;

public class MainActivity extends AppCompatActivity {
    private MyViewModel myViewModel;
    private TextView myTextView;
    private EditText txtName;
    private EditText txtAge;
    private ImageButton sendName;
    private ImageButton sendAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = findViewById(R.id.myTextView);
        txtName = findViewById(R.id.txtName);
        txtAge = findViewById(R.id.txtAge);
        sendName = findViewById(R.id.sendName);
        sendAge = findViewById(R.id.sendAge);

        // Inicializa el ViewModel
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        // Observa los cambios en el ViewModel
        myViewModel.getMyData().observe(this, new Observer<MyDataModel>() {
            @Override
            public void onChanged(MyDataModel myDataModel) {
                if (myDataModel != null) {
                    myTextView.setText(myDataModel.getName() + ", " + myDataModel.getAge());
                }
            }
        });

        // Establecer OnClickListener para actualizar el nombre en el ViewModel
        sendName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = txtName.getText().toString();
                MyDataModel currentData = myViewModel.getMyData().getValue();
                if (currentData != null) {
                    int currentAge = currentData.getAge();
                    myViewModel.updateMyData(newName, currentAge);
                }
            }
        });

        // Establecer OnClickListener para actualizar la edad en el ViewModel
        sendAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newAge;
                try {
                    newAge = Integer.parseInt(txtAge.getText().toString());
                } catch (NumberFormatException e) {
                    newAge = 0;
                }
                MyDataModel currentData = myViewModel.getMyData().getValue();
                if (currentData != null) {
                    String currentName = currentData.getName();
                    myViewModel.updateMyData(currentName, newAge);
                }
            }
        });
    }
}
