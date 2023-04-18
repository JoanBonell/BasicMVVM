package cat.udl.hyperion.appmobils.basicmvvm.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import cat.udl.hyperion.appmobils.basicmvvm.model.MyDataModel;

public class MyViewModel extends ViewModel {
    // Aquí declararamos las variables y métodos que serán observados por la vista.
    private MutableLiveData<MyDataModel> myData = new MutableLiveData<>();

    public LiveData<MyDataModel> getMyData() {
        return myData;
    }

    public void setMyData(MyDataModel newData) {
        myData.setValue(newData);
    }

    // Método para simular la actualización de datos en este ejemplo
    public void updateMyData(String name, int age) {
        MyDataModel updatedData = new MyDataModel(name, age);
        setMyData(updatedData);
    }
}

