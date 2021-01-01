DONE
review domain classes 
repositories with some basic methods
unit tests for ItemRepository class

??
- domain class LP: unieke combinatie title & artist (idem bij Game)
    * normaal met @UniqueConstraints title & artist
    * title: attribute van superclass item
    * als Item @MappedSuperclass: title ook kolom in tabel LP
    * hier echter: Item als Entity —> kolom title onvindbaar in tabel LP —> @UniqueConstraints onmogelijk
- in klasse WebUser: regexp name
- hoe bepalen welke CascadeTypes nodig zijn
- verplichte velden: hoe kiezen tussen @NotNull, @NotBlank, @NotEmpty
    * @NotBlank voor strings
    * @NotNull voor de rest
- getAllItems_ResultListOrderedByTitle(): test met streams werkt niet
- domain klasse met inheritance: alle repo methodes groeperen in 1 ItemRepository of 1 repo per subklasse
