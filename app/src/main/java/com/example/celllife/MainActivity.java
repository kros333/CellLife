package com.example.celllife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Cell> cells = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar() != null)
            getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        Button createButton = findViewById(R.id.createButton);
        RecyclerView recyclerView = findViewById(R.id.CellsList);
        CellAdapter adapter = new CellAdapter(this, cells);
        recyclerView.setAdapter(adapter);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cells.add(new Cell());
                adapter.notifyItemInserted(cells.size());
                recyclerView.scrollToPosition(cells.size() - 1);
                if(cells.size() >= 3 && cells.get(cells.size() - 1).getState() == cells.get(cells.size() - 2).getState()
                        && cells.get(cells.size() - 1).getState() == cells.get(cells.size() - 3).getState())
                {
                    if(cells.get(cells.size() - 1).getState() == Cell.State.life)
                    {
                        cells.add(new Cell(Cell.State.fullLife));
                        adapter.notifyItemInserted(cells.size());
                        recyclerView.scrollToPosition(cells.size() - 1);
                    }
                    else if(cells.size() >= 4 && cells.get(cells.size() - 1).getState() == Cell.State.dead && cells.get(cells.size() - 4).getState() == Cell.State.fullLife)
                    {
                        cells.set(cells.size() - 4, new Cell(Cell.State.fullDead));
                        adapter.notifyItemChanged(cells.size() - 4);
                    }

                }
            }
        });
    }
}