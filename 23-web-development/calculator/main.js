const numberButtons = document.querySelectorAll("[data-number]");
const operationButtons = document.querySelectorAll("[data-operation]");
const display = document.getElementById("calculator-display");
const clearButton = document.getElementById("AC");
const equalButton = document.getElementById("equal");

let displayNumber = "0";

const updateDisplay = () => {
  display.textContent = displayNumber;
};

// updateDisplay();

numberButtons.forEach((button) => {
  button.addEventListener("click", () => {
    if (displayNumber === "0") {
      displayNumber = button.innerText;
    } else {
      append(button.innerText);
    }
    updateDisplay();
  });
});

const clear = () => {
  displayNumber = "0";
  updateDisplay();
};

clearButton.addEventListener("click", () => clear());

const append = (input) => {
  displayNumber = displayNumber + input;
};

operationButtons.forEach((button) => {
  button.addEventListener("click", () => {
    append(button.innerText);
    updateDisplay();
  });
});

equalButton.addEventListener("click", () => {
  displayNumber = eval(displayNumber);
  updateDisplay();
  displayNumber = "0";
});
