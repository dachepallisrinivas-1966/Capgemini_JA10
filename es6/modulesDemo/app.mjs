import  { Box }  from './module1.mjs';
import GreetService from './module2.mjs';

let b = new Box();
console.log(b.print());

console.log(GreetService.greet("Vamsy"));