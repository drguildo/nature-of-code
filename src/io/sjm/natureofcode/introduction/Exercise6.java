package io.sjm.natureofcode.introduction;

import processing.core.PApplet;

public class Exercise6 extends PApplet {
  private static final long serialVersionUID = 1L;

  class Walker {
    private float x, y;

    Walker() {
      x = width / 2;
      y = height / 2;
    }

    void render() {
      stroke(0);
      ellipse(x, y, 4, 4);
    }

    void step() {
      float stepx = getStepSize();
      float stepy = getStepSize();

      line(x, y, x + stepx, y + stepy);

      x += stepx;
      y += stepy;
      x = constrain(x, 0, width - 1);
      y = constrain(y, 0, height - 1);
    }

    private float getStepSize() {
      int max = 10;

      while (true) {
        float r1 = random(-max, max);
        float r2 = random(max * max);

        if (r2 < (r1 * r1))
          return r1;
      }
    }
  }

  private Walker w;

  public void setup() {
    size(800, 600);
    w = new Walker();
    background(255);
  }

  public void draw() {
    w.step();
    w.render();
  }
}
