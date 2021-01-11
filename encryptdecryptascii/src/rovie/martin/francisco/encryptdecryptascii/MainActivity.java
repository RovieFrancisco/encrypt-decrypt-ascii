package rovie.martin.francisco.encryptdecryptascii;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText input = (EditText) findViewById(R.id.input);
        final EditText result = (EditText) findViewById(R.id.result);

        Button encrypt = (Button) findViewById(R.id.encrypt);
        Button decrypt = (Button) findViewById(R.id.decrypt);

        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!input.getText().toString().equals("")) {
                    result.setText(Encrypt(input.getText().toString()));
                }
                input.setText("");
            }
        });
        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!input.getText().toString().equals("")) {
                    result.setText(Decrypt(input.getText().toString().split(" ")));
                }
                input.setText("");
            }
        });
    }

    public String Encrypt(String text) {
        byte[] byteArr = text.getBytes();
        String str = "";

        for (int x = 0; x < byteArr.length; x++) {
            str += (byteArr[x] + " ");
        }

        return str;
    }
    public String Decrypt(String[] text) {
        byte[] byteArr = new byte[text.length];

        for (int x = 0; x < text.length; x++) {
            byteArr[x] = Byte.parseByte(text[x]);
        }

        String msg = new String(byteArr);

        return msg;
    }
}