package org.nikolay.ligthexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class DetailActivity extends Activity {
    public static final String EXTRA_CURRENT = "current";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Item currentItem = intent.getParcelableExtra(EXTRA_CURRENT);
        Toast.makeText(this, "Selected Item " + currentItem, Toast.LENGTH_SHORT).show();
    }
}
