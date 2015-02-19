package org.nikolay.ligthexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private static final int NEW_ITEM_REQUEST_CODE = 1;

    private final List<Item> itemList = new ArrayList<>();

    {
        for(int i = 0; i < 20; i++) {
            itemList.add(new Item("Item " + (i + 1)));
        }
    }

    private ListView listView;

    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestNewItem();
            }
        });

        listView = (ListView) findViewById(R.id.list_items);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item selectedItem = (Item) parent.getItemAtPosition(position);
                openDetails(selectedItem);
            }
        });

        adapter = new ItemAdapter(this, itemList);
        listView.setAdapter(adapter);
    }

    private void requestNewItem() {
        Intent takeNewItem = new Intent(this, NewItemActivity.class);
        startActivityForResult(takeNewItem, NEW_ITEM_REQUEST_CODE);
    }

    private void openDetails(Item selectedItem) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_CURRENT, selectedItem);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == NEW_ITEM_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Item item = data.getParcelableExtra(NewItemActivity.EXTRA_ITEM);
                addItem(item);
            } else {
                Toast.makeText(this, R.string.error_item_not_created, Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void addItem(Item item){
        adapter.add(item);
    }
}
