package com.example.celllife;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CellAdapter extends RecyclerView.Adapter<CellAdapter.ViewHolder>
{
    private final LayoutInflater inflater;
    private final List<Cell> cells;

    CellAdapter(Context context, List<Cell> cells)
    {
        this.cells = cells;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public CellAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = inflater.inflate(R.layout.cell_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CellAdapter.ViewHolder holder, int position) {
        Cell cell = cells.get(position);
        switch (cell.getState())
        {
            case dead: {
                holder.stateTextView.setText("Мертвая");
                int unicode = 0x1F480;
                holder.emojiTextView.setText(new String(Character.toChars(unicode)));
                holder.descriptionTextView.setText("Такова задумка природы...");
                break;
            }
            case life: {
                holder.stateTextView.setText("Живая");
                int unicode = 0x1F47E;
                holder.emojiTextView.setText(new String(Character.toChars(unicode)));
                holder.emojiTextView.setText(new String(Character.toChars(unicode)));
                holder.descriptionTextView.setText("Но свидетельства о рождении все-таки нет");
                break;
            }
            case fullDead: {
                holder.stateTextView.setText("Умерла");
                int unicode = 0x1F47B;
                holder.emojiTextView.setText(new String(Character.toChars(unicode)));
                holder.descriptionTextView.setText("Ее душа точно попала в рай");
                break;
            }
            case fullLife: {
                holder.stateTextView.setText("Жизнь");
                int unicode = 0x1F984;
                holder.emojiTextView.setText(new String(Character.toChars(unicode)));
                holder.descriptionTextView.setText("Первичный бульон делает свое дело!");
                break;
            }
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return cells.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        final TextView stateTextView, descriptionTextView, emojiTextView;
        ViewHolder(@NonNull View view) {
            super(view);
            emojiTextView = view.findViewById(R.id.emojiTextView);
            stateTextView = view.findViewById(R.id.stateTextView);
            descriptionTextView = view.findViewById(R.id.descriptionTextView);
        }
    }

}
