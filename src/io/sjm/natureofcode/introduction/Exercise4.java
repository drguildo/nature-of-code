package io.sjm.natureofcode.introduction;

import io.sjm.natureofcode.Const;

import java.util.Random;

import processing.core.PApplet;

public class Exercise4 extends PApplet {
  private static final long serialVersionUID = 1L;

  private Random generator;

  private int x, y, r, g, b;

  public void setup() {
    generator = new Random();

    size(1280, 720);
    background(Const.BLACK);
  }

  public void draw() {
    x = adjust(width / 2);
    y = adjust(height / 2);

    r = adjust(generator.nextInt(Const.WHITE / 2));
    g = adjust(generator.nextInt(Const.WHITE / 2));
    b = adjust(generator.nextInt(Const.WHITE / 2));

    noStroke();
    fill(color(r, g, b), 0xFF / 2);
    ellipse(x, y, 16, 16);
  }

  private int adjust(int f) {
    return (int) (60 * (float) generator.nextGaussian() + f);
  }
}
