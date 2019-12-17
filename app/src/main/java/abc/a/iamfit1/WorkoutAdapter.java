package abc.a.iamfit1;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.ViewHolder> {

    Context context;
    ArrayList dataArrayList;

    public WorkoutAdapter(Context context, ArrayList dataArrayList) {
        this.context = context;
        this.dataArrayList = dataArrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_workout,parent,false);
        return new WorkoutAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        if(dataArrayList.get(position)!=null){
            holder.cardname.setText(dataArrayList.get(position).toString());
        }

        if(position==0)
        {
            holder.cardpic.setImageResource(R.drawable.ic_ab1);
            final Intent intent = new Intent(context, Workout1Activity.class);
            holder.cardpic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    context.startActivity(intent);
                }
            });
        }
        if(position==1)
        {
            holder.cardpic.setImageResource(R.drawable.ic_ab2);
            final Intent intent = new Intent(context, Workout2Activity.class);
            holder.cardpic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView cardname;
        ImageView cardpic;

        public ViewHolder(View itemView) {
            super(itemView);

            cardname = itemView.findViewById(R.id.textView5);
            cardpic = itemView.findViewById(R.id.imageView);

        }
    }
}
