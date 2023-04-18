package cat.udl.hyperion.appmobils.basicmvvm.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import cat.udl.hyperion.appmobils.basicmvvm.model.MyDataModel;

public class MyViewModel extends ViewModel {
    // Aquí declararamos las variables y métodos que serán observados por la vista.
    private MutableLiveData<MyDataModel> myData = new MutableLiveData<>();

    public MyViewModel() {
        // Inicializar los datos de MyDataModel con valores predeterminados
        MyDataModel initialData = new MyDataModel("Joan Bonell", 22);
        myData = new MutableLiveData<>(initialData);
    }

    // Método para simular la actualización de datos en este ejemplo
    public void updateMyData(String name, int age) {
        MyDataModel updatedData = new MyDataModel(name, age);
        setMyData(updatedData);
    }

    public LiveData<MyDataModel> getMyData(){
        return myData;
    }

    public void setMyData(MyDataModel newData){
        myData.setValue(newData);
    }
}

/*import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<MyDataModel> myData;

    public MyViewModel() {
        // Inicializar los datos de MyDataModel con valores predeterminados
        MyDataModel initialData = new MyDataModel("Nombre Ejemplo", 25);
        myData = new MutableLiveData<>(initialData);
    }

    public LiveData<MyDataModel> getMyData() {
        return myData;
    }

    public void setMyData(MyDataModel newData) {
        myData.setValue(newData);
    }

    // Método para simular la actualización de datos
    public void updateMyData(String name, int age) {
        MyDataModel updatedData = new MyDataModel(name, age);
        setMyData(updatedData);
    }
}
*/