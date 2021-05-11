
simpleGreetProvider = function (){
    return "Hello ";
}

console.log(simpleGreetProvider());


timelyGreetProvider = function (){
    greet="";

    hour = (new Date()).getHours();

    if (hour>=3 && hour<=11) greet="Good Morning ";
    else if(hour<=15) greet="Good Noon ";
    else greet="Good Evening ";

    return greet;
}

console.log(timelyGreetProvider());

function greetUser(userName, greetProvider){    // userName is string. greetProvider is a functionReference
    return greetProvider() + " " + userName;
}

// calling 

console.log(greetUser("Vamsy", simpleGreetProvider));
console.log(greetUser("Vamsy", timelyGreetProvider));

console.log(greetUser("Vamsy", function () { return "Sasriakal ";}));

// console.log(greetUser("Vamsy",()=>"Namasthey "));
// console.log(greetUser("Vamsy",()=>"Vanakkam "));
// console.log(greetUser("Vamsy",()=>"Namaskar "));

// IIFE - Immediately Invoked Function Expression

(function(){
     console.log("has to execute here right away..!");    
})();