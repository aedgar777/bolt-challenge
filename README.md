This is a sample app that I wrote as a modular project starter for various Android take home interview exercises. It fetches a JSON list of simple items from a single endpoint, formats/transforms them into a domain Item object using a Mapper class, stores them in a local database, and displays them in a ComposeAcitivity (for simplicity. Would typically use Fragments for a multi-screen app).
This project makes use of Compose for UI, Ktor for building API calls, and Room for persistant storage.
This project implements the MVVM and respository architectural patterns, with API declarations (ItemKtorImpl), their calls (ItemRepository), and databases (ItemDatabase) in seperate classes, which would support modularization and easy extendability in a more complex app. Data is fetched in the ItemViewModel via the ItemInteractor that provides access to the aforementioned data sources.

Use

On launch, the app will fetch a full list of items from the remote source, insert them into the Room database, and display them in the Compose list. The first 3 numbered buttons on the buttom will fetch fetch the items with the corresponding listId from that local database. The refresh button loads the full list again from the remote source and overwrites the database.
