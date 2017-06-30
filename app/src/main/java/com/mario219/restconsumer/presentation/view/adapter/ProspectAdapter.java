package com.mario219.restconsumer.presentation.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mario219.restconsumer.R;
import com.mario219.restconsumer.models.ProspectSqlModel;
import com.mario219.restconsumer.presentation.view.EditProspectActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by marioalejndro on 29/06/17.
 */

public class ProspectAdapter extends RecyclerView.Adapter<ProspectAdapter.ProspectHolder> {

    private List<ProspectSqlModel> prospectList;

    public ProspectAdapter(List<ProspectSqlModel> prospectList) {
        this.prospectList = prospectList;
        notifyDataSetChanged();
    }

    @Override
    public ProspectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.prospect_item, parent, false);

        return new ProspectHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProspectHolder holder, final int position) {
        final ProspectSqlModel prospect = prospectList.get(position);
        holder.etName.setText(prospect.getName());
        holder.etSurname.setText(prospect.getSurname());
        holder.etId.setText(prospect.getIdentification().toString());
        holder.etTelephone.setText(prospect.getTelephone().toString());
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent editProspectActivity = new Intent(context, EditProspectActivity.class);
                editProspectActivity.putExtra("position", position);
                editProspectActivity.putExtra("prospect_object", prospect);
                context.startActivity(editProspectActivity);
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
