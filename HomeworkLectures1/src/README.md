1) Napravite klasu CampStringBuilder koja treba da koristeci niz charova oponasa
funkcionalnost StringBuilder klase u Javi. Metode koje treba da implementirate
su
append(object o) ­ dodaje object.toString() na kraj niza charova
prepend(object o) ­ dodaje object.toString() na pocetak niza charova
toString(object o) ­ pretvara niz charova u string.
Sjetite se da svaka klasa nasljeduje objekt, pa za bilo koji objekt vrijedi da ima
metodu toString().
Mala pomoc:
public class CampStringBuilder {
private char[] characters;
//vas kod
public void append(Object o){
//vas kod
}
public void prepend(Object o){
//vas kod
}
private String toString(){
//vas kod
}
}

2) Napisati klasu Autor. Klasa Autor predstavlja, kako i samo ime kaze nekog
Autora. Autor ima svoje ime, mail i spol. Za klasu Autor napisati sve standardne
metode.

3) Napisati klasu Knjiga koja ima podatke o nazivu, cijeni, stanju (imamo 1, 2, 3
primjerka knjige ili nemamo knjigu na stanju). Dodatno svaka knjiga ima autora
(pogledati zadatak 1). Napisati standardne metode.

4) Napisati Klasu Knjizara koja ima podatke o imenu knjizare I knjigama koje su u
prodaji. Napisati I testni program koji napravi novu knjizaru, doda u knjizaru
odredeni broj knjiga a zatim simulira da dodajemo nove knjige I da se knjige
prodaju. Omoguciti da se ispisu knjige. I da se ispisu sve knjige od odredenog
autora.

5) Napisite klasu Date, klasa Date treba da predstavlja datum. Datum treba da ima
mjesec, dan i godinu. Datum treba da omogucite da se napravit novi datum gdje
se postavi samo dan (default vrijednost za mjesec je 1, a za godinu 1), treba da
omogucite da se napravi novi datum gdje je postavljen samo dan i mjesec i
naravno novi datum gdje su postavljeni dan, mjesec i godina. Klasa treba da ima
ToString() metodu koja vraca string u formatu “01.02.2013” odnosno
“31.12.2014”. Klasa treba da ima i metode SetDate(int day), SetMonth(int month)
i SetYear(int year), gdje morate obezbijediti da su vrijednosti za dan i mjesec
validne. Dodajte i metodu DayPassed() koja poveca vrijednost dana za 1 (obratiti
paznju na slucaj kad treba preci na novi mjesec) i MonthPassed() koja poveca
vrijednost mjeseca za 1 (obratiti paznju kad treba preci na novu godinu). Napisite
testni program gdje cete provjeriti da li sve ovo radi kako treba.

6) Napravite klasu Pet koja predstavlja kucnog ljubimca, svaki ljubimac ima svoje
ime, godine i vrstu (pas, macka, …).
Koristeci klasu Pet napravite klase Dog i Cat, psi treba da imaju pasminu. Ako
neko napravi objekt tipa Dog i pozove ToString metodu treba da se vrati string
“Av av”, ukoliko se napravi objekt tipa Cat i pozove ToString treba da vrati string
“Go away human”.
