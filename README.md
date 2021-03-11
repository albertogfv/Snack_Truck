# Snack_Truck
A snak truck app for accepting food truck orders

To use this app a user has to add restaurn items in first. 
I didnt set up a database with initial food items


Completion of priority cases:

For the first priority case the user can select snacks.
The app at this time does not submit those to a dialog box. 
I ran into dependency issues several times when tryin to access a viewmodel through the dialog fragments.
I made a wuery statement to refresh the amount after the orders were submitted, but it just ended up wiping all the menu items.

For the priority two cases, I was able to added a colmun int the database to add the veggie option for each item.
They can be queried, but i was not able to finish that portion.

for the priority three cases, there is an add button, there is a toggle for veggie option
the cancel and save buttons work.

As a proposal for how to allow menu item changes to distinguish between a user and a worker. For the delete an add functions for menu items.
I would add a password requesting dialog box that would be acting as a roadblock for accepting new items or delete previous ones.
