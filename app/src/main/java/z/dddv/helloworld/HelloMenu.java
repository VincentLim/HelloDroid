package z.dddv.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HelloMenu extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "z.dddv.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TextViews
        if(savedInstanceState != null){
            onRestoreInstanceState(savedInstanceState);
        }

        setContentView(R.layout.activity_menu);

        //get The Layout
        View layout = getLayoutInflater().inflate(R.layout.activity_menu, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id){
            case  R.id.action_settings :
                return true;
            case R.id.action_gps :
                openGPS();
                return true;
            case R.id.action_search :
                openSearch();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    private void openSearch(){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);

        startActivity(intent);
    }

    /**
     * on click on OK button
     * @param view
     */
    public void sendMessage(View view){
        openSearch();
    }

    public void updateMessage(View view){
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();

        TextView hello = (TextView) findViewById(R.id.textView);

        hello.setText(message);
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    private void openGPS() {
        Intent intent = new Intent(this, GPSActivity.class);
        startActivity(intent);
    }


}
