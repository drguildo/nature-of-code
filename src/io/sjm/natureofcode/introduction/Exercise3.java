package io.sjm.natureofcode.introduction;

import processing.core.PApplet;

public class Exercise3 extends PApplet {
  private static final long serialVersionUID = 1L;

  class Walker {
    int x, y;

    Walker() {
      x = width / 2;
      y = height / 2;
    }

    void render() {
      stroke(0);
      strokeWeight(2);
      point(x, y);
    }

    void step() {
      float r = random(1);

      if (r < 0.5 && mouseX != 0 && mouseY != 0) {
        if (mouseX > x) {
          x++;
        } else {
          x--;
        }
        if (mouseY > y) {
          y++;
        } else {
          y--;
        }
      } else {
        r = random(1);
        if (r < 0.25) {
          x--;
        } else if (r < 0.5) {
          x++;
        } else if (r < 0.75) {
          y--;
        } else {
          y++;
        }
      }

      x = constrain(x, 0, width - 1);
      y = constrain(y, 0, height - 1);
    }
  }

  Walker w;

  public void setup() {
    size(640, 360);
    w = new Walker();
    background(255);
  }

  public void draw() {
    w.step();
    w.render();
  }
}
