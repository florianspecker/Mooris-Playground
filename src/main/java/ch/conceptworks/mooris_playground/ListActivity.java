package ch.conceptworks.mooris_playground;

/**
 * Example using https://github.com/emilsjolander/StickyScrollViewItems
 * TODO create UI programmatically as described here: http://stackoverflow.com/questions/4979212/programmatically-creating-a-relativelayout-in-android
 *
 * @author Florian Specker
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.TextView;

public class ListActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.list_layout);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        final GridAdapter gridadapter = new GridAdapter(this);
        gridview.setAdapter(gridadapter);
        gridview.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_MOVE){
                    return true;
                }
                return false;
            }

        });

        gridview = (GridView) findViewById(R.id.gridview1);
        final GridAdapter gridadapter1 = new GridAdapter(this);
        gridview.setAdapter(gridadapter1);
        gridview.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_MOVE){
                    return true;
                }
                return false;
            }

        });

        gridview = (GridView) findViewById(R.id.gridview2);
        final GridAdapter gridadapter2 = new GridAdapter(this);
        gridview.setAdapter(gridadapter2);
        gridview.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_MOVE){
                    return true;
                }
                return false;
            }

        });


    }

    @Override
    public void onStart() {
        super.onStart();
        TextView textView = (TextView) findViewById(R.id.text_view1);
        textView.setText("Hello world!");
        textView = (TextView) findViewById(R.id.text_view3);
        textView.setText("Another title");
    }

}
