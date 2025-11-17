package com.example.pawhelp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private Context context;
    private List<TeamMember> teamMembers;

    public TeamAdapter(Context context, List<TeamMember> teamMembers) {
        this.context = context;
        this.teamMembers = teamMembers;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_team_member, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        TeamMember member = teamMembers.get(position);

        holder.tvName.setText(member.getName());
        holder.tvPosition.setText(member.getPosition());
        holder.tvDescription.setText(member.getDescription());
        holder.tvStatus.setText(member.getStatus());
        holder.ivAvatar.setImageResource(member.getAvatarResId());

        // Có thể thêm logic để thay đổi màu sắc status badge dựa vào status
        if (member.getStatus().equals("ĐÃ ĐĂNG KÝ")) {
            holder.tvStatus.setBackgroundResource(R.drawable.bg_status_active);
        } else if (member.getStatus().equals("TRỢ LÝ ĐỘI TRƯỞNG")) {
            holder.tvStatus.setBackgroundResource(R.drawable.bg_status_leader);
        } else {
            holder.tvStatus.setBackgroundResource(R.drawable.bg_status_member);
        }
    }

    @Override
    public int getItemCount() {
        return teamMembers.size();
    }

    static class TeamViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAvatar;
        TextView tvName;
        TextView tvPosition;
        TextView tvDescription;
        TextView tvStatus;
        ImageView btnEmail;
        ImageView btnCall;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.ivAvatar);
            tvName = itemView.findViewById(R.id.tvName);
            tvPosition = itemView.findViewById(R.id.tvPosition);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            btnEmail = itemView.findViewById(R.id.btnEmail);
            btnCall = itemView.findViewById(R.id.btnCall);
        }
    }
}
