DONE
- review domain classes 
- repositories with some basic methods
- unit tests for ItemRepository class

??
- domain class LP: unieke combinatie title & artist (idem bij Game)
    * normaal met @UniqueConstraints title & artist
    * title: attribute van superclass item
    * als Item @MappedSuperclass: title ook kolom in tabel LP
    * hier echter: Item als Entity —> kolom title onvindbaar in tabel LP —> @UniqueConstraints onmogelijk
- in klasse WebUser: regexp name
- hoe bepalen welke CascadeTypes nodig zijn  //TRAINER: als bijv iets niet mag verwijderd worden maar wel persisten dan gebruik je enkel CascadeType.Persist, het hangt af van de business logic 
- verplichte velden: hoe kiezen tussen @NotNull, @NotBlank, @NotEmpty
    * @NotBlank voor strings //TRAINER: inderdaad een blanco String is bijv "" of " "
    * @NotNull voor de rest //TRAINER: juist objecten zoals arrays, wrapperclasses, custom objects kunnen null zijn en met NotNull verhinder je dat je null zou opslaan in u db
- getAllItems_ResultListOrderedByTitle(): test met streams werkt niet //TRAINER: zie comments
- domain klasse met inheritance: alle repo methodes groeperen in 1 ItemRepository of 1 repo per subklasse //TRAINER: dat mag je kiezen, je werkt met inheritance dus alles kan in 1 item repo, dus lp, game, book zijn ook items. Een webuser niet uiteraard dus daarvoor moet je sowieso een aparte repo voor maken
