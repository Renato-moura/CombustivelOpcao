package renato.com.br.combustivelopcao;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
    private static final NumberFormat valorMoeda =
            NumberFormat.getCurrencyInstance();

    private TextView bestTextView;
    private TextView valEtanolTextView;
    private TextView valGasTextView;
    private ImageView imgPrincipal;

    public MainActivity() {
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bestTextView = (TextView) findViewById(R.id.bestTextView);
        valGasTextView = (TextView) findViewById(R.id.valGasTextView);
        valEtanolTextView = (TextView) findViewById(R.id.valEtanolTextView2);
        imgPrincipal = (ImageView) findViewById(R.id.imgPtincipal);

        SeekBar gasSeekBar = (SeekBar) findViewById(R.id.gasSeekBar);
        gasSeekBar.setOnSeekBarChangeListener(seekBarGasListner);
        SeekBar etanolSeekBar = (SeekBar) findViewById(R.id.etanolSeekBar);
        etanolSeekBar.setOnSeekBarChangeListener(seekBarEtanolListiner);

    }
    private void Porcentagem(){
        /*@SuppressLint("ResourceType") CharSequence valor1 = getText(R.id.gasTextView);
        int gas = Integer.parseInt(valor1.toString());
        @SuppressLint("ResourceType") CharSequence valor2 = getText(R.id.valEtanolTextView2);
        int etn = Integer.parseInt(valor2.toString());
        int result = 0;

        result = etn/gas;

        if(result >= 0.7){
            imgPrincipal.setImageResource(R.drawable.etanol);
        }
        else {
            imgPrincipal.setImageResource(R.drawable.gasolina);
        }*/
        SeekBar gasSeekBar = (SeekBar) findViewById(R.id.gasSeekBar);
       double a = gasSeekBar.getProgress()/10.0;
       SeekBar etanolSeekBar = (SeekBar) findViewById(R.id.etanolSeekBar);
       double b = etanolSeekBar.getProgress()/10.0;

       double result = b/a;

        if(result <= 0.7){
            imgPrincipal.setImageResource(R.drawable.etanol);
            bestTextView.setText(R.string.etanol_textview);

        }
        else {
            imgPrincipal.setImageResource(R.drawable.gasolina);
            bestTextView.setText(R.string.gas_textview);
        }


    }
    private final SeekBar.OnSeekBarChangeListener seekBarEtanolListiner =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    double x = progress/10.0;
                    valEtanolTextView.setText(valorMoeda.format(x));
                    Porcentagem();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };
    private final SeekBar.OnSeekBarChangeListener seekBarGasListner =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                   double x = progress/10.0;
                   valGasTextView.setText(valorMoeda.format(x));
                   Porcentagem();

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };
}
