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
package com.iluwatar.factory.method2.method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ComputerShop {

  private static final Logger LOGGER = LoggerFactory.getLogger(ComputerShop.class);

  private final MachineFactory computer;

  public ComputerShop(MachineFactory computer) {
    this.computer = computer;
  }
  
  /**
   * Program entry point
   * 
   * @param args command line args
   */
  public static void main(String[] args) {
    // Lets go to war with Orc weapons
    ComputerShop computerShop = new ComputerShop(new HighQualityComputer());
    computerShop.assembleMachine();
    
    // Lets go to war with Elf weapons
    computerShop = new ComputerShop(new LowQualityComputer());
    computerShop.assembleMachine();
  }
  
  private void assembleMachine() {
    Processor processor = computer.getProcessor();
    HardDisk hardDisk = computer.getHardDisk();

    processor.performOperation();
    hardDisk.storeData();
  }
}

interface MachineFactory {
  Processor getProcessor();
  HardDisk getHardDisk();
}

class HighQualityComputer implements MachineFactory {

  @Override public Processor getProcessor() {
    return new HighQualityProcessor();
  }

  @Override public HardDisk getHardDisk() {
    return new HighQualityHardDisk();
  }
}

class LowQualityComputer implements MachineFactory {

  @Override public Processor getProcessor() {
    return new LowQualityProcessor();
  }

  @Override public HardDisk getHardDisk() {
    return new LowQualityHardDisk();
  }
}

interface Processor {
  void performOperation();
}

class HighQualityProcessor implements Processor {

  @Override public void performOperation() {
    System.out.println("high : Operation will perform quickly");
  }
}

class LowQualityProcessor implements Processor {

  @Override public void performOperation() {
    System.out.println("low : Operation will perform Slowly");
  }
}

interface HardDisk {
  void storeData();
}

class HighQualityHardDisk implements HardDisk {

  @Override public void storeData() {
    System.out.println("high : Data will take less time to store");
  }
}

class LowQualityHardDisk implements HardDisk {

  @Override public void storeData() {
    System.out.println("low : Data will take more time to store");
  }
}