import "./Board.css";

let guessingBoard = Array.from({ length: 5 });

const Board = (props) => {
  let style;
  if (props.boardNumber === props.guesses.length + 1) {
    return (
      <div className="board" id={`guessingBoard${props.id}`} style={style}>
        {props.letter[props.id]}
      </div>
    );
  } else if (props.boardNumber <= props.guesses.length) {
    let wordIndex = props.word.current[props.id];
    let letterIndex = props.guesses[props.boardNumber - 1][props.id];
    if (wordIndex === letterIndex) {
      style = { backgroundColor: "#79bd8b" };
    } else if (props.word.current.includes(letterIndex)) {
      style = { backgroundColor: "#d4ce79" };
    }
    return (
      <div className="board" id={`guessingBoard${props.id}`} style={style}>
        {props.guesses[props.boardNumber - 1][props.id]}
      </div>
    );
  }
  return (
    <div className="board" id={`guessingBoard${props.id}`} style={style}></div>
  );
};

export const WholeBoard = (props) => {
  return (
    <div className="whole-board">
      {guessingBoard.map((e, index) => {
        return (
          <Board
            key={index}
            id={index}
            letter={props.letter}
            word={props.word}
            enter={props.enter}
            boardNumber={props.boardNumber}
            guesses={props.guesses}
          ></Board>
        );
      })}
    </div>
  );
};
