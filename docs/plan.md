# Animation Software Project

## Scope

The aim of this project is to allow people to create simple animations in an intuitive and easy to use piece of software. I would like to create software where users are able to draw things on the screen, be able to colour them, scale, rotate and animate them using this software. To do this the software will need a system of storing the drawings as objects, so that a layer system can be implemented. This would make each component independently selectable and be able to be ordered differently.

With these building blocks the user can use keyframes to move these items around the screen. They will be able to do this with both frame by frame type animation and with motion tweening. 
## Toolset

I would like a limited toolset including scaling, rotation, selection, drawing and erasing. The tool currently in use is highlighted in gold. When selected, all other tools will be disabled. 
### Select
I would like objects to be able to be moved round when they are clicked on and dragged by the cursor. If the user is not clicking anything in particular a rubber band selection should show so objects from multiple layers can be selected. If the user tries to select on an anchor group, it will also show this rubber band selection type. 
## Draw
The user will be able to choose the thickness of the lines as well as the colour. Lines are drawn when the user holds down and moves the mouse. Drawings on the same layer become part of the same drawing.
### Fill
The user will be able to fill in enclosed spaces. If the user fills not in an enclosed area, the whole canvas will fill. To do this I will need to research scanline fill and queue-based flood fill. This is probably the most difficult thing to implement.
## Timeline
There will be a blue line indicating the position on the timeline the user will be able to drag it around and be able to see the progress of the animation at different times. 

## Animation
The keyframes in the timeline contain the changes over the time of the animation. A JSON format will be used to store the changed made. 

## Objects

Objects are the things that can be moved around. They can be connected to other objects as seperate entities but anchored to them in some way. Objects can have different drawings over different keyframes. Similar to in Scratch. This gives the ability of both motion tweening and onion skin type animation.

## GUI Options

I would like ctrl z to be in my program. This will mean I will need to revert the changes that have been made, involving representing the transformation (i.e., scale, position, etc.) and the graphic changes such as a line stroke or a fill.

I think it would be best to

The FXML file needs to be split into different controller files so that the methods can be clearly seperated. 

## Future Capabilities
Exporting the animation as a video file. Adjusting the thickness of the line using a drawing tablet.