package com.example.android.stackoverflowapi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.stackoverflowapi.R;
import com.example.android.stackoverflowapi.model.StackModel;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StackAdapter extends RecyclerView.Adapter<StackAdapter.StackViewHolder> {
    private List<StackModel> users;
    private Context context;

    public StackAdapter(List<StackModel> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public StackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_view, parent, false);
        return new StackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StackViewHolder holder, int position) {
        holder.usernameTv.setText("Username: " + users.get(position).getDisplay_name());
        holder.reputationTv.setText("Reputation: " + users.get(position).getReputation());
        holder.locationTv.setText("Location: " + users.get(position).getLocation());

        Iterator<Map.Entry<String, Integer>> it =
                users.get(position).getBadges().entrySet().iterator();

        Map.Entry<String, Integer> pair = it.next();
        holder.bdgGold.setText(pair.getKey() + " : ");
        holder.bdgGoldVal.setText(pair.getValue().toString());

        pair = it.next();
        holder.bdgBronze.setText(pair.getKey() + " : ");
        holder.bdgBronzeVal.setText(pair.getValue().toString());

        pair = it.next();
        holder.bdgSilver.setText(pair.getKey() + " : ");
        holder.bdgSilverVal.setText(pair.getValue().toString());


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class StackViewHolder extends RecyclerView.ViewHolder {
        private TextView usernameTv, reputationTv, locationTv, bdgBronze, bdgSilver, bdgGold, bdgBronzeVal, bdgSilverVal, bdgGoldVal;

        public StackViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameTv = itemView.findViewById(R.id.usernametv);
            reputationTv = itemView.findViewById(R.id.reputationtv);
            locationTv = itemView.findViewById(R.id.locationtv);
            bdgBronze = itemView.findViewById(R.id.bdgbronzetv);
            bdgSilver = itemView.findViewById(R.id.bdgsilvertv);
            bdgGold = itemView.findViewById(R.id.bdggoldtv);
            bdgBronzeVal = itemView.findViewById(R.id.bdgbronzevalue);
            bdgSilverVal = itemView.findViewById(R.id.bdgsilvervalue);
            bdgGoldVal = itemView.findViewById(R.id.bdggoldvalue);

        }
    }
}
