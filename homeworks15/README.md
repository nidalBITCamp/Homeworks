TASK 1

Napisati klasu koja opisuje jednu kasu. Kasa sadrzi:

 -Atribut (private) koji opisuje ime.
 -Atribut (private) koji opisuje trenutnu sumu novca u kasi
- Konstruktor koji inicijalizira ime objekta (ne i trenutnu sumu novca)

- Metoda koja dodaje novac u kasu, npr. dodaj 20 u kasu bi bilo addMoney(20)
- Metoda koja vadi sav novac iz kase, npr. ako je bilo 20 onda ce postati 0
- Metoda koja ispisuje koliko novca ima u kasi na sljedeci nacin:
	- Ako nema nikako onda ispisuje “It is empty...”
	- Ako ima izmedu 1 i 20 ispisuje “There’s some, but not much.”
	- Ako ima izmedu 21 i 100 ispisuje “There’s some.”
	- Ako ima 101 ili  vise onda ispisuje “There’s a lot.”



TASK 2

Napisati klasu koja opisuje jednu zivotinju. Zivotinju opisuju sljedeci atributi:

- Atribut (private) koji opisuje ime zivotinje
- Atribut (private) koji opisuje da li je zivotinja aktivna danju ili nocu
	- Vrijednost 1 znaci da je zivotinja aktivna danju
	- Vrijednost 2 znaci da je zivotinja aktivna nocu
- Atribut (private) koji opisuje koliko je zivotinji potrebno vode
	- Vrijednost 1 znaci da je zivotinji potrebno malo vode
	- Vrijednost 2 znaci da je zivotinji potrebno vise vode
	- Vrijednost 3 znaci da je zivotinji potrebno mnogo vode

- Napraviti konstruktor koji inicijalizira ta tri atributa

Pored toga, sve te zivotinje dijele isto staniste. Staniste je potrebno predstaviti u istoj klasi kao i zivotinje,
tj. bez koristenja dodatnih klasa. To staniste je opisano sa dvije varijable:
- Da li je noc ili dan (private) koje je po default-u 1
	- Vrijednost 1 znaci da je dan
	- Vrijednost 2 znaci da je noc
- Koliko vode ima staniste (private) koje je po default-u 1
	- Vrijednost 0 znaci da staniste nema vode
	- Vrijednost 1 znaci da staniste posjeduje malo vode
	- Vrijednost 2 znaci da staniste posjeduje vise vode
	- Vrijednost 3 znaci da staniste posjeduje mnogo vode
	
Zivotinje imaju samo jednu metodu:
- Isprintati kakvo je trenutno stanje zivotinje
	- Ukoliko doba dana odgovara zivotinji i ona ima dovoljno vode za sebe
- Isprintati “It’s fine. The animal is active and has water.”
	- Ukoliko doba dana odgovara, ali nema dovoljno vode
- Isprintati “The animal is active, but does not have enough water.”
	- Ukoliko doba dana ne odgovara, ali ima dovoljno vode
- Isprintati “The animal is not active, but has enough water.”
	- Ukoliko doba dana ne odgovara, niti ima dovoljno vode
- Isprintati “The animal is not active and it does not have enough water.”

Postoji jos jedna metoda koja utice na staniste:
- Promijeni doba dana
	- Ako je bila noc onda postaje dan (nakon poziva metode)
	- Ako je bio dan onda postaje noc (nakon poziva metode)
- Promijeni koliko vode trenutno ima (static set metoda)