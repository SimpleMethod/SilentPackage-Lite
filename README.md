
# SilentPackage-Lite

Projekt SilentPackage-Lite ma na celu umożliwić monitorowanie pracy Systemu Windows.


Projekt wykonał Michał Młodawski (1ID21A) [m.mlodawski@simplemethod.io](mailto:m.mlodawski@simplemethod.io)

Podział prac w zespole: 
Wszystko wykonał Michał Młodawski 
Temat pracy Inżynierskiej:
System meteorologiczny zrealizowany w technologii Internetu rzeczy.
Temat pracy Magisterskiej:
Generowanie modelu pogodowego w oparciu o system meteorologiczny zrealizowany w technologii Internetu rzeczy.


Lista funkcjonalności: 
1.	Pobieranie informacji  o procesorze, producent i model oraz temperaturze, obciążeniu i taktowaniu każdego z rdzenia procesora.
2.	Pobieranie informacji płyty głównej, nazwa producenta, model, wersja BIOS oraz producent BIOS.
3.	Pobieranie informacji o dedykowanej karcie graficznej. Umożliwia pobranie takich danych jak: Producent, model, wersja sterownika, gałąź sterownika, temperaturze rdzenia, ilości całkowitej pamięci vRAM i ilości dostępnej pamięci do alokacji vRMA.
4.	Pobranie informacji na temat dysków twardych w tym: Nazwy dysku, formatu, lokalizacji, ilości wolnego oraz zajętego miejsca.
5.	Pobieranie informacji o zainstalowanej pamięci RAM w tym producencie, modelu, prędkości, numerze banku i ilości wolnego miejsca.
6.	Listy procesów z nazwą, identyfikatorem oraz czasem startu procesu.
7.	Graficzny interfejs dostępny z poziomu przeglądarki pracujący w koncepcji „jednej strony” obsługujący zapytania AJAX.
8.	Dostęp do API w celu rozszerzenia projektu o dodatkowe punkty wyjścia informacji. 


Spis technologii:
 - .NET w aplikacji do pobierania telemetrii systemu Windows
	 - Biblioteka OpenHardwareMonitor 
	 - Biblioteka  Json.NET
- JAVA w kliencie umożliwiającym prezentację danych.
   - Spring Framework 

## 1. Użyte języki programowania

1.	Java wraz z framework Spring do warstwy serwerowej. 
2.	C# w wersji .Net Framework do warstwy agregacji danych.
3.	HTML z wykorzystaniem frameworka Bootstrap, JavaScript z frameworkiem jQuery oraz AngularJS.
4.	JSON jako format tekstowy dla przejrzystego uporządkowania danych.

## 2. Wykorzystane oprogramowanie przy projektowaniu i wdrażaniu projektu

1.	Adobe XD CC w celu szybkiego prototypowanie interfejsu graficznego.
2.	IntelliJ IDEA jako główne IDE do programowanie serwera.
3.	JavaDoc do prowadzenia dokumentacji kodu. 
4.	JetBrains WebStorm jako IDE do interfejsu graficznego.
5.	Visual Studio z rozszerzeniem  ReSharper

## 3. Wykorzystane zewnętrznej biblioteki 
Podczas pracy wykorzystano kod źródłowy Open Hardware Monitor w celu odtworzenia biblioteki służącej do pobierania informacji o urządzeniu. Fork biblioteki miał na celu port do nowszej wersji .NET Framework i dodanie funkcjonalności zawracania danych w postaci plików JSON oraz dodanie telemetrię pamięci ram.
Fork dostępny jest pod adresem: [https://github.com/SimpleMethod/openhardwaremonitor](https://github.com/SimpleMethod/openhardwaremonitor)

## 4. Interfejs graficzny

Strona główna interfejsu graficznego:
![Strona główna](https://raw.githubusercontent.com/SimpleMethod/SilentPackage-Lite/master/doc/mainPage.png)

Konsola Javy z poziomu uruchomionej aplikacji:
![Cmd](https://raw.githubusercontent.com/SimpleMethod/SilentPackage-Lite/master/doc/console.png)
