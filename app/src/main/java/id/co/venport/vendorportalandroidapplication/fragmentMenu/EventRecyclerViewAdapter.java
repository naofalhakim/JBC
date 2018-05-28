package id.co.venport.vendorportalandroidapplication.fragmentMenu;

import android.content.Context;
import android.content.Intent;
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
        //holder.mContentView.setText(mValues.get(position).getDeskripsi());
        holder.pembuat.setText(mValues.get(position).getPembuat());
        holder.tanggal.setText(mValues.get(position).getTanggal());
        holder.imageView.setImageResource(mValues.get(position).getImage());
        if(mValues.get(position).getStatus()==0){
            holder.status.setText("Free Entry ");
        }else{
            holder.status.setText("Rp "+mValues.get(position).getStatus()+" ");
        }
        holder.lokasi.setText(mValues.get(position).getTempat()+" ");
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView mIdView;
        //public final TextView mContentView;
        public final TextView pembuat;
        public final TextView tanggal;
        public ImageView imageView;
        public final TextView status;
        public final TextView lokasi;

        public Event mItem;

        public ViewHolder(View view) {
            super(view);
            mIdView = (TextView) view.findViewById(R.id.txtJudul);
            pembuat = (TextView) view.findViewById(R.id.txtPembuat);
            tanggal = (TextView) view.findViewById(R.id.txtTanggal);
            //mContentView = (TextView) view.findViewById(R.id.txtDeskripsi);
            imageView = (ImageView) view.findViewById(R.id.imgPoster);
            status = (TextView) view.findViewById(R.id.txtstatus);
            lokasi = (TextView) view.findViewById(R.id.txtlokasi);

            view.setOnClickListener(this);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + "'";
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Event contentEvent = mValues.get(position);
            Intent intent = new Intent(context, DetailEvent.class);
            intent.putExtra("judulAcara",contentEvent.getJudul());
            intent.putExtra("pembuatAcara",contentEvent.getPembuat());
            intent.putExtra("tanggalAcara",contentEvent.getTanggal());
            intent.putExtra("statusAcara",contentEvent.getStatus());
            intent.putExtra("tempatAcara",contentEvent.getTempat());
            intent.putExtra("deskripsiAcara",contentEvent.getDeskripsi());
            intent.putExtra("jamAcara",contentEvent.getWaktu());
            intent.putExtra("noteAcara",contentEvent.getNote());
            intent.putExtra("posterAcara",contentEvent.getImage());
            context.startActivity(intent);
        }
    }
}
