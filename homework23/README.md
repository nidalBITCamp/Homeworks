TASK #1 – FILES + WORKER THREADS

Ucitati bilo koju tekst datoteku i odrediti koliko se prvo slovo prvog reda ponavlja u cijelom File-u.

Podijeliti posao na više Thread-ova pomocu Producer Consumer metodologije, tako da svaki Thread 

dobije jednu liniju File-a. Program nije osjetljiv na velika i mala slova.


TASK #2 – BUFFEREDIMAGE + WORKER THREADS


Koristeci Producer Consumer metodologiju ucitanu sliku renderati u negativ. Ucitati sliku sa racunara 

u BufferedImage tako da postoje sve informacije o svakom pikselu. Koristeci te informacije podijeliti 

posao na više Thread-ova (na proizvoljan, ali efikasan nacin). Svaki Thread mora obrnuti vrijednost 

piksela, tj. vrijednost R, G i B oduzeti od 255. Prikazati pomocu GUI-a rezultat tih operacija.