package giovanni.domesticsos;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    public static final String TOTAL_SCORE = "giovanni.domesticSOS.TOTAL_SCORE";


    private ArrayList<InfoCard> infoCards;
    private InfoCardArrayAdapter arrayAdapter;
    private int i;
    private int count;
    private int totalDangerScore;
    private SwipeFlingAdapterView flingContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoCards = new ArrayList<InfoCard>();
        InfoCard c = new InfoCard("Violência Psicológica", "- Ameaças\n" +
                "- Perseguição\n" +
                "- Constrangimento\n" +
                "- Humilhação\n" +
                "- Manipulação\n" +
                "- Isolamento (proibir de sair de casa)\n" +
                "- Vigilância constante\n" +
                "- Insultos\n" +
                "- Chantagem\n" +
                "- Exploração\n" +
                "- Limitação do direito de ir e vir\n" +
                "- Ridicularização\n" +
                "- Tirar a liberdade de crença", "auhsdhasd", 20, "#8b8378");

        InfoCard d = new InfoCard("Violência Física", "\n" +
                "- Tapas, socos e espancamento\n" +
                "- Atirar objetos, sacudir e apertar os braços\n" +
                "- Estrangulamento ou sufocamento\n" +
                "- Lesões com objetos cortantes ou perfurantes\n" +
                "- Ferimentos causados por queimaduras ou armas de fogo\n" +
                "- Tortura", "auhduas", 30, "#886262");


        InfoCard a = new InfoCard("Violência Moral", "-Rebaixar a mulher por meio de xingamentos\n" +
                "- Tentar manchar a reputação da mulher\n" +
                "- Emitir juízos morais sobre a conduta\n" +
                "- Fazer críticas mentirosas\n" +
                "- Expor a vida íntima\n" +
                "- Distorcer e omitir fatos para pôr em dúvida a memória e sanidade da mulher\n" +
                "- Afirmar falsamente que a mulher praticou crime que ela não cometeu", "uhasdha", 5, "#85414c");

        InfoCard b = new InfoCard("Violência Patrimonial", "- Furto, extorsão ou dano\n" +
                "- Controlar o dinheiro\n" +
                "- Deixar de pagar pensão alimentícia\n" +
                "- Destruição de documentos pessoais\n" +
                "- Estelionato\n" +
                "- Privar de bens, valores ou recursos econômicos\n" +
                "- Causar danos de propósito a objetos da mulher ou dos quais ela goste", "auhsd", 15, "#832136");

        InfoCard e = new InfoCard("Violência Sexual", "- Estupro (inclusive dentro do casamento)\n" +
                "- Obrigar a mulher a fazer atos sexuais que causam desconforto ou repulsa (fetiches)\n" +
                "- Impedir o uso de anticoncepcionais ou forçar a mulher a abortar\n" +
                "- Forçar matrimônio, gravidez ou prostituição\n" +
                "- Limitar ou anular o exercício dos direitos sexuais e reprodutivos da mulher\n" +
                "- Exploração sexual", "auhsdusa", 40, "#832136");
        infoCards.add(a);
        infoCards.add(b);
        infoCards.add(c);
        infoCards.add(d);
        infoCards.add(e);

        count = 0;

        arrayAdapter = new InfoCardArrayAdapter(this, R.layout.item, infoCards);

        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);
        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                //this is called before the others
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                Log.d("LIST", "Nao sofri");
                Log.d("LIST", "removed object!");
                infoCards.remove(0);
                arrayAdapter.notifyDataSetChanged();

                if(infoCards.isEmpty()){
                    //makeToast(MainActivity.this, "Acabou!");
                    Log.d("LIST", "card list is empty");

                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra(TOTAL_SCORE, String.valueOf(totalDangerScore));
                    startActivity(intent);
                }
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                Log.d("LIST", "Ja sofri");
                InfoCard obj = (InfoCard) dataObject;
                totalDangerScore += obj.getDangerScore();

                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                infoCards.remove(0);
                arrayAdapter.notifyDataSetChanged();

                if(infoCards.isEmpty()){
                    //makeToast(MainActivity.this, "Acabou!");
                    Log.d("LIST", "card list is empty");

                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra(TOTAL_SCORE, String.valueOf(totalDangerScore));
                    startActivity(intent);
                }
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                //infoCards.add("XML ".concat(String.valueOf(i)));
                //arrayAdapter.notifyDataSetChanged();
                //Log.d("LIST", "notified");
                //i++;
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