package id.co.venport.vendorportalandroidapplication.fragmentMenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import id.co.venport.vendorportalandroidapplication.R;
import id.co.venport.vendorportalandroidapplication.model.Barang;
import id.co.venport.vendorportalandroidapplication.model.Vendor;

public class BarangLogistikRecyclerAdapter extends RecyclerView.Adapter<BarangLogistikRecyclerAdapter.ViewHolder> {

    private final List<Barang> mBarang;
    Context context;

    public BarangLogistikRecyclerAdapter(List<Barang> barangs, Context context) {
        mBarang = barangs;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_barang_logistik, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mBarang.get(position);
        holder.txtNamaBarang.getBackground().setAlpha(120);
        holder.txtNamaBarang.setText(holder.mItem.getNama());

        if(holder.mItem.getBonus().equals("")){
            holder.txtBonus.setVisibility(View.INVISIBLE);
        }else{
            holder.txtBonus.setText(holder.mItem.getBonus());
        }
        Glide.with(context).load(mBarang.get(position).getImage()).fitCenter().into(holder.imageBarangVendor);
    }

    @Override
    public int getItemCount() {
        return mBarang.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final View mView;
        public final ImageView imageBarangVendor;
        public final TextView txtBonus,txtNamaBarang;
        public Barang mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            imageBarangVendor = (ImageView) view.findViewById(R.id.imgBarangVendor);
            txtBonus = (TextView) view.findViewById(R.id.txt_bonus_barang);
            txtNamaBarang = (TextView) view.findViewById(R.id.txtnamabarang);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context,txtNamaBarang.getText().toString()+","+txtBonus.getText().toString(),Toast.LENGTH_SHORT).show();
        }
    }
}
