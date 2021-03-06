package com.example.retailapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retailapp.ProductModel;
import com.example.retailapp.R;
import com.google.android.material.button.MaterialButton;


public class ProductDetailsFragment extends Fragment {


    private ImageView productIv;
    private TextView productTitle;
    private TextView productDetails;
    private TextView productDescription;
    private TextView productPrice;
    private Button addBtn;

    ProductModel productModel  ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_details, container, false);

        productIv =view.findViewById(R.id.product_details_iv);
        productTitle=view.findViewById(R.id.product_title_details_tv);
        productDetails=view.findViewById(R.id.product_details_details_tv);
        productDescription=view.findViewById(R.id.product_description_tv);
        productPrice=view.findViewById(R.id.product_price_details_tv);
        addBtn=view.findViewById(R.id.add_to_cart_btn);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

   getProductObjectFromHomeFragment();
    }

    private void getProductObjectFromHomeFragment() {
        Bundle args = getArguments();


        if(args != null){
          productModel = (ProductModel) args.getSerializable("Current_product");
          productTitle.setText(productModel.getTitle());
          productDetails.setText(productModel.getDetails());
          productDescription.setText(productModel.getDescription());
          productPrice.setText(productModel.getPrice() );
            Glide.with(requireContext()).load(productModel.getImage()).into(productIv);
        }
    }
}