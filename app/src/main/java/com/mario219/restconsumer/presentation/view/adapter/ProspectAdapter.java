package com.mario219.restconsumer.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mario219.restconsumer.R;
import com.mario219.restconsumer.models.ProspectModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by marioalejndro on 29/06/17.
 */

public class ProspectAdapter extends RecyclerView.Adapter<ProspectAdapter.ProspectHolder> {

    private List<ProspectModel> prospectList;

    public ProspectAdapter(List<ProspectModel> prospectList) {
        this.prospectList = prospectList;
    }

    @Override
    public ProspectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.prospect_item, parent, false);

        return new ProspectHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProspectHolder holder, int position) {
        ProspectModel prospect = prospectList.get(position);
        holder.etName.setText(prospect.getName());
        holder.etSurname.setText(prospect.getSurname());
        holder.etId.setText(prospect.getSchProspectIdentification());
        holder.etTelephone.setText(prospect.getTelephone());
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context c = v.getContext();
                Toast.makeText(c, "hello", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return prospectList.size();
    }

    static class ProspectHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.prospect_item_name) TextView etName;
        @BindView(R.id.prospect_item_surname) TextView etSurname;
        @BindView(R.id.prospect_item_id) TextView etId;
        @BindView(R.id.prospect_item_telephone) TextView etTelephone;
        @BindView(R.id.prospect_btn_edit) Button btnEdit;
        public ProspectHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
