package com.saikat1102.cfood.chefFoodPanel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.saikat1102.cfood.R;
import com.saikat1102.cfood.UpdateDishModel;
import com.saikat1102.cfood.customer_foodPanel.CustomerHomeAdapter;

import java.util.List;

public class ChefHomeAdapter extends RecyclerView.Adapter<ChefHomeAdapter.ViewHolder> {

    public Context mcontext;
    public List<UpdateDishModel> updateDishModellist;
    DatabaseReference databaseReference;

    public ChefHomeAdapter(Context context , List<UpdateDishModel>updateDishModelslist){

        this.updateDishModellist = updateDishModelslist;
        this.mcontext = context;
    }


    @NonNull
    @Override
    public ChefHomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.customer_menudish,parent,false);
        return new ChefHomeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChefHomeAdapter.ViewHolder holder, int position) {
        final UpdateDishModel updateDishModel = updateDishModellist.get(position);
        Glide.with(mcontext).load(updateDishModel.getImageURL()).into(holder.imageView);
        holder.Dishname.setText(updateDishModel.getDishes());
        updateDishModel.getRandomUID();
        updateDishModel.getChefId();
        holder.Price.setText("Price: "+updateDishModel.getPrice()+"Tk");
    }

    @Override
    public int getItemCount() {
        return updateDishModellist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView Dishname,Price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.menu_image);
            Dishname = itemView.findViewById(R.id.dishname);
            Price = itemView.findViewById(R.id.dishprice);
        }
    }
}
