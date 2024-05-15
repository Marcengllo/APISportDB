package com.example.apisportdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {
    private List<Team> teams;
    private Context context;

    public TeamAdapter(List<Team> teams, Context context) {
        this.teams = teams;
        this.context = context;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inggrisrow, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.textViewTeamName.setText(team.getStrTeam());
        Glide.with(context).load(team.getStrTeamBadge()).into(holder.imageViewTeamBadge);
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class TeamViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewTeamBadge;
        TextView textViewTeamName;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewTeamBadge = itemView.findViewById(R.id.gambarjersey);
            textViewTeamName = itemView.findViewById(R.id.namateam);
        }
    }
}
