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
        MyDB.execSQL("insert into Sastojci VALUES(7,'brašno','V')");
        MyDB.execSQL("insert into Sastojci VALUES(8,'lješnjaci','V')");
        MyDB.execSQL("insert into Sastojci VALUES(9,'banana','V')");
        MyDB.execSQL("insert into Sastojci VALUES(10,'kokos','V')");
        MyDB.execSQL("insert into Sastojci VALUES(11,'šećer','S')");
        MyDB.execSQL("insert into Sastojci VALUES(12,'sol','S')");
        MyDB.execSQL("insert into Sastojci VALUES(13,'prašak za pecivo','S')");
        MyDB.execSQL("insert into Sastojci VALUES(14,'vanilin šećer','S')");
        MyDB.execSQL("insert into Sastojci VALUES(15,'soda bikarbona','S')");
        MyDB.execSQL("insert into Sastojci VALUES(16,'želatina u prahu','S')");
        MyDB.execSQL("insert into Sastojci VALUES(17,'gustin','S')");
        MyDB.execSQL("insert into Sastojci VALUES(18,'šećer u prahu','S')");
        MyDB.execSQL("insert into Sastojci VALUES(19,'mineralna voda','P')");
        MyDB.execSQL("insert into Sastojci VALUES(20,'voda','P')");
        MyDB.execSQL("insert into Sastojci VALUES(21,'suncokretovo ulje','P')");
        MyDB.execSQL("insert into Sastojci VALUES(22,'rum','P')");
        MyDB.execSQL("insert into Sastojci VALUES(23,'čokolada za kuhanje','O')");
        MyDB.execSQL("insert into Sastojci VALUES(24,'kakao','O')");
        MyDB.execSQL("insert into Sastojci VALUES(25,'mliječna čokolada','O')");
        MyDB.execSQL("insert into Sastojci VALUES(26,'maslac od kikirikija','O')");
        MyDB.execSQL("insert into Sastojci VALUES(27,'ekstrakt vanilije','O')");


        //recept
        MyDB.execSQL("insert into Recept VALUES(1,'Palačinke','Priprema palačinki:\n" +
                "1. Pjenasto umutite cijela jaja, izmiješajte dok ne dobijete gustu homogenu smjesu, ulijte ulje pa mlijeko i izmiješajte.\n" +
                "\n" +
                "2. Potom uz neprestano miješanje pjenjačom sipajte brašno dok ne potrošite zadanu mjericu, dodajte prstohvat soli i malo ruma tek toliko da smjesa dobije aromu, a još važnije da spriječite upijanje ulja.\n" +
                "\n" +
                "3. Ako vam se smjesa čini gusta, razrijedite je mineralnom vodom.')");

        MyDB.execSQL("insert into Recept VALUES(2,'Palačinke od 2 sastojka','priprema:\n" +
                "Sve što trebate napraviti je umijesiti jednu bananu i dva jaja, sve dok ne dobijete tekuću smjesu. Zatim ih ispečete kao i normalne palačinke, a od ove smjese dobit ćete pet do sedam palačinki. Možete dodati malo praška za pečenje, ako želite da vam budu prozračnije, a za brže palačinke, možete ih umijesiti mikserom.\n" +
                "\n" +
                "Smjesa je malo više lomljiva, nego od običnih palačinki, pa nemojte prejako upaliti vatru te čekajte dok se ne pojave mjehurići kako biste ih preokrenuli. \n" +
                "\n" +
                "Naravno, završene palačinke imaju malo drugačiji okus nego obične palačinke jer su zdravije, ali su i dalje jednako ukusne, pogotovo kada dodate razne dodatke, poput karamele, čokolade i slično.\n')");

        MyDB.execSQL("insert into Recept VALUES(3,'Čudo od čokolade','priprema:\n" +
                "biskvit:\n" +
                "Žutanjke i šećer umutiti, dodati istopljeni margarin i čokoladu, brašno \n" +
                "pomiješano sa praškom za pecivo i na kraju snijeg od bijelanjaka \n" +
                "(bijelanjke umiješati polagano, ne mikserom). Peći (u tepsiji cca 20x35cm)  \n" +
                "na 180°C oko 20 min… ovisi od pećnice… provjeriti čačkalicom kad je pečeno.\n" +
                "\n" +
                "krema:Slatko vrhnje, čokoladu i šećer zagrijavati\n" +
                " na laganoj vatri (miješajući polagano) dok ne provri.\n" +
                "\n" +
                "Pečeni biskvit izbockati vilicom na nekoliko mijesta i dok je još \n" +
                "topao preliti ga sa toplom kremom. Krema je dosta rijetka ali je ne treba\n" +
                " dodatno miksati ili bilo što dodavati jer će se nakon nekoliko sati u hladnjaku \n" +
                "stisnuti. Kolač ohladiti prvo na sobnoj temp. a onda staviti u hladnjak da se dobro\n" +
                " ohladi i stegne krema…')");

        MyDB.execSQL("insert into Recept VALUES(4,'Kolač s kokosom i sirom od brašna','Odvojiti žumanjke od bjelanjaka. Od bjelanjaka umiksati čvrsti snijeg.\n" +
                "Žumanjke miksati sa šećerom i vanilin šećerom, dodati otopljeni maslac i sirni namaz, te na kraju kokos. U sve to dodati i ručno umiješati čvrsti snijeg od bjelanjaka.\n" +
                "Biskvitnu smjesu rasporediti u lim preko papira za pečenja i poravnati. Lim neka ne bude veći od 30×20 cm jer će kolač nakon pečenja biti jako tanak.\n" +
                "Peći u pećnici na 175*C 20-25 minuta. Kolač je gotov kada dobije lijepu zlaćanu boju. Izvaditi, rezati na ploške i poslužiti. Odličan je topao ili hladan. Dobar tek!')");

        MyDB.execSQL("insert into Recept VALUES(5,'Krafne bez kvasca','Miksati u posudi jaje sa šećerom pa kada posvjetli dodati ulje i još malo promiksati. Tada dodati i jogurt pa opet sve sjediniti. Na kraju dodati naizmjence brašno, prašak za pecivo i sodu bikarbonu.\n" +
                "Tijesto prebaciti na radnu površinu, dobro pobrašniti pa rukom lagano premijesiti kako bi se dobilo mekano, ali kompaktno i glatko tijesto. Ako vam je premekano slobodono dodajte malo brašna.\n" +
                "Tijesto odmah razvaljati valjkom na debljinu od 1 cm. Izrezivati krafne, a u sredini napraviti rupicu nekim manjim okurglim predmetom.\n" +
                "Formirane krafne odlagati na pobrašnjen pladanj, a ostatak tijesta premijesiti i izrezati još krafni.\n" +
                "U dubljoj tavi zagrijati ulje. Pržiti krafne s obje strane dok lijepo ne porumene. Budite oprezni sa uljem – ono ne smije biti prevruće kako krafne ne bi prebrzo dobile boju izvana, a iznutra ostale sirove. Također ulje ne smije biti niti premalo zagrijano jer će tada krafne upiti puno ulja.\n" +
                "Pečene krafne vaditi šupljom žlicom i odlagati na papirni ubrus. Još dok su tople uvaljati ih u šećer i poslužiti.')");

        MyDB.execSQL("insert into Recept VALUES(6,'Vruća čokolada','Pomiješati mlijeko i slatko vrhnje pa polovicu te tekućine staviti u lončić i staviti na tihu vatricu da se zagrije. Primiješati i kakao i šećer. Ostatak pomiješajte sa gustinom.\n" +
                "Kada tekućina u lončiću zavrije, ukuhati razmućeni gustin. Kuhati uz miješanje par minuta dok se ne dobije glatka masa. Tada vatru pospuno smanjiti i ubaciti natrganu čokoladu. Miješati tako dugo dok se sva čokolada ne otopi i dok ne postane potpuno sjajna.\n" +
                "Vruću čokoladu odmah izliti u pripremljene šalice, na vrh svake staviti po žlicu slatkog vrhnja, posipati kakaom i  uživati.')");

        MyDB.execSQL("insert into Recept VALUES(7,'Kolač od lješnjaka','Lješnjake prije svega rasprostrite na veliki lim preko papira za pečenje i zapecite ih u pećnici na visokoj temperaturi na funkciji grila kakvih 5 minuta. Lješnjaci će nakon ovog postati predivnog okusa i smeđa ljuskica će sama skliznuti sa njih. Pazite da vam ne izgore! Očistite ih od tih ljuskica, prohladite i sameljite.\n" +
                "Za biskvit razdvojiti bjalanjke i žumanjke. Miksati žumanjke sa šećerom i vanilin šećerom 1-2 min. Tada dodavati po malo brašno sa praškom za pecivo, mlijeko i lješnjake. Na kraju u sve umiješati posebno istučeni čvrsti snijeg od bjelanjaka. Biskvit izručiti u lim dimenzije 36×20 cm preko papira za pečenje, poravnati površinu i peći u pećnici na 180*C 25 min. \n" +
                "Pečeni biskvit prohladiti par minuta, pa ga iskrenuti iz lima i maknuti sa njega papir za pečenje. Biskvit tada prerezati tankim oštrim nožem na dva dijela kako biste dobili dvije kore. Onaj donji dio biskvita vratite u lim u kojem se biskvit pekao jer u njemu ćete nastaviti slagati kolač do kraja.\n" +
                "Gornji dio biskvita namrviti rukama ili nasjeći na male kockice i staviti na stranu.\n" +
                "Za preljev treba zakuhati 500 ml mlijeka u koje treba dodati čokoladu natrganu na kockice, šećer i maslac. Miješati tako dugo dok se sva čokolada i maslac ne otopi. Tada dodati mljevene lješnjake.\n" +
                "Kuhanim vrućim preljevom preliti kockice biskvita koje ste ranije stavili na stranu. Dobro sve promiješati. Ovako ste dobili gusti ‘kremasti’ gornji dio kolača.\n" +
                "Donji dio biskvita prelijte ravnomjerno sa nekoliko žlica toplog mlijeka ili kave kako bi kolač bio još sočniji! Preko tog dijela biskvita nanesite čokoladni dio i sve dobro poravnajte. Kolač odmah prelijte čokoladnom glazurom koju napravite tako da otopite zajedno maslac, čokoladu i ulje.\n" +
                "Kolač možete poslužiti i rezati odmah, a možete i sačekati da se ohladi. Jednako je ukusan! Dobar tek!')");

        MyDB.execSQL("insert into Recept VALUES(8,'Brzi kolač od 3 sastojka','Umutiti mikserom 4 jajeta, dodati 2 kašike brašna.\n" +
                "\n" +
                "Istopiti čokoladu i dodati jajima.\n" +
                "\n" +
                "Sve dobro sjediniti  i peći na 180°C oko 15 – 20 minuta')");

        MyDB.execSQL("insert into Recept VALUES(9,'Kolač od maslaca s kikirikijem','1.Otopite čokoladu na pari ili u mikrovalnoj pećnici.\n" +
                "\n" +
                "2. Šećer u prahu dobro umiješajte u maslac od kikirikija.\n" +
                "3. U metalni kalup za muffine stavite jednu žlicu rastopljene čokolade te je razmažite po površini. Potom dodajte jednu žlicu mješavine maslaca od kikirikija i šećera. Premažite sve s još jednom žlicom rastopljene čokolade.\n" +
                "\n" +
                "4. Ponavljajte postupak dok ne potrošite sve sastojke.\n" +
                "\n" +
                "5. Stavite hladiti u hladnjak na oko sat vremena, odnosno dok se ne stvrdne čokolada.\n" +
                "\n" +
                "6. Izvadite ovu čokoladnu fantaziju iz kalupa i navalite. Dobar tek!')");

        MyDB.execSQL("insert into Recept VALUES(10,'Šlag','1. Želatinu otopite u vodi. Ako ste je kuhali, želatinu dobro rastopite miješajući je pjenjačom. Potom je pustite neka se ohladi. \n" +
                "\n" +
                "2. U zdjelu stavite mlijeko i dodajte mu ohlađenu želatinu i razradite pjenjačom. \n" +
                "\n" +
                "3. Dodajte im šećer u prahu, ekstrakt vanilije i liker po želji. Miksajte pjenjačom, ostavite desetak minuta, a zatim mikserom tucite smjesu dok ne dobijete šlag. Poslužite ga uz slasticu po želji ili uz voćnu salatu. Dobar tek!')");

        MyDB.execSQL("insert into Recept VALUES(11,'Muffin u šalici','Pomješati brašno, šećer i kakao u šalici.\n" +
                "\n" +
                "Dodati jedno jaje i izmješati.\n" +
                "Dodati mlijeko i ulje i smjesu izjednačiti.\n" +
                "\n" +
                "Peči u mikrovalnoj na 100%, 3 minute.\n" +
                "\n" +
                "Posluživanje\n" +
                "Možete sa žlicom izvaditi kolačić na tanjur ili ga jesti iz šalice.\n" +
                "Nema neku estetsku vrijednost, al je jako ukusan i ravnomjerno pečen.')");

        MyDB.execSQL("insert into Recept VALUES(12,'Milkshake od banane','1.Izsjeckati omeksane banane na komadice.\n" +
                "2.U mikser staviti banane, mlijeko, vanilin ekstrat, i sve to miksati oko 2 min. (ne smiju ostati komadici banane, znaci sve mora da bude kremasto).\n" +
                "3.Ako volite da vam je milkshake jos gusci mozete da dodate 2-3 zlice slag krema gotovog ili tucenog slatkog vrhnja.\n" +
                "4.Milkshake sasutu u case, stavite slamcicu i posluzite.')");

        //Kolicina
        MyDB.execSQL("insert into Kolicina VALUES(1,1,'3')");
        MyDB.execSQL("insert into Kolicina VALUES(1,11,'2 velike žlice')");
        MyDB.execSQL("insert into Kolicina VALUES(1,7,'250 g (pola glatkog pola oštrog)')");
        MyDB.execSQL("insert into Kolicina VALUES(1,2,'350 ml')");
        MyDB.execSQL("insert into Kolicina VALUES(1,19,'1 dl')");
        MyDB.execSQL("insert into Kolicina VALUES(1,12,'malo')");
        MyDB.execSQL("insert into Kolicina VALUES(1,21,'2 žličice')");
        MyDB.execSQL("insert into Kolicina VALUES(1,22,'pola žličice')");

        MyDB.execSQL("insert into Kolicina VALUES(2,1,'2')");
        MyDB.execSQL("insert into Kolicina VALUES(2,9,'1')");

        MyDB.execSQL("insert into Kolicina VALUES(3,1,'4')");
        MyDB.execSQL("insert into Kolicina VALUES(3,11,'10 dkg + 1 žlica')");
        MyDB.execSQL("insert into Kolicina VALUES(3,3,'20 dkg')");
        MyDB.execSQL("insert into Kolicina VALUES(3,23,'10 dkg + 20 dkg')");
        MyDB.execSQL("insert into Kolicina VALUES(3,7,'4 žlice')");
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
        MyDB.execSQL("insert into Kolicina VALUES(5,15,'1,5 žličica')");
        MyDB.execSQL("insert into Kolicina VALUES(5,13,'1,5 žličica')");
        MyDB.execSQL("insert into Kolicina VALUES(5,21,'200 ml + 500 ml')");
        MyDB.execSQL("insert into Kolicina VALUES(5,18,'100 g')");

        MyDB.execSQL("insert into Kolicina VALUES(6,2,'300 ml')");
        MyDB.execSQL("insert into Kolicina VALUES(6,4,'200 ml')");
        MyDB.execSQL("insert into Kolicina VALUES(6,23,'200 g')");
        MyDB.execSQL("insert into Kolicina VALUES(6,11,'2 žlice')");
        MyDB.execSQL("insert into Kolicina VALUES(6,24,'1 žlica')");
        MyDB.execSQL("insert into Kolicina VALUES(6,17,'1 žlica')");

        MyDB.execSQL("insert into Kolicina VALUES(7,1,'6')");
        MyDB.execSQL("insert into Kolicina VALUES(7,11,'12 žlica + 5 žlica')");
        MyDB.execSQL("insert into Kolicina VALUES(7,7,'10 žlica')");
        MyDB.execSQL("insert into Kolicina VALUES(7,13,'1')");
        MyDB.execSQL("insert into Kolicina VALUES(7,14,'1')");
        MyDB.execSQL("insert into Kolicina VALUES(7,2,'14 žlica + 500 ml')");
        MyDB.execSQL("insert into Kolicina VALUES(7,8,'8 žlica + 100 g mljevenih')");
        MyDB.execSQL("insert into Kolicina VALUES(7,23,'150 g + 100 g')");
        MyDB.execSQL("insert into Kolicina VALUES(7,28,'150 g + 50 g')");
        MyDB.execSQL("insert into Kolicina VALUES(7,21,'5 žlica')");

        MyDB.execSQL("insert into Kolicina VALUES(8,7,'2 žlice')");
        MyDB.execSQL("insert into Kolicina VALUES(8,25,'300 g')");
        MyDB.execSQL("insert into Kolicina VALUES(8,1,'4')");

        MyDB.execSQL("insert into Kolicina VALUES(9,25,'170 g')");
        MyDB.execSQL("insert into Kolicina VALUES(9,26,'120 g')");
        MyDB.execSQL("insert into Kolicina VALUES(9,18,'3 žlice')");

        MyDB.execSQL("insert into Kolicina VALUES(10,20,'1/4 šalica')");
        MyDB.execSQL("insert into Kolicina VALUES(10,16,'10 grama')");
        MyDB.execSQL("insert into Kolicina VALUES(10,2,'1 šalica')");
        MyDB.execSQL("insert into Kolicina VALUES(10,27,'1/2 žlice')");
        MyDB.execSQL("insert into Kolicina VALUES(10,18,'1/4 šalice')");

        MyDB.execSQL("insert into Kolicina VALUES(11,7,'4 žlice')");
        MyDB.execSQL("insert into Kolicina VALUES(11,11,'4 žlice')");
        MyDB.execSQL("insert into Kolicina VALUES(11,24,'2 žlice')");
        MyDB.execSQL("insert into Kolicina VALUES(11,1,'1')");
        MyDB.execSQL("insert into Kolicina VALUES(11,21,'3 žlice')");
        MyDB.execSQL("insert into Kolicina VALUES(11,2,'3 žlice')");

        MyDB.execSQL("insert into Kolicina VALUES(12,2,'2 dl')");
        MyDB.execSQL("insert into Kolicina VALUES(12,9,'2')");
        MyDB.execSQL("insert into Kolicina VALUES(12,27,'1/2 žličice')");



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
