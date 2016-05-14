package com.niupai_xxr_lqtj.myui.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.niupai_xxr_lqtj.R;
import com.niupai_xxr_lqtj.base.BaseRecyclerAdapter;
import com.niupai_xxr_lqtj.bean.GoodsList;
import com.niupai_xxr_lqtj.network.manager.MyRetrofitManager;
import com.niupai_xxr_lqtj.utils.general.DensityUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by qibin on 2015/11/7.
 */
public class GoodListAdapter extends BaseRecyclerAdapter<GoodsList> {

    private Context mContext;


    @Override
    public RecyclerView.ViewHolder onCreate(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment_buy_normal, parent, false);

        return new MyHolder(layout);
    }

    @Override
    public void onBind(RecyclerView.ViewHolder holder, int RealPosition, GoodsList goodsList) {

        if(holder instanceof MyHolder) {
            DisplayMetrics dm = new DisplayMetrics();
            ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(dm);
            float wdith = dm.widthPixels;
            float wdithDp = DensityUtil.px2dip(mContext,wdith);
            GridLayoutManager.LayoutParams params = (GridLayoutManager.LayoutParams) ((MyHolder) holder).mBuyCvitem.getLayoutParams();
            params.width = dm.widthPixels/2;
            params.height = (int) mContext.getResources().getDimension(R.dimen.y600);
            ((MyHolder) holder).mBuyCvitem.setLayoutParams(params);
            Glide.with(mContext).load(MyRetrofitManager.BASE_IMAGE_URL+goodsList.getHeadImage()).placeholder(R.drawable.ic_placeholder).into(((MyHolder) holder).mBuyImgPic);
            ((MyHolder) holder).mBuyTxtName.setText("揭晓进度"+goodsList.getProductName());

            int progress = 100*Integer.valueOf(goodsList.getCurrentBuyCount())/(Integer.valueOf(goodsList.getProductPrice()));
            ((MyHolder) holder).mBuyTxtProgress.setText(progress+"%");
            ((MyHolder) holder).mBuyPbProgressbar.setMax(Integer.valueOf(goodsList.getProductPrice()));
            ((MyHolder) holder).mBuyPbProgressbar.setProgress(Integer.valueOf(goodsList.getCurrentBuyCount()));
        }
    }

    class MyHolder extends Holder {
      //  TextView text;
        @Bind(R.id.buy_cv_item)
        CardView mBuyCvitem;
        @Bind(R.id.buy_img_game)
        ImageView mBuyImgGame;
        @Bind(R.id.buy_img_pic)
        ImageView mBuyImgPic;
        @Bind(R.id.buy_txt_name)
        TextView mBuyTxtName;
        @Bind(R.id.buy_txt_progress)
        TextView mBuyTxtProgress;
        @Bind(R.id.buy_pb_progressbar)
        ProgressBar mBuyPbProgressbar;
        @Bind(R.id.buy_txt_add_bill)
        TextView mBuyTxtAddBill;

        public MyHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
         //   text = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
