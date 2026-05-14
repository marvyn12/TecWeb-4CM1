// Obtener la referencia de la pantalla
const display = document.getElementById('display');

// Función para agregar números y operadores a la pantalla
function agregarValor(valor) {
    display.value += valor;
}

// Función para limpiar la pantalla (Botón C)
function limpiar() {
    display.value = '';
}

// 1. Uso de eval() para evaluar expresiones (Botón =)
function calcular() {
    try {
        // eval toma el string de la pantalla (ej. "5+6+8") y lo resuelve
        let resultado = eval(display.value);
        display.value = resultado;
    } catch (error) {
        display.value = 'Error';
    }
}

// 2. Uso de Math.log (Botón log)
function calcularLog() {
    let valor = parseFloat(display.value);
    if (!isNaN(valor)) {
        display.value = Math.log(valor);
    }
}

// Función extra para la Raíz Cuadrada (Botón √)
function calcularRaiz() {
    let valor = parseFloat(display.value);
    if (!isNaN(valor)) {
        display.value = Math.sqrt(valor);
    }
}

// 3 y 4. Uso de Math.pow y prompt() (Botón x^n)
function calcularPotencia() {
    // Tomamos el valor actual de la pantalla como la base (x)
    let base = parseFloat(display.value);

    if (!isNaN(base)) {
        // Usamos prompt para pedir el exponente (n)
        let exponente = prompt("Ingresa el valor del exponente (n):");

        // Verificamos que el usuario haya ingresado algo
        if (exponente !== null && exponente !== "") {
            // Calculamos la potencia y la mostramos
            display.value = Math.pow(base, parseFloat(exponente));
        }
    } else {
        alert("Primero ingresa el valor de la base (x) en la pantalla.");
    }
}