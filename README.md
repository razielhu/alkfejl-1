# alkfejl 
University project


## Rövid leírás
 A web alkalmazás egy személyes feladat menedzselés
 megkönnyítésére szánt eszköz lenne. A Pomodoro technikára
 épülve segítené a felhasználót feladatainak szervezésében.
 Lehetőséget biztosít feladatok csoportosítására és...

### Pomodoro technika 
 ![alt text](https://cdn-images-1.medium.com/max/1600/1*R_S2oOzg5nI3e5VFHW1CKA.png)
 
## Adatbázis modell
 * **User tábla**: id, nev, jelszo, email
 * **Task tábla**: id, user, csapat,  határidő , állapot, leírás, prioritás
 * **Group tábla**: id, user, team, nev, leiras, szin 
 * **Team tábla**: id, nev, leiras
 * *(Team-User összekötő tábla: id, user, team, jogosultsag)*
 
## Funkcionális követelmények
* ### User functions
	* Regisztrálás
	* Bejelentkezés / Kijelentkezés
	* Adatmódosítás
 
* ### Task functions
	* Új Taszk Létrehozás
	* Taszk Törlés
	* Taszkok Listázása
	* Taszk Módosítás
	* Teljesített-re állítás
	* Elhalasztás
	* Szüneteltetés
	* Task Mozgatás
* ### Group functions
	* Group Létrehozás
	* Group Módosítás
	* Group Törlés
	* Group Listázás
* ### Team functions
	* Team Létrehozás
	* Team Módosítás
	* Team Törlés
	* Team Listázás
	* User meghívása Team-be
	* Csatlakozás Team-be
	* *(Jogosultságok kiosztása)*
 
## Adatbázis diagram
