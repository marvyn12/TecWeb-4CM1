//Con java creamos la aplicacion del lado del servidor
//Con javascript hacemos las aplicaciones del lado del cliente (brave, firefox, chrome, etc.)

//alert("Hola mundo de las aplicaciones del lado del cliente"); //Se crea una alerta emitida por la pagina

function DivisaUSA()
{
    //Document por sus origenes cientificos 
    let precioDolar = parseFloat(document.getElementById("precio-dolar").value);
    let CantidaDinero = parseFloat(document.getElementById("Cantidad-dinero").value);
    let resultado = (precioDolar  * CantidaDinero);
    let mensaje = CantidaDinero + " dolares son "+ resultado + " pesos "
    document.getElementById("resultado").innerHTML=mensaje;
}

function DivisaMX()
{
    let precioDolar = parseFloat(document.getElementById("precio-dolar").value);
    let CantidaDinero = parseFloat(document.getElementById("Cantidad-dinero").value);
    let resultado = (CantidaDinero  / precioDolar);
    let mensaje = CantidaDinero + " dolares son "+ resultado + " pesos ";
    document.getElementById("resultado").innerHTML=mensaje;
}


