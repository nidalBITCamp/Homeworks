Zadatak 1

Napisati dvije klase:
1. StoryElement klasa (abstract)
a. Klasa koja opisuje jedan element u radnji jedne price
b. Sadrži atribut imena
c. Sadrži dva konstruktora
i. Konstruktor koji inicijalizira ime na datu vrijednost
ii. Prazni konstruktor koji inicijalizira, preko prvog konstruktora, ime na „STElement“
2. Character klasa koja nasljeduje StoryElement klasu
a. Klasa koja opisuje jednog lika u radnji jedne price
b. Sadrži spol karaktera
c. Sadrži atribut koji opisuje da li je lik živ ili ne (default je true)
d. Sadrži atribut koji opisuje da li je lik sposoban ili ne
e. Sadrži metodu koja... ubija lika
f. Sadrži metodu koja pretvara nesposobnog lika u sposobnog
g. Konstruktor koji inicijalizira ime, spol karaktera i sposobnost karaktera

Zadatak 2

Napisati dvije klase:
1. Event klasa
a. Klasa koja opisuje dogadaj u radnji jedne price
b. Klasa sadrži samo konstante i to:
i. Poraz
ii. Prijateljstvo
iii. Ljubav
iv. Osveta
v. Manipulacija
2. Goal klasa koja nasljeduje StoryElement klasu
a. Klasa koja opisuje cilj jednog lika u radnji jedne price
b. Sadrži atribut težine bazirano na tri vrijednosti (lagano, teško i nemoguce)
c. Sadrži atribut koji opisuje šta (Event) se treba desiti da se ispuni cilj
d. Sadrži atribut koji opisuje kome ili sa kim (Character) se treba desiti dogadaj pod c.
e. Sadrži konstruktor koji inicijalizira tri pomenuta atributa, kao i ime cilja


Zadatak 3

Napisati klasu:
1. Protagonist klasa koja nasljeduje Character klasu
a. Opisuje glavnog pozitivca u prici
b. Sadrži atribut koji opisuje glavni cilj (Goal) lika
c. Sadrži jedan niz, kao atribut, likova (Character) koji pomažu glavnom liku (max. 3)
d. Sadrži jedan atribut koji oznacava glavnog neprijatelja (Character)
i. Dati atribut može biti null
e. Sadrži konstruktor koji inicijalizira ime, spol, sposobnost i cilj lika
f. Sadrži metodu koja postavi glavnog neprijatelja
g. Sadrži metodu koja doda jednog lika koji ce pomoci glavnom liku
i. Pomenuta metoda se može samo cetiri puta pozvati (peti throw-a exception)

Zadatak 4

Napisati metodu:
1. Metoda attainGoal() u klasi Protagonist
a. Metoda koja pokrene ciklus borbe glavnog lika i pokušaja da dokuci svoj cilj
b. Metoda ne može raditi ukoliko glavni lik nije živ
c. Metoda izracuna kolika je šansa da glavni lik dokuci svoj cilj
i. Ukoliko je glavni lik sposoban onda +40%
ii. Za svakog sposobnog pomocnog lika +20%
iii. Ukoliko je glavni neprijatelj sposoban onda -30%
iv. Ukoliko je cilj težak onda -20%
v. Ukoliko je cilj nemoguc onda -100%
vi. Šansa uvijek mora biti izmedu 0 i 100%
d. Bazirano na izracunatoj šansi metoda odluci da li je lik uspio ili ne
i. Uspjeh:
1. Ispisati na konzolu da je lik uspio i u cemu (Goal) je uspio
2. Napraviti jednog lika (nasumicno izabranog) sposobnim (ako nije bio)
ii. Neuspjeh:
1. Ispisati na konzolu da lik nije uspio i u cemu (Goal) nije uspio
2. Nasumicno izabrati jednoga lika koji je ucestvovao i ubiti ga
3. Napraviti jednog lika (nasumicno izabranog) sposobnim (ako nije bio)

Zadatak 5

Napraviti pricu u main metodi pomocu navedenih klasa!