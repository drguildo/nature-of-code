package io.sjm.natureofcode.introduction;

import java.util.Random;

import processing.core.PApplet;

public class Exercise5 extends PApplet {
  private static final long serialVersionUID = 1L;

  class Walker {
    private float x, y;
    private Random generator = new Random();

    Walker() {
      x = width / 2;
      y = height / 2;
    }

    void render() {
      stroke(0);
      // fill(0);
      ellipse(x, y, 4, 4);
    }

    void step() {
      float stepx = getStepSize();
      float stepy = getStepSize();
      x += stepx;
      y += stepy;
      x = constrain(x, 0, width - 1);
      y = constrain(y, 0, height - 1);
    }

    private float getStepSize() {
      return (float) generator.nextGaussian() * 4;
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
