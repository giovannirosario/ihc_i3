package giovanni.domesticsos;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MoreInfoActivity extends AppCompatActivity {

    private ArrayList<InfoCard> infoCards;
    private MenuCardArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        infoCards = new ArrayList<InfoCard>();
        InfoCard c = new InfoCard("Violência Psicológica", "Qualquer conduta que cause à mulher dano emocional e diminuição da autoestima ou que lhe prejudique e perturbe o pleno desenvolvimento ou que vise degradar ou controlar suas ações, comportamentos, crenças e decisões.\n" +
                "\n" +
                "É uma das violências mais comuns e mais difíceis de serem detectadas pelas vítimas, porém o dano psicológico costuma ser devastador. Muitas mulheres não denunciam seus companheiros simplesmente porque não acreditam que estejam sofrendo algum tipo de violência.", "auhsdhasd", 20, "#8b8378");

        InfoCard d = new InfoCard("Violência Física", "Qualquer conduta que ofenda a integridade ou saúde corporal da mulher. São os casos mais relatados nas delegacias da mulher e na maioria da vezes os agressores são os companheiros ou os próprios familiares da vítima", "auhduas", 30, "#886262");


        InfoCard a = new InfoCard("Violência Moral", "É uma violência pouco comentada, porém é mais comum do que você imagina. Podemos dizer que é qualquer conduta que configure calúnia, difamação ou injúria. É quando o agressor dá uma opinião contra a reputação moral da mulher e faz críticas mentirosas. Esse tipo de violência também pode acontecer pela Internet", "uhasdha", 5, "#85414c");

        InfoCard b = new InfoCard("Violência Patrimonial", "Qualquer ação ou conduta que possa configurar retenção, subtração, destruição parcial ou total dos objetos da mulher. Esses bens podem ser instrumentos de trabalho, documentos pessoais, bens, valores e direitos ou recursos econômicos, incluindo os destinados a satisfazer as necessidades da mulher", "auhsd", 15, "#832136");

        InfoCard e = new InfoCard("Violência Sexual", "Qualquer conduta que obrigue a mulher a presenciar, a manter ou a participar de relação sexual não desejada, mediante intimidação, ameaça, coação ou uso da força. Apesar de ser normalmente associado ao estupro, o termo violência sexual é muito mais amplo e abrange uma série de situações que as mulheres sofrem atualmente, seja com desconhecidos, parentes, namorados ou companheiros.", "auhsdusa", 40, "#832136");
        infoCards.add(a);
        infoCards.add(b);
        infoCards.add(c);
        infoCards.add(d);
        infoCards.add(e);

        arrayAdapter = new MenuCardArrayAdapter(this, R.layout.menu_item, infoCards);

        final ListView list_itens = findViewById(R.id.list_itens);
        list_itens.setAdapter(arrayAdapter);

        list_itens.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3)
            {
                Intent intent = new Intent(getApplicationContext(), CardActivity.class);
                intent.putExtra("title", infoCards.get(position).getTitle());
                intent.putExtra("text", infoCards.get(position).getInfoText());
                intent.putExtra("color", infoCards.get(position).getBgColor());
                startActivity(intent);
            }
        });
    }
}
