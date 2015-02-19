package io.sjm.natureofcode.introduction;

import processing.core.PApplet;

public class Exercise1 extends PApplet {
  private static final long serialVersionUID = 1L;

  class Walker {
    float x, y;

    Walker() {
      x = width / 2;
      y = height / 2;
    }

    void render() {
      stroke(0);
      point(x, y);
    }

    void step() {
      float stepx = constrain(random(-1, (float) 1.2), -1, 1);
      float stepy = constrain(random(-1, (float) 1.2), -1, 1);
      x += stepx;
      y += stepy;
      x = constrain(x, 0, width - 1);
      y = constrain(y, 0, height - 1);
    }
  }

  Walker w;

  public void setup() {
    size(200, 200);
    w = new Walker();
    background(255);
  }

  public void draw() {
    w.step();
    w.render();
  }
}
