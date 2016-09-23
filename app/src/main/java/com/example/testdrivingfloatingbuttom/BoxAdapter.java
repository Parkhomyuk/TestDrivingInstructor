package com.example.testdrivingfloatingbuttom;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class BoxAdapter extends BaseAdapter  {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Instructors> objects;

    BoxAdapter(Context context, ArrayList<Instructors> instructors) {
        ctx = context;
        objects = instructors;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return objects.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        Instructors instructors = getInstructor(position);

        // заполняем View в пункте списка данными из товаров: наименование, цена
        // и картинка
        ((TextView) view.findViewById(R.id.tvName)).setText(instructors.name);
        ((TextView) view.findViewById(R.id.tvCity)).setText(instructors.city);
        ((TextView) view.findViewById(R.id.tvExperience)).setText(instructors.experience);
        ((TextView) view.findViewById(R.id.tvRating)).setText(instructors.rating);
        ((TextView) view.findViewById(R.id.tvTypeVeh)).setText(instructors.typeVehicle);

        ((ImageView) view.findViewById(R.id.ivImage)).setImageResource(instructors.avatar);


       /* CheckBox cbBuy = (CheckBox) view.findViewById(R.id.cbBox);
        // присваиваем чекбоксу обработчик
        cbBuy.setOnCheckedChangeListener(myCheckChangeList);
        // пишем позицию
        cbBuy.setTag(position);
        // заполняем данными из товаров: в корзине или нет
        cbBuy.setChecked(instructors.box);*/
        return view;
    }

    // Instructor по позиции
    Instructors getInstructor(int position) {
        return ((Instructors) getItem(position));
    }

   /* // содержимое корзины
    ArrayList<Instructors> getBox() {
        ArrayList<Instructors> box = new ArrayList<Instructors>();
        for (Instructors instr : objects) {
            // если в корзине
            if (instr.box)
                box.add(instr);
        }
        return box;
    }*/


    //obrabotka tach instructor


   /* // обработчик для чекбоксов
    CompoundButton.OnCheckedChangeListener myCheckChangeList = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
            // меняем данные товара (в корзине или нет)
            getInstructor((Integer) buttonView.getTag()).box = isChecked;
        }
    };*/


}