package com.mario219.restconsumer.presentation.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.mario219.restconsumer.R;
import com.mario219.restconsumer.data.DataProspects;
import com.mario219.restconsumer.models.ProspectSqlModel;
import com.mario219.restconsumer.presentation.presenter.EditProspectPresenter;
import com.mario219.restconsumer.presentation.view.contract.EditProspectView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditProspectActivity extends AppCompatActivity implements EditProspectView{

    /**
     * UI
     */
    @BindView(R.id.edit_name)
    EditText etName;
    @BindView(R.id.edit_surname)
    EditText etSurname;
    @BindView(R.id.edit_id)
    EditText etId;
    @BindView(R.id.edit_tel)
    EditText etTelephone;

    /**
     * State
     */
    EditProspectPresenter editProspectPresenter;
    private ProspectSqlModel prospect;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_prospect);
        ButterKnife.bind(this);
        DataProspects dataInstance = DataProspects.getInstance(this);
        editProspectPresenter = new EditProspectPresenter(this, dataInstance);
        position = getIntent().getIntExtra("position", 0);
        prospect = getIntent().getParcelableExtra("prospect_object");
        etName.setHint(prospect.getName());
        etSurname.setHint(prospect.getSurname());
        etId.setHint(prospect.getIdentification().toString());
        etTelephone.setHint(prospect.getTelephone().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.prospect_btn_edit)
    public void onSaveBtnClick(){
        if(etName.getText().equals("") || etSurname.getText().equals("") ||
                etId.getText().equals("") || etTelephone.getText().equals("")){
            Toast.makeText(this, R.string.login_empty_field, Toast.LENGTH_SHORT).show();
        }else{
            editProspectPresenter.updateProspect(prospect.getId(),
                    etName.getText().toString(), etSurname.getText().toString(),
                    Long.parseLong(etId.getText().toString()),
                    Long.parseLong(etTelephone.getText().toString())
            );
        }
    }


    /**
     * Contract Methods
     */
    @Override
    public void onUserUpdated(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        finish();
    }

}

