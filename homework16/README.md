Zadatak 1
Napisati klasu koja opisuje temperaturu napolju. Temperatura je spremljena u jedan atribut, u °C.
? Napisati konstruktor koji inicijalizira vrijednost temperature
? Napisati metodu getTemperatureInC() koja vraca temperaturu u Celzijusima
? Napisati metodu getTemperatureInK() koja vraca temperaturu u Kelvinima
? Napisati metodu getTemperatureInF() koja vraca temperaturu u Farenhajtim
? Napisati metodu setTemperature(int) koja postavlja vrijednost temperature
? Napisati javadoc za sve metode

Zadatak 2

Napisati klasu koja opisuje cašu. Caša prima samo jednu vrstu tecnosti. Dati objekat opisuju tri atributa, vrsta
tecnosti, kolicinu tecnosti i maksimalnu kolicinu tecnosti.
? Napisati konstruktor koji inicijalizira kolicinu na 0, vrstu na null i max. kolicinu na datu vrijednost
? Napisati metodu getTypeOfLiquid() koja vraca tip tecnosti koji se nalazi u caši
? Napisati metodu getMaxCapacity() koja vraca maksimalni kapacitet caše
? Napisati metodu getCurrentCapacity() koja vraca trenutni kapacitet caše
? Napisati metodu addLiquid(String, int) koja dodaje neku kolicinu nekog tipa tecnosti u cašu
o Ukoliko caša sadrži tecnost koja nije kao data onda ništa ne raditi
o Ukoliko caša sadrži tecnost koja je i data onda povecati za datu kolicinu
? Svaki višak tecnosti se „prelije“ i trenutni kapacitet bude isti kao i maksimalni
? Napisati metodu emptyGlass() koja „prospe“ svu tecnost iz caše
? Napisati javadoc za sve metode

Zadatak 3

Napisati klasu koja opisuje jedan printer. Printer ima sljedece atribute:
? Ime printera
? Kolicina papira u printeru
? Kolicina tinte u printeru
? Ukupno isprintano stranica
Printer ima sljedece konstruktore:
? Prazni konstruktor koji inicijalizira ime na „DefaultPrinter“, a kolicinu papira i tinte na 0
? Konstruktor koji inicijalizira ime na dati parametar, a kolicinu papira i tinte na 0
o Oba konstruktora inicijaliziraju ukupno isprintano stranica na 0
Printer ima sljedece metode:
? Metoda koja vraca da li ima tinte (true/false)
? Metoda koja vraca da li ima papira (true/false)
? Metoda koja vraca koliko je ukupno isprintano stranica od tog printera
? Metoda koja dodaje papira u printer (void metoda)
o Uzeti u obzir da se ne može imati više od 100 papira u printeru
? Metoda koja napuni tintu na max. (void metoda)
o Maksimalno tinte je 100
? Metoda koja „printa“ stranice papira (void metoda)
o Metoda prima int parametar koji predstavlja koliko stranica isprintati
o Za svaku isprintanu stranicu oduzeti jedan papir iz printera
o Za svaku isprintanu stranicu oduzeti tri iz atributa tinta
o Ukoliko nema papira ili ako nema tinte onda ne treba printati
Pored toga Printer klasa sadrži sljedece:
? toString metodu koja printa ime printera i trenutno stanje
o Stanje može biti „Ready“, „No ink“, „No paper“, „No ink nor paper“
? static varijablu koja bilježi koliko ukupno stranica je isprintano
o Napisati i metodu koja vraca vrijednost te varijable
Napisati malu demonstraciju rada vaše klase u main metodi.

Zadatak 4

Napisati klasu koja opisuje jednu firmu. Firmu opisuju sljedeci atributi:
1. Ime firme
2. Direktor firme (koristiti Employee klasu)
3. Niz zaposlenih radnika (koristiti Employee klasu)
Bitno je naglasiti da se i direktor smatra zaposlenikom u firmi, ali se ne nalazi u nizu zaposlenih radnika.
Svaki radnik (Employee) je objekat opisan sljedecim atributima:
1. Ime osobe
2. Spol
3. Mjesecna plata
Svaki atribut je private i svaki ima get metodu. Samo atribut koji opisuje mjesecnu platu ima set
metodu. Pored toga, klasa Employee treba sadržavati i konstruktor koji inicijalizira sve atribute.
Metode koje se nalaze u klasi koja opisuje firmu su:
1. Metoda koja vraca koliko je zaposlenih u firmi
2. Metoda koja vraca koliko ukupno se daje novca za zaposlene, tj. njihove plate
3. Metoda koja odreduje koliko ima zaposlenih žena u firmi
4. Metoda koja povecaje svim zaposlenim platu za datu sumu novca
5. toString metoda koja stavlja ime firme, ime direktora i broj radnika u String