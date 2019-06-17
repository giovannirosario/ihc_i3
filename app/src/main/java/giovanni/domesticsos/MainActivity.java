package giovanni.domesticsos;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<InfoCard> infoCards;
    private InfoCardArrayAdapter arrayAdapter;
    private int i;
    private int totalDangerScore;
    private SwipeFlingAdapterView flingContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoCards = new ArrayList<InfoCard>();
        InfoCard a = new InfoCard("Violência Psicológica", "Qualquer conduta que cause dano emocional, diminuição da autoestima, controle das ações e do comportamento, como as listadas a seguir:\n" +
                "– Chantagem emocional\n" +
                "– Humilhação pública\n" +
                "– Vigilância e perseguição\n" +
                "– Constrangimento em público\n" +
                "– Insulto e humilhação com palavras\n" +
                "– Isolamento (privar a mulher do convívio com amigos e familiares)\n" +
                "– Limitação do direito de ir e vir", "auhsdhasd", 5);

        InfoCard b = new InfoCard("Violência Física", "Qualquer conduta que ofenda integridade ou saúde corporal:\n" +
                "– Puxão ou apertão\n" +
                "– Empurrão\n" +
                "– Beliscão\n" +
                "– Bofetada\n" +
                "– Soco\n" +
                "– Mordida\n" +
                "– Arranhão\n" +
                "– Pontapé\n" +
                "– Agressão que pode levar à morte", "auhduas", 6);

        InfoCard c = new InfoCard("Violência Moral", "– Calúnia\n" +
                "– Difamação\n" +
                "– Injúria", "uhasdha", 3);

        InfoCard d = new InfoCard("Violência Patrimonial", "– Retenção, subtração ou destruição de objetos, bens, valores, instrumentos de trabalho, documentos pessoais, incluindo os destinados a satisfazer as necessidades.\n" +
                "– Quando o companheiro é responsável pela renda familiar e usa o dinheiro como punição, deixando de pagar ou comprar algo importante para o bem-estar dela e dos filhos.", "auhsd", 2);

        infoCards.add(a);
        infoCards.add(b);
        infoCards.add(c);
        infoCards.add(d);

        arrayAdapter = new InfoCardArrayAdapter(this, R.layout.item, infoCards);

        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);
        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                infoCards.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                makeToast(MainActivity.this, "Nunca Sofri!");
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                makeToast(MainActivity.this, "Já Sofri!");
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                //infoCards.add("XML ".concat(String.valueOf(i)));
                arrayAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                makeToast(MainActivity.this, "Clicked!");
            }
        });

    }

    static void makeToast(Context ctx, String s){
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }


    public void onLeftButtonClicked(View view) {
        makeToast(MainActivity.this, "Nunca Sofri!");
        flingContainer.getTopCardListener().selectLeft();
    }

    public void onRightButtonClicked(View view) {
        makeToast(MainActivity.this, "Já Sofri!");
        flingContainer.getTopCardListener().selectRight();
    }
}