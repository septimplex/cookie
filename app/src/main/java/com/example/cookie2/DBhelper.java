package com.example.cookie2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBhelper extends SQLiteOpenHelper {

    public static final String DBNAME = "CookieDB.db";

    private static final String Korisnici = "korisnici";
    private static final String Recept = "recept";
    private static final String Sastojci = "sastojci";
    private static final String Kolicina = "kolicina";


    public DBhelper(Context context) {
        super(context, "CookieDB.db", null, 1);
        //SQLiteDatabase MyDB = this.getWritableDatabase(); // provjera za sada

    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        //MyDB.execSQL("create Table korisnici(username TEXT primary key, password TEXT)");
        //MyDB.execSQL("Create Table recept(id_recept INTEGER primary key, naslov_recepta TEXT, opis_recepta TEXT)");
        //MyDB.execSQL("Create Table sastojci(id_sastojak INTEGER primary key, naziv_sastojak TEXT, vrsta_sastojak TEXT)");
        //MyDB.execSQL("Create Table kolicina(id_recept INTEGER primary key,id_sastojak INTEGER primary key, broj TEXT)");
    String korisnici = "CREATE TABLE " + Korisnici + "(username TEXT primary key, password TEXT)";
    String recept = "CREATE TABLE " + Recept + "(id_recept INTEGER primary key, naslov_recepta TEXT, opis_recepta TEXT)";
    String sastojci = "CREATE TABLE " + Sastojci + "(id_sastojak INTEGER primary key, naziv_sastojak TEXT, vrsta_sastojak TEXT)";
    String kolicina = "CREATE TABLE " + Kolicina + "(id_recept INTEGER,id_sastojak INTEGER, broj TEXT, primary key(id_recept,id_sastojak))";



    MyDB.execSQL(korisnici);
    MyDB.execSQL(recept);
    MyDB.execSQL(sastojci);
    MyDB.execSQL(kolicina);


        //sastojci
        MyDB.execSQL("insert into Sastojci VALUES(1,'jaje','MP')");
        MyDB.execSQL("insert into Sastojci VALUES(2,'mlijeko','MP')");
        MyDB.execSQL("insert into Sastojci VALUES(3,'margarin','MP')");
        MyDB.execSQL("insert into Sastojci VALUES(4,'slatko vrhnje','MP')");
        MyDB.execSQL("insert into Sastojci VALUES(5,'sirni namaz','MP')");
        MyDB.execSQL("insert into Sastojci VALUES(6,'jogurt','MP')");
        MyDB.execSQL("insert into Sastojci VALUES(28,'maslac','MP')");
        MyDB.execSQL("insert into Sastojci VALUES(7,'bra??no','V')");
        MyDB.execSQL("insert into Sastojci VALUES(8,'lje??njaci','V')");
        MyDB.execSQL("insert into Sastojci VALUES(9,'banana','V')");
        MyDB.execSQL("insert into Sastojci VALUES(10,'kokos','V')");
        MyDB.execSQL("insert into Sastojci VALUES(11,'??e??er','S')");
        MyDB.execSQL("insert into Sastojci VALUES(12,'sol','S')");
        MyDB.execSQL("insert into Sastojci VALUES(13,'pra??ak za pecivo','S')");
        MyDB.execSQL("insert into Sastojci VALUES(14,'vanilin ??e??er','S')");
        MyDB.execSQL("insert into Sastojci VALUES(15,'soda bikarbona','S')");
        MyDB.execSQL("insert into Sastojci VALUES(16,'??elatina u prahu','S')");
        MyDB.execSQL("insert into Sastojci VALUES(17,'gustin','S')");
        MyDB.execSQL("insert into Sastojci VALUES(18,'??e??er u prahu','S')");
        MyDB.execSQL("insert into Sastojci VALUES(19,'mineralna voda','P')");
        MyDB.execSQL("insert into Sastojci VALUES(20,'voda','P')");
        MyDB.execSQL("insert into Sastojci VALUES(21,'suncokretovo ulje','P')");
        MyDB.execSQL("insert into Sastojci VALUES(22,'rum','P')");
        MyDB.execSQL("insert into Sastojci VALUES(23,'??okolada za kuhanje','O')");
        MyDB.execSQL("insert into Sastojci VALUES(24,'kakao','O')");
        MyDB.execSQL("insert into Sastojci VALUES(25,'mlije??na ??okolada','O')");
        MyDB.execSQL("insert into Sastojci VALUES(26,'maslac od kikirikija','O')");
        MyDB.execSQL("insert into Sastojci VALUES(27,'ekstrakt vanilije','O')");


        //recept
        MyDB.execSQL("insert into Recept VALUES(1,'Pala??inke','Priprema pala??inki:\n" +
                "1. Pjenasto umutite cijela jaja, izmije??ajte dok ne dobijete gustu homogenu smjesu, ulijte ulje pa mlijeko i izmije??ajte.\n" +
                "\n" +
                "2. Potom uz neprestano mije??anje pjenja??om sipajte bra??no dok ne potro??ite zadanu mjericu, dodajte prstohvat soli i malo ruma tek toliko da smjesa dobije aromu, a jo?? va??nije da sprije??ite upijanje ulja.\n" +
                "\n" +
                "3. Ako vam se smjesa ??ini gusta, razrijedite je mineralnom vodom.')");

        MyDB.execSQL("insert into Recept VALUES(2,'Pala??inke od 2 sastojka','priprema:\n" +
                "Sve ??to trebate napraviti je umijesiti jednu bananu i dva jaja, sve dok ne dobijete teku??u smjesu. Zatim ih ispe??ete kao i normalne pala??inke, a od ove smjese dobit ??ete pet do sedam pala??inki. Mo??ete dodati malo pra??ka za pe??enje, ako ??elite da vam budu prozra??nije, a za br??e pala??inke, mo??ete ih umijesiti mikserom.\n" +
                "\n" +
                "Smjesa je malo vi??e lomljiva, nego od obi??nih pala??inki, pa nemojte prejako upaliti vatru te ??ekajte dok se ne pojave mjehuri??i kako biste ih preokrenuli. \n" +
                "\n" +
                "Naravno, zavr??ene pala??inke imaju malo druga??iji okus nego obi??ne pala??inke jer su zdravije, ali su i dalje jednako ukusne, pogotovo kada dodate razne dodatke, poput karamele, ??okolade i sli??no.\n')");

        MyDB.execSQL("insert into Recept VALUES(3,'??udo od ??okolade','priprema:\n" +
                "biskvit:\n" +
                "??utanjke i ??e??er umutiti, dodati istopljeni margarin i ??okoladu, bra??no \n" +
                "pomije??ano sa pra??kom za pecivo i na kraju snijeg od bijelanjaka \n" +
                "(bijelanjke umije??ati polagano, ne mikserom). Pe??i (u tepsiji cca 20x35cm)  \n" +
                "na 180??C oko 20 min??? ovisi od pe??nice??? provjeriti ??a??kalicom kad je pe??eno.\n" +
                "\n" +
                "krema:Slatko vrhnje, ??okoladu i ??e??er zagrijavati\n" +
                " na laganoj vatri (mije??aju??i polagano) dok ne provri.\n" +
                "\n" +
                "Pe??eni biskvit izbockati vilicom na nekoliko mijesta i dok je jo?? \n" +
                "topao preliti ga sa toplom kremom. Krema je dosta rijetka ali je ne treba\n" +
                " dodatno miksati ili bilo ??to dodavati jer ??e se nakon nekoliko sati u hladnjaku \n" +
                "stisnuti. Kola?? ohladiti prvo na sobnoj temp. a onda staviti u hladnjak da se dobro\n" +
                " ohladi i stegne krema???')");

        MyDB.execSQL("insert into Recept VALUES(4,'Kola?? s kokosom i sirom od bra??na','Odvojiti ??umanjke od bjelanjaka. Od bjelanjaka umiksati ??vrsti snijeg.\n" +
                "??umanjke miksati sa ??e??erom i vanilin ??e??erom, dodati otopljeni maslac i sirni namaz, te na kraju kokos. U sve to dodati i ru??no umije??ati ??vrsti snijeg od bjelanjaka.\n" +
                "Biskvitnu smjesu rasporediti u lim preko papira za pe??enja i poravnati. Lim neka ne bude ve??i od 30??20 cm jer ??e kola?? nakon pe??enja biti jako tanak.\n" +
                "Pe??i u pe??nici na 175*C 20-25 minuta. Kola?? je gotov kada dobije lijepu zla??anu boju. Izvaditi, rezati na plo??ke i poslu??iti. Odli??an je topao ili hladan. Dobar tek!')");

        MyDB.execSQL("insert into Recept VALUES(5,'Krafne bez kvasca','Miksati u posudi jaje sa ??e??erom pa kada posvjetli dodati ulje i jo?? malo promiksati. Tada dodati i jogurt pa opet sve sjediniti. Na kraju dodati naizmjence bra??no, pra??ak za pecivo i sodu bikarbonu.\n" +
                "Tijesto prebaciti na radnu povr??inu, dobro pobra??niti pa rukom lagano premijesiti kako bi se dobilo mekano, ali kompaktno i glatko tijesto. Ako vam je premekano slobodono dodajte malo bra??na.\n" +
                "Tijesto odmah razvaljati valjkom na debljinu od 1 cm. Izrezivati krafne, a u sredini napraviti rupicu nekim manjim okurglim predmetom.\n" +
                "Formirane krafne odlagati na pobra??njen pladanj, a ostatak tijesta premijesiti i izrezati jo?? krafni.\n" +
                "U dubljoj tavi zagrijati ulje. Pr??iti krafne s obje strane dok lijepo ne porumene. Budite oprezni sa uljem ??? ono ne smije biti prevru??e kako krafne ne bi prebrzo dobile boju izvana, a iznutra ostale sirove. Tako??er ulje ne smije biti niti premalo zagrijano jer ??e tada krafne upiti puno ulja.\n" +
                "Pe??ene krafne vaditi ??upljom ??licom i odlagati na papirni ubrus. Jo?? dok su tople uvaljati ih u ??e??er i poslu??iti.')");

        MyDB.execSQL("insert into Recept VALUES(6,'Vru??a ??okolada','Pomije??ati mlijeko i slatko vrhnje pa polovicu te teku??ine staviti u lon??i?? i staviti na tihu vatricu da se zagrije. Primije??ati i kakao i ??e??er. Ostatak pomije??ajte sa gustinom.\n" +
                "Kada teku??ina u lon??i??u zavrije, ukuhati razmu??eni gustin. Kuhati uz mije??anje par minuta dok se ne dobije glatka masa. Tada vatru pospuno smanjiti i ubaciti natrganu ??okoladu. Mije??ati tako dugo dok se sva ??okolada ne otopi i dok ne postane potpuno sjajna.\n" +
                "Vru??u ??okoladu odmah izliti u pripremljene ??alice, na vrh svake staviti po ??licu slatkog vrhnja, posipati kakaom i  u??ivati.')");

        MyDB.execSQL("insert into Recept VALUES(7,'Kola?? od lje??njaka','Lje??njake prije svega rasprostrite na veliki lim preko papira za pe??enje i zapecite ih u pe??nici na visokoj temperaturi na funkciji grila kakvih 5 minuta. Lje??njaci ??e nakon ovog postati predivnog okusa i sme??a ljuskica ??e sama skliznuti sa njih. Pazite da vam ne izgore! O??istite ih od tih ljuskica, prohladite i sameljite.\n" +
                "Za biskvit razdvojiti bjalanjke i ??umanjke. Miksati ??umanjke sa ??e??erom i vanilin ??e??erom 1-2 min. Tada dodavati po malo bra??no sa pra??kom za pecivo, mlijeko i lje??njake. Na kraju u sve umije??ati posebno istu??eni ??vrsti snijeg od bjelanjaka. Biskvit izru??iti u lim dimenzije 36??20 cm preko papira za pe??enje, poravnati povr??inu i pe??i u pe??nici na 180*C 25 min. \n" +
                "Pe??eni biskvit prohladiti par minuta, pa ga iskrenuti iz lima i maknuti sa njega papir za pe??enje. Biskvit tada prerezati tankim o??trim no??em na dva dijela kako biste dobili dvije kore. Onaj donji dio biskvita vratite u lim u kojem se biskvit pekao jer u njemu ??ete nastaviti slagati kola?? do kraja.\n" +
                "Gornji dio biskvita namrviti rukama ili nasje??i na male kockice i staviti na stranu.\n" +
                "Za preljev treba zakuhati 500 ml mlijeka u koje treba dodati ??okoladu natrganu na kockice, ??e??er i maslac. Mije??ati tako dugo dok se sva ??okolada i maslac ne otopi. Tada dodati mljevene lje??njake.\n" +
                "Kuhanim vru??im preljevom preliti kockice biskvita koje ste ranije stavili na stranu. Dobro sve promije??ati. Ovako ste dobili gusti ???kremasti??? gornji dio kola??a.\n" +
                "Donji dio biskvita prelijte ravnomjerno sa nekoliko ??lica toplog mlijeka ili kave kako bi kola?? bio jo?? so??niji! Preko tog dijela biskvita nanesite ??okoladni dio i sve dobro poravnajte. Kola?? odmah prelijte ??okoladnom glazurom koju napravite tako da otopite zajedno maslac, ??okoladu i ulje.\n" +
                "Kola?? mo??ete poslu??iti i rezati odmah, a mo??ete i sa??ekati da se ohladi. Jednako je ukusan! Dobar tek!')");

        MyDB.execSQL("insert into Recept VALUES(8,'Brzi kola?? od 3 sastojka','Umutiti mikserom 4 jajeta, dodati 2 ka??ike bra??na.\n" +
                "\n" +
                "Istopiti ??okoladu i dodati jajima.\n" +
                "\n" +
                "Sve dobro sjediniti  i pe??i na 180??C oko 15 ??? 20 minuta')");

        MyDB.execSQL("insert into Recept VALUES(9,'Kola?? od maslaca s kikirikijem','1.Otopite ??okoladu na pari ili u mikrovalnoj pe??nici.\n" +
                "\n" +
                "2. ??e??er u prahu dobro umije??ajte u maslac od kikirikija.\n" +
                "3. U metalni kalup za muffine stavite jednu ??licu rastopljene ??okolade te je razma??ite po povr??ini. Potom dodajte jednu ??licu mje??avine maslaca od kikirikija i ??e??era. Prema??ite sve s jo?? jednom ??licom rastopljene ??okolade.\n" +
                "\n" +
                "4. Ponavljajte postupak dok ne potro??ite sve sastojke.\n" +
                "\n" +
                "5. Stavite hladiti u hladnjak na oko sat vremena, odnosno dok se ne stvrdne ??okolada.\n" +
                "\n" +
                "6. Izvadite ovu ??okoladnu fantaziju iz kalupa i navalite. Dobar tek!')");

        MyDB.execSQL("insert into Recept VALUES(10,'??lag','1. ??elatinu otopite u vodi. Ako ste je kuhali, ??elatinu dobro rastopite mije??aju??i je pjenja??om. Potom je pustite neka se ohladi. \n" +
                "\n" +
                "2. U zdjelu stavite mlijeko i dodajte mu ohla??enu ??elatinu i razradite pjenja??om. \n" +
                "\n" +
                "3. Dodajte im ??e??er u prahu, ekstrakt vanilije i liker po ??elji. Miksajte pjenja??om, ostavite desetak minuta, a zatim mikserom tucite smjesu dok ne dobijete ??lag. Poslu??ite ga uz slasticu po ??elji ili uz vo??nu salatu. Dobar tek!')");

        MyDB.execSQL("insert into Recept VALUES(11,'Muffin u ??alici','Pomje??ati bra??no, ??e??er i kakao u ??alici.\n" +
                "\n" +
                "Dodati jedno jaje i izmje??ati.\n" +
                "Dodati mlijeko i ulje i smjesu izjedna??iti.\n" +
                "\n" +
                "Pe??i u mikrovalnoj na 100%, 3 minute.\n" +
                "\n" +
                "Poslu??ivanje\n" +
                "Mo??ete sa ??licom izvaditi kola??i?? na tanjur ili ga jesti iz ??alice.\n" +
                "Nema neku estetsku vrijednost, al je jako ukusan i ravnomjerno pe??en.')");

        MyDB.execSQL("insert into Recept VALUES(12,'Milkshake od banane','1.Izsjeckati omeksane banane na komadice.\n" +
                "2.U mikser staviti banane, mlijeko, vanilin ekstrat, i sve to miksati oko 2 min. (ne smiju ostati komadici banane, znaci sve mora da bude kremasto).\n" +
                "3.Ako volite da vam je milkshake jos gusci mozete da dodate 2-3 zlice slag krema gotovog ili tucenog slatkog vrhnja.\n" +
                "4.Milkshake sasutu u case, stavite slamcicu i posluzite.')");

        //Kolicina
        MyDB.execSQL("insert into Kolicina VALUES(1,1,'3')");
        MyDB.execSQL("insert into Kolicina VALUES(1,11,'2 velike ??lice')");
        MyDB.execSQL("insert into Kolicina VALUES(1,7,'250 g (pola glatkog pola o??trog)')");
        MyDB.execSQL("insert into Kolicina VALUES(1,2,'350 ml')");
        MyDB.execSQL("insert into Kolicina VALUES(1,19,'1 dl')");
        MyDB.execSQL("insert into Kolicina VALUES(1,12,'malo')");
        MyDB.execSQL("insert into Kolicina VALUES(1,21,'2 ??li??ice')");
        MyDB.execSQL("insert into Kolicina VALUES(1,22,'pola ??li??ice')");

        MyDB.execSQL("insert into Kolicina VALUES(2,1,'2')");
        MyDB.execSQL("insert into Kolicina VALUES(2,9,'1')");

        MyDB.execSQL("insert into Kolicina VALUES(3,1,'4')");
        MyDB.execSQL("insert into Kolicina VALUES(3,11,'10 dkg + 1 ??lica')");
        MyDB.execSQL("insert into Kolicina VALUES(3,3,'20 dkg')");
        MyDB.execSQL("insert into Kolicina VALUES(3,23,'10 dkg + 20 dkg')");
        MyDB.execSQL("insert into Kolicina VALUES(3,7,'4 ??lice')");
        MyDB.execSQL("insert into Kolicina VALUES(3,13,'1')");
        MyDB.execSQL("insert into Kolicina VALUES(3,4,'0.5 l')");

        MyDB.execSQL("insert into Kolicina VALUES(4,1,'4')");
        MyDB.execSQL("insert into Kolicina VALUES(4,11,'120 g')");
        MyDB.execSQL("insert into Kolicina VALUES(4,28,'100 g')");
        MyDB.execSQL("insert into Kolicina VALUES(4,14,'1')");
        MyDB.execSQL("insert into Kolicina VALUES(4,5,'200 g')");
        MyDB.execSQL("insert into Kolicina VALUES(4,10,'130 g')");

        MyDB.execSQL("insert into Kolicina VALUES(5,7,'400 g')");
        MyDB.execSQL("insert into Kolicina VALUES(5,6,'250 ml')");
        MyDB.execSQL("insert into Kolicina VALUES(5,1,'1')");
        MyDB.execSQL("insert into Kolicina VALUES(5,11,'100 g')");
        MyDB.execSQL("insert into Kolicina VALUES(5,12,'prstohvat')");
        MyDB.execSQL("insert into Kolicina VALUES(5,15,'1,5 ??li??ica')");
        MyDB.execSQL("insert into Kolicina VALUES(5,13,'1,5 ??li??ica')");
        MyDB.execSQL("insert into Kolicina VALUES(5,21,'200 ml + 500 ml')");
        MyDB.execSQL("insert into Kolicina VALUES(5,18,'100 g')");

        MyDB.execSQL("insert into Kolicina VALUES(6,2,'300 ml')");
        MyDB.execSQL("insert into Kolicina VALUES(6,4,'200 ml')");
        MyDB.execSQL("insert into Kolicina VALUES(6,23,'200 g')");
        MyDB.execSQL("insert into Kolicina VALUES(6,11,'2 ??lice')");
        MyDB.execSQL("insert into Kolicina VALUES(6,24,'1 ??lica')");
        MyDB.execSQL("insert into Kolicina VALUES(6,17,'1 ??lica')");

        MyDB.execSQL("insert into Kolicina VALUES(7,1,'6')");
        MyDB.execSQL("insert into Kolicina VALUES(7,11,'12 ??lica + 5 ??lica')");
        MyDB.execSQL("insert into Kolicina VALUES(7,7,'10 ??lica')");
        MyDB.execSQL("insert into Kolicina VALUES(7,13,'1')");
        MyDB.execSQL("insert into Kolicina VALUES(7,14,'1')");
        MyDB.execSQL("insert into Kolicina VALUES(7,2,'14 ??lica + 500 ml')");
        MyDB.execSQL("insert into Kolicina VALUES(7,8,'8 ??lica + 100 g mljevenih')");
        MyDB.execSQL("insert into Kolicina VALUES(7,23,'150 g + 100 g')");
        MyDB.execSQL("insert into Kolicina VALUES(7,28,'150 g + 50 g')");
        MyDB.execSQL("insert into Kolicina VALUES(7,21,'5 ??lica')");

        MyDB.execSQL("insert into Kolicina VALUES(8,7,'2 ??lice')");
        MyDB.execSQL("insert into Kolicina VALUES(8,25,'300 g')");
        MyDB.execSQL("insert into Kolicina VALUES(8,1,'4')");

        MyDB.execSQL("insert into Kolicina VALUES(9,25,'170 g')");
        MyDB.execSQL("insert into Kolicina VALUES(9,26,'120 g')");
        MyDB.execSQL("insert into Kolicina VALUES(9,18,'3 ??lice')");

        MyDB.execSQL("insert into Kolicina VALUES(10,20,'1/4 ??alica')");
        MyDB.execSQL("insert into Kolicina VALUES(10,16,'10 grama')");
        MyDB.execSQL("insert into Kolicina VALUES(10,2,'1 ??alica')");
        MyDB.execSQL("insert into Kolicina VALUES(10,27,'1/2 ??lice')");
        MyDB.execSQL("insert into Kolicina VALUES(10,18,'1/4 ??alice')");

        MyDB.execSQL("insert into Kolicina VALUES(11,7,'4 ??lice')");
        MyDB.execSQL("insert into Kolicina VALUES(11,11,'4 ??lice')");
        MyDB.execSQL("insert into Kolicina VALUES(11,24,'2 ??lice')");
        MyDB.execSQL("insert into Kolicina VALUES(11,1,'1')");
        MyDB.execSQL("insert into Kolicina VALUES(11,21,'3 ??lice')");
        MyDB.execSQL("insert into Kolicina VALUES(11,2,'3 ??lice')");

        MyDB.execSQL("insert into Kolicina VALUES(12,2,'2 dl')");
        MyDB.execSQL("insert into Kolicina VALUES(12,9,'2')");
        MyDB.execSQL("insert into Kolicina VALUES(12,27,'1/2 ??li??ice')");



    }





    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        //MyDB.execSQL("drop Table if exists korisnici");
        //MyDB.execSQL("drop Table if exists recept");
        //MyDB.execSQL("drop Table if exists sastojci");
        //MyDB.execSQL("drop Table if exists kolicina");
        MyDB.execSQL("DROP TABLE IF EXISTS " +Korisnici);
        MyDB.execSQL("DROP TABLE IF EXISTS " +Recept);
        MyDB.execSQL("DROP TABLE IF EXISTS " +Sastojci);
        MyDB.execSQL("DROP TABLE IF EXISTS " +Kolicina);
        onCreate(MyDB);

    }

    public Cursor Recept(){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        String query = "SELECT * FROM Recept";
        Cursor res = MyDB.rawQuery(query, null);
        return res;
    }



    //broj recepata
    public int brojRecepata() {
        String broj = "SELECT  * FROM " + Recept;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(broj, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    //Dohvacanje svih id recept + ime sastojak
    public Cursor Sastojci(){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        String query = "SELECT k.id_recept,s.naziv_sastojak FROM Sastojci s JOIN Kolicina k on k.id_sastojak = s.id_sastojak";
        Cursor res = MyDB.rawQuery(query, null);
        return res;
    }

    //dobavi sve recepte
    public Cursor getAllData(){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        String query = "SELECT * FROM Recept ORDER BY naslov_recepta ASC";
        Cursor res = MyDB.rawQuery(query, null);
        return res;
    }



    //dobavljanje MP
    public Cursor dobaviMP(){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        String query = "SELECT naziv_sastojak FROM Sastojci WHERE vrsta_sastojak ='MP'";
        Cursor res = MyDB.rawQuery(query, null);
        return res;
    }
    //dobavljanje V
    public Cursor dobaviV(){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        String query = "SELECT naziv_sastojak FROM Sastojci WHERE vrsta_sastojak ='V'";
        Cursor res = MyDB.rawQuery(query, null);
        return res;
    }
    //dobavljanje S
    public Cursor dobaviS(){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        String query = "SELECT naziv_sastojak FROM Sastojci WHERE vrsta_sastojak ='S'";
        Cursor res = MyDB.rawQuery(query, null);
        return res;
    }

    //dobavljanje P
    public Cursor dobaviP(){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        String query = "SELECT naziv_sastojak FROM Sastojci WHERE vrsta_sastojak ='P'";
        Cursor res = MyDB.rawQuery(query, null);
        return res;
    }
    //dobavljanje O
    public Cursor dobaviO(){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        String query = "SELECT naziv_sastojak FROM Sastojci WHERE vrsta_sastojak ='O'";
        Cursor res = MyDB.rawQuery(query, null);
        return res;
    }





    public boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);

        long result = MyDB.insert("Korisnici",null,contentValues);
        if(result == -1) return false;
        else
            return true;
    }

    public boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from Korisnici where username = ?", new String[] {username});

        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from Korisnici where username = ? and password = ?", new String[] {username,password});

        if (cursor.getCount()> 0)
            return true;
        else
            return false;
    }
}
