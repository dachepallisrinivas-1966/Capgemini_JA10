//assigning a function to a object

var f1 = function () {
    console.log("I am called");
}

f1(); //we can call it this way.        

var temp = 100;
function f2() {
    let temp = 200;
    console.log(temp);
}
f2();

console.log(temp);