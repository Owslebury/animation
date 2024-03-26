# Animation Software Project

## Scope

This project will let users draw things on the screen, which are created as objects. These objects can then be moved around using motion tweens and connected to other objects. For this, I will need to implement important parts including the toolset, the timeline, the objects, the animation, and general GUI options such as ctrl Z.

## Toolset

I would like a limited toolset including scaling, rotation, selection, and drawing. I want the selection to select in the form of a rubber band like on operating systems.

### Fill

Research scanline fill, queue-based flood fill. This is probably the most difficult thing to implement.

## Timeline

There will be a blue line indicating the position on the timeline the user will be able to draw it around and be able to see the progress of the animation.

## Animation

Animation will be done by JSON. Where things change in a keyframe, there will be a change in position, scale, and rotation. Drawings must be able to be stored in some format so they can be loaded later. This would have to include fills!

## Objects

Objects are the things that can be moved around. They can be connected to other objects and moved as one object. These are what have keyframes attributed to them.

## GUI Options

I would like ctrl z to be in my program. This will mean I will need to revert the changes that have been made, involving representing the transformation (i.e., scale, position, etc.) and the graphic changes such as a line stroke or a fill.

I think it would be best to

The FXML file needs to be split into different controller files so that the methods can be clearly seperated. 
