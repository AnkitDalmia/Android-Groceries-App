package com.addevelopment.shankerdelivery.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.addevelopment.shankerdelivery.R;
import com.addevelopment.shankerdelivery.model.ProductsInfoModel;

import java.util.List;

import static com.addevelopment.shankerdelivery.MainActivity.addToFavorite;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.viewHolder>{
    List<ProductsInfoModel> allProductList;
    private static final String TAG = "ProductAdapter";
    Context context;

    public ProductAdapter(List<ProductsInfoModel> allProductList, Context context) {
        this.allProductList = allProductList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_product_view,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {
        ProductsInfoModel model = allProductList.get(position);
        holder.cardviewImg.setImageResource(model.getProductImg());
        holder.cardviewTvDisscountedPrice.setText(model.getDissPrice());
        holder.cardviewTvMrpPrice.setText(model.getMaxRetailPrice());
        holder.tvProductTitle.setText(model.getProTilte());
        holder.tvProductQuntity.setText(model.getProQuntity());
        holder.cardviewTvDisscountValue.setText(model.getDissPercent());


        holder.productAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToFavorite.add(allProductList.get(position));
                Toast.makeText(context, addToFavorite.first().getProTilte(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return allProductList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView cardviewImg;
        TextView cardviewTvDisscountedPrice,cardviewTvMrpPrice,tvProductTitle,tvProductQuntity,cardviewTvDisscountValue;
        Button productAddButton;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            cardviewImg = itemView.findViewById(R.id.cardview_img);
            cardviewTvDisscountedPrice = itemView.findViewById(R.id.cardview_tv_disscounted_price);
            cardviewTvMrpPrice = itemView.findViewById(R.id.cardview_tv_mrp_price);
            tvProductTitle = itemView.findViewById(R.id.tv_product_title);
            tvProductQuntity = itemView.findViewById(R.id.tv_product_quntity);
            cardviewTvDisscountValue = itemView.findViewById(R.id.cardview_tv_disscount_value);
            productAddButton = itemView.findViewById(R.id.product_add_button);

        }
    }
}
