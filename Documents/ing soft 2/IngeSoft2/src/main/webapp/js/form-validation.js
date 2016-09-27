/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// Wait for the DOM to be ready
$(function() {
  // Initialize form validation on the registration form.
  // It has the name attribute "registration"
  $("form[name='crear_cliente']").validate({
    // Specify validation rules
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      Nombre_Cliente: "required",
      Telefono_Local: "required",
      Telefono_Movil: "required",
      Nombre_Usuario: "required",
      Area: "required",
      Puesto: "required",
      Nombre_Empresa: "required",
      correo: {
        required: true,
        // Specify that email should be validated
        // by the built-in "email" rule
        email: true
      },
      password: {
        required: true,
        minlength: 5
      }
    },
    // Specify validation error messages
    messages: {
        Nombre_Cliente: "Debes de ingresar tu nombre",
      Telefono_Local: "Debes ingresar un telefono de casa",
      Telefono_Movil: "Debes de ingresar un telefono movil",
      Nombre_Usuario: "Especifica tu nombre de usuario",
      Area: "Especifica el area en la que trabajas",
      Puesto: "Especifica tu puesto",
      Nombre_Empresa: "Escribe el nombre de la empresa a la que perteneces",
      password: {
        required: "Por favor provee una contraseña",
        minlength: "La contraseña debe de ser mínimo 5 caractéres"
      },
      correo: "por favor ingresa un email válido"
    },
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function(form) {
      form.submit();
    }
  });
});