package com.example.prp.controller;

import com.example.prp.model.CalcClient;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.Objects;

public class Controller {

    public GridPane pane;
    public Button cancel;
    public Button plusOrMinus;
    public Button percent;
    public Button divide;
    public Button seven;
    public Button eight;
    public Button nine;
    public Button multiply;
    public Button four;
    public Button five;
    public Button six;
    public Button minus;
    public Button one;
    public Button two;
    public Button three;
    public Button plus;
    public Button zero;
    public Button comma;
    public Button equals;
    public Label result;

    public void cancelClicked() {
        result.setText("0");
    }

    public void plusOrMinusClicked() {
        if (!result.getText().contains("=")) {
            result.setText(String.valueOf(Integer.parseInt(result.getText()) * -1));
        }
    }

    public void percentClicked() {
        if (!result.getText().contains("=")) {
            result.setText(String.valueOf(Double.parseDouble(result.getText()) / 100));
        }
    }

    public void divideClicked() {
        if (!result.getText().contains("=")) {
            if (!result.getText().contains("/")) {
                result.setText(result.getText().concat(" / "));
            }
        }
    }

    public void sevenClicked() {
        if (!result.getText().contains("=")) {
            if (Objects.equals(result.getText(), "0")) {
                result.setText("7");
            } else {
                result.setText(result.getText().concat("7"));
            }
        }
    }

    public void eightClicked() {
        if (!result.getText().contains("=")) {
            if (Objects.equals(result.getText(), "0")) {
                result.setText("8");
            } else {
                result.setText(result.getText().concat("8"));
            }
        }
    }

    public void nineClicked() {
        if (!result.getText().contains("=")) {
            if (Objects.equals(result.getText(), "0")) {
                result.setText("9");
            } else {
                result.setText(result.getText().concat("9"));
            }
        }
    }

    public void multiplyClicked() {
        if (!result.getText().contains("=")) {
            if (!result.getText().contains("*")) {
                result.setText(result.getText().concat(" * "));
            }
        }
    }

    public void fourClicked() {
        if (!result.getText().contains("=")) {
            if (Objects.equals(result.getText(), "0")) {
                result.setText("4");
            } else {
                result.setText(result.getText().concat("4"));
            }
        }
    }

    public void fiveClicked() {
        if (!result.getText().contains("=")) {
            if (Objects.equals(result.getText(), "0")) {
                result.setText("5");
            } else {
                result.setText(result.getText().concat("5"));
            }
        }
    }

    public void sixClicked() {
        if (!result.getText().contains("=")) {
            if (Objects.equals(result.getText(), "0")) {
                result.setText("6");
            } else {
                result.setText(result.getText().concat("6"));
            }
        }
    }

    public void minusClicked() {
        if (!result.getText().contains("=")) {
            if (!result.getText().contains("-")) {
                result.setText(result.getText().concat(" - "));
            }
        }
    }

    public void oneClicked() {
        if (!result.getText().contains("=")) {
            if (Objects.equals(result.getText(), "0")) {
                result.setText("1");
            } else {
                result.setText(result.getText().concat("1"));
            }
        }
    }

    public void twoClicked() {
        if (!result.getText().contains("=")) {
            if (Objects.equals(result.getText(), "0")) {
                result.setText("2");
            } else {
                result.setText(result.getText().concat("2"));
            }
        }
    }

    public void threeClicked() {
        if (!result.getText().contains("=")) {
            if (Objects.equals(result.getText(), "0")) {
                result.setText("3");
            } else {
                result.setText(result.getText().concat("3"));
            }
        }
    }

    public void plusClicked() {
        if (!result.getText().contains("=")) {
            if (!result.getText().contains("+")) {
                result.setText(result.getText().concat(" + "));
            }
        }
    }

    public void zeroClicked() {
        if (!result.getText().contains("=")) {
            if (Objects.equals(result.getText(), "0")) {
                result.setText("0");
            } else {
                result.setText(result.getText().concat("0"));
            }
        }
    }

    public void commaClicked() {
        if (!result.getText().contains("=")) {
            if (!result.getText().contains(".")) {
                result.setText(result.getText().concat("."));
            } else if (result.getText().contains(".") && (result.getText().contains("+") || result.getText().contains("-")
                    || result.getText().contains("*") || result.getText().contains("/"))) {
                result.setText(result.getText().concat("."));
            }
        }
    }

    public void equalsClicked() throws Exception {

        CalcClient chat = new CalcClient("localhost", 8080);
        chat.run();
        chat.sendMessage(result.getText());

        if (!result.getText().contains("=")) {
            result.setText(result.getText().concat(" = ").concat(chat.getResult()));
        }
        chat.close();
    }
}