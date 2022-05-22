# Boatclub OO-Design
This document describes the design according to the requirements presented in assignment 2.

## Architectural Overview
The application uses the model-view-controller (MVC) architectural pattern. The view is passive and gets called from the controller. The view may only read information from the model, not directly change it.

![class diagram](img/package_diagram.jpg)

## Detailed Design
### Class Diagram
<img src="img/classDiagram.svg" alt="">

### Sequence Diagram
<p>The sequence diagram show the scenario when adding a new member Scenario accroding to Tobias's suggestions on first submission. </p>
<img src="img/sequenceDiagram.svg" alt="">