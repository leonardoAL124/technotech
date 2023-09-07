const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');
const btnEnviar = document.getElementById('btn-enviar');

const expresiones = {
    correo: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
    nombre: /^[a-zA-ZÀ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
    apellido: /^[a-zA-ZÀ-ÿ\s]{1,40}$/
    //cedulaid: /^[0-9]+$/, //Solo números del 0 al 9
};

const campos = {
    correo: false,
    nombre: false,
    apellido: false
};

const validarFormulario = (e) =>{
    switch (e.target.name) {
        case "correo":
            validarCampo(expresiones.correo, e.target, 'correElec');
            break;
        case "nombre":
            validarCampo(expresiones.nombre, e.target, 'nombres');
            break;
        case "apellido":
            validarCampo(expresiones.apellido, e.target, 'apellidos');
            break;
    }
};

const validarCampo = (expresion, input, campo) =>{
    if(expresion.test(input.value)){
        document.getElementById(`${campo}`).style.backgroundColor = "rgba(60, 229, 75, 0.5)";
    }else{
        document.getElementById(`${campo}`).style.backgroundColor = "rgba(255, 99, 71, 0.8)";
    }
};

inputs.forEach((input)=>{
    input.addEventListener('keyup', validarFormulario);
    input.addEventListener('blur', validarFormulario);
});


