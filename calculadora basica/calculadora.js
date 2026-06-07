//Con java creamos la aplicacion del lado del servidor
//Con javascript hacemos las aplicaciones del lado del cliente (brave, firefox, chrome, etc.)

//alert("Hola mundo de las aplicaciones del lado del cliente"); //Se crea una alerta emitida por la pagina

function suma()
{
    //Document por sus origenes cientificos 
    let num1 = parseFloat(document.getElementById("num1").value);
    let num2 = parseFloat(document.getElementById("num2").value);
    let resultado = num1  + num2;
    alert ("La suma es: " +resultado);
}

function resta()
{
    let num1 = parseFloat(document.getElementById("num1").value);
    let num2 = parseFloat(document.getElementById("num2").value);
    let resultado = num1 - num2;
    alert ("La resta es: " +resultado);
}

function multiplicacion()
{
    let num1 = parseFloat(document.getElementById("num1").value);
    let num2 = parseFloat(document.getElementById("num2").value);
    let resultado = num1  * num2;
    alert ("La multiplicacion es: " +resultado);
}

function division()
{
    let num1 = parseFloat(document.getElementById("num1").value);
    let num2 = parseFloat(document.getElementById("num2").value);
    if(num2 = 0)
    {
        alert("No se puede dividir entre cero")
    }
    else
    {
        let resultado = num1  / num2;
        alert ("La division es: " +resultado);
    }
}