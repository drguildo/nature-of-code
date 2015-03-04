package io.sjm.natureofcode.introduction;

import processing.core.PApplet;

public class Exercise7 extends PApplet {
  private static final long serialVersionUID = 1L;

  class Walker {
    private float tx, ty, x, y;

    Walker() {
      tx = 0;
      ty = 10000;
      x = width / 2;
      y = height / 2;
    }

    void render() {
      stroke(0);
      point(x, y);
    }

    void step() {
      float stepx = map(noise(tx), 0, 1, -2, 2);
      float stepy = map(noise(ty), 0, 1, -2, 2);

      x += stepx;
      y += stepy;

      x = constrain(x, 0, width);
      y = constrain(y, 0, height);

      tx += 0.1;
      ty += 0.1;
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
