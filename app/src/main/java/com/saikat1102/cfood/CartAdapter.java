package com.saikat1102.cfood;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHodler> {

    List<Cart> cartList;

    public CartAdapter(List<Cart> cartList) {
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_model_design,parent, false);
        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHodler holder, int position) {
        Cart cart = cartList.get(position);
        holder.title.setText(cart.getTitle());
        holder.price.setText(cart.getPrice()+"Tk");
        holder.quantity.setText(cart.getQuantity());
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        TextView title, price, quantity;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            quantity = itemView.findViewById(R.id.quantity);
        }
    }
}