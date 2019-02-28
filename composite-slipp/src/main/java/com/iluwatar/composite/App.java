/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.composite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

abstract class Component {
  ArrayList<Component> list = new ArrayList<>();
  public abstract void render();
  public abstract Composite getComposite();
  public void remove() {
    parent.remove(this);
  }
}

class Leaf extends Component {

  @Override public void render() {
    System.out.println();
  }

  @Override public Composite getComposite() {
    return null;
  }
}

class Composite extends Component {



  @Override public void render() {
    System.out.println();
  }

  @Override public Composite getComposite() {
    return this;
  }

  public void add(Component component) {
    list.add(component);
  }

  public void remove(Component cpnt) {
    list.remove(cpnt);
  }
}


public class App {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {


    Composite composite = new Composite();
    Leaf leaf = new Leaf();

    Component cpnt = composite;
    Composite test;

    if ((test = cpnt.getComposite()) != null) {
      System.out.println("composite");
      test.add(new Leaf());
    }

    cpnt = leaf;
    if ((test = cpnt.getComposite()) != null) {
      System.out.println("leaf");
      test.add(new Leaf());
    }








  }
}
