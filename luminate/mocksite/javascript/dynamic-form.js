var lwms = lwms || {};

/**
* DynamicForm is a class used by client javascript code to generate a html form
* based on some meta data
*/
lwms.DynamicForm = function(formId, containerId) {
  this.formId = formId;
  this.containerId = containerId;
}
