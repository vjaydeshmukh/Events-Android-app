package com.example.anmol.events.Adapter.Insider;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.anmol.events.Adapter.BookMyShow.BookMyShowAdapter;
import com.example.anmol.events.OnSiteWeb.onsite;
import com.example.anmol.events.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class InsiderAdapter extends RecyclerView.Adapter<InsiderAdapter.ViewHolder> {


    Context ctx;
    private List<String> image,title,date,place,href;

    public InsiderAdapter(Context ctx, List<String> image, List<String> title, List<String> date, List<String> place,List<String> href){

        this.ctx=ctx;
        this.image=image;
        this.title=title;
        this.date=date;
        this.place=place;
        this.href=href;

    }


    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView titl,dateTim,evenu,genr;

        RelativeLayout rv;

        public ViewHolder(View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.EventsHighTodayImageOne);
            titl=itemView.findViewById(R.id.EventsHighTodayTitleOne);
            dateTim=itemView.findViewById(R.id.EventsHighTodayDateTimeOne);
            evenu=itemView.findViewById(R.id.EventsHighTodayEvenueOne);
            genr=itemView.findViewById(R.id.EventsHighTodayGenreOne);

            rv=itemView.findViewById(R.id.RelativeMainEventsHighTodayOne);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i=new Intent(ctx,onsite.class);
                    i.putExtra("link","https://insider.in"+href.get(getAdapterPosition()));
                    ctx.startActivity(i);

                }
            });

        }
    }


    @Override
    public InsiderAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new InsiderAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_events_high_today_one,parent,false));

    }

    @Override
    public void onBindViewHolder(final InsiderAdapter.ViewHolder holder, int position) {

        //Setting Image
        Picasso.with(ctx).load(image.get(position)).fit().into(holder.img);

        Glide.with(ctx).load(image.get(position)).centerCrop().bitmapTransform(new BlurTransformation(ctx,50)).into(new SimpleTarget<GlideDrawable>() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                holder.rv.setBackground(resource);
            }
        });

        //Setting title
        holder.titl.setText(title.get(position));

        //Setting date
        holder.dateTim.setText(date.get(position));

        //Setting Evenue
        holder.evenu.setText(place.get(position));

        //Setting Tag
        holder.genr.setText(" ");



    }

    @Override
    public int getItemCount() {

        return image.size();

    }
}

