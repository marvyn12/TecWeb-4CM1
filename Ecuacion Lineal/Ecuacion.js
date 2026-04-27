//una funcion
function Ecuacion() {
    let b = parseFloat(document.getElementById("b").value) || 0;
    let c = parseFloat(document.getElementById("c").value) || 0;

    let x1 = parseFloat(document.getElementById("x1").value) || 0;
    let x2 = parseFloat(document.getElementById("x2").value) || 0;
    let x3 = parseFloat(document.getElementById("x3").value) || 0;
    let x4 = parseFloat(document.getElementById("x4").value) || 0;
    let x5 = parseFloat(document.getElementById("x5").value) || 0;

    let y1 = b * x1 + c;
    let y2 = b * x2 + c;
    let y3 = b * x3 + c;
    let y4 = b * x4 + c;
    let y5 = b * x5 + c;

    document.getElementById("y1").innerHTML = "y1 = " + y1;
    document.getElementById("y2").innerHTML = "y2 = " + y2;
    document.getElementById("y3").innerHTML = "y3 = " + y3;
    document.getElementById("y4").innerHTML = "y4 = " + y4;
    document.getElementById("y5").innerHTML = "y5 = " + y5;

}