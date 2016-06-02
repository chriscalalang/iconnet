package ph.edu.bulsu.compnetworkingapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ph.edu.bulsu.compnetworkingapp.R;
import ph.edu.bulsu.compnetworkingapp.fragments.TroubleshootingFragment;

/**
 * Created by FDM CjC on 3/12/2016.
 */
public class TroubleshootingAdapter extends RecyclerView.Adapter<TroubleshootingAdapter.MyViewHolder> {

    private List<TroubleshootingFragment> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }
    public TroubleshootingAdapter(List<TroubleshootingFragment> troubleList) {
        this.list = troubleList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_troubleshooting_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TroubleshootingFragment trouble = list.get(position);
//        holder.title.setText(trouble.getTitle());
//        holder.genre.setText(trouble.getGenre());
//        holder.year.setText(trouble.getYear());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
