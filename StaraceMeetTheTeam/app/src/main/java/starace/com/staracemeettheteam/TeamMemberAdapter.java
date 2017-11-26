package starace.com.staracemeettheteam;

import android.content.Context;
import android.support.v4.content.ContextCompat;
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
    private Contract.Presenter presenter;

    public TeamMemberAdapter(List<TeamMemberModel> memberModelList, Contract.Presenter presenter) {
        this.memberModelList = memberModelList;
        this.presenter = presenter;
    }

    @Override
    public TeamMemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new TeamMemberViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.main_recycler_view_content, parent, false));
    }

    @Override
    public void onBindViewHolder(final TeamMemberViewHolder holder, int position) {
        final TeamMemberModel memberModel = memberModelList.get(position);
        loadAvatar(holder.avatarView, memberModel);
        holder.nameView.setText(memberModel.getName());
        holder.titleView.setText(memberModel.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.modelClicked(memberModel, holder.getAdapterPosition());
            }
        });

        if (memberModel.isHasMet()) {
            holder.itemView.setBackground(ContextCompat.getDrawable(context, R.drawable.light_border));
        } else {
            holder.itemView.setBackground(ContextCompat.getDrawable(context, R.drawable.dark_border));
        }
    }

    private void loadAvatar(final ImageView view, TeamMemberModel model) {
        Picasso.with(context)
                .load(model.getAvatar())
                .resize(300, 300)
                .centerCrop()
                .error(R.drawable.default_avatar_100_100)
                .into(view);
    }

    @Override
    public int getItemCount() {
        return memberModelList.size();
    }

    public class TeamMemberViewHolder extends RecyclerView.ViewHolder {
        ImageView avatarView;
        TextView nameView;
        TextView titleView;

        public TeamMemberViewHolder(View itemView) {
            super(itemView);
            avatarView = (ImageView) itemView.findViewById(R.id.recycler_avatar);
            nameView = (TextView) itemView.findViewById(R.id.recycler_name);
            titleView = (TextView) itemView.findViewById(R.id.recycler_title);
        }
    }
}
