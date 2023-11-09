const numberButtons = document.querySelectorAll("[data-number]");
const operationButtons = document.querySelectorAll("[data-operation]");
const display = document.getElementById("calculator-display");
const clearButton = document.getElementById("AC");
const equalButton = document.getElementById("equal");

let displayNumber = "0";

const updateDisplay = (displayNumber) => {
  display.textContent = displayNumber;
};

// updateDisplay();

numberButtons.forEach((button) => {
  button.addEventListener("click", (e) => {
    if (displayNumber === "0") {
      displayNumber = e.target.innerText;
    } else {
      append(e.target.innerText);
    }
    updateDisplay();
  });
});

const clear = () => {
  // displayNumber = "0";
  updateDisplay("0");
};

clearButton.addEventListener("click", () => clear());

const append = (input) => {
  updateDisplay(`${displayNumber}${input}`);
  // displayNumber = displayNumber + input;
};

// what if the user clicks operation more than once?
operationButtons.forEach((button) => {
  button.addEventListener("click", () => {
    append(button.innerText);
    updateDisplay();
  });
});

equalButton.addEventListener("click", () => {
  displayNumber = eval(displayNumber);
  updateDisplay(displayNumber);
  displayNumber = "0";
});

// try es6 class
