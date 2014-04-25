package ch.conceptworks.mooris_playground;

/**
 * Example using https://github.com/emilsjolander/StickyScrollViewItems
 *
 * @author Florian Specker
 */

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class AnotherListActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ScrollView scrollView = new com.emilsjolander.components.StickyScrollViewItems.StickyScrollView(this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        scrollView.setLayoutParams(layoutParams);

        setContentView(scrollView);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        scrollView.addView(relativeLayout);


        // begin store 0

        ImageView header1 = new ImageView(this);
        header1.setId(121);
        header1.setImageResource(R.drawable.header1);
        header1.setTag("sticky");
        relativeLayout.addView(header1, new RelativeLayout.LayoutParams(640, 100));

        TextView textView = new TextView(this);
        textView.setId(123);
        textView.setText("Hello world!");
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.BELOW, header1.getId());
        relativeLayout.addView(textView, lp);

        GridView gridview = new GridView(this);
        gridview.setId(124);
        gridview.setGravity(Gravity.CENTER);
        gridview.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
        gridview.setNumColumns(3);
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

        lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 900);
        lp.addRule(RelativeLayout.BELOW, textView.getId());
        relativeLayout.addView(gridview, lp);

        // end store 0


        // begin store 1

        header1 = new ImageView(this);
        header1.setId(221);
        header1.setImageResource(R.drawable.header2);
        header1.setTag("sticky");
        lp = new RelativeLayout.LayoutParams(640, 100);
        lp.addRule(RelativeLayout.BELOW, gridview.getId());
        relativeLayout.addView(header1, lp);

        textView = new TextView(this);
        textView.setId(223);
        textView.setText(null);
        lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.BELOW, header1.getId());
        relativeLayout.addView(textView, lp);

        gridview = new GridView(this);
        gridview.setId(224);
        gridview.setGravity(Gravity.CENTER);
        gridview.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
        gridview.setNumColumns(3);
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

        lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 900);
        lp.addRule(RelativeLayout.BELOW, textView.getId());
        relativeLayout.addView(gridview, lp);

        // end store 1


        // begin store 2

        header1 = new ImageView(this);
        header1.setId(321);
        header1.setImageResource(R.drawable.header3);
        header1.setTag("sticky");
        lp = new RelativeLayout.LayoutParams(640, 100);
        lp.addRule(RelativeLayout.BELOW, gridview.getId());
        relativeLayout.addView(header1, lp);

        textView = new TextView(this);
        textView.setId(323);
        textView.setText("Hello world!");
        lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.BELOW, header1.getId());
        relativeLayout.addView(textView, lp);

        gridview = new GridView(this);
        gridview.setId(324);
        gridview.setGravity(Gravity.CENTER);
        gridview.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
        gridview.setNumColumns(3);
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

        lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 900);
        lp.addRule(RelativeLayout.BELOW, textView.getId());
        relativeLayout.addView(gridview, lp);

        // end store 2


        scrollView.smoothScrollTo(0,0); // see http://stackoverflow.com/questions/4119441/how-to-scroll-to-top-of-long-scrollview-layout
    }

}
