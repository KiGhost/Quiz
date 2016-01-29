# Quiz
Editable Quiz using the MVC-Pattern (Model-View-Controller) and JavaFX

This Quiz is using the MVC-Pattern for structuring it.
Different tasks have different View-classes. Every Viewclass is only for showing things, not for knowing what is shown in it.

Every View is connected with a controller. The controller is piping data from the global model to its view and informs the model if something has changed.

All calculations are done in the model. Only the model knows about the data and its structure.
