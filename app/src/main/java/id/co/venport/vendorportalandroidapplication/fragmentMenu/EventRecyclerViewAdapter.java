package id.co.venport.vendorportalandroidapplication.fragmentMenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import id.co.venport.vendorportalandroidapplication.R;
import id.co.venport.vendorportalandroidapplication.model.Event;

import java.util.List;


public class EventRecyclerViewAdapter extends RecyclerView.Adapter<EventRecyclerViewAdapter.ViewHolder> {

    private final List<Event> mValues;
    private Context context;

    public EventRecyclerViewAdapter(List<Event> items, Context context) {
        mValues = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getJudul());
        holder.mContentView.setText(mValues.get(position).getDeskripsi());
        holder.pembuat.setText(mValues.get(position).getPembuat());
        holder.imageView.setImageResource(mValues.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView mIdView;
        public final TextView mContentView;
        public final TextView pembuat;
        public ImageView imageView;

        public Event mItem;

        public ViewHolder(View view) {
            super(view);
            mIdView = (TextView) view.findViewById(R.id.txtJudul);
            mContentView = (TextView) view.findViewById(R.id.txtDeskripsi);
            imageView = (ImageView) view.findViewById(R.id.imgPoster);
            pembuat = (TextView) view.findViewById(R.id.txtPembuat);
            view.setOnClickListener(this);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context,toString(),Toast.LENGTH_SHORT).show();
        }
    }
}
