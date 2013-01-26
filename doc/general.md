Üldised nõuded

Projekt on grupitöö, grupi liikmete arv on maksimaalselt 3
Arendamine peab toimuma 100% GitHub-is
Ühtegi faili, mida saab lähtetekstidest kompileerida, ei tohi GitHub-is olla.
Soovitatav on vältida ka Eclipse projektifailide (.project, .classpath, .settings) panemist GitHub-i
Iga nägu panustab GitHub-i enda nime alt, hilisemaid vabandusi stiilis, et me käisime Peetri juures õhtuti arendamas ja tegime tööd tema nime alt ei aktsepteerita
Kui õpilase nime alt pile ühtegi commit'i siis loetakse tema panus võrdseks nulliga
Projekt on grupitöö, hinne on individuaalne:
hinne = projekti üldine hinne (annab õppejõud) * tudengi panus projekti
tudengi panus projekti on kas 0 - olematu, 0.5 - väike või 1 - arvestatav
Projekti jaoks peab olema kirjeldatud ITK CI serveris automaatse kokkupanemise reegel (vaata CI seadistamise juhend) ja selle abil kokku kompileeritud rakendus peab töötama
Rakendus peab olema kaitstud kasutajanime ja parooliga, kohe peale esimest käivitamist peavad eksisteerima järgmised kasutajad (nimi:parool):
admin:admin - saab rakenduses kõike vaadata, muuta, lisada ja kustutada
valvur:valvur - saab vaid vaadata
ylem:ylem - saab vaadata ja muuta
Ühtegi Springi vaikimisi parooliga kasutajat (admin:admin, user:user vms) rakenduses olla ei tohi.
Projekti vastavust üldistele nõuetele kontrollitakse kursuse lõpus, projekti hindamise ajal.
Tehnilised nõuded

Projekt peab olema 100% automaatselt ehitatav Ant-i või Gradle abil
Lähteülesandes ette antud vaadete loogikat muuta ei tohi. Kujundus on loomulikult enda teha kuid vaade peab sisaldama kõiki nõutud elemente ja need peavad asuma lehel õigetes kohtades
Andmebaasiga suhtlemiseks peab kasutama JPA tehnoloogiat
Lahendus peab töötama rakendusserveril Tomcat 7.0.21 või uuem
Kasutama peab HSQLDB 1.8.x andmebaasi
Andmebaasi URL peab olema kujul: jdbc:hsqldb:file:${user.home}/i377/TeamXX/db;shutdown=true kus XX on meeskonna number.
Rakendus peab esimesel käivitamisel looma ise oma tööks vajalikud andmebaasi tabelid
Rakendus peab esimesel käivitamisel tekitama funktsionaalsuse demonstreerimiseks vajaliku komplekti näidisandmeid
Andmebaasi sisestatud andmed ei tohi rakenduse restartimisel ära kaduda
Mitte ükski osa rakendusest ei tohi kasutada Flash tehnoloogiat
Rakenduse taustsüsteem (domain)

Meil on üks riik, igal riigil on piirivalve – järelikult ka meil.

Meil on mitu väeosa.

Väeosadesse kuuluvad piirivalvurid. Igal piirivalvuril on roll väeossa kuulumisel (juhataja, juhataja asetäitja, politruk, pastor, mulla, realiige, vms.)

Piirivalvuritel on auastmed ja kontaktandmed (aadress, telefon, e-mail).

Piir on jagatud lõikudeks. Igat piirilõiku valvab üks väeosa, piirilõikudel võivad omakorda asuda piiripunktid.

Üks väeosa teenindab mitut piirilõiku ja/või piiripunkti. Peab olema näha, milliseid piiripunkte ja -lõike väosa teenindab.

Peab olema näha milline piirivalvur on millises piiripunktis ja milline on tema roll seal (ülem, ülema asetäitja, kokk, realiige, vms.)

On elumajad, mis on jagatud tubadeks ja kohtadeks toas. Peab olema teada, milline piirivalvur, millisel kohal elab.

Piiril käivad vahtkonnad. Iga piirivalvur kuulub mingisse vahtkonda. Peab olema näha millistes vahtkondades piirivalvur on. Vahtkonda kuulumisel on piirivalvuril roll (vahtkonna ülem, vahtkonna ülema asetäitja, realiige vms.)

Vahtkondadele koostatakse „piiril kõndimise“ graafik. Graafikujärgselt käiakse mingil piirilõigul.

Vahel juhtuvad piiril intsidendid. Peab saama märkida, millisel piirilõigul see toimus, millal ja kes avastas.

Piiririkkuja kohta peab olema teada tema kodakondsus ja isikukood.

Samas intsidendis võib osaleda mitu piiririkkujat. Ka piirivalvureid võib olla seotud intsidendiga. Kui intsidendiga on seotud mingi vahtkond, siis peab olema võimalik ka seda kirjeldada. Iga kord ei ole intsident seotud isikuga või isikutega vaid millegi muuga. Ka sellised intsidendid kus põder üle piiri läheb peab saama registreerida. Muud objektid on jagatud gruppidesse.

