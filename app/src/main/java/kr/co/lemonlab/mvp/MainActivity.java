package kr.co.lemonlab.mvp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import kr.co.lemonlab.mvp.adapter.ListAdapter;
import kr.co.lemonlab.mvp.data.DataRepository;
import kr.co.lemonlab.mvp.view.presenter.MainContract;
import kr.co.lemonlab.mvp.view.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    private MainContract.Presenter presenter;
    private ProgressDialog dialog;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = dialogInit();
        adapter = new ListAdapter();
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        presenter = new MainPresenter(this, adapter, new DataRepository());

        Button button = (Button) findViewById(R.id.search);
        final EditText editText = (EditText) findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loadItems(getApplicationContext(), editText.getText().toString());
            }
        });
    }

    @Override
    public void showProgress() {
        if( dialog.isShowing() ){
            dismissProgress();
        }
        dialog.show();
    }

    @Override
    public void dismissProgress() {
        dialog.hide();
    }

    private ProgressDialog dialogInit(){
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("잠시만 기다려 주세요");
        dialog.setCancelable(false);
        return dialog;
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
