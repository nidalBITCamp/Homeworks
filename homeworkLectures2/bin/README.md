Dio 1:

Pretpostavite da umjesto odvojenih indikatora za razne tipove imamo samo %b indikator, svako

%b se treba zamijeniti sa narednom vrijednosti iz liste parametara.

Primjer:

format( ?“Moj %b format”, 3) treba da vrati Moj 3 format

format( ?“Moj %b format”, “Camp”) treba da vrati Moj Camp format

Dio 2:

Pretpostavite da osim %b mozete imati indikator tipa %.3b, odnosno %.BROJb koji oznacava

da taj dio treba da uzme samo BROJ znakova (%.3b su 3 znaka). Ukoliko nesto ima vise od 3

znaka treba do skratiti na 3, ukoliko uzima manje popunite razmacima.

Dio 3:

Vas kod treba da uzme u obzir slucajeve gdje ce te  imati viska ili manjka indikatora (odnosno

varijabli) i baci exception u tom slucaju. Testirajte svoju metodu za razne poslane formate.

Prvojerite kako metoda radi (koliko vremena joj treba da zavrsi) za duge stringove.