------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Club
PURPOSE OF PROJECT: Learning to handle lists and iterators
VERSION or DATE: 1.0
HOW TO START THIS PROJECT: Run from BlueJ as it lacks a main driver
AUTHORS: Daniel Kvist, Martin Augustsson
USER INSTRUCTIONS: Join a club!

Frågor

#1
Att fundera på: Det kommer att behövas iteratorobjekt på flera ställen i lösningen. Bör dessa deklareras lokalt i resp. metod, eller räcker det med ett gemensamt iteratorobjekt i klassen som kan användas i de olika metoderna? Motivera! 

Det räcker med ett iterator objekt lokalt. Intansvariabler skall endast lagra objektets tillstånd, allt annat bör deklareras så lokalt som möjligt. Om man deklarerar iteratorn på instansnivå så sparar man förvisso lite kod men det kan generera underliga fel som kan vara svåra att felsöka eftersom så många metoder använder den.

#2
Om parametern month har ett värde utanför det giltiga intervallet 1..12 skall metoden skriva ut ett felmeddelande samt returnera null . Denna metod är något svårare att skriva än ovanstående. Tips: Utnyttja metoden remove. OBS, metoden finns både i listklassen och i iteratorklassen. Vilken bör du använda? Vad skulle kunna hända om du blandar?

Använder man den i iteratorklassen så tar den bort objektet ur den underliggande listan, det vill säga listan med medlemmar. 