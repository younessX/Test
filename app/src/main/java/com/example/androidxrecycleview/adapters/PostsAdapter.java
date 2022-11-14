package com.example.androidxrecycleview.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidxrecycleview.R;
import com.example.androidxrecycleview.models.Film;
import java.util.List;

/**<PostsAdapter.ViewHolder> represent the type of the adapter*/
/**RecycleView.Adapter est une abstract class alors on doit implémenter ces méthodes*/

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

     //private  Context context;
    /**List is the data structure for holding (jam3) all elements (liran2afixiw f RecyclerView)*/
     private  List<Film> posts;
     private  OnclickFilm onclickFilm;

    public PostsAdapter(List<Film> postList, OnclickFilm onclickFilm ){
        //this.context = context;
        this.posts   = postList;
        this.onclickFilm = onclickFilm;

    }

    /** crier un ViewHolder et inflanting its Xml Layout*/
    @NonNull
    @Override

    /**cette class est le réspensable de cier un ViewHolder à travers
       envoyer un objet (view) à la class ViewHolder*/

    public PostsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater layoutInflater = LayoutInflater.from(context);
        /**inflanter it's like import*/

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycleview_item, parent, false);

        return new ViewHolder(view, onclickFilm);
    }

    /**(Bind = rabt) changer les variables declarer dans le ViewHolder
               update ViewHolder*/
    /**cette méthode est appeler n fois tel que n est le nombre d'élements qui sera afficher dans le RecyclerView*/

    /**position est la position de l'objet dans la List*/
    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.ViewHolder holder, int position) {
         Film p = posts.get(position);
         holder.DescUser.setText(p.getDecUser());
         holder.NameUser.setText(p.getNameUser());
         holder.ImageUser.setImageResource(p.getImgUser());

         /**holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(context, p.getNameUser(), Toast.LENGTH_SHORT).show();
                 //final String TAG = "MyActivity";
                 //Log.d(TAG , "vous avez clicker sur "+  p.getNameUser());
             }
         });*/
    }


    /**view holder*/
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView NameUser, DescUser;
        ImageView ImageUser;
        OnclickFilm onclickFilm;

        public ViewHolder(@NonNull View itemView ,OnclickFilm onclickFilm) {
            super(itemView);

            NameUser  = itemView.findViewById(R.id.NameUser);
            DescUser  = itemView.findViewById(R.id.DescUser);
            ImageUser  = itemView.findViewById(R.id.ImageUser);
            this.onclickFilm = onclickFilm;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onclickFilm.onclickFilm(getAdapterPosition());
            Film film =  posts.get(getAdapterPosition());
            Toast.makeText(view.getContext(), "you clicked on "+film.getNameUser(), Toast.LENGTH_SHORT).show();
        }


    }


    /**return le nombre des  elements (items) dans la list
       elle indique à l'adaptre le nombre de lignes qui peut contenir la RecyclerView*/
    @Override
    public int getItemCount() {
        return posts.size();
    }

    public interface OnclickFilm{
        public void onclickFilm(int position);
    }

}
