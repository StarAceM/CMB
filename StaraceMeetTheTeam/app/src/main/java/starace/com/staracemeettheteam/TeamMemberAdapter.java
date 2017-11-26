package starace.com.staracemeettheteam;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by mstarace on 11/25/17.
 */

public class TeamMemberAdapter extends RecyclerView.Adapter<TeamMemberAdapter.TeamMemberViewHolder> {
    private List<TeamMemberModel> memberModelList;
    private Context context;

    public TeamMemberAdapter(List<TeamMemberModel> memberModelList) {
        this.memberModelList = memberModelList;
    }

    @Override
    public TeamMemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new TeamMemberViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.main_recycler_view_content,parent,false));
    }

    @Override
    public void onBindViewHolder(TeamMemberViewHolder holder, int position) {
        final TeamMemberModel memberModel = memberModelList.get(position);
        Picasso.with(context)
        .load(memberModel.getAvatar())
        .into(holder.avatarView);
        holder.nameView.setText(memberModel.getName());
        holder.titleView.setText(memberModel.getTitle());
        holder.idView.setText(memberModel.getId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("teamMember", memberModel);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return memberModelList.size();
    }

    public class TeamMemberViewHolder extends RecyclerView.ViewHolder {
        ImageView avatarView;
        TextView nameView;
        TextView titleView;
        TextView idView;

        public TeamMemberViewHolder(View itemView) {
            super(itemView);
            avatarView = (ImageView) itemView.findViewById(R.id.recycler_avatar);
            nameView  = (TextView) itemView.findViewById(R.id.recycler_name);
            titleView = (TextView) itemView.findViewById(R.id.recycler_title);
            idView = (TextView) itemView.findViewById(R.id.recycler_id);
        }
    }
}
