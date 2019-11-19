package buu.informatics.s59160586.androidfinalproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ListViewAdapter (var context: Context?, var animal: ArrayList<animal>): BaseAdapter() {
    private class ViewHolder(row: View?){
        var txtName : TextView
        var txtSciName : TextView
        var animalImage : ImageView

        init {
            this.txtName = row?.findViewById(R.id.animalName) as TextView
            this.txtSciName = row?.findViewById(R.id.animalSciName) as TextView
            this.animalImage = row?.findViewById(R.id.animalImage) as ImageView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder
        if(convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.list_view,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var setAnimal:animal = getItem(position) as animal
        viewHolder.txtName.text = setAnimal.name
        viewHolder.txtSciName.text = setAnimal.sciName
        viewHolder.animalImage.setImageResource(setAnimal.image)
        return view as View

    }

    override fun getItem(position: Int): Any {
        return animal[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return animal.count()
    }
}