Andmebaasi skeem

Andmebaasi arhitektid on loonud vastavalt taustsüsteemile andmebaasi mudeli. Antud mudel on oluliselt suurem kui projekti raames realiseerida tuleb kuid annab pildi olemitevahelistest seostest ja neis sisalduvatest väljadest.

Auditeeritavuse tagamiseks on andmebaasis igal olemil väljad: avaja, muutja, sulgeja. Nendesse väljadesse tuleb automaatselt kirjutada nimetatud toimingu "süüdlase" kasutajanimi. Lisaks on igas tabelis kuupäevad avatud, muudetud, suletud, seda isegi juhtudel kui see funktsionaalsus võiks olla dubleeritav mõne teise kuupäevavälja abil. Avatud peab alati näitama kirje loomise aega, suletud kirje "kustutamise" aega. Reaalselt ei tohi rakenduse põhivaated ühtegi rida tabelitest mitte kunagi kustutada.



Vihje: Mudeli suuremalt vaatamiseks kliki sellel

Lisaks mudeli graafilisele skeemile on antud ka mudeli kirjeldus SQL failina.

Lahenduses peavad eksisteerima vähemalt oma vaadete realiseerimiseks hädavajalikud olemid. Seotud olemid, mille detaile loodavad vaated otseselt ei redigeeri ega kuva, võivad olla realiseeritud ka vähendatud kujul: sisaldada ainult valikusisendite mõistliku kuvamise jaoks vajalikke välju (id, kood, nimetus jms).

Kasutajaliides

Kasutajaliidese disainerid on joonistanud kliendi soovide alusel hulga vaadete eskiise (mockups). Vaadete loogikat ja ülesehitust muuta ei tohi: kõik eskiisis toodud elemendid peavad eksisteerima ja töötama, samuti asuma eskiisis näidatud kohtades.

Kõik kuupäeva sisendid peavad olema varustatud interaktiivse kalendriga (date picker).

NB! Vaated on meeskonna spetsiifilised vaata "Projekt (detailid)".

Tehnilised vihjed

GIT-ile saab öelda milliseid faile ja katalooge ei tohi versioonihaldusesse panna. Selleks tuleb teha fail .gitignore ja kirjutada need sinna sisse. Eclipse kasutajad võivad vajutada ka vastava faili peal paremat nuppu ja valida Team->Ignore.
PS! .gitignore fail ise peaks olema github-is, siis saavad teised projekti liikmed automaatselt sama seadistuse osaliseks.

Juba valmis tehtud projekti saab importida Eclipse-sse File->Import->Maven->Check out projects from SCM. 
NB! samast aknast saab paigaldada Git-i connectori Mavenile.

Roo poolt genereeritud kood on hea copy-paste materjal :)

Roo tehtud meetodite ümber kirjutamisest üksi aga ei piisa, kuna ühe merge käsuga võidakse salvestada mitu JPA olemit ja kaskaadkustutamine võib viia ikkagi mõne olemi kustutamiseni.

Muutmiskuupäevade ja isikute kindla peale salvestamiseks ning kaskaadkustutamise vältimiseks on vaja kasutada JPA olemi elutsükli annotatsioone. Näiteks:

    @PrePersist
    public void recordCreated() {
        setCreated( new Date() );
    }

    @PreUpdate
    public void recordModified() {
        setModified( new Date() );
    }

    @PreRemove
    public void preventRemove() {
        throw new SecurityException("Removing of bears is prohibited!");
    }
Lisaks on tõenäoliselt vaja muudatusi majandada ka merge meetodist:

    @Transactional
    public XXX merge() {
        ...
        if(id != null && !entityManager.contains(this)) {
            XXX oldEntity = entityManager.find(getClass(), id);
            if(getCreated() == null)
                setCreated(oldEntity.getCreated());
            ...
        }
        ...
    }
Kes oskab võib iga olemi kallal käsitöö asemel teha ka ühist funktsionaalsust ja väljasid sisaldava baasklassi:

...
@MappedSuperclass
@RooToString
@RooEntity(mappedSuperclass = true)
public abstract class BaseEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
...

Põhimõtteliselt saab defineerida ka ühiste väljade gettereid / settereid sisaldava liidese ja kirjeldada persistence.xml failis kõigile olemitele korraga kehtiva listeneri (keerulisem, loe http://docs.jboss.org/hibernate/entitymanager/3.6/reference/en/html/listeners.html).

Kui kasutad Spring Security-t, siis saab kasutajanime praktiliselt igalt poolt kätte nii:

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String userName = auth.getName();
Kontrollerites on aga veelgi lihtsam, lihtsalt lisa meetodile Principal tüüpi argument:

    @RequestMapping(method = RequestMethod.GET)   
    public String showResults(..., Principal principal, Model uiModel) {
        String userName = principal.getName();
        ...
    }
Git help:

GitHub:help
Pro Git book
Git Reference
EGit ja GitHub
How to use Git - Git Video Tutorial - Part 1: http://www.youtube.com/watch?v=DQUcmNO4diQ
