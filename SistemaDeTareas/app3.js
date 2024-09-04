// Agregar y eliminar elementos a un arreglo
const frutas = ['Platano'];
console.log(frutas);
// Inserta al final del arreglo
frutas.push('Sandia');
console.log(frutas);
// Inserta un elemento al inicio del arreglo
frutas.unshift('Manzana');
console.log(frutas);
// Eliminar el ultimo elemento
const eliminaFruta = frutas.pop();
// Arreglo con elementro eliminado por pop
console.log(frutas);
// Arreglo eliminado con pop
console.log(eliminaFruta);
// Eliminar el primer elemento
const eliminaFrutaShift = frutas.shift();
// Arreglo con elementro eliminado por shift
console.log(frutas);
// Arreglo eliminado con shift
console.log(eliminaFrutaShift);