package cn.xiaozhg.code.chapter1;

import org.junit.Test;

import java.util.LinkedList;

public class DogCaQueue {
    private int count = 0;
    private LinkedList<PetElement> dogQueue = new LinkedList<PetElement>();
    private LinkedList<PetElement> catQueue = new LinkedList<PetElement>();

    public void add(Pet pet) {
        if(pet == null) {
            return;
        }
        if ("dog".equals(pet.getType())) {
            dogQueue.add(new PetElement(pet, count++));
        } else if ("cat".equals(pet.getType())) {
            catQueue.add(new PetElement(pet,count++));
        }
    }

    public Pet pollAll() {
        PetElement dog = dogQueue.peek();
        PetElement cat = catQueue.peek();
        if (dog != null && cat != null) {
            return dog.getNum() < cat.getNum() ? dogQueue.poll().getPet() : catQueue.poll().getPet();
        }
        if (dog != null) {
            return dogQueue.poll().getPet();
        }
        if (cat != null) {
            return catQueue.poll().getPet();
        }
        return null;
    }

    public Dog pollDog() {
        return (Dog) dogQueue.poll().getPet();
    }

    public Cat pollCat() {
        return (Cat) catQueue.poll().getPet();
    }

    public boolean isEmpty() {
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return catQueue.isEmpty();
    }


    class PetElement {
        Pet pet;
        int num;

        PetElement(Pet pet,int num) {
            this.pet = pet;
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        public Pet getPet() {
            return pet;
        }
    }

    /**
     * 依赖的类
     * */
    class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    @Test
    public void test() {
        DogCaQueue dogCaQueue = new DogCaQueue();
        dogCaQueue.add(new Dog());
        dogCaQueue.add(new Cat());
        dogCaQueue.add(new Dog());
        dogCaQueue.add(new Cat());
        dogCaQueue.add(new Dog());
        dogCaQueue.add(new Cat());
        dogCaQueue.add(new Dog());
        dogCaQueue.add(new Cat());

        while (!dogCaQueue.isEmpty()) {
            System.out.println(dogCaQueue.pollAll().getType());
        }
        System.out.println("======================");
        dogCaQueue.add(new Dog());
        dogCaQueue.add(new Cat());
        dogCaQueue.add(new Dog());
        dogCaQueue.add(new Cat());
        dogCaQueue.add(new Dog());
        dogCaQueue.add(new Cat());
        dogCaQueue.add(new Dog());
        dogCaQueue.add(new Cat());
        while (!dogCaQueue.isCatEmpty()) {
            System.out.println(dogCaQueue.pollCat().getType());
        }
        System.out.println("======================");
        dogCaQueue.add(new Dog());
        dogCaQueue.add(new Cat());
        dogCaQueue.add(new Dog());
        dogCaQueue.add(new Cat());
        dogCaQueue.add(new Dog());
        dogCaQueue.add(new Cat());
        dogCaQueue.add(new Dog());
        dogCaQueue.add(new Cat());
        while (!dogCaQueue.isDogEmpty()) {
            System.out.println(dogCaQueue.pollDog().getType());
        }

    }
}
