const numberButtons = document.querySelectorAll("[data-number]");
const display = document.getElementById("calculator-display");
const clearButton = document.getElementById("AC");

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
