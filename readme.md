Welcome to Impending Phone Book(tm)(c)(r)(inc)(?)!

About the program!

Impending Phone Book is a Contact manager program with CRUD functionality. It can also convert png images to ASCII and will let you know when a contact's birthdate is.. impending.

To start the program:
	1. Clone the github repo https://github.com/Bagenholm/ImpendingPhoneBook
	2. We assume that you have java and maven installed. (Otherwise download from https://maven.apache.org/ and https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
	3. If downloaded as zip, extract. 
	4. Open bash and locate the folder.
	5. Use the command 
		mvn clean compile assembly:single
	6. Use the command
		java -jar target/ImpendingPhoneBook-1.0-SNAPSHOT-jar-with-dependencies.jar
		

Using the program:
If you've used Impending Phone Book(tm)(c)(r)(inc)(?) before it will auto-load your save file if it's located in the user home folder. 
If you don't have an existing save file, start by creating contacts by using the Create Contact menu. 
You will be prompted to input name, address, birth date, email and a personal note. 
	
To find a contact, choose search for contact from the main menu. You can search by any of the fields or all of the fields. 
If you choose a field and press enter before typing a search string, it will list all contacts.
	
You can edit existing contacts at any point by first searching for them. 
To check which contact is being edited, choose Print Current Contact from the main menu.
	
To add an image to a contact, choose contact from the search menu and then edit contact -> edit image. 
Choose a png image from the popup file chooser, mind the that the image size isn't too large as it won't fit on the screen, 
or too small as the resolution will be too low. When you print this image, make sure that you use a monospace font.

Saving is available either to the auto-save or to a .json file of choice by choosing Save from the main menu.


Authors:
Sebastian Aronsson
Adam Bremholm
Patrik Bågenholm
Filip Christofferson

		
    ..............................................................................................................................................................................................................................................................................
    ..........................................................................................................................................................................................................................................:&&&&&oo:***........................
    ..............................................................................................................................................................................................................................*o**:o:**&o88&&&&88888&8&&ooo:*.....*...........
    ............................................................................................................................................................................................................................*o&&oo:**&oo8#88&&##8888&88#88&o:ooooo:*..........
    .....................................................................................................................................................................................................................*o8###8888&&o*oo&88#8888#888888&8888888&o:*.*:oo*........
    ..................................................................................................................................................................................................................*&&&ooooo&&&888oo888##########888888###8&oo&o:****o.........
    .................................................................................................................................................................................................................88&&#@@##88####@###########@##@###888@@@#888&8&:****.........
    ...............................................................................................................................................................................................................o8&8@#####8#@########88#####8###8##88#@@@@@###88&&*.*..........
    ..............................................................................................................................................................................................................o8@@###8#####8#8##888888888888&&&&&&&&&8##@@@##888&o*...........
    .............................................................................................................................................................................................................&####8#88@@@###888&&&&oooooooooooo:ooooooo&888888888&&o:.........
    ............................................................................................................................................................................................................8#88#88###@#88&&&oooooooooooooo::::::::::::o&&8888888&&oo:..... ..
    ...........................................................................................................................................................................................................8#@&8@#@@@#8&ooooooooooooooooooo:::::::::::*:oo&&&888&&&&o&o*.. .. 
    .........................*:&88######8&:*..................................................................................................................................................................o8@&&#@@@#&oooooooooooooooooooooo:::::::::****:oo&&&&&&&&ooooo:.    
    .....................*o8###@@@@@@@@@#####&:...............................................................................................................................................................&&8&8@@@8&oooooooooooooooooooooooo:::::::**..*::ooo&&&oo&&&&&oo.    
    ...................*&##@#@@@@8&o**********&#8:.*..........................................................................................................................................................&&88##@8&ooooooooooooooooooooooooo:::::::*...**::ooooooo&&o&o&o..   
    ..................o8##@@@@&:****o&8#8&:**:&:o##*..........................................................................................................................................................&888#@8&oooooooooooooooooooooooo::::::::****.**::ooooo&&oo&&&oo. .  
    ............*****8#@@@@@&******:&8@@@@@@#&*o8:8o................................................................**********:ooo:***........................................................................&&88#8&ooooooooooooooooooo::::::::::::::*******::ooo&&&&&oooo&&o.   
    ............*.*o##@@@@@@8&&o:*******&#@@#@@8:o&:**...........................................................**:oooo&88&&oo8#88&&&o*......................................................................&8&88&oooooooooooooooooooooooo::::::::::********:o&&&&&&oooo:oo:..  
    .........*****o#@@@@@@@@@@@@@@@@#o*****&@8:8@8:o*****......................................................*:o&&&&&&&888#88##8888&&&:**..................................................................*88#88&ooooooooooooooooooooooooooooo&&&ooo:**.*****:&888&&&oooo::..  
    ....*********o#@@@@@@@@#&o:*******::::***&@o:8@&o:*****...................................................**:oo&8########8888###88&oo:**.................................................................o88#88ooooooooooooooooooooo&&&8888888888888#@###8o&&&&88888&o&oo:..  
    ..**********o@@@@@@#o**:o&8888&88888#8o:*:o@&*o@8o*******................................................**::oo&8#@#888&&oo&&&88888&o::*......................................o&&&&o:*...................*o&##8ooooooo&&&&&o&&&&&&&&8##8888&&&&&&&&&&8@8::::o&88&8#8&&&8&o*.  
    ..*********o#@@@@8*:&8&ooooooooooo&&88888o:o@8:o#8o::*****..............................................***::o&88&&ooooooooooooooo&&&o:*...................................:8@@##8888&:*...................&@@8oo&88#####8888888###@#888888888888888&&#&ooo::::&8888##&o*:..  
    ***********8#@@8:o&&oo&ooooooooooooo&&88888oo@8::#&oo::*****..........................................****:o&88&ooooooooooooo::::oooo&&:**............................**:o8#@@@@##88##8o:*.................&#@88##8888888##@@@@888##&88888&&8#@#888888#oo:*....*o&8&oooo&&o.  
    ***********###&:&&&&&&ooooooooooooooooo&8##8oo@&:o8ooo::****.........................................***:oo88&ooooooooooooooo:::::oooo&&o**.........................*o&&8#@@@@@@@@@@@@@@8o:*...............&@@888888&88##@##@8oooo##&&&&88&&&&&&oo&oo&&:::**...*:o&&ooo:*o&*  
    ***********##8:8&&&&&8888&&oooooooooooo&&8##8o&#::8oooo:******....................................*****:o&88&ooooooooooooooooo:::o:o:oo&&:**......................*o&&8#@@@@##88&&ooooo8@#8&:*...........&@@@888888#8#@@@#88#oooooo#8&&&&&&oooooooooo8::::****..*:&8ooo::.o:. 
    **********:##:&8&&8#88@@#88&&&&&&&888888888##8:o:::oooo::*****.................................********:&88&oooooo&&oooooooooooo::::ooo&&&:**...................*o&8#@@88&&&&&&ooo::::::o8888&:............*#8&&8#888&&&&&&88oooo::o8#&oooooooooo:o8o:**::********o&&&&oo:*:  
    ***********88:&&&&&&&&88888&&&&888###88&&&&#@8o::::oooo:::*****.................................*******o888&&88888888&&oooo&8888&&ooooo&&&&:**.................:&8#@@&ooooooooooooo:::::::&8888&:...........o&&&&&&&&oooooo#&ooo::::o&&88&&&&&88&oo::::*:*********:ooo&&&o**  
    **********::&o&o&ooo&&&&&&&ooo&&&88&8##8#888#8&o888ooooo:::*****..............................*********o88@88&&888##8888&8&&8#88&&&&8#8&88&:******............:&8#@@&oooooooooooooo::::::::o8#888&*..........&&oooooooooo&#&ooooo:::*:oo&&&&&&&ooo:::::::*********::::o&&o*.  
    ************:o&oooooooooo&&ooo&&&&&88&&&&&&&&88o@@8ooooo:::*****.............................**********:&##888888888&8&ooo8&&&888888&8#88#8:**********.......*o8#@@&o&&&oooooooooooo:::::::o&#@@88&o..........o88oooo&8#8&&&&&ooooo&ooo:oooooooooo::::::*********:oo:oo:***.  
    *************o&&&&ooo&&&&&oooo&&&&oooooooo&&&88o@8ooooooo:::*******......................************::o8##&&&&&&&&&&8oo:o&&oooo&o&&&&&8@##&::::*********..**:&@@@8&&&&&&oooooooooooo::::::o&#@@##8&*.........*&&&oo&&&&&&&88#88&&&&88&&&oooooooooo::::**:*******:o&o::**..   
    *************:o&&&&&&&&&&88&&88&&&&&oooooo&&&88o8oooooooo::::********.................************::::o&8#&ooo&&&&&&&&&ooooo&&&&&oo&oooo###&oo:**************o#@@@8&&&&&&&ooooooooooooooo:::o8@@#8&*...........o&&&&ooooo&&&8#88888&&oooooooooooooooo::::::******:oo:*****.   
    *************::o&&&&&&&&&&&&88888&&&&&&&&&&&&8&oooooooooooo:::********................**************::o&88&oooooooo&&888&88&&ooooo::oooo888&oo:::************:&@@@#8&&&&&&&&&&&&&&8888&oooo::&#@@8:.............&&&oooooo&&&&&8888888&&&oooooooooooooo::::::***:::o:*o:*..    
    **************:o&&&&&&&&&&&&&&&&&&&&&88&&&&&&&ooooooooooooo:::*********..............****************::o&&ooooooooo&&&o&&&&oooooooo::ooo&&&&oooo:::::*********o#@@@8&8#@@@#88&&&&&8##@#88&o::o#@#8o..............&&oooooooo&&8888888888&&ooo&&&&&&ooooo:::::::::::::.&&:.     
    ***************:o&&&&oo&&&&&&&&888&&&&&&&&&&&&&ooooooooooo:::::********..............****************::oo&&&&&&&&o&&&&&&&&ooooooooooooo&&oo&ooooo:::::::*******o8@@@8888#@@##8&ooo&888&&ooo:::&8o&:..............o&&&&oo&&&&8888&&&&8&&&&&&&888888&&ooo::::::::::oo:*oo..     
    ****************:o&&&&&&&&&&&&&&&&&&&&&&&&&88ooooooooooooo:::::*********..............***************:::oo&&&&o&&&888&&&&&&88&&oooooooo&&oo&oooooo::::::*******:&@@@888#888888&ooooooooooo::::o8&o*...........  .*&&&&&8888888888888&8&&&&&88888888&oooo::::::::oooo:**..     
    **************o88&&&&&&&&&&&&&&&&&&&&&88&&&&&&ooooooooooo::::::*********..............***************::::o&&&&&&&oooo&&&oooooooooooooo&ooo&&ooooooo:::::********o&@@8&&&&&&&&&&oooooooooo:::::o&&:*...........  ..o&&&8#88#@8&&&oooooooooooooooo&&8&oo:oo:::::ooo&&:***.      
    *************oo&88&&&&&&&&&&&&&&&&&&888&&&88&&#&&ooooooo::::::************............**************::::::o&&&&&&&oooooooooooooooooooo&&&&&&ooooooo:::::*********:&@8&&&&&&&8&&ooooo&&&&oo::::o&::......... .  ...*o&&8#88&&&&&&&&&&&&&&oooooooo&&&&oooooooo:ooo&&o:*.*..     
    ************ooo&&8&&&&&&&&&&&&&&8888&&&&&88&&&o&8&oooooo::::::**************..........****************:::::o8888&&&&oooooooooo&&&&&&&&8&&&&oooooooo:::::**********:88&&&&&&&8#@#88##8&&&&oo:::o&*...........  ......&&8888&&&&&&&88##8&&oooooo&&&&88&&oooooooooooo:****..     
    ***********:oooo&88&&&&&&888888888&&&&&&88&&&o&oo&oooooo:::::::***************************************::::::o88888&&&&&&oooo&&&&88888&8&&&&oooooo::::::::**********o888&8&&8#@@@@@@####88&oo::o&*.............     ..&&888&&&&&&oo&&&&ooooooo&&&&8&&&&ooooooooooo::**.**..    
    *********:ooooooo&88&&&&&&&&&&&&&&&&&&&88&oooooooo&oooooo::::::***************************************::::::&&8##888&&&&&&&&&888888&&#@@#&ooooooo:::::::::**********:88888#@@@###8888&8##8ooo&8&*..............     ..&88#88&&&&ooooooooooo&&&&8888888&&ooooooooo:::***::...  
    *.*****:ooooooooooo&&&&&&&&&&&&&&&&&&&88ooooooooooo&&oooo::::::***************************************:::o#@@&88########8888#8888&&&&#@@@@@&oooo::::::::::***********o8888@@#888&&&&ooo&##88888o................    ...o#####88&&oooo&&&&&&&8888888888&&&&&&&&&oo:::::**..... 
    .***:ooooo&&&oooooooooo&&&8888&&&&&&&8&oooooooooooo&&ooooo::::****************************************::@@@@@&&8888888#8#88888&&&&&o&@@@@@@@8ooo::::::::::**********.*o####@###@@###8&&8##8##88o:*................  . ..o#@@###888&&&&88888#88#####8888&&&&&&&oooooo:*..**....
    :oo:ooooooo&8o&oooo&&&ooooooooooooo&&oooooooooooooo@@@88ooo:::**************************************:*o@@@@@@&&&8&&&&8888&&&&&&&&&oo&@@@@@@@#ooo::::::::::********..***o#@@@@#@@##############&:o&o*...............     .o#@@@@###8888##@@@@@@@###8888888&&&&ooooo:*..**..*...
    #oooooooooo&88o&&&ooooooooooooooooo&ooooooooooooooo@@@@@@@#8o:**************************************::@@@@@#8&&&&&&&&&&&&&&&&&&&&oo&8@@@@@@@@&oo:::::::::*******.......**8@@@@@#########88###8o:o8&:...............      ..o@@@@@@@@@@@@@@@@@@@####8888&&&&&&&&o**::*...*...*.
    ooooooooooo&#@8&oooo&&&&&oooo&&&&&&&ooooooooooooo:&@@@@@@@@@@###&:*******************************:o&8@@@@@@88&&&&&&&&&&&&&&&&ooo&&8@@@@@@@@@@@&o::::::::*******.........:8@@@@@@@@@@########8oooo8o:***............        ..*8@@@@@@@@@@@@@@@@@@##888&&&&&&&oo:**.*:*...**...
    ooooooooooo&@@@@8&&&oooooo&&&oooooooooooooooooooooo@@@@@@@@@@@#####o********************:o&8#@@@@@@@@@@@@@@@@8&o&&&&&&oooooooo8@@@@@@@@@@@@@@@@8&o::::::******..........:8##@@@@@@@@@@@@#8&&oooo&&oo**.............        ....o&#@@@@@@@@@@@@@@#8888&&&&8&oo:::o:****:*...***
    ooooooooooo8@@@@@@@8&&&&oooooooooo&&ooooooooooooo&o@@@@@@#@@@##@#####&*************:&@@@@@@@@@@@@@@@@@@@@@@@@@@#&&&&&&oooo&#@@@@@@@@@@@@@@@@@@@@@@@@8&o::****...........:&&88##@@@@@#8&&&&&oooo&8oo:*...............           ..*&@@##@@@@@@@#88&&&&&&&&oooo:::*:::****:**..*
    ooooooooooo8@@@@@@@@@@@#8&&&oo&&&&&&oooooooo::oo:&o#@@@#@@@#@@@#@#####8:********:&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#o**...........*o&8#88888888&&oooooo&&&o&o**.......**.....**........    ..*888888888888&&&&8&&&oo:::oo::*::::****:::*
    ooo::::oooo#@@#@@@@#####@@@@@@@@@@@8oooooooo::o::oo#@@@#@@@@@@@@#####@@@8:****:o@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#o*........:ooo&8&&&&&&&&&&&&&&&&oo&o:*.......**..*.********.........o88888888888888888&oooooo::::o:::**::::*****
    ooooooooooo@@@@@@@@@@@@#@@@@@@@@@@@&:oooooooo::::oo#@@#@@@@@@@@@##@@@@@@@#:::*8@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#o....*::o&&oo:o&&&&&&&&&&&&ooo&o:**..*.*.**..***********.*.....*&88#888888888888&ooo&oo:ooo:::::::::*:::::::*
    ooooooooooo@@@@@@@@@@##@@@@@@@@@@@@o:oooo::::::::oo#@#@@@@@@@@@##@@#@@@@@@#o:8@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#*.*:o:oo8&&&oo:oo&&&&&&oooooo::**.**.**:*.*:*************.**o&&8#8#88888888&&ooooooooo:::oo:::::::::::*::::
    ooo::ooooo8@@@@@@@@@@###@@@@@@@@@@#oooooo::::oo::oo@@@@@@@@@@@@####@@@@@@@@88@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&:ooo::ooo&&&oooo::o&o:oooo:***..******.*:***::**********:oo&888###88888&oooooooo::ooo::::::::::::::::::::****__****__