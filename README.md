# Android Calculator App v 0.1

This Simple calculator application for android version 0.1

----------------------------------------------------------------
## Description:

This simple application and the first of my Android applications, from this application, I will start my career in developing Android applications, despite the simplicity of the application, but it opened the door for me to develop applications The application is so simple that I used a small educational course to create it. This is what any beginner would do anyway, but I added my touch to it. The application performs simple arithmetic operations only from adding, subtracting, getting and dividing. I will develop the application later to perform other operations, as this is the first version only.

----------------------------------------------------------------

## Some notes on project

In fact, in my project, I used a small educational course on YouTube, as I am a beginner, but I added my own touch in order to shorten many commands, it is in the course when I put the buttons it gave all the buttons its own function when pressed, but I have set one function that collects all the commands With the removal of redundancy, of course.
The function you created is:
```Java
public void ButtonClick(View view) {
  int curpos = equation_ent.getSelectionStart(); // Get cursor position
  int textlen = equation_ent.getText().length(); // Get equation length
  String equation = equation_ent.getText().toString(); // Get equation
  switch (view.getId()) {
    case R.id.zero_btn:
      updateText("0"); // add 0 number
      break;
    case R.id.one_btn:
      updateText("1");   // add 1 number
      break;
    case R.id.two_btn:
      updateText("2");   // add 2 number
      break;
    case R.id.three_btn:
      updateText("3");   // add 3 number
      break;
    case R.id.four_btn:
      updateText("4");   // add 4 number
      break;
    case R.id.five_btn:
      updateText("5");   // add 5 number
      break;
    case R.id.six_btn:
      updateText("6");   // add 6 number
      break;
    case R.id.seven_btn:
      updateText("7");   // add 7 number
      break;
    case R.id.eight_btn:
      updateText("8");   // add 8 number
      break;
    case R.id.nine_btn:
      updateText("9");   // add 9 number
      break;
    case R.id.clear_btn:
      equation_ent.setText(""); // Clear text in equation EditText widget
      displayResult.setText(getString(R.string.display)); // Set defualt text when clear
      equation_ent.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP); // Set defualt color
      break;
    case R.id.exponent_btn:
      updateText("^");   // add exponent char
      break;
    case R.id.parentheses_btn: // Add open or close parentheses
      int openpar = 0; // open parentheses length
      int closepar = 0; // close parentheses length
      for (int i = 0; i < curpos; i++) { // calculate open and close parentheses
        if (equation.substring(i, i+1).equals("(")){
          openpar += 1;
        }else if (equation.substring(i, i+1).equals(")")){
          closepar += 1;
        }
      }
      if (openpar == closepar || equation.substring(textlen-1, textlen).equals("(")) {
        updateText("(");// Add open parentheses
      }else if (openpar > closepar && !equation.substring(textlen-1, textlen).equals("(")) {
        updateText(")");// Add close parentheses
      }
      equation_ent.setSelection(curpos+1); // update cursor position
      break;
    case R.id.divide_btn:
      updateText("/");  // add divide char
      break;
    case R.id.multiply_btn:
      updateText("×");  // add multiply char
      break;
    case R.id.add_btn:
      updateText("+");  // add plus char
      break;
    case R.id.subtract_btn:
      updateText("-");   // add subtract char
      break;
    case R.id.point_btn:
      updateText(".");   // add point
      break;
    case R.id.equals_btn:  // Show result
      equation = equation.replace("÷", "/");  // replace all ÷ chars on equation with /
      equation = equation.replace("×", "*");  // replace all × chars on equation with *
      equation = equation.replace("(", "*("); // replace all ( chars on equation with *(
      /////////////////////////// get result from equation text ///////////////////////////
      Expression exp = new Expression(equation); // this class is from tutorial
      String res = String.valueOf(exp.calculate());
      if (res == "NaN"){ // When there is an error in the equation
        equation_ent.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP); // change color to red
        displayResult.setText("Error"); // Set Error text on result TextView
      }else {
        equation_ent.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP); // change color to gray
        displayResult.setText(res); // Set result on result TextView
      }
      /////////////////////////////////////////////////////////////////////////////////////
      break;
    case R.id.backspase_btn: // Remove the last letter next to the cursor
      if (curpos != 0 && textlen != 0) {
        SpannableStringBuilder selection = (SpannableStringBuilder) equation_ent.getText();
        selection.replace(curpos-1, curpos, "");
        equation_ent.setText(selection);
        equation_ent.setSelection(curpos-1); // Update cursor position
      }
      break;
  }
}
```
This is all that I added and others, but there are some errors that I could not solve, namely:
1. The color of the buttons, although I changed their color in the min file, but they did not change as they remained the same.
2. Also, I did not find how to add the effect of pressing the button, as when pressing the button it does not give any effect such as changing color
3. This is not a mistake. I feel that there is another way, which is to remove the address line at the top, as I did not find my activism empty without that line, so I used a small code to remove it
That's all for the project, I am open to any suggestions, comments and criticisms
Meet you in other projects.

This Tutorial link: [Android Studio Calculator App](https://www.youtube.com/playlist?list=PLcSIMAULmMyd6p8lSBtOoC_TutRMsnZOc)

Source code link: [Android Calculator App v 0.1](https://github.com/AIabdoPr/Calculator-App-v-0.1.git)

## My links for connect
[Youtube Channel](https://www.youtube.com/channel/UCrUlwWUF9y7wE7AD12XSbRw)

[Facebook Page](https://www.facebook.com/AbdoInfo47)

[Linkdin](https://www.linkedin.com/in/abdo-information-9a3957197/)

[Instagram](https://www.instagram.com/abdo_information/)
