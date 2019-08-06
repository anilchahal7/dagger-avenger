package in.iceberg.myavenger.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import in.iceberg.myavenger.R;
import in.iceberg.myavenger.api.Avenger;

public class AvengerAdapter extends RecyclerView.Adapter<AvengerAdapter.MyViewHolder> {

    private List<Avenger> heroList;
    private Context context;

    public AvengerAdapter(Context mContext) {
        context = mContext;
        heroList = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        return new MyViewHolder(itemView);
    }

    public void setHeroList(List<Avenger> heroList) {
        this.heroList = heroList;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.avengerName.setText(heroList.get(position).getName());
        holder.realName.setText(heroList.get(position).getRealname());
        loadAvengerImage(holder.avengerImage, heroList.get(position).getImageurl());
    }

    private void loadAvengerImage(ImageView imageView, String url) {
        Glide.with(context)
                .load(url)
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView avengerName;
        private TextView realName;
        private ImageView avengerImage;
        private MyViewHolder(View view) {
            super(view);
            avengerName = view.findViewById(R.id.avenger_name);
            realName = view.findViewById(R.id.real_name);
            avengerImage = view.findViewById(R.id.avenger_image);
        }
    }
}